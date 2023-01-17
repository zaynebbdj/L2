

import java.util.ArrayList;


public class TestConditions {

    public static void remplitAlea(ArrayList<Integer> liste, int n){
        for(int i=0 ; i<n ;i++){
            liste.add(Integer.valueOf((int)Math.random()*50));
        }
    }

    public static int compte(ArrayList<Integer> liste , Condition c , boolean b){
        int nb = 0;
        for(int i= 0 ; i<liste.size();i++){
                if(c.verif(liste.get(i))==b) nb++;

        }
        
        return nb;
    }
    
}

