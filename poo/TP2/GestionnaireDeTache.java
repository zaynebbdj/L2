package TP2;

public class GestionnaireDeTache {

    private int max;
    private Tache[] tab ;
    private int position;

    public GestionnaireDeTache(){
        max=5000;
        int position=0;
        tab = new Tache[max];
    }
    public static Tache creer_tache_secondes(long o,String s){
        Tache t1 = new Tache(o*100000000,s);
        return t1;
        
    }

    public void ajout_tache(Tache t){
        if (position>max-1) System.out.print("Plus de place");
        else {tab[position]=t;
        position++;}
    }
    public long conversion_heure(long r){
        return r/(1000000000*60*60);
    }
    public void affiche_tache(){
        for (int i=0;i<position;i++){
            if(tab[i].datedepasse()==false){ //si la date limite de la tache n'est pas depasse 
                long tempsrestant = tab[i].getdatelimite()-System.nanoTime();   //date limite- date actuelle
                float temps = conversion_heure(tempsrestant);    // conversion en heure du temps restant
                System.out.print(tab[i]);
                System.out.println(" "+temps);
            }
            
        }
    }

    public void retire_tache(Tache t){ // afin d'eviter a lutilisateur de preciser qu'on commence a la position 0
        retire_tache_aux(t,0);
    }
    public void retire_tache_aux(Tache t,int pos){ 
        if (pos>=position) return; //si la position est superieur au nombre d'elements du tableau on sort 
        if(tab[pos].equals(t)){           //on compare la tache a la position pos du tableau avec la tache t(element a retirer)
            tab[pos]=tab[position-1]; //on place la dernier tache du tableau a la position pos afin decrase celle a retirer
            position--;               // on decremente le nombre d'elemenet du tableau
        }else{
            retire_tache_aux(t,pos+1);
        }
    }
    
    public int nb_tache_faite(){ // retourne le nombre de tache dont le delai est depassé
        int nb=0;
        for(int i=0 ; i<position ; i++){
            if(tab[i].datedepasse()) nb++;
        }return nb;
    }
    public Tache[] tache_faite(){ // creer un tableau de tache dont le delai est depassé
        Tache[] t1 = new Tache[nb_tache_faite()];
        int j=0;
        for(int i= 0; i<position; i++){
            if (tab[i].datedepasse()){
                t1[j]=tab[i];
                j++;
            } 
        }
        return t1;
        
    }

    public int nb_tache_apres(long r){ // retourne le nombre de tache dont la datelimite est inferieur a la date passe en parametres
        int nb=0;
        for(int i=0 ; i<position ; i++){
            if(tab[i].getdatelimite()>r) nb++;
        }return nb;
    }
    public Tache[] tache_apres(Tache t){
        long u = t.getdatelimite();
        Tache[] t1 = new Tache[nb_tache_apres(u)];
        int j=0;
        for(int i= 0 ; i<position ; i++){
            if(tab[i].getdatelimite()>u){
                t1[j]=tab[i];
                j++;
            }
        }return t1;
    }



}
