import java.io.FileNotFoundException;

class SudokuPlay{

public static void main (String[] args){

try{

   SudokuBoard sudokuBoard = new SudokuBoard("very-fast-solve.sdk");
   system.out.println("File:very-fast-solve.sdk");
   system.out.println(sudokuboard);
   system.out.println("Is board valid:" + sudokuBoard.isValid());
   system.out.println("Is board solved:" + sudokuBoard.isSolved());

   system.out.println("The Solution is:");
   system.out.println("Was able to solve board:" + sudokuBoard.solved());
   system.out.println(sudokuBoard);
   
   SudokuBoard sudokuBoard = new SudokuBoard("fast-solve.sdk");
   system.out.println("File:fast-solve.sdk");
   system.out.println(sudokuboard);
   system.out.println("Is board valid:" + sudokuBoard.isValid());
   system.out.println("Is board solved:" + sudokuBoard.isSolved());

   system.out.println("The Solution is:");
   system.out.println("Was able to solve board:" + sudokuBoard.solved());
}
catch FileNotReadException;
}
}