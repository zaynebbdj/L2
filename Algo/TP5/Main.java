public class Main {
    
    public static void main(String[] args){
        /*Arbre a = new Arbre();
        a.setracine(Arbre.creer_arbre_parfait(2));
        Arbre.affichage_arborescence(a);

        Noeud.supp_max(a);
        Arbre.affichage_arborescence(a);*/

        Arbre abr = new Arbre(5);
        Noeud c = new Noeud(2);
        abr.getracine().setfilsgauche(c);
        Noeud d = new Noeud(12);
        abr.getracine().setfilsdroit(d);
        Noeud e = new Noeud(1);

        Noeud f = new Noeud(3);
        Noeud g = new Noeud(9);
        Noeud h = new Noeud(21);
        Noeud i = new Noeud(19);
        Noeud j = new Noeud(25);
        c.setfilsgauche(e);
        c.setfilsdroit(f);
        d.setfilsgauche(g);
        d.setfilsdroit(h);
        h.setfilsgauche(i);
        h.setfilsdroit(j);
        Arbre.affichage_arborescence(abr);

     }
}
