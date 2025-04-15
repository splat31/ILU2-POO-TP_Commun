package model;

public abstract class EntiteReservable {
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

    
    public abstract boolean estLibre(Formulaire formulaire);

    
    public abstract boolean compatible(Formulaire formulaire);

    
    public abstract Reservation reserver(Formulaire formulaire);
}

