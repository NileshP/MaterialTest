package miway.com.materialtest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

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

    private OnFragmentInteractionListener mListener;



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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
    public void cardViewClicked(int goToId) {


        Fragment fragment = new DetailsFragment();
        getFragmentManager().beginTransaction().replace(R.id.content_frame_subdata,fragment).commit();
    }

    @Override
    public void navLayoutClicked(int goToId) {

    }

    @Override
    public void onRefresh() {


       /* new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                swipeContainer.setRefreshing(false);
            }
        }, 5000);*/

        Log.d("start time", System.currentTimeMillis() + "");
        invokeWS();



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


    class FetchData extends AsyncTask<Void,String,List<CardData>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           // cardListAdaptor.clear();
        }

        @Override
        protected List<CardData> doInBackground(Void... params) {


            List<CardData> cardData = new ArrayList<>();

            invokeWS();

            return cardData;
        }

        @Override
        protected void onPostExecute(List<CardData> cardData_new) {
            super.onPostExecute(cardData_new);

           // cardListAdaptor.addAll(cardData_new);

            swipeContainer.setRefreshing(false);

        }
    }

    public void invokeWS(){
        // Show Progress Dialog

        // Make RESTful webservice call using AsyncHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://52.88.2.44:8080/position?latitude=17.655&longitude=75.905" ,new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                Toast.makeText(SubDataFragment.this.getActivity(), "StatusCode "+statusCode, Toast.LENGTH_LONG).show();
                swipeContainer.setRefreshing(false);
                Log.d("End time", System.currentTimeMillis() + "");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                Toast.makeText(SubDataFragment.this.getActivity(), "StatusCode "+statusCode, Toast.LENGTH_LONG).show();
            }


        });
    }




}

