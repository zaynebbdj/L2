import java.util.ArrayList;

public class RH extends Service{
    
    private int nb_entretien ;

    
    public RH(String name , ArrayList<Salarie> list ,int capacite ,int nb){
        super(name,list,capacite);
        this.nb_entretien = nb;
    }
}
