import java.util.ArrayList;

public class Tour extends Piece {
	private boolean premierCoup;
	
	public Tour(boolean blanc, int ligne, int colonne) {
		super(blanc, ligne, colonne);
		if (blanc) {
			symbole = "TB";
		} else {
			symbole = "TN";
		}
		premierCoup = true;
	}

	public boolean isPremierCoup() {
		return premierCoup;
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
		 V�rification : la case d'arriv�e doit �tre sur la m�me ligne ou colonne que la case de d�part sinon on retourne false
		 */
		
		if (colonneArrivee != colonne && ligneArrivee != ligne) {
			return false;
		}
		
		/*
		 On v�rifie si il se d�place � l'horizontale ou en verticale
		 Si c'est en verticale, on v�rifie si elle va vers le bas ou vers le haut
		 Sinon on v�rifie si elle va vers la gauche ou la droite
		 On v�rifie si une pi�ce se trouve entre la case de d�part et la case d'arriv�e avec une boucle
		 Dans cette boucle, on v�rifie si la case interm�diaire "c" est vide sinon on retourne false
 		 */
		
		if(colonneArrivee == this.colonne) {
			if(ligneArrivee > ligne) {
				for(int ligne = this.ligne + 1 ; ligne < ligneArrivee ; ligne++) {
					Piece p = plateau.getPiece(ligne, colonneArrivee);
					if (p != null) {
						return false;
					}
				}
			} else {
				for(int ligne = this.ligne - 1 ; ligne > ligneArrivee ; ligne--) {
					Piece p = plateau.getPiece(ligne, colonneArrivee);
					if (p != null) {
						return false;
					}
				}
			}
		} else {
			if(colonneArrivee > colonne) {
				for(int colonne = this.colonne + 1 ; colonne < colonneArrivee ; colonne++) {
					Piece p = plateau.getPiece(ligneArrivee, colonne);
					if (p != null) {
						return false;
					}
				}
			} else {
				for(int colonne = this.colonne - 1 ; colonne > colonneArrivee ; colonne--) {
					Piece p = plateau.getPiece(ligneArrivee, colonne);
					if (p == null) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void deplacer(Coup coup, Plateau plateau, ArrayList<Coup> historiqueDesCoups) {
		super.deplacer(coup, plateau, historiqueDesCoups);
		if(premierCoup)
			premierCoup = false;
	}
}