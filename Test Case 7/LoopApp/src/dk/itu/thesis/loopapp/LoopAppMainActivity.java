package dk.itu.thesis.loopapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;


public class LoopAppMainActivity extends Activity {
	
	public static final String EXTRA_KEY = "SECRET_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_app_main);
        if(getIntent() != null){
			sendIntent(getIntent().getStringExtra(LoopAppMainActivity.EXTRA_KEY));
		}
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
    	Intent intent = new Intent();
    	intent.setAction("dk.itu.thesis.ACTION");
    	intent.putExtra(LoopAppMainActivity.EXTRA_KEY, extra);
    	intent.setType("text/plain");
    	startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loop_app_main, menu);
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
