
public class Tableau {
    private int[] tab;


    public Tableau(int n){
        tab = new int[n];
        for(int i=0; i<n; i++){
            tab[i]=(int)(Math.random()*100);
        }
    }
    
    public void permute(int i, int j){
        int c =tab[i];
        tab[i]=tab[j];
        tab[j]=c;
    }
    public int indicemin(int j){
        int min = tab[j];
        int indice=0;
        for(int i=j; i<tab.length; i++){
            if (tab[i]<min){
                min = tab[i];
                indice =i;
            }
        }
        return indice;
    }
    public boolean veriftab(){
        if(tab.length==0)return true;
        for(int i=0; i<tab.length-1; i++){
            if(tab[i]>tab[i+1]) return false;
        }return true;
    }
    public void triabulle(){
        for(int j= tab.length-1 ; j>0 ; j--){
            for(int i=0; i<j; i++){
                if (tab[i]>tab[i+1]) permute(i,i+1);
            }
        }
    }
    public void triinsertion(){
        
        for(int i=1 ; i<tab.length ; i++){
            int j = i;

            while(j>0 && tab[j-1]>tab[j]){
                permute(j,j-1);
                j--;
            } 
        }
    }

    public void triselection(){
        for(int i=0 ; i<tab.length-1 ; i++){
            int min = indicemin(i);
            permute(i,min);
        }
    }
    public void affiche(){
        for(int i =0 ; i<tab.length ;i++){
            System.out.print(tab[i]+" ");
        }
        System.out.println(" ");
    }

}
