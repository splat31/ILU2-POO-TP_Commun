package model;

public class ReservationRestaurant extends Reservation {

	private int service;
	private int table;
	
	public ReservationRestaurant(int jour,int mois,int service, int table) {
		super(jour, mois);
		this.service=service;
		this.table=table;
	}
	private String getPose(int service) {
		if (service==1) {
			return "premier";
		} else {
			return "deuxième";
		}
	}
	
	@Override
	public String toString() {
		
		return "Le "+getJour()+"/"+getMois()+"\nTable "+table+" pour le "+getPose(service)+" service.";
	}
}
