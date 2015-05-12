package dk.itu.thesis.acttoservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ReceiverService extends Service {

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(intent != null){
			Log.i(MainActivity.EXTRA_KEY, intent.getStringExtra(MainActivity.EXTRA_KEY));
		}
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
