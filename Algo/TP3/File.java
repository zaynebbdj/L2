public class File {
    private int in;
    private int out ;
    private static final int MAX =100;
    private int[] tab;


    public File(){
        in=0;
        out=0;
        tab = new int[MAX];
    }
    //creer une file vide
    public static File initialise_file(){
        return new File();
    }

    //methode qui convertie une file en une pile
    public static Pile convertie(File l){
        Pile resultat = new Pile(); //on initialise la pile
        int j=l.in%MAX-l.out%MAX;
        while(j!=0){
            Pile.empiler(resultat,File.defiler_inverse(l));      //on remplie la pile en defilant la file
            j--;
        }
        return resultat;
    }
    // print la tete de la file et renvoi true si non vide , false sinon    
    public static Integer  defiler_inverse(File f){
        if( !(est_file_vide(f)) ){
            int x = f.tab[(f.in-1)%MAX];
            f.in--;
            return x;
        }
        return null;
    }
    
// renvoie vrai si la file est pleine faux sinon
    public static boolean est_file_pleine(File f){
        return (f.out%MAX== (f.in+1)%MAX);
    }
// renvoi vrai si la file est pleine ( cas ou in=out) faux sinon   
    public static boolean est_file_vide(File f){
        return f.in==f.out ;
    }
//ajoute un element à la file  si elle n'est pas pleine   
    public static boolean enfiler(File f, int x){
        if(est_file_pleine(f)==false){
          
            f.tab[f.in%MAX]=x; //ajout
            f.in++;            //incrementation de in
            return true;
        }
        return false;
    }
// print la tete de la file et renvoi true si non vide , false sinon    
    public static Integer  defiler(File f){
        if( !(est_file_vide(f)) ){
            int x = f.tab[f.out%MAX];
            f.out++;
            return x;
        }
        return null;
    }
//creer une file de 1 à n ( n etant plus petit que la taille max de la file)    
    public static  File file_entier(int n){
        File res= new File();
        if(n<MAX){
        for(int i=0; i<n; i++){
            enfiler(res,i+1);
        }}
        return res;

    }
// affiche les element d'une file si non vide    
    public static void afficher_file(File f){
        for(int i=f.out ; i<f.in; i++){
            System.out.print(f.tab[i%MAX]+ "  ");
        }System.out.println();
    }
//creer la file inverse d'une file passée en parametre
    public static File inverser_file(File f){
        File res = new File();
        for(int i=f.in-1; i>f.out-1; i--){
            enfiler(res,f.tab[i%MAX]);
        }return res;
    }
//supprime un element d'une file en decalant tous ceux apres cet element vers la gauche
    public static void decalage_file(File f, int debut){
        for(int i=debut; i<f.in;i++){
            f.tab[i%MAX]=f.tab[(i+1)%MAX];
        }
        f.in--;
        
    }  
//supprime les occurences d'un element d'une liste      
    public static void supprimer_element_file(File f, int e){
        for(int i = f.out ; i<f.in ; i++){
            if(f.tab[i%MAX]==e){
                decalage_file(f,i);
            }
        }
        
    }
    // creer une deuxieme file a partir de celle passée en paramètre 
    public static File separe_file(File f){
        int n=f.out;
        if(!(n%2==1))n++;
        File res = new File();
        while(n<f.in){
            enfiler(res,f.tab[n%MAX]);  //on rempli la deuxième file
            n+=2;
        }n=f.out;
        if(!(n%2==1))n++;
        while(n<f.in){
            decalage_file(f,n);  //on supprime les valeurs en trop
            n++;
        }

        return res;
    }
   
    

    
    



}
