


public class SuperieurA implements Condition  {
    private int ref ;

    public SuperieurA(int entier){
        this.ref=entier;
    }
    public int getref(){
        return this.ref;
    }

    @Override 
    public String toString(){
        return "SuperieurA(" + this.ref+")";
    }

    @Override 
    public boolean verif(int n){
        return (n>this.ref);
    }
    
}
