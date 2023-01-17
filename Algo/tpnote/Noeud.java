public class Noeud{
    private int info;
    private Noeud filsgauche;
    private Noeud filsdroit ;



    public Noeud(){};
    public Noeud(int n){
        this.info=n;
        this.filsdroit=null;
        this.filsgauche=null;
    }
    public void setfilsdroit(Noeud n){
        this.filsdroit= n ;
    }
    public void setfilsgauche(Noeud n){
        this.filsgauche=n;
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

    //
    //methode qui supprimer la valeur max d'un ABR
    public static void supp_max(Arbre a){

        if(a==null) return ;
        Noeud prec = a.getracine();
        Noeud courant = a.getracine().filsdroit;
        while(courant.filsdroit != null){
            prec = courant ;
            
            courant= courant.filsdroit;
            System.out.println(prec.info+"  "+courant.info);
        }
        if(courant.filsgauche == null) prec.setfilsdroit(null);
        else prec.setfilsdroit(new Noeud(courant.filsgauche.info));


    }
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


    //EXO5

    //methode qui retourne la profondeur d'un element dans un ABR
    //on suppose que l'lelement appartent bien a l'arbre a
    public static int profondeur_noeud(Arbre a,int element){
        return profondeur_noeud_aux(a.getracine(),element,0);
    }
    public static int profondeur_noeud_aux(Noeud courant, int elm , int prof){
        if(courant.info== elm)return prof;
        if(elm <courant.info) return profondeur_noeud_aux(courant.filsgauche,elm,prof+1);
        return profondeur_noeud_aux(courant.filsdroit,elm,prof+1);
    }
    public static Integer profondeur(Noeud n , int e , int prof){
        if(n == null) return null;
        if(n.info == e ) return prof;
        if(n.info>e) return profondeur(n.filsgauche , e , prof+1);
        else return profondeur(n.filsdroit , e,prof+1); 
    }

    public static Integer distance(Noeud n, int a, int b){
        if(n == null) return null;
        if(a==b) return 0;
        else return profondeur(n,a,0) + profondeur(n,b,0);
    } 

    


    //EXO 6
    //methode qui renvoie la distance la plus courte entre deux noeud d'un ABR
    // on suppose que les elements n et m appartiennent bien à l'arbre a
    public static int distance(Arbre a , int n, int m){ 

        if(n == m  || a==null)return 0;
        if(n < m )return distance_aux(a.getracine(),n,m);
        return distance_aux(a.getracine(),m,n);

    }
    public static int distance_aux(Noeud courant, int n,int m){
        if(n >courant.info) return distance_aux(courant.filsdroit,n,m);
        if(m <courant.info)return distance_aux(courant.filsgauche,n,m);
        return profondeur_noeud_aux(courant,n,0)+profondeur_noeud_aux(courant,m,0);
    

    }


    //methode qui supprime le plus petit element d'un abr
    public static void supp_aux(Noeud prec, Noeud cour, Noeud suiv){
        if(suiv==null){
            if(cour.filsdroit!=null)prec.setfilsgauche(cour.filsdroit);
            else{ prec.setfilsgauche(suiv);}
        }
        else{
            System.out.print(cour.info);
            supp_aux(cour,suiv,suiv.filsgauche);
        }
    }

    public static void supprimer(Noeud n){
        Noeud prec = n;
        Noeud courant = n.filsgauche;
        if(n == null || n.filsgauche == null && n.filsdroit == null  ) return;
        while(courant.filsgauche != null){
            prec= prec.filsgauche;
            courant=courant.filsgauche;
        }
        
        if(courant.filsdroit == null) prec.setfilsgauche(null);
        else prec.filsgauche= courant.filsdroit;
    
 }

    
}