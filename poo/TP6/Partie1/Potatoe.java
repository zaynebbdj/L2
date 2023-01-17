package Partie1;

public class Potatoe{
    private double poids;
    private int yeux;

    public Potatoe(double poids){
        this(poids,(int) (10*poids));
    }
    public Potatoe(double o , int m){
        this.poids=o;;
        this.yeux = m;
    }
    @Override
    public String toString(){
        return "Patate: ["+this.poids+" kg - "+this.yeux +" yeux]";
    }

    public static void main(String[] args){
        Carrot c = new Carrot(0.25, 30);
        Potatoe pdt1 = new Potatoe(0.3, 10);
        Potatoe pdt2 = new Potatoe(0.3);
        System.out.println(c);
        System.out.println(pdt1);
        System.out.println(pdt2); 

    }

    


}
