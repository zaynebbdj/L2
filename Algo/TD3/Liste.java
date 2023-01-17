package TD3;

public class Liste {
    private Maillon premier; //tete de la liste
    private Maillon prec;
    
    public Liste(){

    }
    public Liste(Maillon e){
        premier = e;
        prec=null;
    }
    public Maillon getpremier(){
        return premier;
    }
    public static Liste creer_liste_1_n(int n){
        Liste l = new Liste();
        l.premier = new Maillon (1);
        Maillon.creer_Maillon_1_n(l.premier,2,n);
        return l;
    }
    public boolean estvide(){
        return(premier==null);
    }
    public String toString(){
        String s="";
        if(estvide()) return s;
        Maillon temp = premier;
        while(temp!= null){
            s+= temp.getinfo();
            s+= "->";
            temp = temp.getsuiv();
        }return s;
    }
    public static int longeur(Liste l){
        return longueur_aux(l.premier,0);
    }
    public static int longueur_aux(Maillon e,int nb){
        if(e=null) return nb;
        return longueur_aux(e.getsuiv(),nb+1);
        
    }
    


    //exercice 1)
    public static int nb_occ( Liste l, int e){
        int nb=0;
        Maillon prec = l.getpremier();
        while(prec!= null){
            if(prec.getinfo()==e) nb++;
            prec=prec.getsuiv();
        }
        return nb;
    }
    public static int nb_occ_rec(int e, Maillon n,int i){
        if(n== null)return i;
        Maillon temp = n;
        if(temp.getinfo()== e) return nb_occ_rec(e,temp.getsuiv(),i+1);
        else return nb_occ_rec(e,temp.getsuiv(),i);
    }
    //exercice 2)
    public static int indice_e(Liste l , Maillon e,Maillon cour,int i){
        if(cour==null)return -1;
        if(cour==e)return i;
        return indice_e(l,e,cour.getsuiv(),i+1);
    }

    //exercice 3)
    public static int max( Liste l){   //version iteratif
        Maillon max = l.getpremier();
        Maillon cour= max.getsuiv();
        Maillon suiv = cour.getsuiv();
        while(suiv!= null){
            if(cour.getinfo()>max.getinfo()){
                max=cour;
            }
            cour=suiv;
            suiv=suiv.getsuiv();
            
        }
        return max.getinfo();
    }
    public static int max_rec(Liste l, int max){
        return Maillon.max_Maillon_rec(l.premier,max);
    }
    //exercice 4)

    public static String affiche(Liste l,int i){
        return Maillon.affiche_Maillon_imp(l.premier,1);
    }

    // exercice 5)
    public  void affiche_inverse(){
       System.out.println( Maillon.affiche_Maillon(premier));

    }

    // exercice 6)
    public boolean croissante(){
        return Maillon.Maillon_croissant(premier,premier.getsuiv());
    }
    // exercice 7)
    public static int longueur(Liste l){
        if(l.estvide()) return -1;
        return Maillon.longueur_Maillon(l,l.premier.getsuiv(),1);
    }
    // exercice 8)
    public void supp(){

    }

    //  NIVEAU INTERMEDIAIRE    

    //exo 1)
    public static void concatene(Liste l1 , Liste l2){
        if (l1.estvide()) l1.premier=l2.premier; ;
        if (l2.estvide()) return ;
        
        Maillon temp = l1.premier ;
        while(temp.getsuiv() != null){
            temp = temp.getsuiv();
            
        }
        temp.setsuiv(l2.premier);
        
    }

    //exo 2)

    public static void ajout(Liste l,Maillon e,int position){
        if(position >longeur(l)){
            Maillon cour = l.premier;
            while(cour.getsuiv()!=null){
                cour=cour.getsuiv();

            }
            cour.setsuiv(e);

        }if (position ==0){

            Maillon temp=l.premier.getsuiv();
            l.premier=e;
            e.setsuiv(temp);
        }
    }
    public static void ajout_ldc(Liste l,Maillon e,int position){
        if(position >longeur(l)){
            Maillon cour = l.premier;
            while(cour.getsuiv()!=null){
                cour=cour.getsuiv();

            }
            cour.setsuiv(e);

        }if (position ==0){

            Maillon temp=l.premier.getsuiv();
            l.premier=e;
            e.setsuiv(temp);
        }
    }
    //exo 3)
    /*public static void supprime(Liste l,premier)
    public static void supprime_aux(Liste l ,Maillon e,int pos){

    }*/
    public static Maillon fusion_aux (Maillon l1, Maillon l2){
        if(l1==null)return l2;
        if(l2==null) return l1;
        if(l1.geting()<l2.getinfo()){
            Maillon lr = fusion(l1.getsuiv,l2);
            l1.setsuiv(lr);
            return l1;
        }else {
            Maillon lr= fusion(l1,l2.getsuiv());
                l2.setsuiv(lr);
                return l2;
            
        }
    }
    public static Liste fusion(Liste l1 , Liste l2){
        return new Liste(fusion_aux(l1.premier,l2.premier));
    }


}
