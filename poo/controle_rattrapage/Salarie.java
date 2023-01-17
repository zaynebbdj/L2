import java.util.ArrayList;

public class Salarie implements Comparable<Salarie>{

    private String nom;
    private int salaire;
    private Etat etat;


    public Salarie(){};
    public Salarie(String name ,Etat state){
        this.nom = name ;
        this.etat = state;
        this.salaire =(int) (Math.random()*2500) ;

    }
    public Etat etat(){
        return this.etat;
    }

    public int getSalaire(){
        return this.salaire;
    }


    @Override
    public int compareTo(Salarie s){
        return (int) (Math.floor(this.salaire - s.salaire)) ;
    }

    @Override
    public String toString(){
        return "[ nom : "+ this.nom + " salaire : "+ this.salaire + " etat : "+ this.etat + " ]";
    }

    
    


}