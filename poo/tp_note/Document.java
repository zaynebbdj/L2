public class Document  {
    private final String titre;
    private final Auteur auteur ;
    private final Type type;


    public String gettitre(){
        return this.titre;
    }
    public Type gettype(){
        return this.type;
    }
    public Auteur getauteur(){
        return this.auteur;
    }
    
    public Document(String s, Auteur t,Type p ){
        this.titre=s;
        this.auteur= Auteur.copie(t) ;
        this.type = p;
    }

    



}
