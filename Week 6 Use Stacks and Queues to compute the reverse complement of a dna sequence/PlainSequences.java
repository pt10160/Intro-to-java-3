import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

class PlainSequences implements Sequences {

   private List<String> descriptions;
   private List<String> sequences;
   
   public PlainSequences() {
      descriptions = new ArrayList();
      sequences = new ArrayList();
   }   
   
   @Override
   public List getDescriptions() {
      return descriptions;
   }
   
   public List getSequences() {
      return sequences;
   }
   
   public boolean isValidSequence(int index) {
   
// To represent ambiguity in DNA sequences the following letters can be used (following the rules of the International Union of Pure and Applied Chemistry (IUPAC)):
// 
//         A = adenine           
//         C = cytosine            
//         G = guanine             
//         T = thymine           
//         U = uracil
//         R = G A (purine)        
//         Y = T C (pyrimidine)    
//         K = G T (keto)    
//         M = A C (amino)
//         S = G C 
//         W = A T 
//         B = G T C
//         D = G A T
//         H = A C T
//         V = G C A
//         N = A G C T (any) 
//
// Also allow the charachters for space ' ' and for newline '\n'    

      String sequence = sequences.get(index);
      
      for (int x = 0; x < sequence.length() ; x++) {
         char dnaBase = sequence.charAt(x);
         if 
         (!(
          dnaBase == ' ' ||
          dnaBase == '\n' ||
          dnaBase == 'A' ||
          dnaBase == 'C' ||
          dnaBase == 'G' ||
          dnaBase == 'T' ||
          dnaBase == 'U' ||
          dnaBase == 'R' ||
          dnaBase == 'Y' ||
          dnaBase == 'K' ||
          dnaBase == 'M' ||
          dnaBase == 'S' ||
          dnaBase == 'W' ||
          dnaBase == 'B' ||
          dnaBase == 'D' ||
          dnaBase == 'H' ||
          dnaBase == 'V' ||
          dnaBase == 'N' )) { return false; }      
      }
      return true;
   }
   
   public String formatInGroups(int index, int basesPerGroup, int groupsPerLine) {
      StringBuilder sequenceFormatted = new StringBuilder();
      String sequence = sequences.get(index);
      int indexOfLetterToPrint = 0;
        
      while ( indexOfLetterToPrint < sequence.length()) {
         for (int y = 0; y < groupsPerLine; y++) { 
            for (int z = 0; z < basesPerGroup; z++) {
               if(indexOfLetterToPrint < sequence.length()) {
                  sequenceFormatted.append(sequence.charAt(indexOfLetterToPrint));
                  indexOfLetterToPrint++;
               }
            }
            if (indexOfLetterToPrint < sequence.length()) {
               sequenceFormatted.append(" ");
            }
        }
        if (indexOfLetterToPrint < sequence.length()) {
           sequenceFormatted.append("\n");
        }
      }
        
      return sequenceFormatted.toString();
   }   
   
   public void readSequences(String fileName) throws FileNotFoundException {
      Scanner input = new Scanner(new File(fileName));
      String sequence = "";
      int count = 0;
      
      while (input.hasNextLine()) {
         sequence = sequence + input.nextLine();  
      }
      
      descriptions.add(fileName);
      sequences.add(sequence);
   }
   
   public String toString() {
      StringBuilder sample = new StringBuilder();

      sample.append("Number of sequences: " +sequences.size() + "\n");      
      sample.append("\n");   
      for (int x = 0; x < descriptions.size(); x ++) {
         sample.append("Sequence number: " + x + 1 + "\n");
         sample.append("Description: " + descriptions.get(x) + "\n");
         sample.append("Sequence: " + sequences.get(x) + "\n");
      }
      return sample.toString();
   }

   // pre: assumes the index specified a sequence that exist in the sequences list
   // post: returns a map that shows the frequeny of occurance of all unique substrings from the specified sequence.
   public Map<String, Integer> generateFrequencies(int index) {    
      String sequence = sequences.get(index);
      Map <String, Integer> frequencies = new HashMap();
      String subSequence = "";
     
      for (int start = 0; start < sequence.length(); start++) {
         for (int end = start + 1; end < sequence.length() + 1; end++) {
            subSequence = sequence.substring(start, end); // substring returns letters between indexed from start to end-1
            Integer frequency = frequencies.get(subSequence);
            if (null == frequency) {
               frequency = 1;
            } else {
               frequency++;
            }
            frequencies.put(subSequence,frequency);
         }
      }
      return frequencies;  
   }
   
     public List<String> getSortedListOfSubstrings(int index) {
      List<String> sortedSubstrings = new ArrayList(generateFrequencies(index).keySet());
      Collections.sort(sortedSubstrings); // notice that Collections.sort method changes its parameter object. It returns null.
      return sortedSubstrings;
   }
   
   
   public String getReverseComplement(int index){
   String originalSequence = sequences.get(index);
   String reversedComplement = "";
   
   Queue<Character> sequenceQueue = new LinkedList<Character>();
   for(int x = 0; x < originalSequence.length();x++){
      sequenceQueue.add(originalSequence.charAt(x));
   
   }
   Stack<Character> sequenceStack = new Stack<Character>();
   while (!sequenceQueue.isEmpty()){
   
  Character code = sequenceQueue.remove();
  sequenceStack.push(code);
  }
  
  StringBuilder reverseComplement = new StringBuilder();
 while(!sequenceStack.empty()){
   Character code = sequenceStack.pop();
   
   if(code.equals('a')|| code.equals('A')){
   
   code ='T';
   
   }
   else if(code.equals('t')|| code.equals('T')){
   
   code ='A';
   
   }
  else if(code.equals('g')|| code.equals('G')){
   
   code ='C';
   
   }
   
  else if(code.equals('c')|| code.equals('C')){
   
   code ='G';
   
   }
   reverseComplement.append(code);
 }
   
   return reverseComplement.toString();
     
   
   }
   


}