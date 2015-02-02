/*
    Travel Expense Tracker: Record and manage each travel expense claim with list of items.
 
    Copyright (C) {2015}  {Xinyi Pan anny_pan@live.cn}

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package ca.ualberta.cs.travelexpensetracker;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView claimListView = (ListView) findViewById(R.id.ClaimList);
		Collection<Claim> claims = Controller.getClaimList().getClaims();
		final ArrayList<Claim> claimList = new ArrayList<Claim>(claims);
		final ArrayAdapter<Claim> claimListAdapter = new ArrayAdapter<Claim>(this,android.R.layout.simple_list_item_1, claimList);
		claimListView.setAdapter(claimListAdapter);
		
		// update new claims
		Controller.getClaimList().addNewListener(new NewListener() {
			public void update() {
				Collection<Claim> claims = Controller.getClaimList().getClaims();
				claimList.addAll(claims);
				claimListAdapter.notifyDataSetChanged();
			}
		});	
		
		// when click on a single claim, show the expense list
	    claimListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(MainActivity.this,ExpenseListActivity.class);
				startActivity(intent);
			}
			});
	    
	    claimListView.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					final int position, long id) {
				AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
				build.setMessage("Edit/Delete "+claimList.get(position).toString()+"?");
				build.setCancelable(true);
				final int finalPos = position;
				build.setPositiveButton("Delete", new OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Claim claim = claimList.get(finalPos);
						Controller.getClaimList().deleteClaim(claim);
					}
				});
				build.show();
				
				 build.setNeutralButton("Edit", new OnClickListener() {
						public void onClick (DialogInterface dialog, int which) {
							Intent intent = new Intent(MainActivity.this, EditClaimActivity.class);
							new Index(position);
					    	startActivity(intent);
						}
					});
				 build.show();
				return false;
				
				}
			});
	    
	   
	    
	}
	    	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void addClaim(View v) {
		//Toast.makeText(this, "Add Claim", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this, AddClaimActivity.class);
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
