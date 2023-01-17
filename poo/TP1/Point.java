import java.util.*;

public class Point {
    private int x;
    private int y;


    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return x+" "+y;
    }
    public static void main(String[] args){

        
        
        Point p1 = new Point(1,2);
        Point p2 = p1;
        Point p3 = new Point(1,2);
        ArrayList<Point> list = new ArrayList();
        list.add(p1);
        System.out.println(list.indexOf(p2));
        System.out.println(list.indexOf(p3)); 


        
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        Point p = (Point)o;
        return (p==o)? true : false;
    }
}
