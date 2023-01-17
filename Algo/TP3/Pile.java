public class Pile
{   
    private  static final int taillemax =100;
    private int sommet;
    private int[] tab ;

    
    public Pile(){
        sommet =-1;
        tab=new int[taillemax];
    }
//crée et renvoie une pile vide. 
    public static Pile initialise_pile(){
        return new Pile();
    }
// renvoie un booléen indiquant si P est vide true si vide
    public boolean est_vide(){
        return (sommet==-1);
    }
/* ajoute x au sommet de la pile P et retourne un
 booléen (faux si la pile est pleine) */

    public static boolean empiler(Pile p , int x){
        if(p.sommet<taillemax){
            p.sommet++;
            p.tab[p.sommet]=x;
            return true;
        }return false;
    }
 //: supprime et renvoie le sommet de P, si P est non vide    
    public static Integer  depiler(Pile p){
        if( !(p.est_vide()) ){
            p.sommet--;
            return p.tab[p.sommet+1];
        }return null;
    }
//: renvoie le sommet de P si P est non vide 
    public static Integer sommet(Pile p){
        if( !(p.est_vide()) )return p.tab[p.sommet];
        return null;
    }
/*crée une pile de capacité n (<N)
contenant les entiers de 1 à n, n étant au sommet.*/
    public static Pile pile_entier(int n){
        Pile p = new Pile();
        for(int i=0 ; i<n; i++){
            empiler(p,i+1);
        }return p;
    }

    public static  void afficher_pile_aux(Pile p, int n){
        if(n<=-1){System.out.print("");}
        else{
            System.out.print(p.tab[n]+" ");
        afficher_pile_aux(p,n-1);
    }
    }
//afficher une pile j'ai fait une fonction recursif mais une boucle aurait suffit    
    public static  void afficher_pile(Pile p){
        afficher_pile_aux(p,p.sommet);
    }

// creer une pile qui est l'inverse de celle passée en parametre    
    public static Pile inverse_pile(Pile p){
        Pile r = initialise_pile();
        for(int i = p.sommet; i>=0 ; i--){
            empiler(r,p.tab[i]);
        }return r;
        
    }
    //version recursif inverse d'une pile
    public static void inverse2_aux(Pile p,Pile x, int n){
        if(n<0) return ;
        empiler(x,p.tab[n]);
        inverse2_aux(p,x,n-1);

    }
    public static Pile inverse2(Pile p){
        Pile res = new Pile();
        inverse2_aux(p,res,p.sommet);
        return res;
    }
    public static int factorielle_pile(int n){
        Pile p = pile_entier(n);//on crée une pile de 1 à n
        int fact=1;              
        for(int r = 1 ; r<n; r++){
            fact=fact*(depiler(p));              // on multiplie le sommet de la pile par toutes les valeurs en dessous jusque p.tab[1] (1)
        }return fact;

    }

    
    


}