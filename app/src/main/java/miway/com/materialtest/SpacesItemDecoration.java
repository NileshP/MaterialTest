package miway.com.materialtest;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Mallinath on 6/23/2015.
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int bottomSpace;
    private int rightSpace;
    private int leftSpace;

    public SpacesItemDecoration(int bottomSpace, int rightSpace, int leftSpace) {
        this.bottomSpace = bottomSpace;
        this.rightSpace = rightSpace;
        this.leftSpace = leftSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //super.getItemOffsets(outRect, view, parent, state);

        outRect.bottom = bottomSpace;
        outRect.left = leftSpace;
        outRect.right = rightSpace;
    }
}
