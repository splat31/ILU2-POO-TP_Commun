package model;

public abstract class EntiteReservable<F extends Formulaire> {
	protected CalendrierAnnuel calendrier;
	protected int numero;

	public EntiteReservable(int numero) {
		this.numero = numero;
		this.calendrier = new CalendrierAnnuel();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean estLibre(Formulaire formulaire) {
		int jour = formulaire.getJour();
		int mois = formulaire.getMois();
		return calendrier.estLibre(jour, mois);
	}

	protected abstract boolean compatible(F formulaire);

	protected abstract Reservation reserver(F formulaire);
}
