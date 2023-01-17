public class Buffer {
    private Poste[] tab;
    private static final int  MAX=100;
    private int ecriture;
    private int lecture;

    public Buffer(){
        tab = new Poste[MAX];
        ecriture=0;
        lecture=0;
    }

    public static boolean Lire(Buffer b, char c,int n){
        if( !(b.tab[b.lecture].getalire()) ) return false;
        boolean ok=true;
        b.tab[b.lecture].setinfo(c) ; //lecture de c
        b.tab[b.lecture].setalire(false);//on modifie l'etat du poste
        b.lecture=(b.lecture +1)%MAX;
        return ok;

    }
    public static boolean ecrire(Buffer b, char c, int n){
        if(b.tab[b.ecriture].getalire()) return false;
        b.tab[b.ecriture].setinfo(c); //ecriture de c
        b.tab[b.ecriture].setalire(true);
        b.ecriture=(b.ecriture+1)%MAX;
        return true;

    }


}
