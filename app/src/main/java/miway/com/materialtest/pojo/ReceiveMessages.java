package miway.com.materialtest.pojo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by Mallinath on 08-10-2015.
 */
public class ReceiveMessages extends BroadcastReceiver {




    @Override
    public void onReceive(Context context, Intent intent) {

        IntentFilter filter = new IntentFilter("LOCATION_UPDATE");



    }
}
