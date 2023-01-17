




import java.util.*;

public class Soup {
    private ArrayList<Vegetable> list ;

    public Soup(){
        this.list = new ArrayList<>();
    }
    public void add(Vegetable aliment){
        this.list.add(aliment);
    }

    public double getPeelingWeight(){
        double total = 0;
        for(int i = 0 ; i<this.list.size() ; i++){
            total += this.list.get(i).getPeelingWeight() ;
        }return total;
    }

    public void sortByWeight(){
        Collections.sort(this.list);
    }

    @Override 
    public String toString(){
        return this.list.toString();
        
    }

}
