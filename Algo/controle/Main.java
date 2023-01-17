

public class Main {
    public static void main(String[] args){


        Tree test = Tree.new_perfect_tree(4, 2);
        

        
        test.afficher_arbores();
        System.out.println("moyenne des entiers positifs de l'arbre : "+test.moyenne());
        System.out.println(" nombre de noeud double à la troisième couche : "+test.nb_doubles_couches(test, 3));
        List oui = Tree.liste_inferieure(test, 16);
        System.out.println("liste inferieure à 16");
        List.afficher_list(oui);
      

       


    }
}
