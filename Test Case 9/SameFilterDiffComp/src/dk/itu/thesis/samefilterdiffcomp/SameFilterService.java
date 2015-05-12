package dk.itu.thesis.samefilterdiffcomp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SameFilterService extends Service {

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		if(intent != null){
			Log.i(SameFilterMainActivity.EXTRA_KEY, intent.getStringExtra(SameFilterMainActivity.EXTRA_KEY));
		}
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
