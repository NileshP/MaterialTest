package miway.com.materialtest;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SubDataFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SubDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubDataFragment extends Fragment implements CardListAdaptor.CardClickListener, SwipeRefreshLayout.OnRefreshListener {


    private RecyclerView cardRecycleView;
    private CardListAdaptor cardListAdaptor;
    private CardListAdaptor.CardClickListener cardClickListener;
    private SwipeRefreshLayout swipeContainer;

    private boolean success = false;
    private OnFragmentInteractionListener mListener;


     List<Position> listData = new ArrayList<Position>();
    List<CardData> cardListData = new ArrayList<CardData>();
    private int dataPosition;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubDataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SubDataFragment newInstance(String param1, String param2) {
        SubDataFragment fragment = new SubDataFragment();

        return fragment;
    }

    public SubDataFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sub_data, container, false);

        cardRecycleView = (RecyclerView) view.findViewById(R.id.cardListViewSubData);
        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainer);

        swipeContainer.setOnRefreshListener(this);

        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);



    cardListAdaptor = new CardListAdaptor(getActivity(), StaticDataProvider.getCardListData(getDataPosition()));
        cardListAdaptor.setCardClickListener(this);
        cardRecycleView.setAdapter(cardListAdaptor);
        cardRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if(getDataPosition() == 0)
            getActivity().setTitle("Ambulance");
        if(getDataPosition() == 1)
            getActivity().setTitle("Hospitals");
        if(getDataPosition() == 2)
            getActivity().setTitle("Pharmacy");
        if(getDataPosition() == 3)
            getActivity().setTitle("Garage");
        if(getDataPosition() == 4)
            getActivity().setTitle("Fuel Pumps");
        if(getDataPosition() == 5)
            getActivity().setTitle("Restaurant");
        if(getDataPosition() == 6)
            getActivity().setTitle("ATM");
        if(getDataPosition() == 7)
            getActivity().setTitle("PhoneBooth");
        if(getDataPosition() == 8)
            getActivity().setTitle("Toilet");


        return view;
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

    @Override
    public void callLayoutClicked(long number, int goToId) {

        String url = "tel:"+number;
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(url)));
    }

    @Override
    public void cardViewClicked(CardData cardData) {


        Fragment fragment = new DetailsFragment();

        ((DetailsFragment)fragment).setSelectData(cardData);

        getFragmentManager().beginTransaction().replace(R.id.content_frame_subdata,fragment).commit();
    }

    @Override
    public void navLayoutClicked(int goToId) {

    }

    @Override
    public void onRefresh() {


        Log.d("start time", System.currentTimeMillis() + "");
        invokeWSBaseJSon();





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

    public int getDataPosition() {
        return dataPosition;
    }

    public void setDataPosition(int dataPosition) {
        this.dataPosition = dataPosition;
    }




    public void invokeWSBaseJSon(){

        // Show Progress Dialog
        swipeContainer.setRefreshing(true);
        // Make RESTful webservice call using AsyncHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();




        client.get("http://52.88.2.44:8080/positionjson?latitude="+StaticDataProvider.latitudeString+"&longitude="+StaticDataProvider.longitudeString+"" ,new BaseJsonHttpResponseHandler<Position>() {





            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Position response) {


                System.out.println("Started Parsing");

                System.out.println(rawJsonResponse);


                try {
                    JSONObject  jsonRootObject = new JSONObject(rawJsonResponse);

                    //Get the instance of JSONArray that contains JSONObjects
                    JSONArray jsonArray = jsonRootObject.optJSONArray("position");

                    //Iterate the jsonArray and print the info of JSONObjects
                    for(int i=0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        String district = jsonObject.getString("district").toString();
                        String city = jsonObject.optString("city").toString();
                        String destinationName = jsonObject.optString("destinationName").toString();
                        String address = jsonObject.optString("address").toString();
                        String contact = jsonObject.optString("contact").toString();
                        String latitude = jsonObject.optString("latitude").toString();
                        String longitude = jsonObject.optString("longitude").toString();


                        Position position = new Position(district,city,destinationName,address,contact,latitude,longitude);
                        listData.add(position);

                        CardData cardData = new CardData(destinationName,0.0,contact,"-.-",i+1,address,latitude,longitude);
                        cardListData.add(cardData);



                    }



                    cardListAdaptor.clear();
                    cardListAdaptor.addAll(cardListData);
                    swipeContainer.setRefreshing(false);


                } catch (JSONException e) {e.printStackTrace();}

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

