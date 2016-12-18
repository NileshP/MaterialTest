package miway.com.materialtest.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Collections;
import java.util.List;

import miway.com.materialtest.R;

/**
 * Created by Mallinath on 6/17/2015.
 */
public class GridAdaptor extends RecyclerView.Adapter<GridAdaptor.GridViewHolder>{

    List<GridInformation> data = Collections.emptyList();
    LayoutInflater inflater;
    private GridItemClickListener gridItemClickListener;

    public GridAdaptor(Context context,List<GridInformation> data){
        this.data= data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = inflater.inflate(R.layout.customgridelement,viewGroup,false);

        GridViewHolder gridViewHolder = new GridViewHolder(view);
        return gridViewHolder;



    }

    public void setGridItemClickListener(GridItemClickListener gridItemClickListener){

        this.gridItemClickListener = gridItemClickListener;
    }

    @Override
    public void onBindViewHolder(GridViewHolder gridViewHolder, int i) {

        GridInformation current = data.get(i);

       gridViewHolder.imageId.setImageResource(current.imageId);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

       public ImageView imageId;


        public GridViewHolder(View itemView) {
            super(itemView);
            imageId = (ImageView) itemView.findViewById(R.id.gridIamge);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

                if(gridItemClickListener != null){

                    gridItemClickListener.gridItemClicked(v,getPosition());
                }

        }
    }

    public interface GridItemClickListener{

        public void gridItemClicked(View view,int position);

    }

}
