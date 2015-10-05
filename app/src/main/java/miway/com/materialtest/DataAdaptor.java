package miway.com.materialtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Mallinath on 6/17/2015.
 */
public class DataAdaptor extends RecyclerView.Adapter<DataAdaptor.MyViewHolder> {

    private final LayoutInflater inflator;
    List<Information> data = Collections.emptyList();

    private ClickListener clickListener;

    public DataAdaptor(Context context, List<Information> data) {

        inflator = LayoutInflater.from(context);

        this.data = data;
    }

    public void setClickListener(ClickListener clickListener){

        this.clickListener = clickListener;



    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = inflator.inflate(R.layout.customrow, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {

        Information current = data.get(i);

        myViewHolder.text.setText(current.title);
        myViewHolder.icon.setImageResource(current.iconId);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView text;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            text = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
        }

        @Override
        public void onClick(View v) {

            if(clickListener != null){

                clickListener.itemClicked(v,getPosition());
            }
        }




    }

    public interface ClickListener {

        public void itemClicked(View view, int position);
    }

}