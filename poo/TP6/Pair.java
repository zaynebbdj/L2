

public class Pair implements Condition {

    
    public Pair(){}

    @Override
    public String toString(){
        return "Pair:";
    }
    
    @Override
    public boolean verif(int n){
        return (n%2 ==0);
    }
    
}
