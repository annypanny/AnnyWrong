package ca.ualberta.cs.travelexpensetracker;

import java.io.Serializable;
import java.util.EmptyStackException;

public class Controller implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3437715375599407285L;

	private static ClaimList claimList = null;
	
	private static ItemList itemList = null;
	
	
	public static ClaimList getClaimList(){
		if (claimList == null){
			claimList = new ClaimList();
		}
		return claimList;
	}

	public void addClaim(Claim claim){
		getClaimList();
		ClaimList.addClaim(claim);
	}
	
	public void editClaim(){
		getClaimList();
		ClaimList.editClaim();
	}
	
	public Claim chooseClaim() throws EmptyStackException{
		return getClaimList().chooseClaim();
	}


	static public ItemList getItemList() {
		if (itemList == null) {
			itemList = new ItemList();
		}		
		return itemList;
	}

	public Item chooseItem() throws EmptyStackException {
		return getItemList().chooseItem();
	}

	public void addItem(Item item) {
		getItemList().addItem(item);
	}

	public void editItem() {
		getItemList().editItem();
	}

}
