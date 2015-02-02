package ca.ualberta.cs.travelexpensetracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddItemActivity extends Activity {
	
	//private static final String FILENAME = "ItemFile.sav";
	
	private EditText itemName;
	private Spinner category;
	private EditText itemDate;
	private EditText spendAmount;
	private Spinner currency;
	private EditText itemDescription;
	private Button addItemButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_item_activity);
		
		itemName = (EditText)findViewById(R.id.ItemName);
		category = (Spinner)findViewById(R.id.ItemType);
		itemDate = (EditText)findViewById(R.id.ItemDate);
		spendAmount = (EditText)findViewById(R.id.SpentAmount);
		currency = (Spinner)findViewById(R.id.Currency);
		itemDescription = (EditText)findViewById(R.id.ItemDescription);
		addItemButton = (Button)findViewById(R.id.AddItemButton);
		
		dateFormat();
		
		addItemButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Collection<Claim> claim = Controller.getClaimList().getClaims();
				ArrayList<Claim> claimlist = new ArrayList<Claim>(claim);
				int claimNum = Index.getIndex();
				Controller controller = claimlist.get(claimNum).getController();
				
				String n = itemName.getText().toString();
				String c = category.getSelectedItem().toString();
				String d = itemDate.getText().toString();
				Float sa = Float.valueOf(spendAmount.getText().toString());
				String cur = currency.getSelectedItem().toString();
				String ide = itemDescription.getText().toString();
				
				try {
					controller.addItem(new Item(n,c,d,sa,cur,ide));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}						
				finish();
			}
		});
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_item, menu);
		return true;
	}
	
	@SuppressLint("SimpleDateFormat")
	private void dateFormat() {
		Date date = new Date();
        TextView textview = (TextView) findViewById(R.id.StartDate);
        textview.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
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
