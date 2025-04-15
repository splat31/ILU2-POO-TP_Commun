package model;

public class CalendrierAnnuel {
	Mois[] calendrier;
	
	public CalendrierAnnuel() {
		calendrier=new Mois[12];
		String[] nommois = {"janvier","f�vrier","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","decembre"};
		int[] jourmois = {31,28,31,30,31,30,31,31,30,31,30,31};
		for (int i=0;i<12;i++) {
			calendrier[i]= new Mois(nommois[i],jourmois[i]);
		}
		
	}
	
	
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois - 1].estLibre(jour - 1);
	}
	
	public boolean reserver(int jour, int mois) {
		try {
			calendrier[mois-1].reserver(jour-1);
		} catch (IllegalStateException e) {
			return false;
		}
		return true;
	}
	
	
	private static class Mois {
		private String nom;
		private boolean[] jours;
	
		private Mois(String nom,int nbMois) {
			this.nom = nom;
			this.jours=new boolean[nbMois];
			for (int i=0;i<nbMois;i++) {
				jours[i]=true;
			}
		}
	
	
		private boolean estLibre(int jour) {
			if (jour < 0 || jour >= jours.length) {
				return false;
			}
			return jours[jour];
		}
		
		private void reserver(int jour) throws IllegalStateException  {
			if (estLibre(jour)) {
				jours[jour] = false;
			} else {
				throw new IllegalStateException();
			}
		}
	}
}
