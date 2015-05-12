package dk.itu.thesis.samefilterdiffcomp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;


public class SameFilterMainActivity extends Activity {
	public static final String EXTRA_KEY = "SECRET_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_filter_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.same_filter_main, menu);
        return true;
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
    
    private void sendIntent(String extra){
    	Intent actintent = new Intent();
    	actintent.setAction("dk.itu.thesis.ACTION_DEFAULT");
    	actintent.putExtra(SameFilterMainActivity.EXTRA_KEY, extra);
    	//intent.setType("text/plain");
    	startActivity(actintent);
    	
    	Intent serviceintent = new Intent();
    	serviceintent.setAction("dk.itu.thesis.ACTION_DEFAULT");
    	serviceintent.putExtra(SameFilterMainActivity.EXTRA_KEY, extra);
    	
    	startService(serviceintent);
    	
    	Intent broadintent = new Intent();
    	broadintent.setAction("dk.itu.thesis.ACTION_DEFAULT");
    	broadintent.putExtra(SameFilterMainActivity.EXTRA_KEY, extra);
    	
    	sendBroadcast(broadintent);
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
