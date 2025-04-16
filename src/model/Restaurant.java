package model;

public class Restaurant implements IEtablissement<FormulaireRestaurant> {
	private CentraleReservation centrale;

	public void ajouterTable(int nbChaise) {
		Table table = new Table(nbChaise);
		int nbEntite = centrale.ajouterEntite(table);
		table.setNumero(nbEntite);
	}

	public int[] donnerPossibilitees(FormulaireRestaurant formulaire) {
		int[] possibilite = new int[3];
		return possibilite;

	}

	public Reservation reserver(int numEntite, FormulaireRestaurant formulaire) {
		// ReservationRestaurant retour = new
		// ReservationRestaurant(formulaire.getJour(),formulaire.getMois(),formulaire.getNumService(),formulaire.getIdentificationEntite());

		return CentraleReservation.reserver(numEntite, formulaire);
	}

	private static class Table extends EntiteReservable<FormulaireRestaurant> {
		private int nbChaises;

		public Table(int numero) {
			super(numero);
		}

		@Override
		public boolean compatible(Formulaire formulaire) {
			return (formulaire.getNombrePersonnes() == nbChaises || formulaire.getNombrePersonnes() + 1 == nbChaises)
					&& estLibre(formulaire);
		}

		@Override
		public ReservationRestaurant reserver(FormulaireRestaurant formulaire) {
			ReservationRestaurant reservation = null;
			if (calendrier.reserver(formulaire.getJour(), formulaire.getMois())) {
				reservation = new ReservationRestaurant(formulaire.getJour(), formulaire.getMois(),
						formulaire.getNumService(), formulaire.getIdentificationEntite());
			}
			return reservation;
		}
	}
}
