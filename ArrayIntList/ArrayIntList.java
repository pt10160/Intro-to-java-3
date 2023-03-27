public class ArrayIntList implements IntList{
   private int[] data; // array of integers
   private int size;   // current number of elements in the list

   public static final int CAPACITY = 20;

   public ArrayIntList() {
      data = new int[CAPACITY];
      size = 0;
   
   } 
   public void add(int value){
   checkCapacity(size+1);
    data[size]=value;
    size++;
    
   }

    public String toString(){
      if(size == 0){
           return "[]";
           }
   
           
           else{
           String result = "["+data[0];
           for(int i = 1; i< size; i++){
           result += ","+data[i];
           }
           result += "]";
           return result;
           
            
           }
           }   
   public int size()
   {return size;}
   
   public int get(int index)
   {
      return data[index];
   }

   public int indexOf(int value){
   for(int i=0; i< size;i++)
   {
   if(data[i] == value){
         ;
         return i;}
   }
   return -1;
   }

   public void add(int index,int value){
            checkCapacity(size+1);
            for (int i = 0; i >index ; i--) {
                data[i]=data[i-1];
            }
            data[size]=value;
            size++;
          
        }
        
        public void remove(int index){
            for (int i = 0; i <size ; i++) {
                data[i]=data[i+1];
            }
            size--;
            data[size]=0;
        }



   private void checkIndex(int index) {
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("index: " + index);
      }
   }


   private void checkCapacity(int capacity) {
      if (capacity > data.length) {
         throw new IllegalStateException("would exceed list capacity");
      }
   }
}
/*test result
[100,200,300,400,500,600,700,800,900,1000,25]
 size = 11
 first element = 100
 index 4 = 500
 where is 200(starts from 0)? 1
*/
 
 
 /*modify the array:
   numbers.add(2,2);
   System.out.println(numbers);
   numbers.remove(3);
   System.out.println(numbers);
*/

//result after modified
 /* 
 [100,200,300,400,500,600,700,800,900,1000,25,2]
 [200,300,400,500,600,700,800,900,1000,25,2]*/
 