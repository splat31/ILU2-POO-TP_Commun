package model;

public class FormulaireRestaurant extends Formulaire {
    private int nbPersonnes;
    private int numeroService;

    public FormulaireRestaurant(int jour, int mois, int nbPersonnes, int numeroService) {
        super(jour, mois);
        this.nbPersonnes = nbPersonnes;
        this.numeroService = numeroService;
    }

    public int getNombrePersonnes() {
        return nbPersonnes;
    }

    public int getNumService() {
        return numeroService;
    }
}
