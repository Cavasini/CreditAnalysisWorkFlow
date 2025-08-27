package tech.buildrun.lambda.model.request.Applicant;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import tech.buildrun.lambda.model.request.Applicant.FinancialData.FinancialData;
import tech.buildrun.lambda.model.request.Applicant.PersonalData.PersonalData;
import tech.buildrun.lambda.model.request.Applicant.creditData.CreditData;
import tech.buildrun.lambda.model.request.Applicant.professionalData.ProfessionalData;

@DynamoDbBean
public class Applicant {

    private String type;
    private PersonalData personalData;
    private ProfessionalData professionalData;
    private FinancialData financialData;
    private CreditData creditData;

    public Applicant() {
    }

    public Applicant(String type, PersonalData personalData, ProfessionalData professionalData, FinancialData financialData, CreditData creditData) {
        this.type = type;
        this.personalData = personalData;
        this.professionalData = professionalData;
        this.financialData = financialData;
        this.creditData = creditData;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public ProfessionalData getProfessionalData() {
        return professionalData;
    }

    public void setProfessionalData(ProfessionalData professionalData) {
        this.professionalData = professionalData;
    }

    public FinancialData getFinancialData() {
        return financialData;
    }

    public void setFinancialData(FinancialData financialData) {
        this.financialData = financialData;
    }

    public CreditData getCreditData() {
        return creditData;
    }

    public void setCreditData(CreditData creditData) {
        this.creditData = creditData;
    }
}
