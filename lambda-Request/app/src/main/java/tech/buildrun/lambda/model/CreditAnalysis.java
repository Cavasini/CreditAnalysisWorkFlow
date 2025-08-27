package tech.buildrun.lambda.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import tech.buildrun.lambda.model.request.RequestPayload;

@DynamoDbBean
public class CreditAnalysis {
    private String requestId;
//    private String status;
//    private String creationDate;
//    private String completionDate;
    private RequestPayload requestPayload;

    @DynamoDbPartitionKey
    public String getRequestId(){
        return requestId;
    }

    public CreditAnalysis(){
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }
}
