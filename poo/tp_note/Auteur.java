public class Auteur {
    private String nom;
    private int date;

    public Auteur(String s,int d){
        this.nom = s;
        this.date = d;
    }

    public String getnom(){
        return this.nom;
    }
    public int getdate(){
        return this.date;
    }

    public static Auteur copie(Auteur o){
        return new Auteur(o.nom,o.date);
    }
    @Override
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null)return false;
        if(this.getClass()!= o.getClass())return false;
        Auteur a = (Auteur) o;
        return (this.nom == a.nom && this.date== a.date);

    }

    


}
