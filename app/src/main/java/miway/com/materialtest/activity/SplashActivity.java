package miway.com.materialtest.activity;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
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
import java.util.concurrent.atomic.AtomicInteger;

import cz.msebera.android.httpclient.Header;
import miway.com.materialtest.pojo.Position;
import miway.com.materialtest.R;
import miway.com.materialtest.pojo.StaticDataProvider;


public class SplashActivity extends ActionBarActivity implements GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener,LocationListener {


    SplashActivity activity = this;
    ProgressBar progressBar;

    AtomicInteger counter = new AtomicInteger(2);


    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    String mLatitudeString="";
    String mLongitudeString = "";



    @Override
    public void onConnected(Bundle bundle) {

        System.out.println("Callback Connected");

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            mLatitudeString = String.valueOf(mLastLocation.getLatitude());
            mLongitudeString = String.valueOf(mLastLocation.getLongitude());

            StaticDataProvider.latitudeString = mLatitudeString;
            StaticDataProvider.longitudeString = mLongitudeString;


        }


    }


    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }


    @Override
    protected void onStart() {
        super.onStart();

        mGoogleApiClient.connect();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        buildGoogleApiClient();

        progressBar = (ProgressBar) this.findViewById(R.id.marker_progress);



        new LocationStarter().execute("");


    }


    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
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

    public void invokeWSBaseJSon(String URLm, final int code, final String dataTypes) {


        // Make RESTful webservice call using AsyncHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();

        StaticDataProvider.getBankData().clear();
        StaticDataProvider.getFuelData().clear();
        final List<Position> positions = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);



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
                        String id = jsonObject.optString("id").toString();


                        Position position = new Position(id,district, city, destinationName, address, contact, latitude, longitude,0.0,dataTypes);

                        positions.add(position);

                    }


                    if(code==4){

                        StaticDataProvider.getFuelData().addAll(positions);

                    }else if(code==6){

                        StaticDataProvider.getBankData().addAll(positions);
                    }

                    //StaticDataProvider.getBankData().addAll(positions);

                    System.out.println("successful execution of code "+code+"----------------"+counter.get());


                    if(counter.decrementAndGet()==0) {

                        progressBar.setVisibility(View.INVISIBLE);

                        Log.d("SUCCESS", "DATA LOADING COMPLETED");

                        Intent intent = new Intent(activity, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }

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


    public class LocationStarter extends AsyncTask<String,Void,String>{


        @Override
        protected String doInBackground(String... params) {

            while(!mGoogleApiClient.isConnected()) {

                try {
                    Thread.sleep(100);
                }catch(InterruptedException e){

                    e.printStackTrace();
                }
            }

            System.out.println("GPS Coordinates received"+ mLatitudeString+"--"+mLongitudeString);



            return "SUCCESS";
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            if(mLatitudeString != null && mLongitudeString != null){


                String urlPetrol =  StaticDataProvider.ServerURL+"8093/positionjson?latitude="+StaticDataProvider.latitudeString+"&longitude="+StaticDataProvider.longitudeString+"&dataType=2";
                String urlATM = StaticDataProvider.ServerURL+"8093/positionjson?latitude="+StaticDataProvider.latitudeString+"&longitude="+StaticDataProvider.longitudeString+"&dataType=1";
                String urlResto = StaticDataProvider.ServerURL+"8093/positionjson?latitude="+StaticDataProvider.latitudeString+"&longitude="+StaticDataProvider.longitudeString+"&dataType=3";

                invokeWSBaseJSon(urlPetrol,4,"2");
                invokeWSBaseJSon(urlATM,6,"1");
                invokeWSBaseJSon(urlResto,5,"3");

            }
        }
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

}



