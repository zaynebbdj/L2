
    import java.util.Scanner;


public class Partie1
{
    public static void creerTableau(int[] tableau)
    {
        Scanner s = new Scanner(System.in);
        for(int i=0;i<tableau.length;i++)
        {
            System.out.println("saisir le nombre " + (i+1));         
            tableau[i] = s.nextInt();
        }
        
    }
    
    public static void creerTableauAlea(int[] tableau)
    {
        for(int i=0;i<tableau.length;i++)
        {
            tableau[i] = (int) (100 * Math.random());
        }
        
    }

    public static void afficherTableau(int[] tableau)
    {
        for(int i=0;i<tableau.length;i++)
        {
            System.out.println(tableau[i]+" ");         
        }
    }
    public static void  permuter(int[] tableau, int index1, int index2)
    {
        if(tableau != null)
        {
            if( (index1 >= 0) && (index1 < tableau.length) &&
            (index2 >= 0) && (index2 < tableau.length)
            )
            {
                int tmp = tableau[index1];
                tableau[index1] = tableau[index2];
                tableau[index2] = tmp;
            }
        }
    }

    // Principe :
    // - on suppose le tableau trié jusqu'à la position i-1
    // - on positionne l'élément tableau[i]à sa position en décalant
    // tous les éléments plus grands vers la droite.

    public static void triInsertion(int[] tableau)
    {
        for( int i = 1 ; i < tableau.length ; i++ )
        {
            int tmp = tableau[i];
            int j = i-1;
            while( (j >= 0) && (tmp < tableau[j] ) )
            {
                // décalage des valeurs plus grandes que tableau[j]
                tableau[j+1] = tableau[j];
                j--;
            }
            // puis positionnement de l'élément tableau[j] à sa place
            tableau[j+1] = tmp;
        }
    }

    // avec optimisation :
    // - si aucune permutation lors d'un parcours
    // - alors tableau trié, donc arrêt des parcours (cf. variable booléenne 'fin').
    public static void triBulles(int[] tableau)
    {
        boolean fin = false;
        for(int i = tableau.length-1 ; (!fin) && (i >= 1) ; i--)
        {
            fin = true; // supposons qu'il n'y aura pas de permutation
            // échanger 2 éléments consécutifs si dans mauvais ordre
            for( int j = 0 ; j < i ; j++)
            {
                if( tableau[j] > tableau[j+1] )
                {
                    permuter(tableau, j, j+1);
                    fin = false;
                }
            }
        }
    }

    // Principe :
    // - on cherche l'élément min dans tout le tableau et on le permute avec le 1er élément.
    // - on recommence la recherche du min mais dans la portion du tableau entre la 2nde position et la dernière,
    // puis on permute ce min avec le 2nd élément. 
    // - etc.
    public static void triSelection(int[] tableau)
    {
        for( int i = 0 ; i < tableau.length -1 ; i++ )
        {
            int posMin = i;
            // recherche position de l'élément min
            for( int j = i+1 ; j < tableau.length ; j++ )
            {
                if( tableau[j] < tableau[posMin] )
                {
                    // mise à jour (de la position) du min
                    posMin = j;
                }
            }
            permuter(tableau, i, posMin);
        }
    }
    
    public static void main (String[] args) {
    
        int[] tab=new int[10];
        System.out.println("avant tri");
        creerTableauAlea(tab);
        afficherTableau(tab);
        triSelection(tab);
        System.out.println("apres tri");
        afficherTableau(tab);
    }
    
}


