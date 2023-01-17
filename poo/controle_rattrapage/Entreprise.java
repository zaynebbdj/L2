import java.util.ArrayList;

public class Entreprise {
    private ArrayList<Service> liste;


    public Entreprise(){};
    public Entreprise(ArrayList<Service> list){
        this.liste = list;
    }
    public ArrayList<Service> getListe(){
        return this.liste;
    }


    public void add(Salarie s) throws FullServiceException{
        int incr = 0;
        Service courant = this.liste.get(incr);
        while ( courant.libre()<=0 && incr< this.liste.size()){
            courant = liste.get(incr+1);
            
        }
        if(incr>= this.liste.size() ){
                throw new FullServiceException("plus de poste vacant ");
        }else{
            courant.getListe().add(s);
        }

    }

    public Service chercheService(){

        Salarie premier = this.liste.get(0).getListe().get(0);
        Service prims = this.liste.get(0);

        for(int i = 0 ; i<this.liste.size() ; i++){
            for(int j =1 ; j< this.liste.get(i).getCapacite() ; j++){
                Salarie cour = this.liste.get(i).getListe().get(j);
                if(cour.getSalaire()> premier.getSalaire()){
                    premier = cour;
                    prims = this.liste.get(i);
                }
                
            }
        }

        return prims;
    }
}
