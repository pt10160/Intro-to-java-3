import java.util.*;

public class ExploringArrayList {
   public static void main(String[] args) {
     // ArrayList<Integer> numbers = new ArrayList<Integer>();
      //SimpleArrayIntList numbers = new SimpleArrayIntList();
     IntList numbers = new ArrayIntList();
      
      for(int i=1;i<=10;i++){
      numbers.add(i * 100);
      }
      numbers.add(25);
      //numbers.remove(0);
      //numbers.remove(3);
     
      System.out.println(numbers);
      System.out.println("size = " + numbers.size());
      System.out.println("first element = " + numbers.get(0));
      System.out.println("index 4 = " + numbers.get(4));
      System.out.println("where is 200(starts from 0)? " + numbers.indexOf(200));
      
   //modify the array here
   numbers.add(2,2);
   System.out.println(numbers);
   numbers.remove(3);
   System.out.println(numbers);
   
   
   }
}

// translation from array to ArrayList:
//    String[]          => ArrayList<String>
//    new String[10]    => new ArrayList<String>()
//    a.length          => list.size()
//    a[i]              => list.get(i)
//    a[i] = value;     => list.set(i, value);
// new operations:
//     list.remove(i);     --remove the ith value
//     list.add(value);    --appends a value
//     list.add(i, value); --adds at an index
//     list.clear()        --remove all value