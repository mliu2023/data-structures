/**
* Class to create a Quadrilateral.
* @author Max Liu
* @version 1.0
*/
public class Quadrilateral extends Polygon{

  private String type;

  /**
  * Constructor for the Quadrilateral class.
  * @param type The type of quadrilateral.
  * @param name The name of the quadrilateral.
  * @param area The area of the quadrilateral.
  */
  public Quadrilateral(String type, String name, double area){
    super(4, name, area);
    this.type = type;
  }

  public String getType(){
    return type;
  }
  public void setType(String type){
    this.type = type;
  }
}
