package miway.com.materialtest.adaptor;

import android.content.Context;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import miway.com.materialtest.utility.AnimationUtils;
import miway.com.materialtest.pojo.CardData;
import miway.com.materialtest.R;

/**
 * Created by Mallinath on 6/18/2015.
 */
public class CardListAdaptor extends RecyclerView.Adapter<CardListAdaptor.MyCardViewHolder> {

    LayoutInflater inflater;
    List<CardData> data = Collections.emptyList();
    private int previousPosition = 0;
    private CardClickListener cardClickListener;



    public CardListAdaptor(Context context, List<CardData> data) {

        inflater = LayoutInflater.from(context);
        this.data = data;


    }

    public void setCardClickListener(CardClickListener cardClickListener){
        this.cardClickListener = cardClickListener;
    }

    public void clear() {
        data.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<CardData> list) {
        data.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public MyCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.listwithcards, parent, false);
        MyCardViewHolder myCardViewHolder = new MyCardViewHolder(view);
        return myCardViewHolder;


    }

    @Override
    public void onBindViewHolder(MyCardViewHolder holder, int position) {


        holder.name.setText(data.get(position).getName());
        holder.callText.setText(data.get(position).getCallText());
        holder.navText.setText(data.get(position).getNavText());
        holder.rating.setText(data.get(position).getRating()+"");
        holder.goToId = data.get(position).getGoToId();
        holder.address.setText(data.get(position).getAddress());
        holder.cardData = data.get(position);

        if (position > previousPosition) {

            AnimationUtils.animate(holder, true);

        } else {

            AnimationUtils.animate(holder, false);

        }
        previousPosition = position;


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyCardViewHolder extends RecyclerView.ViewHolder {

        //TextView text;
        TextView name;
        TextView rating;
        TextView callText;
        TextView navText;
        TextView address;
        LinearLayout callLayout;
        CardView cardView;
        int goToId;
        CardData cardData;


        public MyCardViewHolder(View itemView) {
            super(itemView);




            name = (TextView) itemView.findViewById(R.id.nameText);
            rating = (TextView) itemView.findViewById(R.id.rating);
            callText = (TextView) itemView.findViewById(R.id.phonenumber);
            navText = (TextView) itemView.findViewById(R.id.distance);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            address = (TextView) itemView.findViewById(R.id.address);
            /*Typeface typeface = Typeface.createFromAsset()
            name.setTypeface();
*/
            callLayout = (LinearLayout) itemView.findViewById(R.id.callLayout);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    System.out.println("card view clicked"+goToId);
                    cardClickListener.cardViewClicked(cardData);

                }
            });

            callLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    System.out.println("call clicked");

                    cardClickListener.callLayoutClicked(Long.parseLong(callText.getText().toString()),goToId);


                }
            });


        }

    }

    public interface CardClickListener{

        public void callLayoutClicked(long number,int goToId);
        public void cardViewClicked(CardData cardData);
        public void navLayoutClicked(int goToId);
    }
}
