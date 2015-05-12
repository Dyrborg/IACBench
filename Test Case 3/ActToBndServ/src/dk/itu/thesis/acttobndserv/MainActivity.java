package dk.itu.thesis.acttobndserv;

import android.app.Activity;
import android.bluetooth.BluetoothClass.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {
	private ReceiverService s;

	public static final String EXTRA_KEY = "SECRET";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String getDeviceID(){
    	TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
    	return telephonyManager.getDeviceId();
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	sendIntent(getDeviceID());
    }
    
    private ServiceConnection mConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className, 
            IBinder binder) {
        	ReceiverService.MyBinder b = (ReceiverService.MyBinder) binder;
          s = b.getService();
          Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT)
              .show();
        }

        public void onServiceDisconnected(ComponentName className) {
          s = null;
        }
      };
    
    private void sendIntent(String extra){
    	Intent intent = new Intent();
    	intent.setAction("dk.itu.thesis.ACTION_VIEW");
    	intent.putExtra(MainActivity.EXTRA_KEY, extra);
    	//intent.setType("text/plain");
    	bindService(intent, mConnection, Service.INFORMATION);
    }
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
