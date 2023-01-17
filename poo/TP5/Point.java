/**
 * Cette classe représente un point
 * 
 */
import fr.lacl.cpo.Drawing ; 
public class Point {
    private double abscisse;
    private double ordonnee;
    private Color couleur;
    private double width;


    
    /**
     * méthode qui dessine un point 
     * @param d représente la fenetre d'affichage
     */
    public void draw(Drawing d){
        d.setColor(this.couleur.getpremier(),this.couleur.getdeuxieme(),this.couleur.gettroisieme());
        d.setWidth(this.width);
        d.point(this.abscisse,this.ordonnee);
    }
    /**
     * retourne l'abscise d'un point
     * @return l'abscisse du point
     */
    public double getabscisse(){
        return this.abscisse;
    }
    /**
     * retourne l'ordonnee du point 
     * @return l'ordonnée du point 
     */
    public double getordonnee(){
        return this.ordonnee;
    }
    /**
     * retourne la couleur du point 
     * @return retourne la couleur du point
     */
    public Color getcolor(){
        return this.couleur;
    }
    /**
     * retourne l'epaisseur du point
     * @return l'épaisseur du point
     */
    public double getwidth(){
        return this.width;
    }

    

    
}
