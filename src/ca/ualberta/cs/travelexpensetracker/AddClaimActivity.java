package ca.ualberta.cs.travelexpensetracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

@SuppressLint("SimpleDateFormat")
public class AddClaimActivity extends Activity {
	
	
	private EditText claimName;
	private EditText startDate;
	private EditText endDate;
	private EditText description;
	private Button addButton;
	private Spinner status;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_claim_activity);
		
		
		claimName = (EditText)findViewById(R.id.ClaimName);
		startDate = (EditText)findViewById(R.id.StartDate);
		endDate = (EditText)findViewById(R.id.EndDate);
		description = (EditText)findViewById(R.id.Description);
		addButton = (Button)findViewById(R.id.AddClaimToList);
		status = (Spinner)findViewById(R.id.StatusSpinner);
		
		// show the date format as an example for user
		dateFormat1();
		dateFormat2();
		
		addButton.setOnClickListener(new OnClickListener () {

			@Override
			public void onClick(View v) {
				Controller controller = new Controller();
				String claim_name_str = claimName.getText().toString();
				String sdate_str = startDate.getText().toString();
				String edate_str = endDate.getText().toString();
				String des_str = description.getText().toString();
				String status_str = status.getSelectedItem().toString();
				
				try {
					controller.addClaim(new Claim(claim_name_str,sdate_str,edate_str,des_str,status_str));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finish();

				/*
				Gson gson = new Gson();
				claim = (ArrayList<Claim>) Controller.getClaimList().getClaims();
				try{
					FileInputStream fis = openFileInput(FILENAME);
					InputStreamReader in = new InputStreamReader(fis);
					Type dataType = new TypeToken<ClaimList>(){}.getType();
					claim = gson.fromJson(in, dataType);
					fis.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
				
		}
			
		});
	}

		
		
	/*
	private void SaveInFile() {
		Gson gson = new Gson();
		try {
			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(claim, osw);
			osw.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_claim, menu);
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
	
	private void dateFormat1() {
		Date date1 = new Date();
        TextView textview1 = (TextView) findViewById(R.id.StartDate);
        textview1.setText(new SimpleDateFormat("yyyy-MM-dd").format(date1));
	}
	
	private void dateFormat2() {
		Date date2 = new Date();
        TextView textview2 = (TextView) findViewById(R.id.EndDate);
        textview2.setText(new SimpleDateFormat("yyyy-MM-dd").format(date2));
	}
	
	/*
	public void finishAddClaim(View v){
		Intent intent = new Intent(AddClaimActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
	
	
	
	public void returnToPrevActivity(View view) {
		finish();
	}
	
	public void addItem(View v){
		Toast.makeText(this, "Add A Expenses", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(AddClaimActivity .this, ExpenseListActivity.class);
		startActivity(intent);
	}
	*/

}
