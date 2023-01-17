import java.util.ArrayList;

public class Main {
    

    public static void main(String[] args){
        try {

            //liste de service de l'entreprise
            ArrayList<Service> list = new ArrayList<Service>();
        
            //premier element de la liste de service
            Service prims = new Service("premier service", new ArrayList<Salarie>(2),2);
            list.add(prims);

            //deuxieme element de la liste de service 
            RH deus = new RH("deuxieme Service", new ArrayList<Salarie>(2) , 2, 50);
            list.add(deus);

            //creation de l'entreprise avec la liste de service 
            Entreprise entreprise = new Entreprise(list);



            //ajout des salarie aux services de l'entreprise 
            Salarie a = new Salarie("joe" , Etat.STAGIAIRE);
            Salarie b = new Salarie("Jamie",Etat.STAGIAIRE);
            entreprise.add(a);
            entreprise.add(b);

            Salarie c = new Salarie("joe2" , Etat.CONTRACTUEL);
            Salarie d = new Salarie("Jamie2",Etat.STAGIAIRE);
            entreprise.add(c);
            entreprise.add(d);


            //affichage des salarie
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);

            //affichage du premier service de l'entreprise
            System.out.println(entreprise.getListe().get(0)); //OK

            //affichage du salarie ayant le plus haut salaire du premier service de l'entreprise
            System.out.println(entreprise.getListe().get(0).chercheStagiaire());   //OK

            //affichage de la liste des salariés stagiaires dont le salaire dépasse 1000 euros
            System.out.println(entreprise.chercheService());//OK
        

            



        }catch(FullServiceException f){
            System.out.println("aucun postes vacants ");
        }
        
    }
}
