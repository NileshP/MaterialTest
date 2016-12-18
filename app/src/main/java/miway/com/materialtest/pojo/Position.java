package miway.com.materialtest.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mallinath on 15-10-2015.
 */
public class Position {


    public String id;

    public String district;


    public String city;


    public String destinationName;


    public String address;


    public String contact;


    public String latitude;


    public String longitude;


    public double distance;

    public String dataType;

    public Position(String id,String district, String city, String destinationName, String address, String contact, String latitude, String longitude,double distance,String dataType) {
        this.district = district;
        this.id=id;
        this.city = city;
        this.destinationName = destinationName;
        this.address = address;
        this.contact = contact;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance=distance;
        this.dataType=dataType;
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
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
}
