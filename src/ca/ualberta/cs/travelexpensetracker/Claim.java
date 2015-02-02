package ca.ualberta.cs.travelexpensetracker;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;




public class Claim implements Serializable {
	
	
	/**
	 * 
	 */

	private static final long serialVersionUID = 7668992806272251535L;
	
	protected String ClaimName;
	protected String claimStatus;
	protected String des;
	protected Date startDay = new Date();
	protected Date endDay = new Date();
	protected ArrayList<Item> ItemList;
	ItemList list;
	Controller controller;
	ItemList itemlist;
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
	
	

	public Claim(String Iname, String IstartD , String IendD , String Ides, 
			String Istatus) throws ParseException {
		this.ClaimName = Iname;
		try {
			this.startDay = date.parse(IstartD);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.endDay = date.parse(IendD);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.des = Ides;
		this.claimStatus = Istatus;		
		this.ItemList = new ArrayList<Item>();
		this.controller  = new Controller();
		this.itemlist = new ItemList();
	}
	
	public int compareTo(Claim another) {
		return getSDay().compareTo(another.getSDay());
	}
	
	public Controller getController() {
		return this.controller;
	}

	public String getClaim() {
		return this.ClaimName;
	}
	
	public ArrayList<Item> getItemArray() {
		return this.ItemList;
	}
	
	public ArrayList<Item> toArrayList() {
		return getItemArray();
	}
	
	public ItemList getlist() {
		return this.itemlist;
	}
	
	public String getName(){
		return ClaimName;
	}
	public String toString() {
		return getName();
	}
	public String setName(String cNa){
		this.ClaimName = cNa;
		return cNa;
	}
	
	
	public Date getSDay(){
		return startDay;
	}
	public Date SdStr() {
		return getSDay();
	}
	public Date setSDay(Date IstartD){
		this.startDay=IstartD;
		return IstartD;
	}
	
	
	
	public Date getEDay(){
		return endDay;
	}
	public Date EdStr() {
		return getEDay();
	}
	public Date setEDay(Date IendD){
		this.endDay=IendD;
		return IendD;
	}

	
	
	public String getDescription(){
		return des;
	}
	public String desStr() {
		return getDescription();
	}
	public String setDes(String Ides){
		this.des = Ides;
		return Ides;
	}
	
	
	public String getStatus(){
		return claimStatus;
	}
	public String statusStr(){
		return getStatus();
	}	
	public String setStatus(String Istatus){
		this.claimStatus = Istatus;
		return Istatus;
	}
}
	
