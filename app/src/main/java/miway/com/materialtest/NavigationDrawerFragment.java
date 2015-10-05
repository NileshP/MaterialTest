package miway.com.materialtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.pkmmte.view.CircularImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NavigationDrawerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NavigationDrawerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavigationDrawerFragment extends Fragment implements ExpandableListAdaptor.ClickListener {


    private RecyclerView recyclerView;
   // private DataAdaptor dataAdaptor;
    private ExpandableListAdaptor expandableListAdapter;
   // private RecyclerView expandableRecyclerView;

    public static final String PREF_FILE_NAME = "testPref";

    public static  final String KEY_USER_LEARNED_DRAWER="user_learned_drawer";
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    View containerView;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NavigationDrawerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NavigationDrawerFragment newInstance(String param1, String param2) {
        NavigationDrawerFragment fragment = new NavigationDrawerFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    private static List<CustomDataSet> getCountryList() {
        List<CustomDataSet> countries = new ArrayList<>();
        List<CustomViewData> medicalmenu = new ArrayList<>();
        medicalmenu.add(new CustomViewData(R.drawable.ic_number1, "Ambulance", 1,true));
        medicalmenu.add(new CustomViewData(R.drawable.ic_number2, "Pharmacy", 2,true));
        medicalmenu.add(new CustomViewData(R.drawable.ic_number3, "Hospitals", 3,true));
        medicalmenu.add(new CustomViewData(R.drawable.ic_number3, "Clinics", 4,true));
        medicalmenu.add(new CustomViewData(R.drawable.ic_number3, "Doctors", 5,true));
        medicalmenu.add(new CustomViewData(R.drawable.ic_number3, "Blood Banks", 6,true));
        



        countries.add(new CustomDataSet(new CustomViewData(R.drawable.medical,"MEDICAL",7,false), medicalmenu));


        List<CustomViewData> vehicalmenu = new ArrayList<>();
        vehicalmenu.add(new CustomViewData(R.drawable.ic_number1, "Fuel", 8,true));
        vehicalmenu.add(new CustomViewData(R.drawable.ic_number2, "Garage & Service", 9,true));
        vehicalmenu.add(new CustomViewData(R.drawable.ic_number3, "Tow Service", 10,true));

        countries.add(new CustomDataSet(new CustomViewData(R.drawable.vehicles,"VEHICLE",11,false), vehicalmenu));

        List<CustomViewData> moneymenu = new ArrayList<>();
        moneymenu.add(new CustomViewData(R.drawable.ic_number1, "ATM", 12,true));
        moneymenu.add(new CustomViewData(R.drawable.ic_number2, "Banks", 13,true));
        moneymenu.add(new CustomViewData(R.drawable.ic_number3, "Money Transfer", 14,true));

        countries.add(new CustomDataSet(new CustomViewData(R.drawable.money,"MONEY",15,false), moneymenu));

        List<CustomViewData> foodandstaymenu = new ArrayList<>();
        foodandstaymenu.add(new CustomViewData(R.drawable.ic_number1, "Restaurants", 16,true));
        foodandstaymenu.add(new CustomViewData(R.drawable.ic_number2, "Hotels", 17,true));


        countries.add(new CustomDataSet(new CustomViewData(R.drawable.foodstay,"FOOD & STAY",18,false), foodandstaymenu));


        List<CustomViewData> localattractionmenu = new ArrayList<>();

        countries.add(new CustomDataSet(new CustomViewData(R.drawable.local_attractions,"LOCAL ATTRACTION",19,false), localattractionmenu));

        List<CustomViewData> transportmenu = new ArrayList<>();
        transportmenu.add(new CustomViewData(R.drawable.ic_number1, "Bus Stand", 20,true));
        transportmenu.add(new CustomViewData(R.drawable.ic_number2, "Railway Station", 21,true));
        transportmenu.add(new CustomViewData(R.drawable.ic_number1, "Taxi", 22,true));
        transportmenu.add(new CustomViewData(R.drawable.ic_number2, "Auto/Rickshaw", 23,true));
        transportmenu.add(new CustomViewData(R.drawable.ic_number1, "Rent a Vehicle", 24,true));

        countries.add(new CustomDataSet(new CustomViewData(R.drawable.transport,"TRANSPORT",25,false), transportmenu));

        List<CustomViewData> communicationmenu = new ArrayList<>();
        communicationmenu.add(new CustomViewData(R.drawable.ic_number1, "Mobile Recharge", 26,true));
        communicationmenu.add(new CustomViewData(R.drawable.ic_number2, "STD Booth", 27,true));
        communicationmenu.add(new CustomViewData(R.drawable.ic_number2, "Cyber Cafe", 28,true));


        countries.add(new CustomDataSet(new CustomViewData(R.drawable.communication,"COMMUNICATION",29,false), communicationmenu));


        return countries;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       mUserLearnedDrawer = Boolean.valueOf(readFromPreference(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));


       if(savedInstanceState != null){

        mFromSavedInstanceState = true;

       }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);


        recyclerView = (RecyclerView) layout.findViewById(R.id.recyclerView);
        expandableListAdapter = new ExpandableListAdaptor(getCountryList());
       // dataAdaptor = new DataAdaptor(getActivity(),getData());
        recyclerView.setAdapter(expandableListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        expandableListAdapter.setClickListener(this);
        //dataAdaptor.setClickListener(this);

        View circularImageView = layout.findViewById(R.id.profilephoto);
        circularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });

        return layout;
    }

    public static List<Information> getData(){

        List<Information> data = new ArrayList<>();

        int[] icons = {R.drawable.ic_number1,R.drawable.ic_number2,R.drawable.ic_number3,R.drawable.ic_number4};
        String[] titles = {"Item 1","Item 2","Item 3","Item 4"};

        for (int i=0;i< titles.length;i++){

            Information information = new Information(icons[i],titles[i]);
            data.add(information);


        }


        return data;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setUp(int fragmentId,DrawerLayout drawerLayout, Toolbar toolbar) {

        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                if(!mUserLearnedDrawer){

                    mUserLearnedDrawer = true;
                    saveToPreference(getActivity(),KEY_USER_LEARNED_DRAWER,mUserLearnedDrawer+"");
                }

                getActivity().invalidateOptionsMenu();

            }


            @Override
            public void onDrawerClosed(View drawerView) {

                super.onDrawerClosed(drawerView);

                getActivity().invalidateOptionsMenu();
            }
        };


        if(!mUserLearnedDrawer){

            mDrawerLayout.openDrawer(containerView);
        }


        mDrawerLayout.setDrawerListener(mDrawerToggle);


        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {

                mDrawerToggle.syncState();

            }
        });

    }



    public static void saveToPreference(Context context,String preferenceName,String preferenceValue){

        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME,context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName,preferenceValue);
        editor.commit();

    }

    public static String readFromPreference(Context context,String preferenceName,String defaultValue){

        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME,context.MODE_PRIVATE);

        return sharedPreferences.getString(preferenceName,defaultValue);

    }


    @Override
    public void itemClicked(View view, int position, int clickId) {



        Log.d("SYSO", clickId + "---"+position);
        System.out.println("Position selected" + clickId);

        //  startActivity(new Intent(getActivity(),SearchActivity.class));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
