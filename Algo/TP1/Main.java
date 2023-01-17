
 import java.util.*;

public class Main {
    

    public static void main (String[] args){
        
        int[] tab1= new int[10];
        //initialisetab(6,tab1);
        
        remplitab(tab1);
        afficherec(tab1,0);
        inverse(tab1,2);
        System.out.println("");
        afficherec(tab1,0);
        
        
    }


    public static void initialisetab(int n ,int[] tab){
        Scanner input = new Scanner(System.in);
        for (int i=0 ; i<n ;i++){
            tab[i]= input.nextInt();
        }
    }
    public static void remplitab(int[] tab){
        for(int i=0 ; i<tab.length ; i++){
            tab[i]= (int)(Math.random()*100);
        }
    }
    public static void affichetab(int[] tab){
        for(int i=0 ; i<tab.length ; i++){
            System.out.print (tab[i]+" ");
        }
        System.out.println("");
    }
    public static void afficherec(int[] tab,int n){
        System.out.print( tab[n] + " ");
        if(n<tab.length-1){
            afficherec(tab,n+1);
        }
    }
    public static void afficherecinverse(int[] tab , int n){
        if(n<tab.length-1){
            afficherecinverse(tab,n+1);
        }
        System.out.print(tab[n]+" ");
    }
    public static int somme(int[]tab,int n){
        if (n>=tab.length){
            return 0;
        }else return tab[n]+somme(tab,n+1);
    }
    public static int eltpairtab(int[] tab , int n){
        if (n>= tab.length){
            return 0;
        }else if(tab[n]%2==0){
            return 1+eltpairtab(tab,n+1);
        }else{
            return 0+eltpairtab(tab,n+1);
        }
    }

    public static int nbocc(int[] tab , int e, int n){
        if(n>= tab.length){
            return 0;
        }else if (tab[n]==e){
            return 1 + nbocc(tab,e,n+1);
        }else{
            return 0 + nbocc(tab,e,n+1);
        }
    }
    public static void inverse(int[] tab, int i){
        for(int j=i ; j<((tab.length-1)/2 )+1; j++){
            int temp = tab[j];
            tab[j]=tab[tab.length-1-j];
            tab[tab.length-1-j]=temp;
        }
    }
}
