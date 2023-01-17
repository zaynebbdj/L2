public class Main {
    public static void main(String[] args){

        /*Liste l = Liste.creer_listn(5);
        Liste m = Liste.creer_listn(3);
        l.supprime_element(5);
        m.ajoute_element(8);
        m.supprime_element(8);
        l.supprime_element(2);
        l.affiche();
        m.affiche();
        System.out.println(Liste.sousList(m,l)); 

        Arbre a = Arbre.creer_arbre_parfait(1);
        a.affichage_arborescence();
        System.out.println(Arbre.nb_point_simple(a, 3));
        a.affichage_arborescence();
        System.out.println(Noeud.distance(a,1, 3));*/
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
        abr.affichage_arborescence();
        Noeud.supprimer(abr.getracine());
        System.out.print(Noeud.distance(abr.getracine(), 9, 25));

    }
}    