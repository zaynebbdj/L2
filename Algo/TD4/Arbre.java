public class Arbre{
    private Noeud racine;


    public Arbre (int val){
        this.racine=new Noeud(val);
    }
    //EXO 1
    public Arbre creer_noeud(int val){
        return new Arbre(val);
    }

    //EXO 2
    public static void creer_arbre_parfait_aux(int n, Noeud x){
        if(n>0){
            Noeud r1 = new Noeud((int) (Math.random()*50));
            x.setfilsdroit(r1);
            creer_arbre_parfait_aux(n-1,x.getfilsdroit());
            Noeud r2 = new Noeud((int) (Math.random()*50));
            x.setfilsgauche(r2);
            creer_arbre_parfait_aux(n-1,x.getfilsgauche());
        }
            
        
    }
    public static Arbre creer_arbre_parfait(int n, int val){
        if (n<=0) return null;
        Arbre resultat = new Arbre(val);
        creer_arbre_parfait_aux(n-1,resultat.racine);
        
        return resultat;
    }

    //EXO 3
    
    public static void affiche(Arbre m){
        Noeud.affiche_aux(m.racine);
    }
    //exo 4
    
    public static void affichage_arborescence(Arbre a){
        if (a.racine==null){System.out.print("arbre vide");}
        else{
            Noeud.affichage_arbo_aux(a.racine,0);
        }
    }
    
    //EXO 5
    //1)
    public static int nb_element_aux(Noeud n){
        if (n==null) return 0;
        else return 1+nb_element_aux(n.getfilsdroit()) +nb_element_aux(n.getfilsgauche());
    }
    public static int nb_element(Arbre a){
        return nb_element_aux(a.racine);
    }

    //2)
    public static int nb_feuille_aux(Noeud n){
        if (n==null) return 0;
        if ( n.getfilsdroit()==null && n.getfilsgauche()==null){
            return 1;
        } return nb_feuille_aux(n.getfilsdroit()) +nb_feuille_aux(n.getfilsgauche());
    }
    public static int nb_feuille(Arbre a){
        return nb_feuille_aux(a.racine);
    }
    //3)
    public static int nb_pdouble_aux(Noeud n){
        if (n==null) return 0;
        if ( n.getfilsdroit()!=null && n.getfilsgauche()!=null){
            return 1+nb_pdouble_aux(n.getfilsdroit()) +nb_pdouble_aux(n.getfilsgauche());
        } return nb_pdouble_aux(n.getfilsdroit()) +nb_pdouble_aux(n.getfilsgauche());
    }
    public static int nb_pdouble(Arbre a){
        return nb_pdouble_aux(a.racine);
    }
    //4)
    public static int nsimple_aux(Noeud n){
        if(n==null) return 0;
        if ( n.getfilsdroit()==null && n.getfilsgauche()==null){
            return 0;
        }
        if ( n.getfilsdroit()==null && n.getfilsgauche()!=null){
            return 1+ nsimple_aux(n.getfilsgauche());
        }if ( n.getfilsdroit()==null && n.getfilsgauche()!=null){
            return 1+ nsimple_aux(n.getfilsdroit());
        }   return nsimple_aux(n.getfilsdroit())+nsimple_aux(n.getfilsgauche());
    }
    public static int nsimple(Arbre a){
        return nsimple_aux(a.racine);
    }

    /*//EXO 6)
    public static int hauteur(Arbre a){
 chercher la hauteur de larbre gauhce et celle de larbre droit puis prendre le max
    }*/

    // EXO 7)
    
    public static boolean element_present_aux(Noeud n,int e){
        if (n.getinfo()==e) return true;
        if(n.getfilsgauche()!=null && n.getfilsgauche().getinfo()>e){
            return element_present_aux(n.getfilsgauche(),e);
        }
        if(n.getfilsdroit()!=null && n.getfilsdroit().getinfo()<e){
            return element_present_aux(n.getfilsdroit(),e);
        }
        
        return false ;
    }
    public static boolean nb_element(Arbre a,int e){
        return element_present_aux(a.racine,e);
    }

    // EXO 8)
    public static void ajout_aux(Noeud n, int e){
        if(n.getinfo()<e){
            if(n.getfilsdroit()==null){n.getfilsdroit().setinfo(e);}
            else{ ajout_aux(n.getfilsdroit(),e);}
        }if(n.getinfo()>e){
            if(n.getfilsgauche()==null){n.getfilsgauche().setinfo(e);}
            else{ ajout_aux(n.getfilsgauche(),e);}
        }
    }
    public static void ajout_arbre(Arbre a, int e){
        if(a.racine==null){
            a.racine.setinfo(e);
        }
        ajout_aux(a.racine,e);
    }
    
    public static void main(String[] args){
        Arbre a = creer_arbre_parfait(3,1);
        affiche(a);
        affichage_arborescence(a);
        System.out.println();
        System.out.println("nb element   "+nb_element(a));
        System.out.println("nfeuille  "+nb_feuille(a));
        System.out.println("nsimple   "+nsimple(a));
        System.out.println("nb point double  "+nb_pdouble(a));
    }

}