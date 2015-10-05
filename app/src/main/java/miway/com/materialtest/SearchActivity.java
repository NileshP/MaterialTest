package miway.com.materialtest;

import android.graphics.Color;
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
        cardListAdaptor = new CardListAdaptor(this,getCardListData());

        cardRecycleView.setAdapter(cardListAdaptor);
        cardRecycleView.setLayoutManager(new LinearLayoutManager(this));

    }

    public static List<CardData> getCardListData(){

        List<CardData> data = new ArrayList<CardData>();

        data.add(new CardData("Sutar Hospital",3.5,"9028576234","2.4"+"Km",1));
        data.add(new CardData("Hinjewadi Hospital",2.2,"8007140088","15.3"+"Km",2));




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
