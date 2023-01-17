

public class Tree
{
    private Node root;

    /**
     * Constructeur d'objets de classe Tree
     */
    public Tree()
    {
        root = null;
    }

    public Tree(Node r)
    {
        root = r;
    }

    public boolean estVide() {
        return (root == null);
    }

    public static Tree new_perfect_tree(int n, int e){
        Tree t = new Tree();
        t.root = new_perfect_tree_aux(n,e);
        return t;
    }

    public static Node new_perfect_tree_aux(int n, int e){
        Node t = new Node(e);
        if (n > 1) {
            t.setLeft(new_perfect_tree_aux(n - 1, 2 * e));
            t.setRight(new_perfect_tree_aux(n - 1, 2 * e + 1));
        }
        return t;
    }


    /**
     * affichage en arborescence (pre-ordre comme etant une méthode d'instance
     */
    public void afficher_arbores()
    {
        afficher_arbores_aux(this.root, 0 );
    }

    public static void afficher_arbores_aux(Node a, int p)
    {
        if (a!=null)
        {
            // afficher le nombre de décalages en fonction de la profondeur p
            for(int i=0; i<p;i++) {System.out.print(" ");}            
            if(p!=0) System.out.print(" |");
            System.out.println (a.getInfo());
            afficher_arbores_aux(a.getLeft(),p+1);
            afficher_arbores_aux(a.getRight(),p+1);
        }
    }


    //exo 2
    

    public Double moyenne(){
        if(this!=null){
            return total(this.root)/nb_positif(this.root);
        }

        return null;
    }
    /**
     * methode qui retourne le nombre d'entier positif d'un arbre binaire
     * @param courant noeud dont on regarde l'entier
     * @return le nombre d'entier positif d'un arbre binaire
     */
    public Double nb_positif(Node courant){
        if(courant==null) return 0.;
        if(courant.getInfo()>0) return 1+nb_positif(courant.getLeft())+nb_positif(courant.getRight());
        else return nb_positif(courant.getLeft())+nb_positif(courant.getRight());
    }

    /**
     * methode qui retourne la some des entiers positifs dans un arbre binaire
     * @param courant noeud dont on regarde l'entier
     * @return la somme des entiers positifs d'un arbre binaire
     */
    public Double total(Node courant){
        if(courant==null) return 0.;
        if(courant.getInfo()>0){
            return courant.getInfo()+total(courant.getLeft())
            +total(courant.getRight());
        }else{
            return total(courant.getLeft())
            +total(courant.getRight());
        }
    }
    //exo 3

    /**
     * methode qui retourne le nombre de noeud double à une couche donnée
     * @param t arbre sur lequel on applique la methode
     * @param c couche donnée
     * @return le nombre de noeud double d'un arbre à une couche donnée
     */
    public Integer nb_doubles_couches(Tree t,int c){
        return nb_doubles_couches(t.root, c);
        
    }
    public int nb_doubles_couches(Node courant, int couche){
        if(courant==null) return 0;
        if(couche==1){
            if(courant.getRight()!=null && courant.getLeft()!=null) return 1;
        }
        return nb_doubles_couches(courant.getRight(),couche-1) + nb_doubles_couches(courant.getLeft(),couche-1);
        
    }

    //exo 4

    /**
     * methode qui cree une liste à partir des entiers d'un arbre inferieurs à un certain seuil donné en paramètre
     * @param t arbre sur lequel on opère
     * @param element seuil donné
     * @return la liste des entiers inferieurs à un certain seuil
     */
    public static List liste_inferieure(Tree t, int element){
        List nouvelle = new List();
        liste_inferieure(nouvelle,t.root,element);
        return nouvelle;

    }
    public static void  liste_inferieure(List l,Node courant, int element){
        if(courant!=null){
            if(courant.getInfo()<element) l.ajouter(new Maillon(courant.getInfo()));
        
            liste_inferieure(l,courant.getLeft(),element); 
            liste_inferieure(l,courant.getRight(),element);
        } 
        
    }
    


}