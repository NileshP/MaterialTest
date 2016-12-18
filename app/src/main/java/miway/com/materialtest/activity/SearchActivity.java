package miway.com.materialtest.activity;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import miway.com.materialtest.pojo.CardData;
import miway.com.materialtest.adaptor.CardListAdaptor;
import miway.com.materialtest.R;


public class SearchActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private RecyclerView cardRecycleView;
    private CardListAdaptor cardListAdaptor;
    EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
       /* searchText = new EditText(this);
        searchText.setHint("Search");
        searchText.setTextColor(Color.GRAY);
        searchText.setWidth(300);
*/

        toolbar = (Toolbar) findViewById(R.id.app_bar_search);

        searchText = (EditText) findViewById(R.id.myEditText);


       // toolbar.addView(new EditText(this));

        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("");

        cardRecycleView = (RecyclerView) findViewById(R.id.cardListView);
        cardListAdaptor = new CardListAdaptor(this,getCardListData(0));

        cardRecycleView.setAdapter(cardListAdaptor);
        cardRecycleView.setLayoutManager(new LinearLayoutManager(this));

    }

    public static List<CardData> getCardListData(int position){


        System.out.println("---------------------------------"+position+"-------------------------------------------");

        List<CardData> data = new ArrayList<CardData>();

        data.add(new CardData("Sutar Hospital",3.5,"9028576234","2.4"+"Km",1,"","0.0","0.0",0.0));
        data.add(new CardData("Hinjewadi Hospital", 2.2, "8007140088", "15.3" + "Km", 2,"","0.0","0.0",0.0));
        data.add(new CardData("Sanjivani Hospital",1.5,"9028576234","3.4"+"Km",1,"","0.0","0.0",0.0));
        data.add(new CardData("City Care Hospital",2.1,"8007140088","5.3"+"Km",2,"","0.0","0.0",0.0));
        data.add(new CardData("Surya Hospital",3.2,"9028576234","5.4"+"Km",1,"","0.0","0.0",0.0));
        data.add(new CardData("Sai Hospital",2.7,"8007140088","1.3"+"Km",2,"","0.0","0.0",0.0));
        data.add(new CardData("Polaris HealthCare",2.3,"9028576234","1.4"+"Km",1,"","0.0","0.0",0.0));
        data.add(new CardData("Lokmanya Hospital",1.2,"8007140088","4.3"+"Km",2,"","0.0","0.0",0.0));
        data.add(new CardData("Apple Hospital",3.1,"9028576234","2.2"+"Km",1,"","0.0","0.0",0.0));
        data.add(new CardData("Aditya Birla Hospital",4.5,"8007140088","12.2"+"Km",2,"","0.0","0.0",0.0));




        return data;


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        if(id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);


        }

        return super.onOptionsItemSelected(item);
    }
}
