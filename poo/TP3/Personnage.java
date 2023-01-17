/**
 * Cette classe represente un personnage
 */
public class Personnage{
    private String nom;
    private int niveau_vie;
    private Arme arme_main;
    private Arme arme_poche;


    /**
     * cree un personnage dont le nom est passé en argument
     * @param nom
     */
    public Personnage(String nom)
    {
        niveau_vie = 50;
        arme_main = new Arme("main");


    }
    /**
     * Retourne le nom du personnage
     * @return le  om du personnage
     */
    public String getnom_perso(){
        return nom;
    }
    /**
     * Retourne le niveau de vie d'un personnage
     * @return le niveau de vie d'un personnage
     */
    public int getniveauvie(){
        return niveau_vie;
    }
    /**
     * Retourne l'arme à la main du personnage
     * @return l'arme a la main du personnage
     */
    public Arme getarme_main(){
        return arme_main;
    }
    /**
     * Retourne l'arme en poche du personnage
     * @return l'arme en poche du personnage
     */
    public Arme getarme_poche(){
        return arme_poche;
    }
    /**
     * Modifie le nom du personnage
     * @param s le nom a affecter au personnage
     */
    public void setnom_perso(String s){
        nom=s;
    }
    /**
     * Modifie le niveau de vie du personnage
     * @param n le niveau de vie a affecter au personnage
     */
    public void setniveau_vie(int n){
        niveau_vie =n;
    }
    /**
     * Modifie l'arme à la main du personnage
     * @param m l'arme à affecter à la main du personnage
     */
    public void setarme_main(Arme m){
        arme_main=m;
    }
    /**
     * Modofie l'arme en poche du ppersonnage
     * @param m l'arme a affecter a la poche du personnage
     */
    public void setarme_poche(Arme m){
        arme_poche =m;
    }
    @Override
    /**
     * Retourne les champs du personnage en type string
     */
    public String toString(){
        return "Personnage : "+ nom +" "+niveau_vie+" "+arme_main +" "+arme_poche;
    }
    /**
     * Modifie le niveau de vie d'un personnage en fonction de l'arme du personnage
     * @param p le personnage dont on veut diminuer le niveau de vie
     */
    public  void attaque_perso(Personnage p){
        if(this.arme_main.getforce_attaque()<=0 && this.arme_poche.getforce_attaque()>0  ){
            this.echanger_arme();
        }p.niveau_vie= p.niveau_vie-this.arme_main.getforce_attaque(); //on enleve de la vie au perso p(-la force d'attaque de l'arme)
        this.arme_main.setnb(p.arme_main.getnb()-1);          //on decrement le nb d'utilisation de l'arme
    }
    /**
     * Echange l'arme en main et l'arme en poche du personnage
     */
    public void echanger_arme(){
        Arme temp = this.arme_main;
        this.arme_main=this.arme_poche;
        this.arme_poche=temp;
    }
    /**
     * Affecte une nouvelle arme en poche au personnage
     * @param p l'arme en poche à affecter au personnage
     */
    public void nouvelle_arme_poche(Personnage p){
        p.arme_poche=new Arme("poche");
    }

}