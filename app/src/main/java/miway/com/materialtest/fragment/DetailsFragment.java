package miway.com.materialtest.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import miway.com.materialtest.activity.MainActivity;
import miway.com.materialtest.pojo.CardData;
import miway.com.materialtest.R;
import miway.com.materialtest.pojo.Position;
import miway.com.materialtest.pojo.StaticDataProvider;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ProgressBar progressBar;

    CardData selectData;

    MapView mapView;
    GoogleMap map;

    View v;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.layout_details_page, container, false);


        View v = inflater.inflate(R.layout.layout_details_page, container, false);


        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.navmaplayout);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);

        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        try {
            MapsInitializer.initialize(this.getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Double lat = Double.parseDouble(getSelectData().getLatitude());
            Double logn = Double.parseDouble(getSelectData().getLongitude());


            if((lat != null) && (logn != null)) {
                // Updates the location and zoom of the MapView
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, logn), 8);
                map.animateCamera(cameraUpdate);
                Marker marker = map.addMarker(new MarkerOptions().position(new LatLng(lat, logn)));
            }

        }catch(Exception e){}



        progressBar = (ProgressBar) v.findViewById(R.id.marker_progress2);


        String url = StaticDataProvider.ServerURL+"8093/detailsjson?id="+getSelectData().getId()+"&dataType=2";

        invokeWSBaseJSon(url,1);

        return v;



    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    public void loadData(String name,String address,String contact,String rating){


        TextView nameText = (TextView) v.findViewById(R.id.detailnameText);
        nameText.setText(getSelectData().getName());
        TextView addressText = (TextView) v.findViewById(R.id.detailAddress);
        addressText.setText(getSelectData().getAddress());
        TextView phoneText = (TextView) v.findViewById(R.id.phonenumber);
        phoneText.setText(getSelectData().getCallText());

        TextView rat = (TextView) v.findViewById(R.id.rating);
        rat.setText(rating);



        TextView navText = (TextView) v.findViewById(R.id.distance);
        navText.setText(getSelectData().getNavText()+" Km");



    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
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




    public CardData getSelectData() {
        return selectData;
    }

    public void setSelectData(CardData selectData) {
        this.selectData = selectData;
    }



    public void invokeWSBaseJSon(String URLm,final int code) {


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
