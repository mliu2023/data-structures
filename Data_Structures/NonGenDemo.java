// NonGen is functionally equivalent to NonGen
// but does not use generics
class NonGen {
  Object ob; //ob is now of type Object

  //Pass the constructor a reference to
  // an object of type object
  NonGen(Object o){
    ob = o;
  }

  //Return type object
  Object getOb(){
    return ob;
  }

  // Show type of ob
  void showType(){
    System.out.println("Type of ob is" + ob.getClass().getName());
  }

}

// Demonstarte the non-generics class.
class NonGenDemo{
  public static void main(String[] args){
    NonGen iOb;

  // Create NonGen Object and store
  // an Integer in it. Autoboxing still occurs.
  iOb = new NonGen(88);

  // Show the type of data used by iOb.
  iOb.showType();

  //Create another NonGen object and
  // store a String in it.
  NonGen strOb = new NonGen("Non-Generics Test");

  //Show the type of data used by strOb
  System.out.println((Polygon)strOb.getOb().getNumSides());
}
}
