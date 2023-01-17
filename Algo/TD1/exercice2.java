public class exercice2 {
    

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
    public static void tribulle(int[] tab){
        int j=tab.length-1;
        while(j>1 && veriftab(tab)==false){
            for(int i=0 ; i<j ; i++){
                if (tab[i]>tab[i+1]) permute(tab,i,i+1);
                j--;
            }
        }
    }
}
