package TD2;

public class exercice1 {

    public static void main (String[] args){
        int[] tab= {1,5,6,7,9,2};
        affiche(tab);
        System.out.println(recherche_dich_rec(tab,6,0,tab.length-1));

    }
    
    public static int recherche_dich_rec(int[] tab,int e, int debut,int fin){
        if(debut>fin)return -1;
        int m =(debut+fin)/2;
        if(e==tab[m]) return m;
        if(e<tab[m]) return recherche_dich_rec(tab,e,debut,m-1);
        else return recherche_dich_rec(tab,e,m+1,fin);
    }
    public static int recherche_dich_d(int[] tab,int e,int debut,int fin){
        if(debut>fin)return -1;
        int m =(debut+fin)/2;
        if(e==tab[m]){
            while(e==tab[m+1]) m++;
            return m;
        } 
        if(e<tab[m]) return recherche_dich_rec(tab,e,debut,m-1);
        else return recherche_dich_rec(tab,e,m+1,fin);
    }
    public static int recherche_2d(int[][] tab,int e,int debut, int fin){
        for(int i=0 ; i<tab.length ;i++){
            if(tab[i][0]<e && tab[i][tab.length]>e){
                return recherche_dich_rec(tab[i],e,0,tab.length);
            }
        }return 1;
    }
    public static void affiche(int[] tab){
        for(int i =0 ; i<tab.length ;i++){
            System.out.print(tab[i]+" ");
        }
        System.out.println(" ");
    }
}
