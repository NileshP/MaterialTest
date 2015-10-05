package miway.com.materialtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mallinath on 05-10-2015.
 */
public class StaticDataProvider {

    public static List<CardData> getCardListData(int position) {


        //System.out.println("---------------------------------" + position + "-------------------------------------------");

        List<CardData> data = new ArrayList<CardData>();


        if (position == 0) {
            data.add(new CardData("Jeevan Jyoti Services", 3.5, "9028576234", "3.5" + "Km", 1));
            data.add(new CardData("Bharat Ambulance", 2.2, "8007140088", "5.3" + "Km", 2));
            data.add(new CardData("Golder Care Ambulance", 1.5, "9028576234", "13.4" + "Km", 1));
            data.add(new CardData("Om Sai Ambulance", 2.1, "8007140088", "6.3" + "Km", 2));
            data.add(new CardData("Ojas Ambulance", 3.2, "9028576234", "7.4" + "Km", 1));
            data.add(new CardData("MediLife Ambulance", 2.7, "8007140088", "1.3" + "Km", 2));
            data.add(new CardData("Shree Datta Ambulance", 2.3, "9028576234", "1.4" + "Km", 1));
            data.add(new CardData("Pruthvi Ambulance", 1.2, "8007140088", "2.3" + "Km", 2));
            data.add(new CardData("Lokmangal Ambulance", 3.1, "9028576234", "0.2" + "Km", 1));
            data.add(new CardData("Kolumbus Ambulance", 4.5, "8007140088", "2.7" + "Km", 2));
            return data;
        }

        if (position == 1) {
            data.add(new CardData("Sutar Hospital", 3.5, "9028576234", "2.4" + "Km", 1));
            data.add(new CardData("Hinjewadi Hospital", 2.2, "8007140088", "15.3" + "Km", 2));
            data.add(new CardData("Sanjivani Hospital", 1.5, "9028576234", "3.4" + "Km", 1));
            data.add(new CardData("City Care Hospital", 2.1, "8007140088", "5.3" + "Km", 2));
            data.add(new CardData("Surya Hospital", 3.2, "9028576234", "5.4" + "Km", 1));
            data.add(new CardData("Sai Hospital", 2.7, "8007140088", "1.3" + "Km", 2));
            data.add(new CardData("Polaris HealthCare", 2.3, "9028576234", "1.4" + "Km", 1));
            data.add(new CardData("Lokmanya Hospital", 1.2, "8007140088", "4.3" + "Km", 2));
            data.add(new CardData("Apple Hospital", 3.1, "9028576234", "2.2" + "Km", 1));
            data.add(new CardData("Aditya Birla Hospital", 4.5, "8007140088", "12.2" + "Km", 2));
            return data;
        }

        if (position == 2) {
            data.add(new CardData("Divine Chemist", 2.5, "9028576234", "0.4" + "Km", 1));
            data.add(new CardData("Tulsi Medico", 1.2, "8007140088", "1.3" + "Km", 2));
            data.add(new CardData("Shree Mahatoba Medical", 4.5, "9028576234", "13.4" + "Km", 1));
            data.add(new CardData("Morya Medical", 3.1, "8007140088", "6.3" + "Km", 2));
            data.add(new CardData("Shree Ganesh Medical", 4.2, "9028576234", "1.4" + "Km", 1));
            data.add(new CardData("Yashraj Medical", 2.7, "8007140088", "6.3" + "Km", 2));
            data.add(new CardData("Aditya Medical", 1.3, "9028576234", "3.4" + "Km", 1));
            data.add(new CardData("Pawan Medical", 3.2, "8007140088", "6.3" + "Km", 2));
            data.add(new CardData("Mahavir Medical", 2.1, "9028576234", "5.2" + "Km", 1));
            data.add(new CardData("Sidhivinayak Medical", 4.5, "8007140088", "3.2" + "Km", 2));
            return data;
        }

        if (position == 3) {
            data.add(new CardData("Shettys Multicar Service ", 1.5, "9028576234", "2.4" + "Km", 1));
            data.add(new CardData("Patel Motor Service", 3.2, "8007140088", "15.3" + "Km", 2));
            data.add(new CardData("Shri Balaji Auto Service", 2.5, "9028576234", "3.4" + "Km", 1));
            data.add(new CardData("Car and Bike Point", 4.1, "8007140088", "5.3" + "Km", 2));
            data.add(new CardData("Shree Ganesh Auto", 3.1, "9028576234", "5.4" + "Km", 1));
            data.add(new CardData("Yogi MultiCar Service", 3.5, "8007140088", "1.3" + "Km", 2));
            data.add(new CardData("A J Motors", 4.3, "9028576234", "1.4" + "Km", 1));
            data.add(new CardData("Durga Service Center", 2.2, "8007140088", "4.3" + "Km", 2));
            data.add(new CardData("Maruti Service Center", 4.1, "9028576234", "2.2" + "Km", 1));
            data.add(new CardData("Motor Cafe", 2.5, "8007140088", "12.2" + "Km", 2));
            return data;
        }

        if (position == 4) {
            data.add(new CardData("Krishna Petroleum", 2.5, "9028576234", "1.4" + "Km", 1));
            data.add(new CardData("Rajoyog Petroleum", 1.2, "8007140088", "1.7" + "Km", 2));
            data.add(new CardData("Pimple Petroleum", 3.5, "9028576234", "2.2" + "Km", 1));
            data.add(new CardData("Shinde Petroleum", 1.1, "8007140088", "15.6" + "Km", 2));
            data.add(new CardData("Saigauri Petroleum", 3.6, "9028576234", "15.7" + "Km", 1));
            data.add(new CardData("Daulat Petroleum", 2.7, "8007140088", "11.3" + "Km", 2));
            data.add(new CardData("Shree Seva Petroleum", 2.8, "9028576234", "1.8" + "Km", 1));
            data.add(new CardData("Sidhivinayak Petroleum", 4.2, "8007140088", "5.3" + "Km", 2));
            data.add(new CardData("Poonam Petroleum", 3.7, "9028576234", "7.2" + "Km", 1));
            data.add(new CardData("Prajakta Petroleum", 4.5, "8007140088", "1.2" + "Km", 2));
            return data;
        }

        if (position == 5) {
            data.add(new CardData("Courtyard Hinjewadi", 4.5, "9028576234", "4.1" + "Km", 1));
            data.add(new CardData("Rajyog Restaurant ", 3.2, "8007140088", "5.3" + "Km", 2));
            data.add(new CardData("Spice Nation Restaurant", 1.5, "9028576234", "6.3" + "Km", 1));
            data.add(new CardData("Mezza9 Lounge", 3.1, "8007140088", "7.3" + "Km", 2));
            data.add(new CardData("Saundarya Garden", 3.2, "9028576234", "3.8" + "Km", 1));
            data.add(new CardData("Vrundavan Restaurant", 1.2, "8007140088", "2.7" + "Km", 2));
            data.add(new CardData("Eternia Restaurant", 4.3, "9028576234", "6.2" + "Km", 1));
            data.add(new CardData("Kiva Terminus", 3.2, "8007140088", "2.7" + "Km", 2));
            data.add(new CardData("Shanghai Court", 1.0, "9028576234", "4.8" + "Km", 1));
            data.add(new CardData("RushHrs", 2.7, "8007140088", "4.8" + "Km", 2));
            return data;
        }

        if (position == 6) {
            data.add(new CardData("City Bank ATM", 3.5, "9028576234", "5.1" + "Km", 1));
            data.add(new CardData("ICICI Bank ATM ", 4.2, "8007140088", "2.3" + "Km", 2));
            data.add(new CardData("Kotak Mahindra ATM", 2.5, "9028576234", "7.3" + "Km", 1));
            data.add(new CardData("SBI ATM", 4.1, "8007140088", "1.3" + "Km", 2));
            data.add(new CardData("Canara Bank ATM", 1.2, "9028576234", "6.8" + "Km", 1));
            data.add(new CardData("IDBI Bank ATM", 4.2, "8007140088", "7.7" + "Km", 2));
            data.add(new CardData("HDFC Bank ATM", 4.3, "9028576234", "3.2" + "Km", 1));
            data.add(new CardData("Punjab National Bank ATM", 1.2, "8007140088", "6.7" + "Km", 2));
            data.add(new CardData("Axis Bank ATM", 2.5, "9028576234", "5.8" + "Km", 1));
            data.add(new CardData("Indian Overseas Bank ATM", 2.7, "8007140088", "3.8" + "Km", 2));
            return data;
        }

        if (position == 7) {
            data.add(new CardData("Sutar Hospital", 3.5, "9028576234", "2.4" + "Km", 1));
            data.add(new CardData("Hinjewadi Hospital", 2.2, "8007140088", "15.3" + "Km", 2));
            data.add(new CardData("Sanjivani Hospital", 1.5, "9028576234", "3.4" + "Km", 1));
            data.add(new CardData("City Care Hospital", 2.1, "8007140088", "5.3" + "Km", 2));
            data.add(new CardData("Surya Hospital", 3.2, "9028576234", "5.4" + "Km", 1));
            data.add(new CardData("Sai Hospital", 2.7, "8007140088", "1.3" + "Km", 2));
            data.add(new CardData("Polaris HealthCare", 2.3, "9028576234", "1.4" + "Km", 1));
            data.add(new CardData("Lokmanya Hospital", 1.2, "8007140088", "4.3" + "Km", 2));
            data.add(new CardData("Apple Hospital", 3.1, "9028576234", "2.2" + "Km", 1));
            data.add(new CardData("Aditya Birla Hospital", 4.5, "8007140088", "12.2" + "Km", 2));
            return data;
        }

        if (position == 8) {
            data.add(new CardData("Sutar Hospital", 3.5, "9028576234", "2.4" + "Km", 1));
            data.add(new CardData("Hinjewadi Hospital", 2.2, "8007140088", "15.3" + "Km", 2));
            data.add(new CardData("Sanjivani Hospital", 1.5, "9028576234", "3.4" + "Km", 1));
            data.add(new CardData("City Care Hospital", 2.1, "8007140088", "5.3" + "Km", 2));
            data.add(new CardData("Surya Hospital", 3.2, "9028576234", "5.4" + "Km", 1));
            data.add(new CardData("Sai Hospital", 2.7, "8007140088", "1.3" + "Km", 2));
            data.add(new CardData("Polaris HealthCare", 2.3, "9028576234", "1.4" + "Km", 1));
            data.add(new CardData("Lokmanya Hospital", 1.2, "8007140088", "4.3" + "Km", 2));
            data.add(new CardData("Apple Hospital", 3.1, "9028576234", "2.2" + "Km", 1));
            data.add(new CardData("Aditya Birla Hospital", 4.5, "8007140088", "12.2" + "Km", 2));
            return data;
        }

        return data;

    }

}
