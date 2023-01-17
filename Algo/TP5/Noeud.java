public class Noeud{
    private  int info;
    private Noeud filsgauche;
    private Noeud filsdroit;


    public Noeud(){
        
    }

    public void setfilsdroit(Noeud valeur){
        this.filsdroit = valeur;
    }
    public void setfilsgauche(Noeud v){
        this.filsgauche=v;
    }
    public Noeud getfilsdroit(){
        return this.filsdroit;
    }
    public Noeud getfilsgauche(){
        return this.filsgauche;
    }
    public int getinfo(){
        return this.info;
    }
    public void setinfo(int valeur){
        this.info=valeur;
    }
    public Noeud(Integer n){
        this.info= n;
        this.filsgauche=null;
        this.filsdroit=null;
    }
    public Noeud(int valeur){
        this.info= valeur;
        this.filsgauche=null;
        this.filsdroit=null;

    }
    //exo 3
    public static void affiche_aux(Noeud n){
        if(n!=null) System.out.print(n.info+"  ");
        if(n.filsgauche!=null) affiche_aux(n.filsgauche);
        if(n.filsdroit!=null) affiche_aux(n.filsdroit);
    }
    //exo 4
    public static void espace(int n){
        for(int i=0; i<n ; i++){
            System.out.print("  ");
        }System.out.print("|");
    }
    public static void affichage_arbo_aux(Noeud n , int offset){
        if(n==null) return;
        espace(offset);
        System.out.println(n.info);
        if(n.filsgauche!=null){
            affichage_arbo_aux(n.filsgauche,offset+1);
        } 
        if(n.filsdroit!=null){
            affichage_arbo_aux(n.filsdroit,offset+1);
        } 
    }

    //methode qui supprimer la valeur max d'un ABR
    public static void supp_max(Arbre a){

        if(a==null) return ;
        Noeud prec = a.getracine();
        Noeud courant = a.getracine().filsdroit;
        while(courant.filsdroit != null){
            prec = courant ;
            
            courant= courant.filsdroit;
        }
        if(courant.filsgauche == null) prec.setfilsdroit(null);
        else prec.setfilsdroit(new Noeud(courant.filsgauche.info));


    }


    //exo 2 intermediaire supprimer un element d'une liste version déséquilibré

    public static void supprimer_element(Noeud supp){

        if(supp.filsgauche!= null){
            Arbre.echanger_max(supp);
            Noeud max1 = Arbre.max_aux(supp.filsgauche);
            supprimer_element(max1);
        }else if(supp.filsdroit!=null){
            Arbre.echanger_min(supp.filsdroit);
            Noeud min1 = Arbre.min_aux(supp.filsdroit);
            supprimer_element(min1);
        }else{
            supp=null;
        }

    }
    //exo 3 duppliquer un AB
    public static Noeud dupliquer_aux(Noeud n){
        Noeud courant= new Noeud();
        if(n!=null){
            courant.info=n.info;
            Noeud gauche = dupliquer_aux(n.filsgauche);
            Noeud droit = dupliquer_aux(n.filsdroit);
            courant.filsgauche=gauche;
            courant.filsdroit=droit;

        }return courant;
    }

    

}