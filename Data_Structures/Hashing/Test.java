import java.util.*;
public class Test{

  public static void main(String[] args){
    HashMap<String, Integer> h = new HashMap<String, Integer>(200);
    h.put("Dva", Integer.valueOf(600));
    h.put("Widowmaker", Integer.valueOf(175));
    h.put("Tracer", Integer.valueOf(150));
    h.put("Winston", Integer.valueOf(500));
    h.put("Brigitte", Integer.valueOf(225));
    h.put("Wrecking ball", Integer.valueOf(600));
    System.out.println(h);
    h.replace("Brigitte", Integer.valueOf(200));
    System.out.println(h);
    System.out.println(h.containsKey("Widowmaker"));
    Set<Map.Entry<String, Integer>> s = h.entrySet();
    System.out.println(s);
    HashSet<String> set = new HashSet<String>(200);
    set.add("a");
    set.add("b");
    System.out.println(set);
    System.out.println(set.contains("c"));
    System.out.println(set.contains("b"));
  }
}
