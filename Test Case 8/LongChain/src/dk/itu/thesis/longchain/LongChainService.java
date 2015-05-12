package dk.itu.thesis.longchain;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LongChainService extends Service {

	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
		
		String secret = intent.getStringExtra(LongChainMainActivity.EXTRA_KEY);
		
		Intent newIntent = new Intent();
		newIntent.setAction("dk.itu.thesis.ACTION_VIEW");
		newIntent.putExtra(LongChainMainActivity.EXTRA_KEY, secret);
		
		startActivity(newIntent);
		
		return -1;
		
    }

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

}
