public class Maillon {
    private int info;
    private Maillon succ;

    public void setsucc(Maillon m){
        this.succ=m;
    }
    

    public Maillon(int n){
        this.info = n;
        this.succ=null;
    }
    public int getinfo(){
        return this.info;
    }

    public Maillon getsucc(){
        return this.succ;
    }
    public static void affiche(Maillon m){
        if(m!=null){
            System.out.print("["+m.info+"] ->");
            affiche(m.succ);        }
            else{System.out.println("X");}
    }
}
