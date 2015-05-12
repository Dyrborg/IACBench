package dk.itu.thesis.multipleintents;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;


public class MultipleIntentsMainActivity extends Activity {
	public static final String EXTRA_KEY = "SECRET_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_intents_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.multiple_intents_main, menu);
        return true;
    }
    
    private String getDeviceID(){
    	TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
    	return telephonyManager.getDeviceId();
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	Random rand = new Random();
    	if(rand.nextInt(50)>25){
    		Intent i1 = new Intent();
    		i1.setAction("dk.itu.thesis.ACTION");
        	i1.putExtra(MultipleIntentsMainActivity.EXTRA_KEY, getDeviceID());
        	i1.setType("text/plain");
        	startActivity(i1);
    	}
    	else{
    		Intent i2 = new Intent();
    		i2.setAction("dk.itu.thesis.ACTION");
        	i2.putExtra(MultipleIntentsMainActivity.EXTRA_KEY, getDeviceID());
        	i2.setType("text/plain");
        	startActivity(i2);
    	}
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
