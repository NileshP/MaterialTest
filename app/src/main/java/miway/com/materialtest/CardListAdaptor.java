package miway.com.materialtest;

import android.content.Context;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;

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
        LinearLayout callLayout;
        CardView cardView;
        int goToId;

        public MyCardViewHolder(View itemView) {
            super(itemView);


            name = (TextView) itemView.findViewById(R.id.nameText);
            rating = (TextView) itemView.findViewById(R.id.rating);
            callText = (TextView) itemView.findViewById(R.id.phonenumber);
            navText = (TextView) itemView.findViewById(R.id.distance);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            /*Typeface typeface = Typeface.createFromAsset()
            name.setTypeface();
*/
            callLayout = (LinearLayout) itemView.findViewById(R.id.callLayout);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    System.out.println("card view clicked"+goToId);
                    cardClickListener.cardViewClicked(goToId);

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
        public void cardViewClicked(int goToId);
        public void navLayoutClicked(int goToId);
    }
}
