public class Liste {
    private Maillon1 premier;



public static Liste converti(Point[] tab){
    Liste liste = new Liste();
    Maillon m = new Maillon(tab[0]);
    liste.premier=m;
    for(int i= 1; i<tab.length; i++){
        Maillon n = new Maillon(tab[i]);
        m.setsucc(n);
        m =n;

    }
    return liste;

}
public static void supprimer(Liste l,int x){
    
}
}
