import java.util.ArrayList;

public class Correspondance <K,V>{
    private ArrayList<K> listek;
    private ArrayList<V> listev;


    public Correspondance(){
        this.listek = new ArrayList();
        this.listev = new ArrayList();
    }

    public ArrayList<V> getlistev(){
        return this.listev;
    }
    public ArrayList<K> getlistek(){
        return this.listek;
    }
    // verifie si k appartient à la première liste
    public boolean existe( K k){
        return this.listek.contains(k);
    }
    //qui ajoute k a la fin de la première liste et v à
    //la fin de la deuxième, si k n’est pas déjà dans la première liste
    public boolean insere(K k, V v){
        if(!(this.existe(k))){
            this.listev.add(v);
            this.listek.add(k);
            return true;
        }return false;
    }

    //remplace dans la deuxième liste v à la
    //position correspondante à l’élément k s’il 
    //est dans la première liste 

    public boolean remplace(K k, V v){
        if(this.existe(k)){
            this.listev.add(this.listek.indexOf(k),v);
            return true;
        }return false;
    }

    //renvoie l’élément correspondant à k (ou null) 
    public V get (K k){
        if(this.listek.indexOf(k)<this.listev.size()) return this.listev.get(this.listek.indexOf(k));
        return null;
    }

    public boolean efface(K k){
        if(this.existe(k)){
            this.listek.remove(k);
            return true;
        }return false;
    }




}