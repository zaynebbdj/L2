public class Main {
    public static void main(String[] args){
        File l = File.file_entier(8);
        
        Pile p = File.convertie(l);
        File.afficher_file(l);
        System.out.println();
        Pile.afficher_pile(p);

        
    }
}
