package dk.itu.thesis.longchain;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class LongChainBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(LongChainMainActivity.EXTRA_KEY, intent.getStringExtra(LongChainMainActivity.EXTRA_KEY));
	}
}
