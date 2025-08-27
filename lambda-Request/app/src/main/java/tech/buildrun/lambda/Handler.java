package tech.buildrun.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import tech.buildrun.lambda.model.CreditAnalysis;
import tech.buildrun.lambda.model.request.RequestPayload;

import java.util.UUID;

public class Handler implements
        RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final DynamoDbClient ddb = DynamoDbClient.create();
    private final DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder().dynamoDbClient(ddb).build();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final JedisPool jedisPool = new JedisPool(System.getenv("REDIS_ENDPOINT"), 6379);

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request,
                                                      Context context) {

        var logger = context.getLogger();
        String requestBody = request.getBody();
        logger.log("Request received - " + request.getBody());

        try{

            RequestPayload requestPayload = objectMapper.readValue(requestBody, RequestPayload.class);
            CreditAnalysis analysis = new CreditAnalysis();
            analysis.setRequestId(UUID.randomUUID().toString());
            analysis.setRequestPayload(requestPayload);

            DynamoDbTable<CreditAnalysis> analysisTable = getTable();
            analysisTable.putItem(analysis);
            logger.log("Analysis saved successfully! RequestID: " + analysis.getRequestId());


            try(Jedis jedis = jedisPool.getResource()){
                jedis.setex(analysis.getRequestId(), 600, requestPayload.toString());
                logger.log("Cache atualizado com sucesso.");
            }catch (Exception e){
                logger.log("AVISO: Falha ao salvar no cache: " + e.getMessage());
            }

            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(201)
                    .withBody("{\"message\": \"Analysis saved successfully!\", \"requestId\": \"" + analysis.getRequestId() + "\"}")
                    .withIsBase64Encoded(false);


        } catch (Exception e) {
            logger.log("Error processing request: " + e.getMessage());
            e.printStackTrace();
            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(500)
                    .withBody("{\"error\": \"Failed to save the analysis.\"}" + e.getMessage())
                    .withIsBase64Encoded(false);
        }
    }

    private DynamoDbTable<CreditAnalysis> getTable() {
        String tableName = System.getenv("DYNAMODB_TABLE_NAME");
        if (tableName == null || tableName.isEmpty()) {
            throw new IllegalStateException("Environment variable DYNAMODB_TABLE_NAME is not set.");
        }
        return enhancedClient.table(tableName, TableSchema.fromBean(CreditAnalysis.class));
    }
}
