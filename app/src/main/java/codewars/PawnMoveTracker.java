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
        makeMove(board, move, isWhiteMove);
        isWhiteMove = !isWhiteMove;
      } else {
        return new String[][]{ { String.format("%s is invalid", move) } };
      }
    }

    return board;
  }

  private static boolean isValidMove(String[][] board, String move, boolean isWhiteMove) {
    return move.contains("x") ?
      processCapture(board, move, isWhiteMove, true)
      : processNonCapture(board, move, isWhiteMove, true);
  }

  private static void makeMove(String[][] board, String move, boolean isWhiteMove) {
    if(move.contains("x")) {
      processCapture(board, move, isWhiteMove, false);
    } else {
      processNonCapture(board, move, isWhiteMove, false);
    }
  }

  private static int getColumnForFile(String file) {
    return file.getBytes()[0] - "a".getBytes()[0];
  }

  private static boolean processCapture(String[][] board, String move, boolean isWhiteMove, boolean isCheck) {
    int attackerCol = getColumnForFile(move.substring(0, 1));
    int targetCol = getColumnForFile(move.substring(2, 3));
    int targetRow = 8 - Integer.parseInt(move.substring(3));
    if(isCheck) {
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
      if(isWhiteMove) {
        board[targetRow][targetCol] = "P";
        board[targetRow + 1][attackerCol] = ".";
      } else {
        board[targetRow][targetCol] = "p";
        board[targetRow - 1][attackerCol] = ".";
      }

      return true;
    }
  }

  private static boolean processNonCapture(String[][] board, String move, boolean isWhiteMove, boolean isCheck) {
    int destCol = getColumnForFile(move.substring(0, 1));
    int destRow = 8 - Integer.parseInt(move.substring(1, 2));
    if(isCheck) {
      if(isWhiteMove) {
        if((destRow != 4 && !board[destRow + 1][destCol].equals("P"))
          || destRow == 4 && !(board[destRow + 1][destCol].equals("P") || board[destRow + 2][destCol].equals("P"))) {
          // Source square is not occupied by white
          return false;
        }
      } else {
        if((destRow != 3 && !board[destRow - 1][destCol].equals("p"))
          || destRow == 3 && !board[destRow - 1][destCol].equals("p") && !board[destRow - 2][destCol].equals("p")) {
          // Source square is not occupied by black
          return false;
        }
      }

      return board[destRow][destCol].equals(".");
    } else {
      if(isWhiteMove) {
        board[destRow][destCol] = "P";
        if(destRow == 4 && !board[destRow + 1][destCol].equals("P")) {
          board[destRow + 2][destCol] = ".";
        } else {
          board[destRow + 1][destCol] = ".";
        }
      } else {
        board[destRow][destCol] = "p";
        if(destRow == 3 && !board[destRow - 1][destCol].equals("p")) {
          board[destRow - 2][destCol] = ".";
        } else {
          board[destRow - 1][destCol] = ".";
        }
      }

      return true;
    }
  }
}
