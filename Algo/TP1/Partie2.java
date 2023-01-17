public class Partie2
{
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

    public static int puissanceRapide(int a, int n)
    {
        if(n==0) return 1;
        if (n%2==1) return a*puissanceRapide(a,n-1);
        else 
        {
            int res = puissanceRapide(a,n/2);
            return res*res;
        }
    }

    public static int pgcd(int a,int b)
    {
        if(b==0) return a;
        else return pgcd(b,a%b);

    }

    public static void  afficherTableauRec (int[] tab, int n) 
    {
        if(n==0) return;
        afficherTableauRec(tab,n-1);
        System.out.print(tab[n-1] + " ");
    }
    
    public static void  afficherTableauInv (int[] tab, int n) 
    {
        if(n==0) return;
        System.out.print(tab[n-1] + " ");
        afficherTableauInv(tab,n-1);
    }

    public static int  occurenceTableau (int[] tab, int n, int elmt)
    {
        if(n==0) return 0;
        if (tab[n-1]==elmt) return 1+occurenceTableau(tab,n-1, elmt);
        else return occurenceTableau(tab,n-1, elmt);

    }

    public static void  inverserTableau (int[] tab, int r) 
    {
        if((tab.length -r-1) <=r) return;	
        permuter(tab, r, tab.length-r-1);
        inverserTableau(tab,r+1);
    }

    public static void main(String[] args)
    {
        int[] tab = new int[]{1,2,3,4,5,6,7,8,9,10};
        afficherTableauRec(tab, tab.length);
        
        System.out.println ("occ" + occurenceTableau(tab,tab.length, 2));
        inverserTableau(tab,3);
        afficherTableauRec(tab, tab.length);

        //int p = puissanceRapide(5,3);
        //int p = pgcd(225,22);
        ///System.out.println(p);

    }
}