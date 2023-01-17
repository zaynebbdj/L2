import java.lang.Math;
import java.util.ArrayList;

public class Triplet <E>{
    
    private E un;
    private E deux;
    private E trois;


    public Triplet( E x, E y, E z){
        this.un = x;
        this.deux=y;
        this.trois=z;
    }

    public E getun(){
        return this.un;
    }
    public E getdeux(){
        return this.deux;
    }
    public E gettrois(){
        return this.trois;
    }

    
    public void randomSwap(){
        int version = (int) Math.random()*3;
        ArrayList<E> tab = new ArrayList();
        tab.add(this.un);
        tab.add(this.deux);
        tab.add(this.trois);
        
        for(int i=0 ; i<tab.size(); i++){
            tab.set(i,tab.get((i+version)%tab.size()));

        }
        
        this.un=tab.get(0);
        this.deux=tab.get(1);
        this.trois=tab.get(2);

    }
    @Override 
    public String toString(){
        return un+" "+deux+" "+trois;
    }
}