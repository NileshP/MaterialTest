package miway.com.materialtest;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Mallinath on 6/18/2015.
 */
public class AnimationUtils{


public static void animate(RecyclerView.ViewHolder holder,boolean goesDown){

    ObjectAnimator animateTranslateY = ObjectAnimator.ofFloat(holder.itemView,"translationY",goesDown==true?100:-100,0);

    animateTranslateY.setDuration(500);
    animateTranslateY.start();

}

}
