package model;

public class CentraleReservation<E extends EntiteReservable<F>, F extends Formulaire> {
	public E[] entites;
	private int nbEntites;

	public CentraleReservation(E[] entite) {
		this.entites = entite;
		this.nbEntites = 0;
	}

	public int ajouterEntite(E entite) {
		if (nbEntites >= entites.length) {
			throw new IllegalStateException("Capacité maximale atteinte.");
		}
		entite.setNumero(nbEntites + 1);
		entites[nbEntites] = entite;
		nbEntites++;
		return entite.getNumero();
	}

	public int[] donnerPossibilites(F formulaire) {
		int[] possibilites = new int[nbEntites];

		for (int i = 0; i < nbEntites; i++) {
			EntiteReservable<F> entite = entites[i];
			if (entite.estLibre(formulaire) && entite.compatible(formulaire)) {
				possibilites[i] = entite.getNumero();
			} else {
				possibilites[i] = 0;
			}
		}
		return possibilites;
	}

	public Reservation reserver(int numeroEntite, F formulaire) {
		if (numeroEntite < 1 || numeroEntite > nbEntites) {
			return null; //
		}
		E entite = entites[numeroEntite - 1]; //
		formulaire.setIdentificationEntite(numeroEntite);
		return entite.reserver(formulaire);
	}
}