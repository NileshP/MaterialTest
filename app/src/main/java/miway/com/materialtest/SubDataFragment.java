package miway.com.materialtest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SubDataFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SubDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubDataFragment extends Fragment implements CardListAdaptor.CardClickListener {


    private RecyclerView cardRecycleView;
    private CardListAdaptor cardListAdaptor;
    private CardListAdaptor.CardClickListener cardClickListener;

    private OnFragmentInteractionListener mListener;

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
        cardListAdaptor = new CardListAdaptor(getActivity(), SearchActivity.getCardListData());
        cardListAdaptor.setCardClickListener(this);
        cardRecycleView.setAdapter(cardListAdaptor);
        cardRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

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
        startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(url)));
    }

    @Override
    public void cardViewClicked(int goToId) {


        Fragment fragment = new DetailsFragment();
        getFragmentManager().beginTransaction().replace(R.id.content_frame_subdata,fragment).commit();
    }

    @Override
    public void navLayoutClicked(int goToId) {

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
