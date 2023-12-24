import java.util.ArrayList;
/**
* A simple generic class. T is a type parameter that will be replaced by
* a real type when an object of type Gen is created.
*
*/

class Gen<T>
{
  T ob; //declare an object of type T


  // Pass the constructor a reference to an object of type T
  Gen(T o)
  {
    ob = o;
  }

  /**
   * return ob
   *
   */
  T getOb()
  {
    return ob;
  }

  /**
   * show type of T
   *
   */
  void showType()
  {
    System.out.println("Type of T is " + ob.getClass().getName());
  }
}

public class GenDemo
{
  public static void main(String[] args)
  {
    Gen<String> g1 = new Gen<String>("abc");
    Gen<Integer> g2 = new Gen<>(3);

    g1.showType();
    g2.showType();

    Gen<String> str1= new Gen<String>("hi");
    System.out.println(str1.getOb().getNumSides());
    System.out.println(str1.getOb().length());
  }

}
