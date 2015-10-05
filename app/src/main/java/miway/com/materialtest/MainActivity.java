package miway.com.materialtest;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.pkmmte.view.CircularImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment.OnFragmentInteractionListener,DataFragment.OnFragmentInteractionListener,SubDataFragment.OnFragmentInteractionListener {

    private Toolbar toolbar;
    private RecyclerView recycleGrid;

    private GridAdaptor gridAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);


        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("MiWay");

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);





        Fragment fragment = new DataFragment();
        getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();

        View circularImageView = findViewById(R.id.profilephoto);
        circularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("Profile photo clicked");
                profilePhotoClicked(v);

            }
        });

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


        String url = "tel:9028576234";
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(url)));

    }
}
