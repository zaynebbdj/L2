import java.util.*;

class Main{
    public static void main(String[] args){
        Point p1 = new Point(1,2);
        Point p2 = new Point(5,2);
        Point p3 = new Point(0,0);
        Maillon maillon3 = new Maillon(p3,null);
        Maillon maillon2 = new Maillon(p2,maillon3);
        Maillon maillon1 = new Maillon(p1,maillon2);
        System.out.println(maillon1);

    }
    
    public static void affichenb(){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();               //variable de type int
        System.out.print(a);
    }
    public static void affichenb2(){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();               //variable de type int
        int b = input.nextInt();
        System.out.println(a+" "+b);
        System.out.println(a+b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
    }

}