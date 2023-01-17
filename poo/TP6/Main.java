
import java.util.ArrayList;

public class Main {
    

    public static void main(String[] args){
        //exo 1 partie 2 question 1
/*      Vegetable pdt = new Potatoe(0.3,10);
        Vegetable c = new Carrot(0.25,30);
        

        System.out.println(pdt);
        System.out.println(c);            
        // exo 1 partie 2 question 4

        Soup s = new Soup();
        s.add(new Carrot(5.5,20));
        s.add(new Potatoe(0.3,10));
        s.add(new Carrot(0.25,30));
        s.add(new Carrot(3.5,20));
        s.add(new Carrot(1.4,20));
        System.out.println(s.getPeelingWeight()); // affiche 0.155
        System.out.println(s);
        
        s.sortByWeight();
        System.out.println(s);                      */

        ArrayList<Integer> liste1 = new ArrayList<Integer>();
        
        TestConditions.remplitAlea(liste1, 1000);  //on remplie une liste d'entier aleatoirement
       
        Condition[] tableau = new Condition[2] ;   // creation du tableau avec deux conditions
        tableau[0]= new Pair();
        tableau[1]= new SuperieurA(25);


        System.out.println("Pair: "+TestConditions.compte(liste1,tableau[0],true)+"V+"+TestConditions.compte(liste1,tableau[0],false)+"F");
        System.out.println("SuperieurA(25): "+TestConditions.compte(liste1,tableau[1],true)+"V+"+TestConditions.compte(liste1,tableau[1],false)+"F");

        
        
    }
}
