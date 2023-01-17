

public class Carrot extends Vegetable{
    private int longueur;


    public Carrot(double  p , int c){
        super(p);
        this.longueur = c;
    }
    @Override
    public String toString(){
        return "Carrotte: ["+super.toString()+" kg - "+this.longueur +" cm]";
    }
}