
import java.util.*;
public class Service {
    private String nom;
    private ArrayList<Salarie> liste ;
    private int capacite ;


    

    public Service(String name , ArrayList<Salarie> list , int capacite ){
        this.nom = name;
        this.liste = list;
        this.capacite = capacite;
    }
    public ArrayList<Salarie> getListe(){
        return this.liste;
    }
    public int getCapacite(){
        return this.capacite;
    }

    public int libre (){
        return capacite- this.liste.size();
    }


    public ArrayList<Salarie> chercheStagiaire(){
        ArrayList<Salarie> resultat = new ArrayList<Salarie>();

        for (int i =0 ; i< capacite ; i++){
            Salarie courant =this.liste.get(i);
            if(courant.etat() == Etat.STAGIAIRE && courant.getSalaire()>1000 ){
                resultat.add(courant);
            }
        }

        Collections.sort(resultat);
        return resultat;
    }

    @Override
    public String toString(){
        String s = " { Service , "+this.nom + " capacité "+ this.capacite;
        for(int i = 0 ; i<this.capacite ; i++){
            s= s + this.liste.get(i).toString();
        }
        return s;
    }

}
