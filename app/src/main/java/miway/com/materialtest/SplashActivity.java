package miway.com.materialtest;

import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class SplashActivity extends ActionBarActivity {


    SplashActivity activity = this;
    ProgressBar progressBar;




    @Override
    protected void onStart() {
        super.onStart();


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        progressBar = (ProgressBar) this.findViewById(R.id.marker_progress);



        invokeWSBaseJSon();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void invokeWSBaseJSon() {


        // Make RESTful webservice call using AsyncHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();

        StaticDataProvider.getBankData().clear();
        final List<Position> positions = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);







        String URLm = "http://52.88.2.44:8080/positionjson?latitude=17.655&longitude=75.905";

        System.out.println("URL is "+URLm);

        client.get(URLm, new BaseJsonHttpResponseHandler<Position>() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Position response) {


                System.out.println("Started Parsing");


                try {
                    JSONObject jsonRootObject = new JSONObject(rawJsonResponse);

                    //Get the instance of JSONArray that contains JSONObjects
                    JSONArray jsonArray = jsonRootObject.optJSONArray("position");

                    //Iterate the jsonArray and print the info of JSONObjects
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        String district = jsonObject.getString("district").toString();
                        String city = jsonObject.optString("city").toString();
                        String destinationName = jsonObject.optString("destinationName").toString();
                        String address = jsonObject.optString("address").toString();
                        String contact = jsonObject.optString("contact").toString();
                        String latitude = jsonObject.optString("latitude").toString();
                        String longitude = jsonObject.optString("longitude").toString();


                        Position position = new Position(district, city, destinationName, address, contact, latitude, longitude,0.0);

                        positions.add(position);

                    }

                    StaticDataProvider.getBankData().addAll(positions);

                    progressBar.setVisibility(View.INVISIBLE);

                    Log.d("SUCCESS", "DATA LOADING COMPLETED");

                    Intent intent = new Intent(activity, MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, Position errorResponse) {

            }

            @Override
            protected Position parseResponse(String rawJsonData, boolean isFailure) throws Throwable {

                return null;
            }


            @Override
            public void onFinish() {


            }
        });

    }


}



