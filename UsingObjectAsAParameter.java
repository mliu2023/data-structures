/**
 *@author Ms. Thuzar
 *@version 1.0
 */

 import java.util.ArrayList;

public class UsingObjectAsAParameter{

  public static void main(String[] args){
    Polygon p = new Polygon();
    System.out.println(p);

    ArrayList<Object> arr = new ArrayList<>();

    arr.add(new Polygon());
    arr.add(new Triangle());
    //arr.add(new Triangle(3)); //you don't inherit the constructors
    arr.add(new Quadrilateral());
    arr.add(new String("triangle"));

    for (Object obj: arr){
      System.out.println(((Polygon)obj).getNumSides());
    }


  }




}


class Polygon{
  //encapsulated class fields
  private int numSides;

  //default constructor
  public Polygon()
  {
    numSides = 3;
  }

  //accessor
  public int getNumSides(){
    return numSides;
  }

  // overloaded constructor
  public Polygon(int n){
    numSides = n;
  }

  /**
   * formats printing with System.out.print
   *@return String
   */
  @Override
  public String toString(){
    return "This is a polygon";
  }

}

class Triangle extends Polygon{

  /**
   * formats printing with System.out.print
   *@return String
   */
  @Override
  public String toString(){
    return "This is a triangle";
  }

}

class Quadrilateral extends Polygon{

  public Quadrilateral(){
    super(4);
  }
  /**
   * formats printing with System.out.print
   *@return String
   */
  @Override
  public String toString(){
    return "This is a quadrilateral";
  }

}
