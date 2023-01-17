/**Cette classe représente une arme
 *
 */

public class Arme {
    private int nb;
    private String nom;
    private int force_attaque;

    /**
     * Retourne une arme dont le nom est passé en paramètre
     * @param nom le nom de l'arme
     * @return l'arme nouvellemment alloué
     */
    public Arme(String nom){
        this.nom = nom;
        nb = 10;
        force_attaque= 5;
    }
    
    /**
     * Retourne le nombre d'utilisation d'une arme 
     * @return le nombre d'utilisation d'une arme
     */
    public int getnb(){
        return nb;
    }
    /**
     * Modifie le nombre d'utilisation d'une arme
     * @param n
     */
    public void setnb(int n){
        nb=n;
    }
    /**
     * Retourne la force d'attque d'une arme
     * @return la force d'attaque d'une arme 
     */
    public int getforce_attaque(){
        return force_attaque;
    }
    
    
    
    @Override
    /**
     * Retourne les argument de l'arme en type string
     * @return les arguments de l'arme en type string
     */
    public String toString(){
        return "Arme : "+ nom+"  "+ force_attaque;
    }

}
