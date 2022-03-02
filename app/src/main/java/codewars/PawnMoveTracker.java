/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codewars;

public class PawnMoveTracker {

  private static String[][] getInitialBoard() {
    return new String[][]{
      {".", ".", ".", ".", ".", ".", ".", "."},
      {"p", "p", "p", "p", "p", "p", "p", "p"},
      {".", ".", ".", ".", ".", ".", ".", "."},
      {".", ".", ".", ".", ".", ".", ".", "."},
      {".", ".", ".", ".", ".", ".", ".", "."},
      {".", ".", ".", ".", ".", ".", ".", "."},
      {"P", "P", "P", "P", "P", "P", "P", "P"},
      {".", ".", ".", ".", ".", ".", ".", "."},
    };
  }

  public static String[][] movePawns(String[] moves) {
    String[][] board = getInitialBoard();
    boolean isWhiteMove = true;
    for (String move: moves) {
      if(isValidMove(board, move, isWhiteMove)) {
        makeMove(board, move);
        isWhiteMove = !isWhiteMove;
      } else {
        return new String[][]{ { String.format("%s is invalid", move) } };
      }
    }

    return board;
  }

  private static int getColumnForFile(String file) {
    return file.getBytes()[0] - "a".getBytes()[0];
  }

  private static boolean isValidMove(String[][] board, String move, boolean isWhiteMove) {
    if(move.contains("x")) {
      // Capture
      int attackerCol = getColumnForFile(move.substring(0, 1));
      int targetCol = getColumnForFile(move.substring(2, 3));
      int targetRow = Integer.parseInt(move.substring(3));
      if(isWhiteMove) {
        if(board[targetRow][targetCol].equals(".") || board[targetRow][targetCol].equals("P")) {
          // Attacked square is invalid
          return false;
        } else {
          // Attacker square is invalid
          return !board[targetRow + 1][attackerCol].equals(".") && !board[targetRow + 1][attackerCol].equals("p");
        }
      } else {
        if(board[targetRow][targetCol].equals(".") || board[targetRow][targetCol].equals("p")) {
          // Attacked square is invalid
          return false;
        } else {
          // Attacker square is invalid
          return !board[targetRow - 1][attackerCol].equals(".") && !board[targetRow - 1][attackerCol].equals("P");
        }
      }
    } else {
      // Non-capture
      int destCol = getColumnForFile(move.substring(0, 1));
      int destRow = Integer.parseInt(move.substring(1, 2));
      if(isWhiteMove) {
        if((destRow != 4 && !board[destRow + 1][destCol].equals("P"))
          || destRow == 4 && !(board[destRow + 1][destCol].equals("P") || board[destRow + 2][destCol].equals("P"))) {
          // Source square is not occupied by white
          return false;
        } else {
          // Destination square is occupied
          return board[destRow][destCol].equals(".");
        }
      } else {
        if((destRow != 3 && !board[destRow - 1][destCol].equals("p"))
          || destRow == 3 && !board[destRow - 1][destCol].equals("p") && !board[destRow - 2][destCol].equals("p")) {
          // Source square is not occupied by black
          return false;
        } else {
          // Destination square is occupied
          return board[destRow][destCol].equals(".");
        }
      }
    }
  }

  private static void makeMove(String[][] board, String move) {

  }
}
