package tech.buildrun.lambda.model.request.Applicant.PersonalData;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class PersonalData {
    private String fullName;
    private String taxId;
    private IdentityDocument identityDocument;
    private String birthDate;
    private String maritalStatus;
    private Address address;
    private Contact contact;

    public PersonalData() {
    }

    public PersonalData(String fullName, String taxId, IdentityDocument identityDocument, String birthDate, String maritalStatus, Address address, Contact contact) {
        this.fullName = fullName;
        this.taxId = taxId;
        this.identityDocument = identityDocument;
        this.birthDate = birthDate;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.contact = contact;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public IdentityDocument getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(IdentityDocument identityDocument) {
        this.identityDocument = identityDocument;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
