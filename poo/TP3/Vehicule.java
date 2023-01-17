/**
 * Cette classe represente un vehicule
 */

public class Vehicule {
    private final int numero;
    private Compteur c;
    private float jauge;
    private final float conso;
    private static final float capacite =50;
    private static int registre=1;

    /**
     * Cree un vehicule dont la consomation est passée en argument
     * @param cons la consommation du vehicule
     */
    public Vehicule(float cons){
        this.numero=registre;
        this.conso= cons;
        this.c=new Compteur();
        registre++;
    }
    /**
     * Retourne le nombre de vehicule
     * @return le nombre de vehicule
     */
    public int getregistre(){
        return registre;
    }
    /**
     * Retourne le compteur du vehicule
     * @return le compteur du vehicule
     */
    public Compteur getcompteur(){
        return c;
    }
    /**
     * Retourne la jauge du vehicule
     * @return la jauge du vehicule
     */
    public float getjauge(){
        return jauge;
    }
    /**
     * Retourne le numero d'imatriculation du vehicule
     * @return le numero d'immatriculation du vehicule
     */
    public int getnumero(){
        return numero;
    }
    /**
     * Modifie la jauge du vehicule
     * @param a la valeur à affecter a la jauge
     */
    public void setjauge(float a){
        if(this.jauge+a>this.capacite){ this.faireLePlein();}
        else{this.setjauge(this.jauge+a);}
    }
    /**
     * Remplie la jauge au maximum
     */
    public void faireLePlein(){
        this.jauge=capacite ;
    }
    /**
     * Remplie la jauge de la valeur passée en argument
     * @param x les litres à ajouter à la jauge
     */
    public void mettreDeLessence(float x){ // en litre
        if(this.jauge+x>=capacite){this.faireLePlein();}
        else{ this.jauge+=x;}
    }
    /**
     * Retourne la distance qu'a pu parcourir le vehicule sur la distance passée en argument
     * @param distance la distance à parcourir par le vehicule
     * @return la distance parcourue par le vehicule
     */
    public float rouler(float distance){
        
        float d= (this.jauge*100)/this.conso;
        if(d>distance){
            this.c.add(distance);
            float litres_consommé= (this.conso*distance)/100;
            this.setjauge(this.jauge-litres_consommé);
            return distance;
        }
        this.c.add(d);
        this.setjauge(0);
        return d;
    }
    @Override
    /**
     * Affiche un vehicule
     */
    public String toString(){
        return "Véhicule "+this.numero+" : compteur = [ totalisateur = "+ this.c.gettotalisateur() +" |partiel = "+ this.c.getpartiel()+ "  ] ; jauge = "+this.jauge;
    }
}
