package TD3;

public class Maillon {
    private int info; //info de l'Maillon
    private Maillon suiv; //Maillon suivant


    public Maillon(){

    }
    public Maillon(int i){
        info = i;
    }
    public Maillon getsuiv(){
        return suiv;
    }
    public int getinfo(){
        return info;
    }public void setsuiv(Maillon o){
        suiv = o;
    }
    public static void creer_Maillon_1_n(Maillon prims ,int i, int n){
        if(i>n) return ;
        prims.suiv = new Maillon (i);
        creer_Maillon_1_n(prims.suiv,i+1,n);
    }
    public static int max_Maillon_rec(Maillon n, int max){
        if(n==null) return max;
        if(n.info>max) return max_Maillon_rec(n.suiv,n.info);
        else return max_Maillon_rec(n.suiv,max);
    }
   public static String affiche_Maillon_imp(Maillon n, int i){
        if(n==null) return "";
        if(i%2==1){
            System.out.print(n.info+"->");
            return affiche_Maillon_imp(n.suiv,i+1);
        }return affiche_Maillon_imp(n.suiv,i+1);
   }

   public static String affiche_Maillon(Maillon n){
        String s ="";
        if(n==null) return s;
        s+=n.info;
        s+="->";
        return affiche_Maillon(n.suiv)+s;


   }
   public static boolean Maillon_croissant(Maillon n , Maillon m){
        if(m==null) return true;
        if(n.info<=m.info) return Maillon_croissant(m,m.suiv);
        return false;
    }
    public static int longueur_Maillon(Liste l ,Maillon prims,int i){
        if(prims==null) return i;
        if (prims==l.getpremier()) return i;
        return longueur_Maillon(l,prims.suiv,i+1);
    }

}
