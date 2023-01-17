import java.lang.String;

import java.util.ArrayList;
public class Exo3 {
    
    public static Correspondance<Character,ArrayList<String>> regroupe(ArrayList<String> ls){
        Correspondance<Character,ArrayList<String>> co = new Correspondance();

        for(int i =0 ; i<ls.size() ; i++){
            String mot = ls.get(i);
            Character  lettre = mot.charAt(0);
            if(  co.existe(lettre) ){
                co.get(lettre).add(mot);
            }else{
                ArrayList<String> liste = new ArrayList<String> ();
                liste.add(mot);
                co.insere(lettre,liste);
            }
            
        }
        return co;

    }
}
