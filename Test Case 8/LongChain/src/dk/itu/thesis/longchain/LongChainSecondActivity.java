package dk.itu.thesis.longchain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class LongChainSecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_long_chain_main);
		
		Intent intent = getIntent();
		
		Intent newIntent = new Intent("dk.itu.thesis.ACTION_SEND");
		newIntent.putExtra(LongChainMainActivity.EXTRA_KEY, intent.getStringExtra("secret"));
		
		startActivityForResult(newIntent, 1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.long_chain_main, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		Intent i = new Intent("dk.itu.thesis.ACTION_BATTERY_CHANGED");
		i.putExtra(LongChainMainActivity.EXTRA_KEY, data.getStringExtra(LongChainMainActivity.EXTRA_KEY));
		
		sendBroadcast(i);
		
		super.onActivityResult(requestCode, resultCode, data);
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
