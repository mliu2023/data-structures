/**
* Class to create a Triangle.
* @author Max Liu
* @version 1.0
*/
public class Triangle extends Polygon{

  private int inradius;

  /**
  * Constructor for the Triangle class.
  * @param inradius The inradius of the triangle.
  * @param name The name of the triangle.
  * @param area The area of the triangle.
  */
  public Triangle(int inradius, String name, double area){
    super(3, name, area);
    this.inradius = inradius;
  }

  public int getInRadius(){
    return inradius;
  }
  public void setInRadius(int inradius){
    this.inradius = inradius;
  }
}
