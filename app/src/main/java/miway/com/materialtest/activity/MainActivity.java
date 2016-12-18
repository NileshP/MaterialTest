package miway.com.materialtest.activity;

import android.app.Fragment;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;



import java.util.ArrayList;
import java.util.List;

import miway.com.materialtest.fragment.DataFragment;
import miway.com.materialtest.adaptor.GridAdaptor;
import miway.com.materialtest.adaptor.GridInformation;
import miway.com.materialtest.fragment.NavigationDrawerFragment;
import miway.com.materialtest.R;
import miway.com.materialtest.pojo.StaticDataProvider;
import miway.com.materialtest.fragment.SubDataFragment;


public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment.OnFragmentInteractionListener,DataFragment.OnFragmentInteractionListener,SubDataFragment.OnFragmentInteractionListener,GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener,LocationListener
{

    private Toolbar toolbar;
    private RecyclerView recycleGrid;

    private GridAdaptor gridAdaptor;

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
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);


        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("MiWay");

        buildGoogleApiClient();


        System.out.println("Latitude : " + mLatitudeString + "\n Longitude : " + mLongitudeString);


        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);


        Fragment fragment = new DataFragment();
        getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();

        View circularImageView = findViewById(R.id.profilephoto);
        circularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("Profile photo clicked");
                profilePhotoClicked(v);

            }
        });

        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();

            System.out.println("Checking");
            if(mGoogleApiClient.isConnected()) {
                System.out.println("Connected");
            }else{
                System.out.println("2 Not Connect");
            }

            if(mGoogleApiClient.isConnecting()){

                System.out.println("Trying to connect");
            }else{

                System.out.println("Not trying to connect");
            }

        } else{


            System.out.println("Not Connected");

        }

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);


        if (mLastLocation == null){

            System.out.println("m Lst Location is null");

        }else{

            System.out.println("m last location is not null");
        }


    }




        protected synchronized void buildGoogleApiClient() {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }





    public static List<GridInformation> getGridInformation(){

            List<GridInformation> data = new ArrayList<>();

            int[] imageIds = {R.drawable.ambucolcir,R.drawable.hospicolcir,R.drawable.pharmccolcir,R.drawable.garagecolcir,R.drawable.fuelcolcir,R.drawable.restaurantcolcir,R.drawable.atmcolcir,R.drawable.phonecolcir,R.drawable.toiletcolcir};

            for (int i=0;i<imageIds.length;i++){

                GridInformation gridInformation = new GridInformation(imageIds[i]);
                data.add(gridInformation);

            }

            return data;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        if(id == R.id.search){


            startActivity(new Intent(this,SearchActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public void profilePhotoClicked(View v) {

        startActivity(new Intent(this, ProfileActivity.class));

    }


    public void tollFreeClicked(View v){


        String url = "tel:18005551234";
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(url)));

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
