
public enum Type  {
    REVUE,MAGASINE,LIVRE;

 private Type(){
    System.out.println("constructeur");
 }
    
    

}

/*
 * valueOf  : Une méthode de classe qui permet de convertir une chaîne de caractères en une
              énumération.
              Si la chaîne de caractères ne correspond pas à un nom d’un élément de
              l’énumération, cette méthode produit une exception IllegalArgumentException.

 * values   : Une méthode de classe qui retourne un tableau contenant tous les éléments de
              l'énumération dans l'ordre de leur déclaration. Utile pour connaître la listre des 
              valeurs possibles

 * name     : Retourne  le nom de l'élément sous la forme d'une chaîne de caractères
                for(Type t : Type.values()){
                    String name = t.name();
                }
 * ordinal  :  Retourne le numéro d'ordre d'un élément 
               Le numéro d'ordre est donné par l'ordre de la déclaration, le premier élément ayant
               le numéro 0
               int ordre = Type.LIVRE.ordinal();

 *TEST D'EGALITE
  Type t = Type.REVUE;
  if(t.equals(Type.REVUE)) System.out.println("enum egales");
  
  on peut aussi utiliser le " == ";
 */
