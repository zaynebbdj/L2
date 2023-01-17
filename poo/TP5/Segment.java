/**
 * Cette classe représente un segment à partir de deux point
 */
import fr.lacl.cpo.Drawing ; 

public class Segment {
    private Point p1;
    private Point p2;


    public Segment(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    /**
     * méthode qui dessine un segment
     */
    public void draw(Drawing d , double width){
        d.setColor(p1.getcolor().getpremier(),p1.getcolor().getdeuxieme(),p1.getcolor().gettroisieme());
        d.setWidth(width);
        d.line(this.p1.getabscisse(),this.p1.getordonnee(),this.p2.getabscisse(),this.p2.getordonnee());
    }

}
