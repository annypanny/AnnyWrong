package ca.ualberta.cs.travelexpensetracker;

import java.util.ArrayList;
import java.util.Collection;

public class ClaimList {
	
	protected static ArrayList<Claim> ClaimList;
	
	public ClaimList() {
		ClaimList = new ArrayList<Claim>();
		
	}
	

	public Collection<Claim> getClaims() {
		return ClaimList;
	}

	public static void addClaim(Claim testClaim) {
		ClaimList.add(testClaim);		
	}


	public static void removeClaim(Claim testClaim) {
		ClaimList.remove(testClaim);	
	}


	public static Claim editClaim() {
		return null;
	}


	public int size() {
		// TODO Auto-generated method stub
		return ClaimList.size();
	}


	public boolean contains(Claim testClaim) {
		return ClaimList.contains(testClaim);
	}

}
