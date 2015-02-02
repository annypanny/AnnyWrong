package ca.ualberta.cs.travelexpensetracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditClaimActivity extends Activity {
	
	private EditText c_name;
	private EditText c_sd;
	private EditText c_ed;
	private EditText c_des;
	private Spinner c_status;
	private Button c_save;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_claim);
		
		c_name = (EditText) findViewById(R.id.CN);
		c_sd = (EditText) findViewById(R.id.SD);
		c_ed = (EditText) findViewById(R.id.ED);
		c_des = (EditText) findViewById(R.id.D);
		c_status = (Spinner) findViewById(R.id.StatusS);
		c_save = (Button) findViewById(R.id.AddC);
		
		Collection<Claim> claim = Controller.getClaimList().getClaims();
		ArrayList<Claim> claimlist = new ArrayList<Claim>(claim);
		final int cpos = Index.getIndex();
		
        c_name.setText(claimlist.get(cpos).toString());	
		final SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
		c_sd.setText(date.format(claimlist.get(cpos).SdStr()));
		c_ed.setText(date.format(claimlist.get(cpos).EdStr()));
		c_des.setText(claimlist.get(cpos).desStr());
		c_status.setSelection(getIndex(c_status, claimlist.get(cpos).statusStr()));
		
	    c_save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
                String sst = c_status.getSelectedItem().toString();				
				Collection<Claim> claim = Controller.getClaimList().getClaims();
				ArrayList<Claim> claimlist = new ArrayList<Claim>(claim);
			
				try {
					claimlist.get(cpos).setSDay(date.parse(c_sd.getText().toString()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					claimlist.get(cpos).setEDay(date.parse(c_ed.getText().toString()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				claimlist.get(cpos).setName(c_name.getText().toString());
				claimlist.get(cpos).setDes(c_des.getText().toString());
				claimlist.get(cpos).setStatus(sst);
				
				Controller controller = new Controller();
				controller.editClaim();
				finish();
			}
		});
		
	}

	// http://stackoverflow.com/questions/2390102/how-to-set-selected-item-of-spinner-by-value-not-by-position 2015-02-01
	private int getIndex(Spinner spi, String SStr) {
        int index = 0;
		for (int i=0; i<spi.getCount(); i++) {
			if (spi.getItemAtPosition(i).equals(SStr)) {
				index = i;
			}
		}
		return index;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_claim, menu);
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
