public abstract class Acteur{
    
    private final String nom;
    private final String prenom;
    private int age ;

    public Acteur(String nom, String prenom , int age){
        this.nom = nom ;
         this.prenom = prenom;
         this.age = age;
    }


    public abstract double getSalaire();
    @Override
    public String toString(){
        return this.nom +" "+this.prenom+" "+this.age;
    }



}