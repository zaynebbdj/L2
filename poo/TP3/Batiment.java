/**
 * Cette classe représente un batiment
 */
public class Batiment {
    private Salle[] tab;
    private int numero;
    /**
     * cree un batiment
     */
    public Batiment(){}
    
    /**
     * Retourne une copie d'un tableau de batiments passé en argument
     * @param p un tableau de batiment a copier
     * @return une cpie du tableau de batiment passé en argument
     */
    public static Batiment[] copie_bat(Batiment[] p){
        Batiment[] b = new Batiment[p.length];
        for(int i=0 ; i<p.length ; i++){
            b[i]=p[i];
        }return b;
    }

}
