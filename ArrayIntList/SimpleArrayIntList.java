public class SimpleArrayIntList {
   // fields
   private int[] data;
   private int size;
   
   // constructors    
   public SimpleArrayIntList() {
   data = new int[20];
   size = 0;
   
   } 
   // accessors
   
   // mutators
   public void add(int value){
    data[size]=value;
    size++;
    
   }
   // toString
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
 }
 


