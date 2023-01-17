
import java.util.*;
public class Main {
    

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int entier = input.nextInt();

        Liste l1 = Liste.creer_liste_1_n(entier);
        Liste l2 = Liste.creer_syracuse(entier);
        System.out.println("premiere liste " + l1);
        System.out.println("deuxieme liste "+l2);
        System.out.println("la longeur de la premiere liste est: "+Liste.longueur(l1));
        e();
        
        System.out.println("La longueur de la deuxieme liste est : "+ Liste.longueur(l2));
        e();
        System.out.println("position de 8 dans la premiere liste :"+Liste.position_element(l1, 8));
        e();
        System.out.println("nb d'occurence du chiffre 4 dans la premiere liste :"+ Liste.nb_occ_rec(l1, 4));
        e();
        System.out.println("valeur max de la premiere liste : "+Liste.max_rec(l1));
        e();System.out.println("la deuxieme liste est croissante : "+ Liste.croissante(l1));
        e();System.out.print("affichons la deuxieme liste inversée");
        Liste.affiche_inverse(l2);
        e();Liste.concatenelcd(l1, l2);
        e();System.out.println("concatenation de l1 et l2 :");
        System.out.println(l1);
        e();System.out.println("ajoutons l'element 0 a la fin de la premiere liste");
        Liste.ajout(l1,0, 20);
        e();System.out.println(l1);
        e();System.out.println("supprimons l'element 0 de la premeire liste");
        Liste.supp(l1, 0);
        e();System.out.println(l1);
        Liste l3 = Liste.creer_liste_1_n(5);
        Liste.supp(l3,2);
        Liste.supp(l3,3);
        Liste.supp(l3,4);
        e();System.out.println(l3);
        Liste.inserer(l3,3);
        e();System.out.println(l3);



    }

    public static  void e(){
        System.out.println();
    }
}
