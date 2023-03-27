public class LinkedIntList implements IntList {

   private int size;
   private Node start;
   
	public void add(int value){
   
   }
   
   public String toString(){
   
   return null;
   }
	
   public int size(){
   
   return -1;
   }
   public int get(int index){
   checkIndex(index);
   
   for (int x = 0;x< index){
   temp = temp.next;
   }
   
   return temp.data;
     
        }
   
   public int indexOf(int value){
   
   return -1;
   }
	
   public void add(int index, int value){
   
   
   }
	public void remove(int index){
   
   }
   
   public boolean equals(Object object){
   
   return false;
   
   }
   public void insertList(int index, LinkedIntList list){
   
   }
   
   private void checkIndex(int index){
   if (index<0||index >= size){
   throw new IndexOutOfBoundsException("index:"+index);
   
   }
   }
}