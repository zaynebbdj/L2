import java.util.ArrayList;
public class Main{

  public static void main(String[] args){
    BaseDocumentaire base = new BaseDocumentaire();
    
    Auteur i = new Auteur("salut",9);
    Document d1 = new Document("youssouf",new Auteur("Victor Hugo",10), Type.LIVRE);
    Document d2 = new Document("zakaria", new Auteur("deus",10), Type.REVUE);
  
    Document d3 = new Document("salma", i, Type.LIVRE);
    Document d4 = new Document("adam", i, Type.LIVRE);
    try{
      
      base.ajout(d1);
    base.ajout(d2);
    base.ajout(d3);
    base.ajout(d4);}
    catch(Exception BaseDocumentaireException){
      System.out.println("Vous essayez d'ajouter des documents dans une base pleine");
    }

    
    System.out.println(base);
  
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println(new BaseDocumentaire(base.listeLivreAuteur(i)));
    
  
  }
  
}