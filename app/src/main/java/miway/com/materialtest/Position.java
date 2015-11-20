package miway.com.materialtest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mallinath on 15-10-2015.
 */
public class Position {


    public String district;


    public String city;


    public String destinationName;


    public String address;


    public String contact;


    public String latitude;


    public String longitude;


    public double distance;

    public Position(String district, String city, String destinationName, String address, String contact, String latitude, String longitude,double distance) {
        this.district = district;
        this.city = city;
        this.destinationName = destinationName;
        this.address = address;
        this.contact = contact;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance=distance;
    }

    public Position(){}

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
