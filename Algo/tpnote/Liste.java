public class Liste{
    private Maillon tete;


    public Liste(int n){
        this.tete=new Maillon(n);
    }


    //methode qui cree un liste de 1 à n un entier entré en parametre
    public static void creer_listen_aux(Maillon courant,int x,int n){
        if (x>n) return;
        Maillon nouv = new Maillon(x);
        courant.setsucc(nouv);
        creer_listen_aux(nouv,x+1,n);
    }

    public static Liste creer_listn(int n){
        Liste l = new Liste(1);
        creer_listen_aux(l.tete,2,n);
        return l;
    }
    //methode qui affiche une liste
    public void affiche(){
        Maillon.affiche(this.tete);

    }

    //EXO 1
    //methode qui teste si une liste est une sous liste d'une autre
    public static boolean sousList(Liste l1 , Liste l2){
        return sousList_aux(l2.tete,l1.tete);

    }


    public static boolean sousList_aux(Maillon l , Maillon m){
        if(m==null) return true;
        if(l==null)return false ;
        if(l.getinfo()==m.getinfo())return sousList_aux(l.getsucc(),m.getsucc());
        return sousList_aux(l.getsucc(),m);
    }
    
    //methode qui supprime un entier entré en parametre d'une liste
    public void supprime_element(int e){
        if(this!=null){
            Maillon prec=this.tete;
            Maillon courant= this.tete.getsucc();
            while(courant.getsucc() != null){
                if(courant.getinfo()==e){
                    courant=courant.getsucc();
                    prec.setsucc(courant);
                }else{
                    prec=courant;
                    courant=courant.getsucc();
                }
                

            }if(courant.getinfo()==e) prec.setsucc(null);
        }
    }
    
    //methode qui ajoute un element a la fin d'une liste
    public void ajoute_element(int x){
        ajoute_element_aux(this.tete,x);
    }
    public static void ajoute_element_aux(Maillon m, int x){
        if (m.getsucc()==null) m.setsucc(new Maillon(x));
        else ajoute_element_aux(m.getsucc(),x);
    }

    


    
}
