public class Test{

  public static void main(String[] args){
    Person a = new Person(15, 60);
    Person b = new Person(a);
    a.setAge(10);
    System.out.println(a);
    System.out.println(b);
  }
}
class Person{
  private int age;
  private int height;

  public Person(int a, int h){
    age = a;
    height = h;
  }
  public Person(Person other){
    age = other.age;
    height = other.height;
  }

  public String toString(){
    return "" + age + " " + height;
  }
  public void setHeight(int h){
    height = h;
  }
  public void setAge(int a){
    age = a;
  }
}
