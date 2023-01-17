package TP2;

public class Casillo {
    private int dureedefaut ;

    public int getduree(){
        return dureedefaut;
    }
    public Casillo(){
        dureedefaut=1000000000; // en nanosecondes
    }

    public Chronometre chronometre(){
        return new Chronometre();
    }
    public Attente attente(long duree){
        return new Attente(duree);
    }
    public Attente attenteDefaut(Attente d){
        d.setduree(dureedefaut);
        return d;
    }
    public void changeDefaut(int r){
        dureedefaut=r;
    }
    
}
