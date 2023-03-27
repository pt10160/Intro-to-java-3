import java.util.*;
import java.io.*;


public class PlainSequences implements Sequences {

   private List<String> descriptions;
   private List<String> sequences;
   
   public PlainSequences(){
      descriptions = new ArrayList<String>();
      sequences = new ArrayList<String>();
     }
   
   public List<String> getDescriptions(){
      return descriptions;
      }
      
   public List<String> getSequences(){
      return sequences;
   }
      
   public void readSequences(String fileName) throws FileNotFoundException{
   
      Scanner input = new Scanner(new File(fileName));
      String sequence = "";
      int count = 0;
      
      while(input.hasNextLine()) {
         sequence = sequence + input.nextLine();
         
   
   }
   descriptions.add(fileName);
   sequences.add(sequence);
   }
   
   public boolean isValidSequence(int index) {
   
    String sequence = sequences.get(index);
    
    for (int x = 0; x< sequence.length(); x++){
    char dnaBase = sequence.charAt(x);
    if
    (!(
    dnaBase == ' '||
   dnaBase == '\n'||
    dnaBase == 'A'||
    dnaBase == 'C'||
    dnaBase == 'G'||
    dnaBase == 'T'||
    dnaBase == 'U'||
    dnaBase == 'R'||
    dnaBase == 'Y'||
    dnaBase == 'K'||
    dnaBase == 'M'||
    dnaBase == 'S'||
    dnaBase == 'W'||
    dnaBase == 'B'||
    dnaBase == 'D'||
    dnaBase == 'H'||
    dnaBase == 'V'||
    dnaBase == 'N'
    ))
    {return false;}
    
    
        } 
        return true;
     }
     
   public String formatInGroups(int index, int basesPerGroup, int groupsPerLine) {
  StringBuilder formattedSequence = new StringBuilder();
  String sequence = sequences.get(index);
  int i = 0;
  int j = 0;
  int sb = sequence.length()/(groupsPerLine*basesPerGroup);
                while( i < sequence.length()){
            for(int a=0; a<groupsPerLine; a++){
                for(int b=0; b<basesPerGroup; b++){
                    if(i< sequence.length()){
                        formattedSequence.append(sequence.charAt(i));
                        i++;
                    }
                }
               if(i < sequence.length()){  
                      
 formattedSequence.append(" ");}
                 }
                  if(i >= sequence.length()){  
                       break;}
                if(j < sb){  j++;
                  formattedSequence.append("\n");
                  }
               
                                                  
            }
                       
                  
        return formattedSequence.toString();
    }


   
   public String toString(){
      StringBuilder sample = new StringBuilder();
      
      sample.append("Number of sequences:" + sequences.size() + "\n");
      sample.append("\n");
   
      for(int x = 0;x< descriptions.size();x++){
          sample.append("Sequnce number: " + x + 1 + "\n");
          sample.append("Description: " + descriptions.get(x) + "\n");         
          sample.append("Sequence: " + sequences.get(x) + "\n");
           }
          return sample.toString();
       }
  
   
} 
   
   
   