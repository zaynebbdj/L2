import java.util.ArrayList;

public class Exo1 {
    

    //verifie si une arraylist contient des doublons
    public static <E> boolean doublons (ArrayList<E> ls){

        for(int i=0 ;i<ls.size()-1 ; i++){
            if(ls.lastIndexOf(ls.get(i))!=i)return true;
        }return false;
    }


    //renvoie le premier element de la liste qui apparait au moins deux fois

    public static <E> E  inDouble(ArrayList<E> ls){

        for(int i=0 ;i<ls.size()-1 ; i++){
            if(ls.lastIndexOf(ls.get(i))!=i) return ls.get(i);
        }return null;
    }

    //renvoie une nouvelle liste qui contient tous les elements qui apparaissent dans ls au moins deux fois

    public static <E> ArrayList<E> tousLesDoublons(ArrayList<E> ls){

        ArrayList<E> resultat = new ArrayList();
        for(int i=0 ;i<ls.size()-1 ; i++){
            if(ls.lastIndexOf(ls.get(i))!=i){
                if(!(resultat.contains(ls.get(i)))){
                    resultat.add(ls.get(i));
                }
                
            }
        }return resultat;
    }


    //renvoie une nouvelle liste qui contient tous les elements de ls mais sans doublons
    public static <E> ArrayList<E> simplifier(ArrayList<E> ls){

        ArrayList<E> resultat = new ArrayList();
        for(int i=0 ;i<ls.size()-1 ; i++){
            if(ls.lastIndexOf(ls.get(i))==i){
                if(!(resultat.contains(ls.get(i)))){
                    resultat.add(ls.get(i));
                }
            }
        }return resultat;
    }
}
