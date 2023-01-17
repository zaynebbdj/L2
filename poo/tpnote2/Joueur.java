public class Joueur extends Acteur{


    private String club;
    private double montant;
    private double salaire;

    public Joueur(String prenom,String nom, int age,String club,double montant){
        super(nom,prenom,age);
        this.club = club;
        this.montant = montant;
        this.salaire = Math.random()*montant ;
    }
    public String getClub(){
        return this.club;
    }


   
    @Override
    public double getSalaire(){
        return this.salaire;
    };
    
}
