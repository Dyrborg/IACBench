package dk.itu.thesis.samefilterdiffcomp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SameFilterBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent intent) {
		if(intent != null){
			Log.i(SameFilterMainActivity.EXTRA_KEY, intent.getStringExtra(SameFilterMainActivity.EXTRA_KEY));
		}
	}

}
