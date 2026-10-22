package prakash.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String houseNo;
    private  String street;
    private  String city;
    private  String state;
    private  String pincode;

    public Address() {
    }

    public Address(String houseNo, String street, String city, String state, String pincode) {
        this.houseNo=houseNo;
        this.street=street;
        this.city=city;
        this.state=state;
        this.pincode=pincode;
    }

    public String city() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String houseNo() {
        return houseNo;
    }

    public Address setHouseNo(String houseNo) {
        this.houseNo = houseNo;
        return this;
    }

    public String pincode() {
        return pincode;
    }

    public Address setPincode(String pincode) {
        this.pincode = pincode;
        return this;
    }

    public String state() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public String street() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

}
