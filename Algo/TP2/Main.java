
/**
 * Décrivez votre classe Main ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Main
{
    public static void main(String[] args){
        
        int[] tab = creer_tab(8);
        affiche(tab);
        
        trifusion(tab,0,tab.length-1);
        affiche(tab);
    }
    // EXERCICE 1 --------------------------------------------------------------------

// Question 1)
public static int somme_recursif(int n){
    if(n<0) return -1;
    if (n==0) return 0;
    return n+somme_recursif(n-1);
}
// Question 2)
public static int somme_recursif_bis(int n,int res){
    if (n<0)return -1 ;
    if (n==0) return res;
    res = res+n;
    return somme_recursif_bis(n-1,res);
    
}
// Question 3)
/*On voit que les deux algorithme calcule la meme chose mais pas de la meme facon le premier 
sera plus long car il devra depiler tous les appelle de la fonction afin d'afficher le resultat
tandis que l'autre contient deja le resutlat dans les parametres.
*/
    
    
    
// EXERCICE 2 -------------------------------------------------------------------    
    
// Question 1) recursif naif
    public static int fibo(int n){
        if(n==0|| n==1) return 1;
        return fibo(n-1)+fibo(n-2);
    }
// Question 2) recursif malin    
    public static int fibo_term(int n,int f1,int f2){   //f1 et f2 sont les deux premiers termes de la suite
        if(n==0) return f2;
        return fibo_term(n-1,f2,f1+f2);
        
    }
// EXERCICE 3 -----------------------------------------------------------------
// Question 1)    
    public static int recherche_max_recursif(int[] tab,int taille){
        if(taille==1) return 0;
        int indice= recherche_max_recursif(tab,taille-1);
        return tab[indice]>tab[taille-1] ? indice : taille-1 ;
        
    }
// Question 2)    
    public static int somme_recursif(int[] tab,int taille){
        if (taille==0) return 0;
        if (taille == 1) return tab[0];
        return tab[taille-1] + somme_recursif(tab,taille-1);
    }

    public static float somme_recursif_terminal(float[] tab, int taille, float somme){
        somme +=tab[taille];
        if (taille==0) return somme;
        return somme_recursif_terminal(tab,taille-1,somme);
    }

// EXERCICE 5 -------------------------------------------------------------------

// Question 1)
// recherche dichotomique d'un element dans un tableau trié
    public static int recherche_dich(int[] tab, int e,int debut , int fin){ // e element a trouver 
        if(debut>fin)return -1;                                             // recherche entre l'indice debut et l'indice fin du tableau
        int m=(debut+fin)/2;
        System.out.print(m+" ");
        if(tab[m]==e)return m;
        if(tab[m]>e)return recherche_dich(tab,e,debut,m-1);
        return recherche_dich(tab,e,m+1,fin);
    }

    public static void trifusion(int[] tab,int debut,int fin){ // debut = premier indice du tableau
        if (debut<fin){                           // fin = taille du tableau
        int milieu= (debut+fin)/2;

        trifusion(tab,0,milieu);
        trifusion(tab,milieu+1,fin);
        
        fusion(tab,debut,milieu,fin);
        }
    }
    
    public static void fusion(int[] tab,int debut,int milieu,int fin){
        int n1 = milieu - debut + 1;
        int n2 = fin - milieu;
 
        int G[] = new int[n1];
        int D[] = new int[n2];
        // on copie la premiere partie du tableau
        for (int i = 0; i < n1; i++){
            G[i] = tab[debut + i];}
        // on copie la deuxieme partie du tableau    
        for (int j = 0; j < n2; j++){
            D[j] = tab[milieu + 1 + j];
        }
        
        int i=0;
        int j =0; 
        int k=debut;
        
 
        while (i < n1 && j < n2) {
            if (G[i] <= D[j]) {
                tab[k] = G[i];
                i++;
            } else {
                tab[k] = D[j];
                j++;
            }
            k++;
        }
 
        // on copie les elements restants
        while (i < n1) {
            tab[k] = G[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            tab[k] = D[j];
            j++;
            k++;
        }
    }
        
    

// tri rapide d'un tableau
    public static void trirapide(int[] tab,int debut,int fin){
        if(debut<fin){

            int indice_pivot = partition(tab,debut,fin);

            trirapide(tab,debut,indice_pivot);
            trirapide(tab,indice_pivot+1,fin);
        }
    }

    /*placement des plus petits éléments à gauche du pivot
    et des plus grands à droite */
    public static int partition(int[] tab,int debut,int fin){ // debut = premiere indice du tableau , fin= taille du tableau
        int pivot = tab[fin-1]; //valeur du pivot (dernier case du tableau)
        int i=debut;             
        int j= fin-2;
        while(i<j){
            
            while(i<j && tab[i]<=pivot){
                i++;
            }while(i<j && tab[j]>pivot){
                j--;
            }
            if(i<j){permute(tab,i,j);}
            
        }if(i==fin-2 && tab[i]<pivot){
            return i;
        }else{
            permute(tab,i,fin-1);
        }
        
        return i;
    }
    
    
    // permute deux cases d'un tableau
    public static void permute(int[] tab,int i, int j){
        int c =tab[i];
        tab[i]=tab[j];
        tab[j]=c;
    }
    // verifie si un tableau est trié retourne vrai si trié , faux si non trié
    public static boolean trifini(int[] tab){ 
        if(tab.length==0|| tab.length==1)return true;
        for(int i=0; i<tab.length-1; i++){
            if(tab[i]>tab[i+1]) return false;
        }return true;
    }
    // affiche un tableau
    public static void affiche(int[] tab){
        for(int i=0; i<tab.length;i++){
            System.out.print(tab[i]+ "  ");
        }System.out.println();
        
    }
    // creer un tableau de taille n
    public static int[]  creer_tab( int n){
        int[] tab = new int[n];
        for (int i=0; i<n;i++){
            tab[i]=(int)(Math.random()*10);
        }
        return tab;
    }
    // creer un tableau trie de 1 a n
    public static int[] creer_tab_1_n(int n){
        int[] tab = new int[n];
        for(int i=1 ; i<n ; i++){
            tab[i]=i;
        }return tab;
    }
}
