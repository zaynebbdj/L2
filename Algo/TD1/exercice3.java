public class exercice3 {
    
    public static void permute(int[]tab ,int i, int j){
        int c =tab[i];
        tab[i]=tab[j];
        tab[j]=c;
    }
    public static boolean veriftab(int[] tab){
        if(tab.length==0)return true;
        for(int i=0; i<tab.length-1; i++){
            if(tab[i]>tab[i+1]) return false;
        }return true;
    }

    public static void triinsertion(int[] tab){
        int j= 1;
        while(veriftab(tab)==false && j<tab.length){
            int i=j;
            while(tab[i]>tab[i-1]  && i>0){
               permute(tab,i,i-1); 
               i--;
            } 
            j++;
        }
    }

}
