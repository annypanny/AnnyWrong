package ca.ualberta.cs.travelexpensetracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import android.app.Activity;
import android.net.ParseException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditItemActivity extends Activity {
	
	private EditText i_name;
	private EditText i_date;
	private EditText i_spent;
	private EditText i_des;
	private Spinner i_type;
	private Spinner i_curr;
	private Button add_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		
		i_name = (EditText) findViewById(R.id.iName);
		i_date = (EditText) findViewById(R.id.iDate);
		i_spent = (EditText) findViewById(R.id.SAmount);
		i_des = (EditText) findViewById(R.id.iDescription);
		i_type = (Spinner)findViewById(R.id.iType);
		i_curr = (Spinner)findViewById(R.id.Curr);
		add_button = (Button) findViewById(R.id.AddIButton);
		
		final int cpos = Index.getIndex();
        final int epos = Index.getIndex();
		
		Collection<Claim> claim = Controller.getClaimList().getClaims();
		ArrayList<Claim> claimlist = new ArrayList<Claim>(claim);
		claimlist.get(cpos).getController();
		Collection<Item> item = Controller.getItemList().getItem();
		ArrayList<Item> expense = new ArrayList<Item>(item);
		
		add_button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String cate = i_type.getSelectedItem().toString();
				String curr = i_curr.getSelectedItem().toString();
				float _cost = 0;
				if (i_spent.getText().toString().matches("")) {				
				} else {
					_cost = Float.valueOf(i_spent.getText().toString());
				}
				
				Collection<Claim> claim = Controller.getClaimList().getClaims();
				ArrayList<Claim> claimlist = new ArrayList<Claim>(claim);
				ArrayList<Item> expense = claimlist.get(cpos).getItemArray();
			
				expense.get(epos).setName(i_name.getText().toString());
				expense.get(epos).setType(cate);
				expense.get(epos).setDescription(i_des.getText().toString());
				expense.get(epos).setCost(_cost);
				expense.get(epos).setCurr(curr);
				SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
				try {
					try {
						expense.get(epos).setdate(date.parse(i_date.getText().toString()));
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ParseException e) {
					e.printStackTrace();
				} 
				
				Controller controller = new Controller();
				controller.editItem();
				
				
			}
			
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
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
