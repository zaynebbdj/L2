public class ListeChainee {
    private Chainon premier;
    private Chainon dernier;
    private int taille;

    
    
    public ListeChainee(int r){
        this.premier = new Chainon(String.valueOf(r));
        this.dernier=this.premier;
        this.taille = 1;
    }

    
    
    public void insere(String c) throws IllegalArgumentException
    {
        if(c==null)
        {
            throw new IllegalArgumentException("l'élément inséré ne peut être null" );
        }
        Chainon nouveau = new Chainon(c,this.premier);
        this.premier=nouveau;
        this.taille++;

    }
    public void ajoute(String c) throws IllegalArgumentException
    {
        if(c==null)
        {
            throw new IllegalArgumentException("l'élément inséré ne peut être null");
        }
        Chainon nouveau = new Chainon(c);
        this.dernier.setsuiv(nouveau);
        this.dernier=nouveau;
        this.taille=this.taille+1;
    }
    
    public String supprime()
    {
        if(taille<0) return null;
        Chainon res = this.premier;
        
        this.premier=this.premier.getsuiv();
        if(this.taille==1)this.dernier=null;
        this.taille--;
        return res.getinfo();
    }
    public String premier(){
        if(this.taille>=1){
            return this.premier.getinfo();
        }return null;
    }
    public String dernier(){
        if(this.taille>0){
            return this.dernier.getinfo();
        }return null;
        
    }
    @Override
    public String toString(){
        if(this.taille>0){
            String res ="";
            Chainon i = this.premier;
            while (i.getsuiv()!=null){
                res+= i.toString();
                res+="-> ";
                i=i.getsuiv();
            }
            res+= i.toString();
        return res;
        }return "liste vide";
        
    }
    public static ListeChainee creerliste_1_n(int n){
        ListeChainee l = new ListeChainee(1);
        for(int i=2;i<n;i++){
            l.ajoute(String.valueOf(i));
        }
        return l;
    }
    public static void main(String[] args){
        ListeChainee l = creerliste_1_n(6);
        System.out.println(l);
        l.insere("0");
        //l.insere(null);
        System.out.println(l);
        //l.ajoute(null);
        l.ajoute("8");
        System.out.println(l);
        System.out.println(l.premier());

        System.out.println(l.dernier());
    }
}
