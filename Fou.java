public class Fou extends Piece {
	public Fou(boolean blanc, int ligne, int colonne) {
		super(blanc, ligne, colonne);
		if (blanc) {
			symbole = "FB";
		} else {
			symbole = "FN";
		}
	}
	
	public boolean peutSeDeplacer(int ligneArrivee, int colonneArrivee, Plateau plateau) {
		
		if (this.ligne == ligneArrivee && this.colonne == colonneArrivee) {
			return false;
		}
		
		Piece pieceArrivee = plateau.getPiece(ligneArrivee, colonneArrivee);
		if (pieceArrivee != null) {
			if(pieceArrivee.isBlanc() == isBlanc()) {
				return false;
			}
		}
		
		/*
		 On v�rifie si la case d'arriv�e est bien sur la diagonale de la case de d�part
		 */
		if(ligneArrivee - colonneArrivee != this.ligne - this.colonne && 
				ligneArrivee + colonneArrivee != this.ligne + this.colonne)
			return false;
		
		/*
		 On v�rifie si c'est une diagonale montante ou descendante
		 On v�rifie si la pi�ce souhaite aller vers le haut ou vers le bas en comparant la ligne d'arriv�e est sup�rieur � 
		 la ligne de d�part
		 Avec une boucle on v�rifie si il y a une pi�ce entre la case d'arriv�e et la case de d�part sur la diagonale
		 
		 �quation 1 : arriveeLigne - arriveeColonne = departLigne - departColonne
		 �quation 2 : arriveeLigne + arriveeColonne = departLigne + departColonne
		 */
		
		if(ligneArrivee - colonneArrivee == this.ligne - this.colonne) {
			if(ligneArrivee > this.ligne) {
				for(int ligne = this.ligne + 1 ; ligne < ligneArrivee ; ligne++) {
					Piece p = plateau.getPiece(ligne, ligne - this.ligne + this.colonne);
					if (p != null) {
						return false;
					}
				}
			} else {
				for(int ligne = this.ligne - 1 ; ligne > ligneArrivee ; ligne--) {
					Piece p = plateau.getPiece(ligne, ligne - this.ligne + this.colonne);
					if (p != null) {
						return false;
					}
				}
			}
		} else {
			if(ligneArrivee > this.ligne) {
				for(int ligne = this.ligne + 1 ; ligne < ligneArrivee ; ligne++) {
					Piece p = plateau.getPiece(ligne, this.ligne + this.colonne - ligne);
					if (p != null) {
						return false;
					}
				}
			} else {
				for(int ligne = this.ligne - 1 ; ligne > ligneArrivee ; ligne--) {
					Piece p = plateau.getPiece(ligne, this.ligne + this.colonne - ligne);
					if (p != null) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
}