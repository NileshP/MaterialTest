package miway.com.materialtest;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.kaerdan.twolevelexpandablerecyclerview.TwoLevelExpandableAdapter;
import org.kaerdan.twolevelexpandablerecyclerview.ViewHolderWithSetter;

import java.util.List;

/**
 * Created by Mallinath on 6/20/2015.
 */
public class ExpandableListAdaptor extends TwoLevelExpandableAdapter<CustomDataSet> {

    private ClickListener clickListener;

    protected ExpandableListAdaptor(List<CustomDataSet> data) {
        super(data);
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolderWithSetter getSecondLevelViewHolder(ViewGroup viewGroup) {
        return new ExpandableViewHolder(View.inflate(viewGroup.getContext(),R.layout.list_item_members,null));
    }

    @Override
    public ViewHolderWithSetter getTopLevelViewHolder(ViewGroup viewGroup) {
        return new ExpandableViewHolder(View.inflate(viewGroup.getContext(),
                R.layout.list_item_header, null));
    }

    @Override
    public void onBindViewHolder(ViewHolderWithSetter holder, int position) {
        super.onBindViewHolder(holder, position);

        if(super.ITEM_TYPE == holder.getItemViewType()){




        }

    }

    public class ExpandableViewHolder extends ViewHolderWithSetter<CustomViewData> {


        private int clickId;

        public ExpandableViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickListener.itemClicked(v,getPosition(),clickId);
                }
            });


        }



        @Override
        public void setItem(CustomViewData s) {

            TextView textView = (TextView) itemView.findViewById(R.id.listText);
            textView.setText(s.getName());

            clickId = s.getClickId();

            if(!s.isItem()) {
                ImageView imageView = (ImageView) itemView.findViewById(R.id.listIcon);
                imageView.setImageResource(s.getIconId());
            }

        }







    }

    public interface ClickListener {

        public void itemClicked(View view, int position,int clickId);
    }
}
