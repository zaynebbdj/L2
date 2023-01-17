/**
 * Cette classe représente une personne
 */
public class Personne {
    private  String n;
    private  int date_naissance;
    /**
     * Cree un personnage avec un nom et une date de naissance passée en argument
     */
    public Personne(String nom , int date){
        this.n=nom;
        this.date_naissance=date;
    }
    /**
     * Cree une nouvelle personne identique à celle passé en argument
     * @param p la personne dont on veut les caracteristique
     */
    public Personne(Personne p){
        this.n=p.n;
        this.date_naissance=p.date_naissance;
    }

}
