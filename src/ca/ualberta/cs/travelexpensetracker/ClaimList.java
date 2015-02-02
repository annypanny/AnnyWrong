package ca.ualberta.cs.travelexpensetracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class ClaimList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -452925784303745903L;
	
	protected static ArrayList<Claim> ClaimList;
	protected static ArrayList<NewListener> listener;
	
	public ClaimList() {
		ClaimList = new ArrayList<Claim>();
		listener = new ArrayList<NewListener>();	
	}
	

	public Collection<Claim> getClaims() {
		return ClaimList;
	}

	public static void addClaim(Claim sample_Claim) {
		ClaimList.add(sample_Claim);	
		notifylistener();
	}
	
	//  abram hindle https://www.youtube.com/watch?v=7zKCuqScaRE 2015-01-25
	private static void notifylistener() {
		// TODO Auto-generated method stub
		for (NewListener newListener: listener) {
			newListener.update();
		}
	}


	public void deleteClaim(Claim sample_Claim) {
		ClaimList.remove(sample_Claim);	
	}


	public static void editClaim() {
		notifylistener();
	}


	public int size() {
		// TODO Auto-generated method stub
		return ClaimList.size();
	}




	public boolean contains(Claim sample_Claim) {
		return ClaimList.contains(sample_Claim);
	}


	public Claim chooseClaim() {
		// TODO Auto-generated method stub
		return null;
	}


	public void addNewListener(NewListener newListener) {
		// TODO Auto-generated method stub
		
	}



}
