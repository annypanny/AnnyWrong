package ca.ualberta.cs.travelexpensetracker;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.net.ParseException;
import android.widget.EditText;
import android.widget.Spinner;

public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9126355812438938620L;
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd",Locale.getDefault());
	
	protected String Iname;
	protected String type;
	protected Date Idate = new Date();
	protected float Ispent;
	protected String curr;
	protected String Ides;

	public Item(String name_, String type_, String date_,
			float spent_, String curr_, String des_) throws java.text.ParseException {
		this.Iname = name_;
		this.type = type_;
		try {
			this.Idate = date.parse(date_);
		} catch (ParseException e) {
			e.printStackTrace();
		} 		
		this.Ispent = spent_;
		this.curr = curr_;
		this.Ides = des_;
	}

	// getter and setter for name
	public String getName(){
		return Iname;
	}
	public String setName(String name){
		this.Iname = name;
		return name;
	}
	public String toString() {
		return getName();
	}
	
	// getter and setter for category
	public String getType(){
		return type;
	}
	public String setType(String ty){
		this.type = ty;
		return ty;
	}
	public String toType() {
		return getType();
	}
	
	// getter and setter for date
	public Date getdate(){
		return Idate;
	}
	public Date setdate(Date when){
		this.Idate = when;
		return when;
	}
	public Date todate() {
		return getdate();
	}

	// getter and setter for cost
	public float getCost(){
		return Ispent;
	}
	public float setCost(float cost){
		this.Ispent = cost;
		return cost;
	}
	public float toCost(){
		return getCost();
	}
	
	//getter and setter for currency
	public String getCurr(){
		return curr;
	}
	public String setCurr(String curren){
		this.curr = curren;
		return curren;
	}
	public String toCurr(){
		return getCurr();
	}
	
	// getter and setter for description
	public String getDescription(){
		return Ides;
	}
	public String setDescription(String des){
		this.Ides = des;
		return des;
	}
	public String toDescription() {
		return getDescription();
	}
	
	
}
