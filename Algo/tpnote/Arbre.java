import java.util.Scanner;
public class Arbre {
    private Noeud racine;

    public Noeud getracine(){
        return this.racine;
    }
    public Arbre(int n){
        this.racine= new Noeud(n);
    }
    public Arbre(){}


    public  void affichage_arborescence(){
        if (this.racine==null){System.out.print("arbre vide");}
        else{
            Noeud.affichage_arbo_aux(this.racine,0);
        }
    }
    // methode qui cree un arbre parfait
    public static Noeud creer_arbre_parfait_aux(int n, int x){
        Noeud cour = new Noeud(x);
        if(n>0){
            
            cour.setfilsdroit(creer_arbre_parfait_aux(n-1,2*x+1));
            
            cour.setfilsgauche(creer_arbre_parfait_aux(n-1,2*x));
            
        }return cour;
            
        
    }public static Arbre creer_arbre_parfait(int n){
        if (n<=0) return null;
        Arbre a =new Arbre();
        a.racine=creer_arbre_parfait_aux(n,1);
        return a;
    }
    public void setracine(Noeud n){
        this.racine=n;
    }

    //EXO 2
    //methode qui supprimer la valeur max d'un ABR
    public static void supp_max(Arbre a){

        if(a==null) return ;
        Noeud prec = a.racine;
        Noeud courant = a.racine.getfilsdroit();
        while(courant.getfilsdroit() != null){
            prec = courant ;
            
            courant= courant.getfilsdroit();
            System.out.println(prec.getinfo()+"  "+courant.getinfo());
        }
        if(courant.getfilsgauche() == null) prec.setfilsdroit(null);
        else prec.setfilsdroit(new Noeud(courant.getfilsgauche() .getinfo()));


    }
    //EXO 2
    //methode qui supprimer la valeur min d'un ABR
    public static void supp_min(Arbre a){

        if(a==null) return ;
        Noeud parent = a.racine;
        Noeud gauche = parent.getfilsgauche();
        if (gauche==null){
            if(parent.getfilsdroit()!=null) a.setracine(parent.getfilsdroit());
        } else{
            Noeud.supp_aux(parent,gauche,gauche.getfilsgauche());
        }
    }


    // EXO 3
    //methode qui retourne la valeur de la feuille la plus a droite d'un AB
    public static Integer valeur_droite(Arbre a){
        if(a!=null) return valeur_droite_aux(a.racine);
        return null;

    }
    public static int valeur_droite_aux(Noeud courant){
        if(courant.getfilsdroit()==null){
            if(courant.getfilsgauche()==null)return courant.getinfo();
            return valeur_droite_aux(courant.getfilsgauche());
        }return valeur_droite_aux(courant.getfilsdroit());
    }


    //EXO 4
    //methode qui retourne le nombre de points simple dans une couche donnée
    public static Integer nb_point_simple(Arbre a,int p){
        if(a==null)return null;
        return nb_point_simple_aux(a.racine,1,p);
    }
    public static Integer nb_point_simple_aux(Noeud courant,int i, int profondeur){ // profondeur represente la couche
        
        if(courant==null)return 0;
        if(i==profondeur){
            if((courant.getfilsgauche()!= null && courant.getfilsdroit() ==null )|| (courant.getfilsgauche()== null && courant.getfilsdroit() !=null ) ){
                return 1+nb_point_simple_aux(courant.getfilsgauche(),i+1,profondeur)+nb_point_simple_aux(courant.getfilsdroit(),i+1,profondeur);

            }    
        
        }return nb_point_simple_aux(courant.getfilsgauche(),i+1,profondeur)+nb_point_simple_aux(courant.getfilsdroit(),i+1,profondeur);
    }

    //fonction que retourne le nombre de point double d'un arbre dans une couche donnée
    public static Integer nb_point_double(Arbre a,int p){
        if(a==null)return null;
        return nb_point_double_aux(a.racine,1,p);
    }

    public static Integer nb_point_double_aux(Noeud courant,int i, int profondeur){ // profondeur represente la couche
        
        if(courant==null)return 0;
        if(i==profondeur){
            if(courant.getfilsgauche()!= null && courant.getfilsdroit() !=null ){
                return 1+nb_point_double_aux(courant.getfilsgauche(),i+1,profondeur)+nb_point_double_aux(courant.getfilsdroit(),i+1,profondeur);

            }    
        
        }return nb_point_double_aux(courant.getfilsgauche(),i+1,profondeur)+nb_point_double_aux(courant.getfilsdroit(),i+1,profondeur);
    }
    

    

    



    

}
