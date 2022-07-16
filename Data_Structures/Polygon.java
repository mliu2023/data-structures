/**
* Class to create a polygon.
* @author Max Liu
* @version 1.0
*/

public class Polygon{

  private int sides;
  private String name;
  private double area;

  /**
  * Constructor for the Polygon class.
  * @param sides The number of sides.
  * @param name The name of the Polygon.
  * @param area The area of the Polygon.
  */
  public Polygon(int sides, String name, double area){
    this.sides = sides;
    this.name = name;
    this.area = area;
  }

  public int getSides(){
    return sides;
  }
  public String getName(){
    return name;
  }
  public double getArea(){
    return area;
  }
  public void setSides(int sides){
    this.sides = sides;
  }
  public void setName(String name){
    this.name = name;
  }
  public void setArea(double area){
    this.area = area;
  }
}
