package javaapp1;

public class JavaApp1 {

    public static void main(String[] args) {
        Segment p1=new Segment(0,0,0,2,0,0);
        System.out.println(p1);
        System.out.println(p1.length());
        System.out.println(p1.lengthAll(2, 0, 0, 50, 4, 0));
        System.out.println(p1.lengthAll(0, 0, 0, 50, 4, 0));
        System.out.println(p1.fromPointToSegment(50,4,0));
    }
    
}
