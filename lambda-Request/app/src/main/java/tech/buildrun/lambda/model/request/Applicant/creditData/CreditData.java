package tech.buildrun.lambda.model.request.Applicant.creditData;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class CreditData {

    private int creditScore;
    private boolean hasNegativeHistory;

    public CreditData() {
    }

    public CreditData(int creditScore, boolean hasNegativeHistory) {
        this.creditScore = creditScore;
        this.hasNegativeHistory = hasNegativeHistory;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public boolean isHasNegativeHistory() {
        return hasNegativeHistory;
    }

    public void setHasNegativeHistory(boolean hasNegativeHistory) {
        this.hasNegativeHistory = hasNegativeHistory;
    }
}
