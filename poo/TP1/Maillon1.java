public class Maillon1 {
    private int a;
    private Maillon1 succ;

    public Maillon1(int po,Maillon1 s){
        this.a=po;
        this.succ= s;
    }
    public Maillon1(int po){
        this.a=po;
    }
    public Maillon1 getsucc(){
        return succ;
    }
    public String toString(){
        return a +" "+succ;
    }
    public int geta(){
        return a;
    }
    public void setsucc(Maillon1 n){
        succ = n;
    }

    
}

