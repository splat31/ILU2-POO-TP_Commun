package model;

public class ReservationSpectacle extends Reservation {
	private int zone;
	private int chaise;
	
	public ReservationSpectacle(int jour,int mois,int zone, int chaise) {
		super(jour, mois);
		this.zone=zone;
		this.chaise=chaise;
	}
	
	@Override
	public String toString() {
		return "chaise numéro " + chaise + " de la zone " + zone+ " pour le "+getJour()+"/"+getMois()+".";
	}
}