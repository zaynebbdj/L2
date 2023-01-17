public class Maillon{
    private int info;
    private Maillon succ;
    private Maillon pred;


    public void setinfo(int n){
        this.info =n;
    }
    public Maillon(int n){
        this.info=n;
    }
    public void setsucc(Maillon n){
        this.succ=n;
    }
    public Maillon getsucc(){
        return succ;
    }
    public int getinfo(){
        return info;
    }
    public void setpred(Maillon m){
        this.pred=m;
    }

    public static void creer_Maillon_1_n(Maillon prims ,int i, int n){
        if(i>n) return ;
        prims.succ = new Maillon (i);
        creer_Maillon_1_n(prims.succ,i+1,n);
    }
    public static int max_Maillon_rec(Maillon n, int max){
        if(n==null) return max;
        if(n.info>max) return max_Maillon_rec(n.succ,n.info);
        else return max_Maillon_rec(n.succ,max);
    }

    
    
    public static String affiche_Maillon(Maillon n){
        String s ="";
        if(n==null) return s;
        s+=n.info;
        s+=" ->";
        return affiche_Maillon(n.succ)+s;


   }
   public static void supp_maillon(Maillon prec,Maillon cour, int e){
    if(cour==null)return ;
    if(cour.info==e){
        prec.setsucc(cour.succ);
        //cour.setpred(prec);
    }supp_maillon(cour,cour.succ,e);
   }
   @Override
   public String toString(){
    return String.valueOf(this.info);
   }
}