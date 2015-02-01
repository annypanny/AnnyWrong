package ca.ualberta.cs.travelexpensetracker;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("SimpleDateFormat")
public class AddClaimActivity extends Activity {
	
	
	private EditText claimName;
	private EditText startDate;
	private EditText endDate;
	private EditText description;
	@SuppressWarnings("unused")
	private Button addButton;
	private TextWatcher watcher;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_claim_activity);
		
		
		claimName = (EditText)findViewById(R.id.ClaimName);
		startDate = (EditText)findViewById(R.id.StartDate);
		endDate = (EditText)findViewById(R.id.EndDate);
		description = (EditText)findViewById(R.id.Description);
		addButton = (Button)findViewById(R.id.AddClaimToList);
		
		watcher = new LocalTextWatcher();
		claimName.addTextChangedListener(watcher);
		startDate.addTextChangedListener(watcher);
		endDate.addTextChangedListener(watcher);
		description.addTextChangedListener(watcher);
		
		dateFormat1();
		dateFormat2();
		
		
	}


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
        textview1.setText(new SimpleDateFormat("yyyy-MM-DD").format(date1));
	}
	
	private void dateFormat2() {
		Date date2 = new Date();
        TextView textview2 = (TextView) findViewById(R.id.EndDate);
        textview2.setText(new SimpleDateFormat("yyyy-MM-DD").format(date2));
	}
	
	public void finishAddClaim(View v){
		Intent intent = new Intent(AddClaimActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
	
	private class LocalTextWatcher implements TextWatcher {

		@Override
		public void afterTextChanged(Editable s) {
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			
		}
	}
	
	/*
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
