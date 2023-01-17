public class NegativeNumberException extends Exception{
    
    public NegativeNumberException(double d){
       super("le nombre "+d+" est négatif ; sa racine carrée n'existe pas");
    }
}
