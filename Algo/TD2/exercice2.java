package TD2;

public class exercice2 {


    public static void main (String[] args){
        int[] tab= {1,5,6,7,9,2};
        affiche(tab);
        triFusion(tab,0,tab.length-1);
        affiche(tab);

    }
    public static void affiche(int[] tab){
        for(int i =0 ; i<tab.length ;i++){
            System.out.print(tab[i]+" ");
        }
        System.out.println(" ");
    }
    public static boolean veriftab(int[] tab){
        if(tab.length==0)return true;
        for(int i=0; i<tab.length-1; i++){
            if(tab[i]>tab[i+1]) return false;
        }return true;
    }

    private static void triFusion(int[] tab,int deb,int fin)
        {
        if (deb!=fin && veriftab(tab)==false)
            {
            int milieu=(fin+deb)/2;
            triFusion(tab,deb,milieu);
            triFusion(tab,milieu+1,fin);
            fusion(tab,deb,milieu,fin);
            }
        }

    private static void fusion(int tableau[],int deb1,int fin1,int fin2)
        {
        int deb2=fin1+1;

        //on recopie les éléments du début du tableau
        int table1[]=new int[fin1-deb1+1];
        for(int i=deb1;i<=fin1;i++)
            {
            table1[i-deb1]=tableau[i];
            }
        
        int compt1=deb1;
        int compt2=deb2;
        
        for(int i=deb1;i<=fin2;i++)
            {        
            if (compt1==deb2) //c'est que tous les éléments du premier tableau ont été utilisés
                {
                break; //tous les éléments ont donc été classés
                }
            else if (compt2==(fin2+1)) //c'est que tous les éléments du second tableau ont été utilisés
                {
                tableau[i]=table1[compt1-deb1]; //on ajoute les éléments restants du premier tableau
                compt1++;
                }
            else if (table1[compt1-deb1]<tableau[compt2])
                {
                tableau[i]=table1[compt1-deb1]; //on ajoute un élément du premier tableau
                compt1++;
                }
            else
                {
                tableau[i]=tableau[compt2]; //on ajoute un élément du second tableau
                compt2++;
                }
            }
        }
}
