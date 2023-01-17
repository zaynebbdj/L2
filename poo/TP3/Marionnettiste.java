/**
 * Cette classe représente un marionettiste
 */
public class Marionnettiste {
    private Personnage p;

    /**
     * Fait s'auto-attaquer un personnage
     * @param p le personnage cible
     */
    public void attaque_m(Personnage p){
        this.p.attaque_perso(p);
    }
}
