/**
 * Cette classe représente un compteur 
 */
public class Compteur {
    private float totalisateur;
    private float partiel;
    private static int constante=1000;

    /**
     * cree un compteur dont les champs sont initialisés à 0
     */
    public Compteur(){
        this.totalisateur=0;
        this.partiel=0;
    }
    /**
     * Retourne l'enregistrement partiel d'un compteur
     * @return l'enregistrement partiel d'un compteur
     */
    public float getpartiel(){
        return partiel;
    }
    /**
     * Retourne l'enregistrement totalisateur d'un compteur
     * @return l'enregistrement totalisateur d'un compteur 
     */
    public float gettotalisateur(){
        return totalisateur;
    }
    /**
     * Modifie l'enregistrement totalisateur d'un compteur
     * @param distance la valeur nouvelle valeur a donner a l'enregistrement totalisateur d'un compteur
     */
    public void settotalisateur(float distance){
        this.totalisateur=distance;
    }
    /**
     * Modifie l'enregistrement partiel d'un compteur
     * @param a la nouvelle valeur a affecter a l'enregistrement partiel d'un compteur
     */
    public void setpartiel(float a){
        this.partiel=a;
    }
    /**
     * Remet l'enregistrement partiel a 0
     */
    public void resetPartiel(){
        this.partiel=0;
    }
    /**
     * Modifie les enregistrement totalisateur et partiel du compteur
     * @param u la valeur a ajouter aux deux enregistrements
     */
    public void add(float u){
        this.totalisateur+=u;
        this.setpartiel(  (this.partiel+u)%constante );
    }
    @Override
    /**
     * Retourne les champs d'un compteur en type string
     */
    public String toString(){
        return "compteur = [ totalisatuer = " +totalisateur+ "| partiel = "+partiel+" ]";
    }

}
