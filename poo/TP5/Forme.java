/**
 * Cette classe représente une forme
 */
import fr.lacl.cpo.Drawing ;
public class Forme {
    private Point[] tab;

    /**
     * méthode qui dessine une forme sur une fenetre 
     * @param d fenetre sur laquelle on dessine la forme
     */
    public void draw(Drawing d){
        d.setColor(this.tab[0].getcolor().getpremier(),this.tab[0].getcolor().getdeuxieme(),this.tab[0].getcolor().gettroisieme());
        for(int i=0 ; i<this.tab.length-1 ; i++){
            Segment courant = new Segment(this.tab[i],this.tab[i+1]);
            courant.draw(d,this.tab[0].getwidth());
        }
        Segment dernier = new Segment(this.tab[tab.length-1],this.tab[0]);
        dernier.draw(d,this.tab[0].getwidth());
    }

    public void draw(Drawing d, boolean diagonales) throws IllegalArgumentException
    {
        if(this.tab.length<4){ throw new IllegalArgumentException("cette forme n'a pas de diagonale");}
        if(diagonales){
            for(int i=0; i<this.tab.length ;i++){
                for(int j=i+1; j<this.tab.length;j++){
                    Segment courant = new Segment(this.tab[i],this.tab[j]);
                    courant.draw(d,this.tab[0].getwidth());
                }
            }
        }else this.draw(d);
    }
    
    

}
