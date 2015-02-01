package ca.ualberta.cs.travelexpensetracker;

public class Claim {
	
	protected String ClaimName;

	public Claim(String ClaimName) {
		this.ClaimName = ClaimName;
	}

	public String getClaim() {
		return this.ClaimName;
	}
	

}
