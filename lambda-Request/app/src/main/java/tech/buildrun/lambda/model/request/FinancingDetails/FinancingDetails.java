package tech.buildrun.lambda.model.request.FinancingDetails;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class FinancingDetails {
    private double downPayment;
    private double amountRequested;
    private int termInMonths;

    public FinancingDetails() {
    }

    public FinancingDetails(double downPayment, double amountRequested, int termInMonths) {
        this.downPayment = downPayment;
        this.amountRequested = amountRequested;
        this.termInMonths = termInMonths;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public double getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(double amountRequested) {
        this.amountRequested = amountRequested;
    }

    public int getTermInMonths() {
        return termInMonths;
    }

    public void setTermInMonths(int termInMonths) {
        this.termInMonths = termInMonths;
    }
}
