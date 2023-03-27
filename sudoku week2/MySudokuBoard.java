// Your name here
// CS 143
// HW Core Topics: sudoku board 1
//
// This program will Define a SudokuBoard Class Reading in a board data file

import java.util.*;
import java.io.*;

public class MySudokuBoard {
   public final int SIZE = 9;
   protected char[][] myBoard;
   

   public MySudokuBoard(String theFile) {
      myBoard = new char[SIZE][SIZE];
      try {
         Scanner file = new Scanner(new File(theFile));
         for(int row = 0; row < SIZE; row++) {
            String theLine = file.nextLine();
            for(int col = 0; col < theLine.length(); col++) {
               myBoard[row][col] = theLine.charAt(col);
            }
         }
      } catch(Exception e) {
         System.out.println("Something went wrong :(");
         e.printStackTrace();
      }
   }

   public static char[][]Converter(String boardString)
    {
        String str = boardString;
  int row = 9;
  int column = 9;
  int k = 0;
  
        char[][] ch = new char[9][9];
    for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                if(k < str.length())
                    ch[i][j] = str.charAt(k);
                k++;
            }
        }
 

  
       return ch;
    }
   
 public boolean isValid() {
 
      for(char[] row : myBoard) 
         for(char cell : row)
            if(cell != '.' && (cell < '1' || cell > '9'))
               return false;
      
      // checks for row/col violations
      for(int r = 0; r < myBoard.length; r++) {
         Set<Character> tRow = new HashSet<>();
         Set<Character> tCol = new HashSet<>();
         for(int c = 0; c < myBoard[r].length; c++) {
            if(tRow.contains(myBoard[r][c]))
               return false;//illeagal data check in row
            else if(myBoard[r][c] != '.')
               tRow.add(myBoard[r][c]);
               
            // illeagal data check in col
            if(tCol.contains(myBoard[c][r]))
               return false;
            else if(myBoard[c][r] != '.')
               tCol.add(myBoard[c][r]);
         } 
      }
      

      for(int square = 1; square <= 9; square++) {   
         char[][] mini = miniSquare(square);
         Set<Character> tMini = new HashSet<>();
         for(int r = 0; r < 3; r++)
            for(int c = 0; c < 3; c++)
               // illeagal data check in block
               if(tMini.contains(mini[r][c]))
                  return false;
               else if(mini[r][c] != '.')
                  tMini.add(mini[r][c]);
      }
      
            return true;
   }
     private char[][] miniSquare(int spot) {
      char[][] mini = new char[3][3];
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            // whoa - wild! This took me a solid hour to figure out.
            // This translates between the "spot" in the 9x9 Sudoku board
            // and a new mini square of 3x3
            mini[r][c] = myBoard[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }
   


   public boolean isSolved() {
      if(isValid())
         return false;
         
      Map<Character,Integer> map = new HashMap<>();
      for(char[] row : myBoard) {
         for(char cell : row) {
            if(map.containsKey(cell))
               map.put(cell, map.get(cell) + 1);
            else 
               map.put(cell, 1);
         }
      }
      // info on Collections: https://docs.oracle.com/javase/8/docs/api/?java/util/Collections.html
      return map.keySet().size() == 9 && Collections.frequency(map.values(),9) == 9;
   }

   public String toString() {
      String result = "My Board:\n\n";
      for(int row = 0; row < SIZE; row++) {
         for(int col = 0; col < SIZE; col++) {
            result += (myBoard[row][col]);
         }
         result += ("\n");
      }
      return result;
   }

}
/*    My Board:
 
 2..1.5..3
 .54...71.
 .1.2.3.8.
 6.28.73.4
 .........
 1.53.98.6
 .2.7.1.6.
 .81...24.
 7..4.2..1
 
 
 
 */