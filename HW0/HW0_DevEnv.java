// Your name here
// CS 143
// HW Core Topics: setting up my dev environment
//
// This program will produce a "Hello World" program in Java.import java.util.*;
public class HW0_DevEnv{
public static void main(String[] args){
for(int i=0;i<5;i++){
System.out.println("Hello World");
}
while(true){
Scanner sc=new Scanner(System.in);
System.out.println("Would you like to see 'Hello World' again? (Yes/other)");
String option=sc.next();
if(option.contains("Yes")){
for(int i=0;i<5;i++){
System.out.println("Hello World");
}
}
else{
System.exit(0);
}
}   
}
}
/*
Hello World
 Hello World
 Hello World
 Hello World
 Hello World
 Would you like to see 'Hello World' again? (Yes/other)
 Yes
 Hello World
 Hello World
 Hello World
 Hello World
 Hello World
 Would you like to see 'Hello World' again? (Yes/other)
 nnn
 
  ----jGRASP: operation complete.
*/