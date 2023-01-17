package TP2;

public class Main {
    public static void main(String[] rags){
        Attente a = new Attente(100);





        Chronometre chronometre = new Chronometre();
    for(int i=1;i<=1000000;i=i+1) {
        if (i%1000==0) {
            System.out.println(i+" "+chronometre.dureeMicro());
        }
    }
    System.out.println(chronometre.dureeMilli());
    chronometre.reset();
    for(int i=1000000;i>=1;i=i-1) {
        if (i%1000==0) {
            System.out.println(i+" "+chronometre.dureeMicro());
        }
    }
    System.out.println(chronometre.dureeMilli()); 
    chronometre.reset();
    System.out.println(chronometre.getdebut());
    Chronometre c = new Chronometre();
    Casillo salut = new Casillo();
    System.out.print(salut.getduree());
    salut.changeDefaut(5);
    System.out.print(salut.getduree());


}
}
