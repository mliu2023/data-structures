import java.util.ArrayList;
/**
* Runner for the Polygon hierarchy.
* @author Max Liu
* @version 1.0
*/
public class ReviewRunner{

  public static void main(String[] args){
    ArrayList<Polygon> arr = new ArrayList<Polygon>(3);
    Polygon p1 = new Triangle(4, "triangle1", 84.0);
    Polygon p2 = new Triangle(2, "triangle2", 12.0);
    Polygon p3 = new Quadrilateral("kite", "quadrilateral1", 56.0);
    arr.add(p1);
    arr.add(p2);
    arr.add(p3);
    System.out.println(arr.get(0).getSides());
    System.out.println(arr.get(1).getArea());
    System.out.println(arr.get(2).getName());
  }

}
