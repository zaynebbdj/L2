package TP2;

public class Chronometre {
    private long debut; // initialisé a l'heure de creation de l'objet


    public Chronometre(){
        debut= System.nanoTime();
    }
    public long dureeMicro(){
        return (System.nanoTime()-debut)/1000;
    }
    public long dureeMilli(){
        return (System.nanoTime()-debut)/1000000;
    }

    public void reset(){
        debut=System.nanoTime();
    }
    public long getdebut(){
        return debut;
    }



}
