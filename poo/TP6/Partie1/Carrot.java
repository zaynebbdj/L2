package Partie1;

public class Carrot{
    private double poids;
    private int longueur;


    public Carrot(double  p , int c){
        this.poids =p;
        this.longueur = c;
    }
    @Override
    public String toString(){
        return "Carrotte: ["+this.poids+" kg - "+this.longueur +" cm]";
    }
}