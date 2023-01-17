import fr.lacl.cpo.Drawing ; 
public class Triangle {
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * initialise un triangle a partir de trois point 
     * @param p1 le premier Point du triangle
     * @param p2 le deuxieme Point du triangle
     * @param p3 le Troisieme Point du triangle
     */
    public Triangle(Point p1,Point p2, Point p3){
        
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
    }

    /**
     * methode qui dessine un triangle sur une fenetre donnée
     * @param d fenetre sur laquelle on dessine 
     */
    public void draw_triangle(Drawing d){
        Segment prims = new Segment(p1,p2);
        Segment deux = new Segment(p2,p3);
        Segment trois = new Segment(p3,p1);
        prims.draw(d, p1.getwidth());
        deux.draw(d, p1.getwidth());
        trois.draw(d,p1.getwidth());
    }
    
}
