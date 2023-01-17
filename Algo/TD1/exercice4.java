public class exercice4 {
    

    public static int indicemin(int[] tab,int debut){
        int temp = tab[debut];
        int indicemin=debut;
        for(int i=debut+1 ; i<tab.length;i++){
            if(tab[i]<temp ){
                indicemin=i;
                temp=tab[i];
            }
        }return indicemin;
    }
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
    public static void triselection(int[] tab){
        int i=0;
        while(i<tab.length && veriftab(tab)==false){

            int m = indicemin(tab,i);
            permute(tab,i,m);
            i++;
        }
    }
}
