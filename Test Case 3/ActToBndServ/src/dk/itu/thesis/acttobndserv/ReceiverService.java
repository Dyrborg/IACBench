package dk.itu.thesis.acttobndserv;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ReceiverService extends Service {
	
	private final IBinder mBinder = new MyBinder();

	@Override
	public int onStartCommand(Intent service, int flags, int startId) {
		if(service != null){
			Log.i(MainActivity.EXTRA_KEY, service.getStringExtra(MainActivity.EXTRA_KEY));
		}
		return super.onStartCommand(service, flags, startId);
	}
	
	@Override
	public boolean bindService(Intent service, ServiceConnection conn, int flags) {
		if(service != null){
			Log.i(MainActivity.EXTRA_KEY, service.getStringExtra(MainActivity.EXTRA_KEY));
		}
		return super.bindService(service, conn, flags);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public class MyBinder extends Binder {
		ReceiverService getService() {
	      return ReceiverService.this;
	    }
	  }

}
