package tech.buildrun.lambda.model.request.Applicant.FinancialData;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.List;

@DynamoDbBean
public class FinancialData {

    private double grossMonthlyIncome;
    private double otherIncome;
    private java.util.List<CurrentDebt> currentDebts;

    public FinancialData() {
    }

    public FinancialData(double grossMonthlyIncome, double otherIncome, List<CurrentDebt> currentDebts) {
        this.grossMonthlyIncome = grossMonthlyIncome;
        this.otherIncome = otherIncome;
        this.currentDebts = currentDebts;
    }

    public double getGrossMonthlyIncome() {
        return grossMonthlyIncome;
    }

    public void setGrossMonthlyIncome(double grossMonthlyIncome) {
        this.grossMonthlyIncome = grossMonthlyIncome;
    }

    public double getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(double otherIncome) {
        this.otherIncome = otherIncome;
    }

    public List<CurrentDebt> getCurrentDebts() {
        return currentDebts;
    }

    public void setCurrentDebts(List<CurrentDebt> currentDebts) {
        this.currentDebts = currentDebts;
    }
}
