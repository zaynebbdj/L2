
import fr.lacl.cpo.Drawing ; 
public class Mondrian {
    private Forme[] tab;

    public void draw(Drawing d){
        for(int i = 0; i<this.tab.length;i++){
            this.tab[i].draw(d);
        }
    }

    public void draw(Drawing d, double diag) {
        try{
            for(int i=0 ; i<this.tab.length;i++){
                boolean seuil = Math.random()<diag;
                this.tab[i].draw(d,seuil);
                
            }
        }catch( IllegalArgumentException e){
            d.setWidth(50);
            d.setColor(255,0,0);
            d.line(0,0,50,50);
            d.line(0,50,50,0);
        }
    }

}
