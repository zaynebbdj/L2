

public abstract class Vegetable implements Comparable<Vegetable>{
    private double poids;
    private static double PeelingWeigthRatio =0.1;

    public Vegetable(double poids){
        this.poids= poids;
    }
    public double getpoids(){
        return this.poids;
    }

    public double getPeelingWeight(){
        return PeelingWeigthRatio * this.poids;
    }

    @Override 
    public int compareTo(Vegetable v){
        return (int)( Math.floor(this.poids - v.poids));
    }

    @Override
    public String toString(){
        return this.poids + " ";
    }

    
    
}


