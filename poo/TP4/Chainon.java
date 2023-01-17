public class Chainon {
    private String info;
    private Chainon suiv;

    public Chainon(String s ,Chainon n){
        this.info=s;
        this.suiv=n;
    }
    public Chainon(String s){
        this(s,null);
    }
    public void setsuiv(Chainon c){
        this.suiv = c;
    }
    public Chainon getsuiv(){
        return this.suiv;
    }
    public String getinfo(){
        return this.info;
    }
    @Override 
    public String toString(){
        return "[ "+this.info+" ]";
    }
    
}
