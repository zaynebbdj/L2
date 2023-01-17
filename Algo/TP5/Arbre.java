public class Arbre {
    private Noeud racine;

    public Noeud getracine(){
        return this.racine;
    }
    public Arbre(){

    }
    
    public void setracine(Noeud n){
        this.racine = n;
    }
    public Arbre(int valeur){
        this.racine=new Noeud(valeur);
    }
    //exo 2
    public static Noeud creer_arbre_parfait_aux(int n, int x){
        Noeud cour = new Noeud(x);
        if(n>0){
            
            cour.setfilsdroit(creer_arbre_parfait_aux(n-1,2*x+1));
            
            cour.setfilsgauche(creer_arbre_parfait_aux(n-1,2*x));
            
        }return cour;
            
        
    }public static Noeud creer_arbre_parfait(int n){
        if (n<=0) return null;
        return creer_arbre_parfait_aux(n,1);
    }
    //exo 3
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

    //exo 5
    // 1)
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
    public static boolean element_present(Arbre a,int e){
        return element_present_aux(a.racine,e);
    }

    
    

    // exo 8

    public static void ajout_aux(Noeud courant, int e){
        if(e<=courant.getinfo()){
            if(courant.getfilsgauche()==null){ courant.setfilsgauche(new Noeud(e));}
            ajout_aux(courant.getfilsgauche(),e);
        } 
        else if(courant.getfilsdroit()== null){
            courant.setfilsdroit(new Noeud(e));
        }else{ajout_aux(courant.getfilsdroit(),e);}

    }// ici  on peut aussi faire une fonction qui retourne un noeud
    public static void ajout(Arbre a , int e){
        if(a.racine==null){
            a.racine = new Noeud(e);
        }
        ajout_aux(a.racine,e);
    }


    ///////////////// NIVEAU INTERMEDIAIRE
    // exercice 1
     //1) noeud minimum d'un abr


     public static Noeud min_aux(Noeud courant){
        if(courant.getfilsgauche()==null) return courant;
        else return min_aux(courant.getfilsgauche());

     }
     public static Noeud min(Arbre a){
        if(a==null) return null;
        return min_aux(a.racine);
     }
     // noeud maximum d'un abr
     public static Noeud max_aux(Noeud courant){
        if(courant.getfilsdroit()==null) return courant;
        else return max_aux(courant.getfilsdroit());
     }
     public static Noeud max(Arbre a){
        if(a==null)return null;
        return max_aux(a.racine);
     }

     // 2)

     public static void echanger_aux(Noeud n , Noeud m){
        int temp = n.getinfo();
        n.setinfo(m.getinfo());
        m.setinfo(temp);
     }
     public static void echanger_max(Noeud n){
        if(n!= null){
            echanger_aux(n,max_aux(n.getfilsgauche()));
        }
     }
     public static void echanger_min(Noeud n){
        if(n!=null){
            echanger_aux(n,min_aux(n.getfilsdroit()));
        }
     }

     
     ///exo 2 dans la classe noeud

     

     // EXERCICE 3 dupliquer un AB

     public static Arbre dupliquer(Arbre a){
        Arbre res = new Arbre();
        if(a.racine!=null){
            res.racine = Noeud.dupliquer_aux(a.racine);
        }
        
        return res;
     }

     //EXERCICE 3supprimer un AB

     public static void supprimer(Arbre a){
        supprimer_aux(a.racine);
     }
     public static void supprimer_aux(Noeud n){
        if(n!=null){
            supprimer_aux(n.getfilsgauche());
            supprimer_aux(n.getfilsdroit());

        }
        n=null;
     }

     





}
