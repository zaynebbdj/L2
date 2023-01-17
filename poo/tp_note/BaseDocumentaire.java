import java.util.ArrayList;

public class BaseDocumentaire {
    private ArrayList<Document> base;
    private final static int Max =100;


    public BaseDocumentaire(ArrayList<Document> d){
        this.base =d;
    }
    public BaseDocumentaire(){
        this.base= new ArrayList<Document>();
    }
    
    public void ajout(Document d) throws BaseDocumentException {
        if(this.base.size()>Max) throw new BaseDocumentException("liste commplete");
        else this.base.add(d);
    }


    public Document magasineAuteur(Auteur o){
        int i=0;
        while(this.base.get(i).gettype()!=Type.MAGASINE && !(this.base.get(i).getauteur().equals(o))){
            i++;
        }
        return this.base.get(i);
    }

    public Document chercheDocument(String s){
        int i=0;
        while(this.base.get(i).gettitre()!=s){
            i++;
        }
        return this.base.get(i);
    }

    public ArrayList<Document> listeLivreAuteur(Auteur o){

        ArrayList<Document> liste = new ArrayList<Document>();

        for(int i= 0 ;i<this.base.size(); i++){
            switch (this.base.get(i).gettype() ){
                case LIVRE :
                    if (this.base.get(i).getauteur().equals(o)){liste.add(this.base.get(i));}
                break;
                default:
                break;

            }
        }
        return liste;

    }

    @Override
    public String toString(){
       
            String s="";
            for(int i=0;i<this.base.size();i++){
                Document d = this.base.get(i);
                Auteur o = d.getauteur();
                Type t = d.gettype();
                String title = d.gettitre();
                s+="       auteur :";
                s+= o.getnom();
                s+="  titre :";
                s+=title;
                s+= "  type :";
                s+= t;
                s+="    ->    " ;
            
            }
            s+= "X";
        return s;
    }

    
}