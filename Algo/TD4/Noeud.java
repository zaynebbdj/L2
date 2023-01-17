public class Noeud {
    private Noeud filsgauche;
    private Noeud filsdroit;
    private int info;


    public Noeud(int r){
        this.info=r;
    }
    public int getinfo(){
        return this.info;
    }
    public void setinfo(int val){
        this.info=val;
    }
    public void setfilsdroit(Noeud x){
        this.filsdroit=x;
    }
    public void setfilsgauche(Noeud x){
        this.filsgauche=x;
    }
    public Noeud getfilsdroit(){
        return this.filsdroit;
    }
    public Noeud getfilsgauche(){
        return this.filsgauche;
    }
    //exo3
    public static void affiche_aux(Noeud n){
        if(n!=null) System.out.print(n.info+"  ");
        if(n.filsgauche!=null) affiche_aux(n.filsgauche);
        if(n.filsdroit!=null) affiche_aux(n.filsdroit);
    }
    //exo4
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
