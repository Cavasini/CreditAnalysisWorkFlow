package tech.buildrun.lambda.model.request;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import tech.buildrun.lambda.model.request.Applicant.Applicant;
import tech.buildrun.lambda.model.request.FinancingDetails.FinancingDetails;
import tech.buildrun.lambda.model.request.vehicle.Vehicle;

@DynamoDbBean
public class RequestPayload {

    private Applicant applicant;
    private Vehicle vehicle;
    private FinancingDetails financingDetails;

    public RequestPayload(Applicant applicant, Vehicle vehicle, FinancingDetails financingDetails) {
        this.applicant = applicant;
        this.vehicle = vehicle;
        this.financingDetails = financingDetails;
    }

    public RequestPayload() {
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public FinancingDetails getFinancingDetails() {
        return financingDetails;
    }

    public void setFinancingDetails(FinancingDetails financingDetails) {
        this.financingDetails = financingDetails;
    }
}
