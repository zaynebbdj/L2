public class Maillon {
    private Point a;
    private Maillon succ;

    public Maillon(Point po,Maillon s){
        this.a=po;
        this.succ= s;
    }
    public Maillon(Point po){
        this.a=po;
    }
    public Maillon getsucc(){
        return succ;
    }
    public String toString(){
        return a +" "+succ;
    }
    public Point geta(){
        return a;
    }
    public void setsucc(Maillon n){
        succ = n;
    }

    
}
