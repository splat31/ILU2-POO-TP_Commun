package model;

public class CentraleReservation {
    private EntiteReservable[] entites;
    private int nbEntites;

    public CentraleReservation(int capaciteMax) {
        this.entites = new EntiteReservable[capaciteMax];
        this.nbEntites = 0;
    }

    public int ajouterEntite(EntiteReservable entite) {
        if (nbEntites >= entites.length) {
            throw new IllegalStateException("Capacité maximale atteinte.");
        }
        entite.setNumero(nbEntites + 1); 
        entites[nbEntites] = entite;
        nbEntites++;
        return entite.getNumero();
    }

    public int[] donnerPossibilites(Formulaire formulaire) {
        int[] possibilites = new int[nbEntites];

        for (int i = 0; i < nbEntites; i++) {
            EntiteReservable entite = entites[i];
            if (entite.estLibre(formulaire) && entite.compatible(formulaire)) {
                possibilites[i] = entite.getNumero();
            } else {
                possibilites[i] = 0;
            }
        }    
        return possibilites;
    }

    public Reservation reserver(int numeroEntite, Formulaire formulaire) {
        if (numeroEntite < 1 || numeroEntite > nbEntites) {
        	return null; //
        }
        EntiteReservable entite = entites[numeroEntite - 1]; // 
        formulaire. setIdentificationEntite(numeroEntite);
        return entite.reserver(formulaire);
    }
}