package model;

public class ReservationHotel extends Reservation {

	private int simple;
	private int ldouble;
	private int chambre;
	
	public ReservationHotel(int jour,int mois,int simple, int ldouble ,int chambre) {
		super(jour, mois);
		this.simple=simple;
		this.ldouble=ldouble;
		this.chambre=chambre;
	}
	
	@Override
	public String toString() {
		return "Le "+getJour()+"/"+getMois()+"\nChambre "+chambre+" avec "+simple+" lit simple et "+ldouble+" lit double.";
	}
}

