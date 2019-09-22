package fit5042.heritage.repository.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Adnan
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Address implements Serializable {
    
    private String streetNumber;
    private String streetAddress;
    private String suburb;
    private String postcode;
    private String city;

    public Address() {
    }

    public Address(String streetNumber, String streetAddress, String suburb, String postcode, String city) {
        this.streetNumber = streetNumber;
        this.streetAddress = streetAddress;
        this.suburb = suburb;
        this.postcode = postcode;
        this.city = city;
    }

    @Column(name = "street_number")
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Column(name = "street_address")
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    @Column(name = "suburb")
    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Column(name = "postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return streetNumber + " " + streetAddress + ", " + suburb + ", " + city + " " + postcode;
    } 
}
