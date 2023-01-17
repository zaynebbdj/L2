public class Liste {
    private Maillon first;

    public Liste(int n){
        this.first = new Maillon(n);
    }
    public Liste(){
    }
//partie 1    
//1)   creation d'une liste simplement chainee de facon recursif
    
    public static Liste creer_liste_1_n(int n){
        if(n>=1){
            Liste l = new Liste();
        l.first = new Maillon (1);
        Maillon.creer_Maillon_1_n(l.first,2,n);
        return l;
        }else return null;
        
    }

    //version iterative

    public Liste creerliste(int n){
        if(n<=0) return null;
        Liste l = new Liste(1);
        Maillon c =l.first;
        for(int i=2; i<=n ;i++){
            Maillon suite = new Maillon(i);
            c.setsucc(suite);
            c=suite;

        }return l;
    }


//2)     liste de syracuse

//version recursive
public static void creer_syracuse_aux(Maillon m,int x,int n){
    if(!(x==n)){
        if(x%2==0){
            x=x/2;
        }else {
            x= 3*x+1;
        }
        Maillon suite= new Maillon(x);
        m.setsucc(suite);
        creer_syracuse_aux(suite,x,n);
    }
    
    
}
public static Liste creer_syracuse(int s){
    Liste l = new Liste(s);
    creer_syracuse_aux(l.first,s,1);
    return l;

}
//version iterative
public Liste syracuse_ite(int s){
    Liste l = new Liste(s);
    Maillon courant = l.first;
    while (s!=1){
        
        if(s%2==0){
            s=s/2;
            
        }else{
            s= 3*s+1;
        }
        Maillon suivant = new Maillon(s);
        courant.setsucc(suivant);
        courant =suivant;
    }
    return l;
}
//3)  

public void convertie_aux(Maillon m,int[] tab ,int x){
    if(x<tab.length){
        Maillon suite= new Maillon(tab[x]);
        m.setsucc(suite);
        convertie_aux(suite,tab,x+1);
    }
    
    
}
/**
 * méthode qui convertie un tableau en liste
 * @param tab tableau a convertir
 * @return le tableau converti en liste
 */
public Liste convertie(int[] tab){
    if(tab.length==0)return null;
    Liste l = new Liste(tab[0]);
    convertie_aux(l.first,tab,1);
    return l;

}

//partie 2
public boolean estvide(){
    return(first==null);
}
/**
 * methode toString qui affiche une liste
 */
@Override
//version iterative
// 1)  AFFICHAGE D'UNE LISTE
public String toString(){
    String s="";
    if(estvide()) return s;
    Maillon temp = first;
    while(temp!= null){
        s+= temp.getinfo();
        s+= "->";
        temp = temp.getsucc();
    }
    s+="X";
    return s;
}
//version recursive

public static String toString(Liste l){
    return toString_aux(l.first);
}

public static String toString_aux(Maillon m){
    if(m==null) return "X";
    else{
        return m.toString()+" ->"+ toString_aux(m.getsucc());
    }
}

//2) LONGUEUR D'UNE LISTE 
//version recursif
public static int longueur(Liste l){
    return longueur_aux(l.first,0);
}
public static int longueur_aux(Maillon e,int nb){
    if(e==null) return nb;
    return longueur_aux(e.getsucc(),nb+1);
    
}
//version iteratif
public static int longueur_ite(Liste l){
    int nb = 0;
    if(  !(l.estvide())  ){
        Maillon courant = l.first;
        while(courant!=null){
            courant=courant.getsucc();
            nb++;
        }
    }return nb;
}
//3) POSITION D'UN ELEMENT DANS UNE LISTE
//version iteratif
public static int position_element(Liste l,int e){
    if( !(l.estvide())){
        int position =0;
        Maillon courant = l.first;
        while(courant!=null && courant.getinfo()!=e){
            courant= courant.getsucc();
            position++;
        }return position;
        
    }return -1;//l'element n'est pas present dans la liste
}
//version recursif
public static int position_element_rec(Liste l, int e){
    return position_element_rec_aux(l.first,e,1);
}
public static int position_element_rec_aux(Maillon m, int e,int position){
    if (m==null) return -1;
    if(m.getinfo()==e) return position;
    else {
        return position_element_rec_aux(m.getsucc(),e,position+1);
    }
}


//4) NOMBRE D'OCCURENCE D'UN ELEMENT DANS UNE LISTE
//version recursif 
public static int nb_occ_rec(Liste l , int element){
    return nb_occ_rec_aux(l.first,element,0);
}
public static int nb_occ_rec_aux(Maillon m , int element , int nb){
    if(m==null) return nb;
    if(m.getinfo()==element) return nb_occ_rec_aux(m.getsucc(),element,nb+1);
    return nb_occ_rec_aux(m.getsucc(),element,nb);
}
//version iteratif
public static Integer nb_occ_ite(Liste l,int e){
    if(!(l.estvide())){
        int nb=0;
        Maillon courant = l.first;
        while(courant!=null){
            if (courant.getinfo()==e) nb++;
            courant= courant.getsucc();
        }
        return nb;
    }return null;
}

//5) VALEUR MAXIMAL D'UNE LISTE
//version recursif
public static Integer max_rec(Liste l){
    if(!(l.estvide())){
        return Maillon.max_Maillon_rec(l.first.getsucc(),l.first.getinfo());
    }return null;
    
}
//version iteratif
public static Integer max_ite(Liste l){
    if(!(l.estvide())){
        int max = l.first.getinfo();
        Maillon courant =  l.first;
        while(courant!=null){
            if(courant.getinfo()>max)max=courant.getinfo();
            courant= courant.getsucc();
        }
        return max;
    }return null;
}


//6) AFFICHAGE D'UN ELEMENT SUR DEUX D'UNE LISTE
//version recursif

//version iteratif


//7) VERIFICATION DE LA CROISSANCE D'UNE LISTE
//version recursif
public static boolean croissante(Liste l){
    if(l.estvide()){
        return croissante_aux(l.first,l.first.getsucc());
    }return true;
}
public static boolean croissante_aux(Maillon n , Maillon m){
    if(m==null) return true;
    if(n.getinfo()<=m.getinfo()) return croissante_aux(m,m.getsucc());
    return false;
}
//version iteratif
public static boolean croissante_ite(Liste l){
    if(!(l.estvide()) && l.first.getsucc()!=null){
        return false;
    }return true;
}

//8)
public static  void affiche_inverse(Liste l){
    System.out.println( Maillon.affiche_Maillon(l.first));

 }
 

 //9)
 public static void supprimer(Liste l){
    l.first=null;
 }

 //niveau intermédiaire
 //1 LSC
 public static void concatenelsd(Liste l1 , Liste l2){
    if (l1.estvide()) l1.first=l2.first; ;
    if (l2.estvide()) return ;
    
    Maillon temp = l1.first ;
    while(temp.getsucc() != null){
        temp = temp.getsucc();
        
    }
    temp.setsucc(l2.first);
    
}
//1 LDC
public static void concatenelcd(Liste l1 , Liste l2){
    if (l1.estvide()) l1.first=l2.first; ;
    if (l2.estvide()) return ;
    
    Maillon temp = l1.first ;
    while(temp.getsucc() != null){
        temp = temp.getsucc();
        
    }
    temp.setsucc(l2.first);
    l2.first.setpred(temp);
    
}
//2)
public static void ajout(Liste l,int e,int position){
    Maillon n= new Maillon (e);
    if(position >longueur(l)){
        Maillon cour = l.first;
        while(cour.getsucc()!=null){
            cour=cour.getsucc();

        }
        
        cour.setsucc(n);

    }else if (position <=0){

        n.setsucc(l.first);
        l.first= n;
        
    }else{
        int j=1;
        Maillon cour = l.first;
        while(cour.getsucc()!=null && j+1<position){
            cour=cour.getsucc();
            j++;
        }
        
        n.setsucc(cour.getsucc());
        cour.setsucc(n);
    }
}
public static void ajoutldc(Liste l,Maillon e,int position){
    if(position >longueur(l)){
        Maillon cour = l.first;
        while(cour.getsucc()!=null){
            cour=cour.getsucc();

        }
        cour.setsucc(e);
        e.setpred(cour);

    }if (position ==0){

        Maillon temp=l.first.getsucc();
        l.first=e;
        e.setsucc(temp);
    }else{
        int j=1;
        Maillon cour = l.first;
        while(cour.getsucc()!=null && j+1<position){
            cour=cour.getsucc();
            j++;
        }
        e.setsucc(cour.getsucc());
        cour.setsucc(e);
        e.setpred(cour);
    }
}
//3)
//LSC
public static void supp(Liste l,int e){
    if(!(l.estvide())){
        Maillon.supp_maillon(l.first,l.first.getsucc(), e);
    }if(l.first.getinfo()==e) l.first=l.first.getsucc();
    
}
//4)
public boolean appartient(int e){
    if(longueur(this)>0){
        Maillon courant = this.first;
        while(courant.getsucc()!=null){
            if(courant.getinfo()==e) return true;
            courant= courant.getsucc();
        }
    }return false;
}
public static boolean inserer(Liste l,int e){
    Maillon nouveau = new Maillon(e);
    if( !(l.appartient(e))){
        if(l.first==null){
            l.first=nouveau;
        }
        Maillon courant = l.first;
        while(courant.getsucc()!=null && courant.getsucc().getinfo()<e){
            courant=courant.getsucc();
        }
        nouveau.setsucc(courant.getsucc());
        courant.setsucc(nouveau);
        return true;
    }return false;

}






 

}
