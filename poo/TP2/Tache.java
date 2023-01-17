package TP2;

public class Tache {
    private long dateLimite; 
    private String description;
    

    public Tache(long temps,String d ){
        dateLimite = System.nanoTime()+temps;
        description=d;
    }
    public long getdatelimite(){
        return dateLimite;
    }
    public String getdescription(){
        return description;
    }

    public long conversion_seconde(){ // conversion de la date limite en seconde
        return dateLimite/(10^9);
    }
    public long conversion_minute(){ // conversion  de la date limite en minute
        return conversion_seconde()/60;
    }
    public long conversion_heure(){  //conversion de la date limite en heure
        return conversion_minute()/60;
    }
    

    public long nb_jour(){            // fonction brouillon
        return conversion_heure()/24 ;
    }
    public long nb_heure(){           // fonction brouillon
        return conversion_heure()%24 ;
    }
    public long nb_minute(){         // fonction brouillon
        return conversion_minute()%60;
    }
    public long nb_seconde(){
        return (dateLimite/10^9)%60;
    }
    public boolean datedepasse(){// true si a date limite est depassée
        return dateLimite< System.nanoTime() ;
    }
    @Override
    public String toString(){
        return dateLimite+" "+description;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        if(o == null) return false;
        Tache t =(Tache) o;
        return (this.dateLimite == t.dateLimite && this.description == t.description );

    } 

        
    
    

}
