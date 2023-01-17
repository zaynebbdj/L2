public class Inventaire {
    private PC[] liste1;
    private Imprimante[] liste2;
    private Portable[] liste3;




    public Inventaire(Imprimante[] i1,PC[] pc,Portable... portable){
        for(int i =0; i<pc.length ; i++){
            liste1[i]=pc[i];
        }for(int i =0; i<i1.length ; i++){
            liste2[i]=i1[i];
        }for(int i =0; i<portable.length ; i++){
            liste3[i]=portable[i];
        }
        

    }

}
