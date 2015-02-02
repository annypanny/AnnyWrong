package ca.ualberta.cs.travelexpensetracker;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ExpenseListActivity extends Activity {
	
	private ListView itemListView;
	private int getIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.expense_list_activity);
		
		getIndex = Index.getIndex();
		itemListView = (ListView) findViewById(R.id.ItemList);
		Collection<Claim> claims = Controller.getClaimList().getClaims();
		final ArrayList<Claim> claimList = new ArrayList<Claim>(claims);
		final ArrayList<Item> itemList = claimList.get(getIndex).getItemArray();
		final ArrayAdapter<Item> itemListAdapter = new ArrayAdapter<Item>(this,android.R.layout.simple_list_item_2, itemList);
		itemListView.setAdapter(itemListAdapter);

	Controller.getItemList().addNewListener(new NewListener() {
		public void update() {
			Collection<Item> item = Controller.getItemList().getItem();
			itemList.addAll(item);
			itemListAdapter.notifyDataSetChanged();
		}
	});
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expense_list, menu);
		return true;
	}
	
	public void addItem(View v) {
		//Toast.makeText(this, "Add Claim", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(ExpenseListActivity.this, AddItemActivity.class);
		startActivity(intent);
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
