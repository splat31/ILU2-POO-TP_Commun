package model;

public class CalendrierAnnuel {
	Mois[] calendrier;
	
	private CalendrierAnnuel() {
		calendrier=new Mois[12];
		String[] nommois = {"janvier","février","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","decembre"};
		int[] jourmois = {31,28,31,30,31,30,31,31,30,31,30,31};
		for (int i=0;i<12;i++) {
			calendrier[i]= new Mois(nommois[i],jourmois[i]);
		}
		
	}
	
	
	private boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour);
	}
	
	private boolean reserver(int jour, int mois) {
		try {
			calendrier[mois-1].reserver(jour);
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
			if (jour>=jours.length-1) {
				return false;
			}
			return jours[jour-1];
		}
		
		private void reserver(int jour) throws IllegalStateException  {
			if (estLibre(jour)) {
				jours[jour]=false;
			}else {
				throw new IllegalStateException();
			}
		}
	}
}
