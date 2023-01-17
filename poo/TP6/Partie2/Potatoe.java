

public class Potatoe extends Vegetable{
    private int yeux;

    public Potatoe(double poids){
        this(poids,(int) (10*poids));
    }
    public Potatoe(double o , int m){
        super(o);
        this.yeux = m;
    }
    @Override
    public String toString(){
        return "Patate: ["+super.toString()+" kg - "+this.yeux +" yeux]";
    }

    

    @Override 
    public double getPeelingWeight(){
        return super.getPeelingWeight() +0.01*( (float)this.yeux ) ;
    }


}
