import java.util.Scanner ;

import javax.swing.JOptionPane;
/**
 * Cette classe correpsond à la version Beta -- du jeu
 */
public class OthelloVersionTerminal {
    

    /**
     * Methode qui permet d'executer le jeu dans le terminale
     * @param args tableau d'argument
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int taille = Integer.parseInt(JOptionPane.showInputDialog("saisissez une taille pour le plateau"));
        Board nouvelle = new Board(taille);
        try{
            while(!(nouvelle.isOver())==true){
            nouvelle.showterminal();
            nouvelle.showCoupPossible(nouvelle.French_of_Player());
            int coupX = input.nextInt();
            int coupy = input.nextInt();
            nouvelle.update(coupX, coupy);
            



        }
        input.close();
        JOptionPane.showMessageDialog(null, "Le joueur "+nouvelle.winner().name()+" a gagné");

        }catch(Exception e){
            System.out.println("erreur");
        }
        
    }
}
