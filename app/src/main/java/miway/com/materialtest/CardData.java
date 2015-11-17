package miway.com.materialtest;

/**
 * Created by Mallinath on 6/22/2015.
 */
public class CardData {

    private String name;
    private double rating;
    private String callText;
    private String navText;
    private int goToId;
    private String address;
    private String latitude;
    private String longitude;



    public CardData(String name, double rating, String callText, String navText, int goToId,String address,String latitude,String longitude) {
        this.name = name;
        this.rating = rating;
        this.callText = callText;
        this.navText = navText;
        this.goToId = goToId;
        this.address = address;
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCallText() {
        return callText;
    }

    public void setCallText(String callText) {
        this.callText = callText;
    }

    public String getNavText() {
        return navText;
    }

    public void setNavText(String navText) {
        this.navText = navText;
    }

    public int getGoToId() {
        return goToId;
    }

    public void setGoToId(int goToId) {
        this.goToId = goToId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
