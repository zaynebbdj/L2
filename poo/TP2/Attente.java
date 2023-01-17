package TP2;

public class Attente {
    private long duree;
    private Chronometre c;

    public Attente(long r){
        duree=r;
        c= new Chronometre();
    }
    public void setduree(long r){
        duree=r;
    }

    public long getduree(){
        return duree=System.nanoTime();
    }
    public static boolean tempsDepasse(Attente a){
        return System.nanoTime()>(a.c.getdebut()+a.getduree()) ;
    }

    public static void attendFin(Attente t){
        if(tempsDepasse(t)) return;
        long decalage =  t.c.getdebut()+t.getduree()-System.nanoTime();
        nanosleep(decalage); 
    }
    static void nanosleep(long nanoseconds){
        try{
            java.util.concurrent.TimeUnit.NANOSECONDS.sleep(nanoseconds);
        }
        catch (java.lang.InterruptedException e) {
            throw new java.lang.AssertionError(e);
        }
    }
}
