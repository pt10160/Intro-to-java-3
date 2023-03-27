public class ArrayIntList implements IntList{
   private int[] data; // array of integers
   private int size;   // current number of elements in the list

   public static final int CAPACITY = 20;

   // constructor   
   public ArrayIntList() {
      data = new int[CAPACITY];
      size = 0;
   }   

   public void add(int value) {
      checkCapacity(size+1);
      data[size] = value;
      size++;
   }
   
   public String toString() {
      if (size == 0) {
         return "[]";
      } else {
         String result = "[" + data[0];
         for (int x = 1; x < size; x ++) {
            result += ", " + data[x];
         }
         result += "]";
         return result;  
      } 
   } 
	
   public int size() {
      return size;
   }
   
   public int get(int index) {
      checkIndex(index);
      return data[index];
   }
   
   public int indexOf(int value) {
      for (int x = 0; x < size; x++) {
         if (data[x] == value) 
            return x;
      }   
      return -1;
   }
   	
   public void add(int index, int value) {
     checkCapacity(size+1);
     for (int i = size; i > index; i--) {
         data[i] = data[i - 1];
      }
      data[index] = value;
      size++;
   }

   public void remove(int index) {
      for (int i = index; i < size; i++) {
         data[i] = data[i + 1];
      }
      size--;
      data[size] = 0; 
   }   

   public boolean equals(Object o) {
       // self check
       if (this == o)
           return true;
       // null check
       if (o == null) 
           return false;
       // type check and cast
       if (getClass() != o.getClass())
           return false;
       ArrayIntList list = (ArrayIntList) o;
       // list size comparison
       if (size != list.size()) {
         return false;
       }
       // value of each element comparison
       for (int x = 0; x < size; x++) {
         if (data[x] != list.get(x)) {
            return false;
         }
       }
       return true;
   }

   // post: throws an IndexOutOfBoundsException if the given index is
   //       not a legal index of the current list
   private void checkIndex(int index) {
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("index: " + index);
      }
   }

   // post: checks that the underlying array has the given capacity,
   //       throwing an IllegalStateException if it does not
   private void checkCapacity(int capacity) {
      if (capacity > data.length) {
         throw new IllegalStateException("would exceed list capacity");
      }
   }
}