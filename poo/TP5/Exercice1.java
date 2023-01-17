import fr.lacl.cpo.Drawing ; 

public class Exercice1{

    public static void dessine_rectangle(){
        Drawing image = new Drawing("rectangle",100,100,true);
        image.line(1,1,50,1);
        image.line(50,1,50,40);
        image.line(50,40,1,41);
        image.line(1,41,1,1);
        
    }
    public static void dessine_etoile(){
        Drawing image = new Drawing("etoile", 500,500,true);
        for(int i=0;i<5;i++){
            image.line(250,250,250+10*Math.cos(i*2*Math.PI/5),250+10*Math.cos(i*2*Math.PI/5));
            
        }
    }
    

}