package tech.buildrun.lambda.model.request.Applicant.FinancialData;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class CurrentDebt {

    private String type;
    private double monthlyInstallmentValue;

    public CurrentDebt() {
    }

    public CurrentDebt(String type, double monthlyInstallmentValue) {
        this.type = type;
        this.monthlyInstallmentValue = monthlyInstallmentValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMonthlyInstallmentValue() {
        return monthlyInstallmentValue;
    }

    public void setMonthlyInstallmentValue(double monthlyInstallmentValue) {
        this.monthlyInstallmentValue = monthlyInstallmentValue;
    }
}
