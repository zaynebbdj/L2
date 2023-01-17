/**
 * Cette classe represente une université
 */
public class Universite {
    private final Batiment[] bat;
    private final Personne president;

    /**
     * Cree une universite
     * @param bat le tableau de batiment de l'universite
     * @param p le president de l'universite
     */
    public Universite(Batiment[] bat, Personne p){
        president=new Personne(p);
        this.bat = Batiment.copie_bat(bat);
    }

}
