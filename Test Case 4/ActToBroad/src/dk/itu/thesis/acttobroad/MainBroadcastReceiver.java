package dk.itu.thesis.acttobroad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MainBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent intent) {
		if(intent != null){
			Log.i(MainActivity.EXTRA_KEY, intent.getStringExtra(MainActivity.EXTRA_KEY));
		}

	}

}
