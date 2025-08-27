package tech.buildrun.lambda.model.request.Applicant.professionalData;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class ProfessionalData {
    private String occupation;
    private String employmentType;
    private String companyName;
    private String hireDate;

    public ProfessionalData() {
    }

    public ProfessionalData(String occupation, String employmentType, String companyName, String hireDate) {
        this.occupation = occupation;
        this.employmentType = employmentType;
        this.companyName = companyName;
        this.hireDate = hireDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
}
