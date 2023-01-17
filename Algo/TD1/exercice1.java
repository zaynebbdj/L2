public class exercice1{

    public static boolean permute(int[] tab,int i, int j){
        if (tab.length==0) return true;
        if (i>=0 && i<tab.length && j>0 && j<tab.length){
            int c = tab[i];
            tab[i]=tab[j];
            tab[j]=c;
            return true;
        }return false;
        
    }
}