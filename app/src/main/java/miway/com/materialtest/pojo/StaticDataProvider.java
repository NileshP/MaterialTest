package miway.com.materialtest.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mallinath on 05-10-2015.
 */
public class StaticDataProvider {




    public static CardData selectData;

    public static String latitudeString;
    public static String longitudeString;

    public static String ServerURL = "http://54.244.209.143:";

    public static String urlPetrolPump = StaticDataProvider.ServerURL+"8092/positionjson?latitude=17.65&longitude=75.90&dataType=2";
    public static String urlATM = StaticDataProvider.ServerURL+"8091/positionjson?latitude=17.65&longitude=75.90&dataType=1";
    public static String urlRestaurant=StaticDataProvider.ServerURL+"8093/positionjson?latitude=17.65&longitude=75.90&dataType=3";

    public static List<CardData> getCardListData(int position) {


        //System.out.println("---------------------------------" + position + "-------------------------------------------");

        List<CardData> data = new ArrayList<CardData>();


        if (position == 0) {
            data.add(new CardData("0","Jeevan Jyoti Services", 3.5, "9028576234", "3.5" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Bharat Ambulance", 2.2, "8007140088", "5.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Golder Care Ambulance", 1.5, "9028576234", "13.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Om Sai Ambulance", 2.1, "8007140088", "6.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Ojas Ambulance", 3.2, "9028576234", "7.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","MediLife Ambulance", 2.7, "8007140088", "1.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Shree Datta Ambulance", 2.3, "9028576234", "1.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Pruthvi Ambulance", 1.2, "8007140088", "2.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Lokmangal Ambulance", 3.1, "9028576234", "0.2" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Kolumbus Ambulance", 4.5, "8007140088", "2.7" + "Km", 2,"","0.0","0.0",0.0));
            return data;
        }

        if (position == 1) {
            data.add(new CardData("0","Sutar Hospital", 3.5, "9028576234", "2.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Hinjewadi Hospital", 2.2, "8007140088", "15.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Sanjivani Hospital", 1.5, "9028576234", "3.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","City Care Hospital", 2.1, "8007140088", "5.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Surya Hospital", 3.2, "9028576234", "5.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Sai Hospital", 2.7, "8007140088", "1.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Polaris HealthCare", 2.3, "9028576234", "1.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Lokmanya Hospital", 1.2, "8007140088", "4.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Apple Hospital", 3.1, "9028576234", "2.2" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Aditya Birla Hospital", 4.5, "8007140088", "12.2" + "Km", 2,"","0.0","0.0",0.0));
            return data;
        }

        if (position == 2) {
            data.add(new CardData("0","Divine Chemist", 2.5, "9028576234", "0.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Tulsi Medico", 1.2, "8007140088", "1.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Shree Mahatoba Medical", 4.5, "9028576234", "13.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Morya Medical", 3.1, "8007140088", "6.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Shree Ganesh Medical", 4.2, "9028576234", "1.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Yashraj Medical", 2.7, "8007140088", "6.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Aditya Medical", 1.3, "9028576234", "3.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Pawan Medical", 3.2, "8007140088", "6.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Mahavir Medical", 2.1, "9028576234", "5.2" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Sidhivinayak Medical", 4.5, "8007140088", "3.2" + "Km", 2,"","0.0","0.0",0.0));
            return data;
        }

        if (position == 3) {
            data.add(new CardData("0","Shettys Multicar Service ", 1.5, "9028576234", "2.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Patel Motor Service", 3.2, "8007140088", "15.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Shri Balaji Auto Service", 2.5, "9028576234", "3.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Car and Bike Point", 4.1, "8007140088", "5.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Shree Ganesh Auto", 3.1, "9028576234", "5.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Yogi MultiCar Service", 3.5, "8007140088", "1.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","A J Motors", 4.3, "9028576234", "1.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Durga Service Center", 2.2, "8007140088", "4.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("0","Maruti Service Center", 4.1, "9028576234", "2.2" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("0","Motor Cafe", 2.5, "8007140088", "12.2" + "Km", 2,"","0.0","0.0",0.0));
            return data;
        }

        if (position == 4) {
            for (Position position2:fuelData) {

                data.add(new CardData(position2.id,position2.getDestinationName(),0.0,position2.getContact(),"-.- Km",1,position2.getAddress(),position2.getLatitude(),position2.getLongitude(),position2.getDistance(),position2.getDataType()));

            }

            return data;
        }

        if (position == 5) {
            data.add(new CardData("Courtyard Hinjewadi", 4.5, "9028576234", "4.1" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("Rajyog Restaurant ", 3.2, "8007140088", "5.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("Spice Nation Restaurant", 1.5, "9028576234", "6.3" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("Mezza9 Lounge", 3.1, "8007140088", "7.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("Saundarya Garden", 3.2, "9028576234", "3.8" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("Vrundavan Restaurant", 1.2, "8007140088", "2.7" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("Eternia Restaurant", 4.3, "9028576234", "6.2" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("Kiva Terminus", 3.2, "8007140088", "2.7" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("Shanghai Court", 1.0, "9028576234", "4.8" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("RushHrs", 2.7, "8007140088", "4.8" + "Km", 2,"","0.0","0.0",0.0));
            return data;
        }

        if (position == 6) {


            for (Position position2:bankData) {

                data.add(new CardData(position2.getDestinationName(),0.0,position2.getContact(),"-.- Km",1,position2.getAddress(),position2.getLatitude(),position2.getLongitude(),position2.getDistance()));
                
            }

            return data;
            
            
           /* data.add(new CardData("City Bank ATM", 3.5, "9028576234", "5.1" + "Km", 1,""));
            data.add(new CardData("ICICI Bank ATM ", 4.2, "8007140088", "2.3" + "Km", 2,""));
            data.add(new CardData("Kotak Mahindra ATM", 2.5, "9028576234", "7.3" + "Km", 1,""));
            data.add(new CardData("SBI ATM", 4.1, "8007140088", "1.3" + "Km", 2,""));
            data.add(new CardData("Canara Bank ATM", 1.2, "9028576234", "6.8" + "Km", 1,""));
            data.add(new CardData("IDBI Bank ATM", 4.2, "8007140088", "7.7" + "Km", 2,""));
            data.add(new CardData("HDFC Bank ATM", 4.3, "9028576234", "3.2" + "Km", 1,""));
            data.add(new CardData("Punjab National Bank ATM", 1.2, "8007140088", "6.7" + "Km", 2,""));
            data.add(new CardData("Axis Bank ATM", 2.5, "9028576234", "5.8" + "Km", 1,""));
            data.add(new CardData("Indian Overseas Bank ATM", 2.7, "8007140088", "3.8" + "Km", 2,""));
            return data;*/
        }

        if (position == 7) {
            data.add(new CardData("Sutar Hospital", 3.5, "9028576234", "2.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("Hinjewadi Hospital", 2.2, "8007140088", "15.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("Sanjivani Hospital", 1.5, "9028576234", "3.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("City Care Hospital", 2.1, "8007140088", "5.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("Surya Hospital", 3.2, "9028576234", "5.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("Sai Hospital", 2.7, "8007140088", "1.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("Polaris HealthCare", 2.3, "9028576234", "1.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("Lokmanya Hospital", 1.2, "8007140088", "4.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("Apple Hospital", 3.1, "9028576234", "2.2" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("Aditya Birla Hospital", 4.5, "8007140088", "12.2" + "Km", 2,"","0.0","0.0",0.0));
            return data;
        }

        if (position == 8) {
            data.add(new CardData("Sutar Hospital", 3.5, "9028576234", "2.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("Hinjewadi Hospital", 2.2, "8007140088", "15.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("Sanjivani Hospital", 1.5, "9028576234", "3.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("City Care Hospital", 2.1, "8007140088", "5.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("Surya Hospital", 3.2, "9028576234", "5.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("Sai Hospital", 2.7, "8007140088", "1.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("Polaris HealthCare", 2.3, "9028576234", "1.4" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("Lokmanya Hospital", 1.2, "8007140088", "4.3" + "Km", 2,"","0.0","0.0",0.0));
            data.add(new CardData("Apple Hospital", 3.1, "9028576234", "2.2" + "Km", 1,"","0.0","0.0",0.0));
            data.add(new CardData("Aditya Birla Hospital", 4.5, "8007140088", "12.2" + "Km", 2,"","0.0","0.0",0.0));
            return data;
        }

        return data;

    }


    public static List<Position> getBankData() {
        return bankData;
    }

    public static void setBankData(List<Position> bankData) {
        StaticDataProvider.bankData = bankData;
    }

    private static List<Position> bankData = new ArrayList<>();

    public static List<Position> getFuelData() {
        return fuelData;
    }

    public static void setFuelData(List<Position> fuelData) {
        StaticDataProvider.fuelData = fuelData;
    }

    private static List<Position> fuelData = new ArrayList<>();

    public static CardData getSelectData() {
        return selectData;
    }

    public static void setSelectData(CardData selectData) {
        StaticDataProvider.selectData = selectData;
    }



}
