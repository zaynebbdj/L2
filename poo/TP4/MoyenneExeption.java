public class MoyenneExeption{

    public static void main(String[] argv)
    {
        if (argv.length < 0)
        {
            System.out.println("Il n'y a pas d'arguments");
            System.exit(1);
        } 
        try{
            int moyenne = moyenne(argv);
            System.out.println("La moyenne est " + moyenne);
        }catch(ArithmeticException e){
            System.out.println("on ne peut diviser par 0");
        }
        
        
    }
    public static int moyenne(String[] argv)
    {
        int somme = 0;
        int cpt = 0;
        for (int i = 0; i < argv.length; i++)
        {
            try{
                somme += Integer.parseInt(argv[i]);
                cpt++;
            
            }catch(NumberFormatException e){
                System.out.print("ce n'est pas un nombre");
            }    
            
        }
        return somme / cpt;
    } 

}