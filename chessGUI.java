import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.lang.Math;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class chessGUI {
   
   public static loadingScreen loading;
   public static JFrame loadingFrame;
   public static JFrame frame;
   public static JPanel panel;
   public static JButton[][] buttons = new JButton[8][8];
   
   public static Image dot;
   public static Image blackPawn;
   public static Image blackPawnCapture;
   public static Image blackKing;
   public static Image blackKnight;
   public static Image blackKnightCapture;
   public static Image blackBishop;
   public static Image blackBishopCapture;
   public static Image blackRook;
   public static Image blackRookCapture;
   public static Image blackQueen;
   public static Image blackQueenCapture;
   public static Image whitePawn;
   public static Image whitePawnCapture;
   public static Image whiteKing;
   public static Image whiteKnight;
   public static Image whiteKnightCapture;
   public static Image whiteBishop;
   public static Image whiteBishopCapture;
   public static Image whiteRook;
   public static Image whiteRookCapture;
   public static Image whiteQueen;
   public static Image whiteQueenCapture;
   public static JPanel devPanel;
   public static JLabel currentPage;
   public static JButton nextPage;
   public static JButton previousPage;
   
   public static Color lightSquare = new Color(184, 139, 74);
   public static Color darkSquare = new Color(227, 193, 111);
   public static Color highlight = new Color(130, 197, 255);
   public static Color movement = new Color(184, 204, 163);
   
   public static boolean pieceSelected = false;
   public static ArrayList<int[]> pieceMoves = new ArrayList<int[]>();
   public static int selectedPieceValue = -1;
   public static int selectedPieceX = -1;
   public static int selectedPieceY = -1;
   
   public static int previouslySelectedRow = -1;
   public static int previouslySelectedCol = -1;
   
   public static int formerSquareX = -1;
   public static int formerSquareY = -1;
   public static int currentSquareX = -1;
   public static int currentSquareY = -1;
   
   public static int loadingProgress = 0;
   public static int loadingItems = 2;
   
   public static boolean[][] dotGrid = new boolean[8][8];
   
   public static void showUI() {
      
      for (int row = 0; row < 8; row++) {
         for (int col = 0; col < 8; col++) {
            dotGrid[row][col] = false;
         }
      }
      
      frame = new JFrame();
      frame.setLayout(null);
      panel = new JPanel();
      panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
      panel.setLayout(new GridLayout(8, 8));
      
      try {
         dot = ImageIO.read(new File("images/Dot.png"));
         dot = dot.getScaledInstance(65, 50,  java.awt.Image.SCALE_SMOOTH );
         blackPawn = ImageIO.read(new File("images/blackPawn.png"));
         blackPawn = blackPawn.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH);
         blackPawnCapture = ImageIO.read(new File("images/blackPawnCapture.png"));
         blackPawnCapture = blackPawnCapture.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         blackKnight = ImageIO.read(new File("images/blackKnight.png"));
         blackKnight = blackKnight.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         blackKnightCapture = ImageIO.read(new File("images/blackKnightCapture.png"));
         blackKnightCapture = blackKnightCapture.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         blackBishop = ImageIO.read(new File("images/blackBishop.png"));
         blackBishop = blackBishop.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         blackBishopCapture = ImageIO.read(new File("images/blackBishopCapture.png"));
         blackBishopCapture = blackBishopCapture.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         blackRook = ImageIO.read(new File("images/blackRook.png"));
         blackRook = blackRook.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         blackRookCapture = ImageIO.read(new File("images/blackRookCapture.png"));
         blackRookCapture = blackRookCapture.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         blackQueen = ImageIO.read(new File("images/blackQueen.png"));
         blackQueen = blackQueen.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         blackQueenCapture = ImageIO.read(new File("images/blackQueenCapture.png"));
         blackQueenCapture = blackQueenCapture.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         blackKing = ImageIO.read(new File("images/blackKing.png"));
         blackKing = blackKing.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         whitePawn = ImageIO.read(new File("images/whitePawn.png"));
         whitePawn = whitePawn.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH);
         whitePawnCapture = ImageIO.read(new File("images/whitePawnCapture.png"));
         whitePawnCapture = whitePawnCapture.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         whiteKnight = ImageIO.read(new File("images/whiteKnight.png"));
         whiteKnight = whiteKnight.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         whiteKnightCapture = ImageIO.read(new File("images/whiteKnightCapture.png"));
         whiteKnightCapture = whiteKnightCapture.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         whiteBishop = ImageIO.read(new File("images/whiteBishop.png"));
         whiteBishop = whiteBishop.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         whiteBishopCapture = ImageIO.read(new File("images/whiteBishopCapture.png"));
         whiteBishopCapture = whiteBishopCapture.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         whiteRook = ImageIO.read(new File("images/whiteRook.png"));
         whiteRook = whiteRook.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         whiteRookCapture = ImageIO.read(new File("images/whiteRookCapture.png"));
         whiteRookCapture = whiteRookCapture.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         whiteQueen = ImageIO.read(new File("images/whiteQueen.png"));
         whiteQueen = whiteQueen.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         whiteQueenCapture = ImageIO.read(new File("images/whiteQueenCapture.png"));
         whiteQueenCapture = whiteQueenCapture.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
         whiteKing = ImageIO.read(new File("images/whiteKing.png"));
         whiteKing = whiteKing.getScaledInstance(80, 65,  java.awt.Image.SCALE_SMOOTH );
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 
      
      Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
      for (int row = 0; row < 8; row++) {
         for (int col = 0; col < 8; col++) {
            buttons[row][col] = new JButton();
            final int tempRow = row;
            final int tempCol = col;
            buttons[row][col].setBorder(null);
            buttons[row][col].addActionListener(new AbstractAction() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  for (int row = 0; row < 8; row++) {
                     for (int col = 0; col < 8; col++) {
                        dotGrid[row][col] = false;
                     }
                  }
                  if (Chess.isPlayerTurn) {
                     updateBoard(chessEngine.chessBoard);
                     if ((chessEngine.chessBoard[tempRow][tempCol] < 0 && !Chess.playerIsWhite) || (chessEngine.chessBoard[tempRow][tempCol] > 0 && Chess.playerIsWhite) || pieceSelected) {
                        if (!pieceSelected) {
                           pieceSelected = true;
                           buttons[tempRow][tempCol].setBackground(highlight);
                           if (!(tempRow == previouslySelectedRow && tempCol == previouslySelectedCol)) {
                              previouslySelectedRow = tempRow;
                              previouslySelectedCol = tempCol;
                              for (int entry = 0; entry < chessEngine.playerMoveList.size(); entry++) {
                                 if (chessEngine.playerMoveList.get(entry)[0] == tempRow && chessEngine.playerMoveList.get(entry)[1] == tempCol) {                               
                                    dotGrid[chessEngine.playerMoveList.get(entry)[2]][chessEngine.playerMoveList.get(entry)[3]] = true;
                                    pieceMoves.add(new int[]{chessEngine.playerMoveList.get(entry)[2], chessEngine.playerMoveList.get(entry)[3]});
                                 }
                              }
                              updateBoard(chessEngine.chessBoard);
                           } else {
                              previouslySelectedRow = -1;
                              previouslySelectedCol = -1;
                              for (int row = 0; row < 8; row++) {
                                 for (int col = 0; col < 8; col++) {
                                    dotGrid[row][col] = false;
                                 }
                              }
                           }
                        } else {
                           if ((chessEngine.chessBoard[tempRow][tempCol] < 0 && !Chess.playerIsWhite) || (chessEngine.chessBoard[tempRow][tempCol] > 0 && Chess.playerIsWhite)) {
                              updateBoard(chessEngine.chessBoard);
                              previouslySelectedRow = tempRow;
                              previouslySelectedCol = tempCol;
                              pieceMoves.clear();
                              for(int entry = 0; entry < chessEngine.playerMoveList.size(); entry++) {
                                 if (chessEngine.playerMoveList.get(entry)[0] == tempRow && chessEngine.playerMoveList.get(entry)[1] == tempCol) {
                                    buttons[chessEngine.playerMoveList.get(entry)[2]][chessEngine.playerMoveList.get(entry)[3]].setIcon(new ImageIcon(dot));
                                    pieceMoves.add(new int[]{chessEngine.playerMoveList.get(entry)[2], chessEngine.playerMoveList.get(entry)[3]});
                                 }
                              }
                           } else {
                              boolean found = false;
                              for (int i = 0; i < pieceMoves.size(); i++) {
                                 if (pieceMoves.get(i)[0] == tempRow && pieceMoves.get(i)[1] == tempCol) {
                                    found = true;
                                 }
                              }
                              if (found) {
                                 if (Math.abs(chessEngine.chessBoard[previouslySelectedRow][previouslySelectedCol]) == 1) {
                                    if (tempRow - 2 == previouslySelectedRow) {
                                       chessEngine.ePassX = tempRow;
                                       chessEngine.ePassY = tempCol;
                                       chessEngine.isEPassWhite = Chess.playerIsWhite;
                                    } else if (previouslySelectedRow == chessEngine.ePassX) {
                                       if (previouslySelectedCol + 1 == chessEngine.ePassY && (tempRow == chessEngine.ePassX - 1 && tempCol == chessEngine.ePassY)) {
                                          chessEngine.chessBoard[tempRow + 1][tempCol] = 0;
                                       } else if (previouslySelectedCol - 1 == chessEngine.ePassY && (tempRow == chessEngine.ePassX - 1 && tempCol == chessEngine.ePassY)) {
                                          chessEngine.chessBoard[tempRow + 1][tempCol] = 0;
                                       }
                                    } else {
                                       chessEngine.ePassX = -1;
                                       chessEngine.ePassY = -1;
                                    }
                                 } else {
                                    chessEngine.ePassX = -1;
                                    chessEngine.ePassY = -1;
                                 }
                                 if (Math.abs(chessEngine.chessBoard[tempRow][tempCol]) == 5) {
                                    if (tempRow == 0 && tempCol == 0) {
                                       chessEngine.castlingData[0] = 0;
                                    } else if (tempRow == 0 && tempCol == 7) {
                                       chessEngine.castlingData[2] = 0;
                                    } else if (tempRow == 7 && tempCol == 0) {
                                       chessEngine.castlingData[3] = 0;
                                    } else if (tempRow == 7 && tempCol == 7) {
                                       chessEngine.castlingData[5] = 0;
                                    }
                                 }
                                 if (Math.abs(chessEngine.chessBoard[previouslySelectedRow][previouslySelectedCol]) == 5) {
                                    if (Chess.playerIsWhite) {
                                       if (previouslySelectedCol == 0) {
                                          chessEngine.castlingData[0] = 0;
                                       } else if (previouslySelectedCol == 7) {
                                          chessEngine.castlingData[2] = 0;
                                       } 
                                    } else {
                                       if (previouslySelectedCol == 0) {
                                          chessEngine.castlingData[3] = 0;
                                       } else if (previouslySelectedCol == 7) {
                                          chessEngine.castlingData[5] = 0;
                                       }
                                    }
                                 }
                                 if (Math.abs(chessEngine.chessBoard[previouslySelectedRow][previouslySelectedCol]) == 15) {
                                    if (Chess.playerIsWhite) {
                                       chessEngine.castlingData[1] = 0;
                                    } else {
                                       chessEngine.castlingData[4] = 0;
                                    }
                                    if (previouslySelectedCol - 2 == tempCol) {
                                       chessEngine.chessBoard[7][0] = 0;
                                       if (Chess.playerIsWhite) {
                                          chessEngine.chessBoard[tempRow][tempCol + 1] = 5;
                                       } else {
                                          chessEngine.chessBoard[tempRow][tempCol + 1] = -5;
                                       }
                                    } else if (previouslySelectedCol + 2 == tempCol) {
                                       chessEngine.chessBoard[7][7] = 0;
                                       if (Chess.playerIsWhite) {
                                          chessEngine.chessBoard[tempRow][tempCol - 1] = 5;
                                       } else {
                                          chessEngine.chessBoard[tempRow][tempCol - 1] = -5;
                                       }
                                    }
                                 }
                                 chessEngine.chessBoard[tempRow][tempCol] = chessEngine.chessBoard[previouslySelectedRow][previouslySelectedCol];
                                 chessEngine.chessBoard[previouslySelectedRow][previouslySelectedCol] = 0;
                                 if (Math.abs(chessEngine.chessBoard[previouslySelectedRow][previouslySelectedCol]) == 1) {
                                    if (tempRow == 0) {
                                       if (Chess.playerIsWhite) {
                                          chessEngine.chessBoard[tempRow][tempCol] = 9;
                                       } else {
                                          chessEngine.chessBoard[tempRow][tempCol] = -9;
                                       }
                                    }
                                 }
                                 formerSquareX = previouslySelectedRow;
                                 formerSquareY = previouslySelectedCol;
                                 currentSquareX = tempRow;
                                 currentSquareY = tempCol;
                                 for (int row = 0; row < 8; row++) {
                                    for (int col = 0; col < 8; col++) {
                                       dotGrid[row][col] = false;
                                    }
                                 }
                                 updateBoard(chessEngine.chessBoard);
                                 chessEngine.playerMoveList.clear();
                                 Chess.isPlayerTurn = false;
                                 Thread minimax = new Thread(new Chess());
                                 minimax.start();
                              }
                              pieceSelected = false;
                              previouslySelectedRow = -1;
                              previouslySelectedCol = -1;
                              pieceMoves.clear();
                           }
                        }
                     }
                  }
               }
            });       
            if ((col + row) % 2 != 0) {
               buttons[row][col].setBackground(lightSquare);
            } else {
               buttons[row][col].setBackground(darkSquare);
            }
            panel.add(buttons[row][col]);
         }
      }
      
      panel.setBounds((ss.width / 2) - 300, (ss.height / 2) - 340, 600, 600);
      frame.add(panel);
      frame.setVisible(true);
   }
   
   public static void updateBoard(int[][] chessBoard) {
      for (int row = 0; row < 8; row++) {
         for (int col = 0; col < 8; col++) {
            int pieceValue = chessBoard[row][col];
            JButton square = buttons[row][col];
            if (dotGrid[row][col]) {
               square.setIcon(new ImageIcon(dot));
            } else {
               square.setIcon(null);
            }
            if ((col + row) % 2 != 0) {
               square.setBackground(lightSquare);
            } else {
               square.setBackground(darkSquare);
            }
            if (pieceValue != 0) {
               if (pieceValue > 0) {
                  square.setForeground(Color.WHITE);
               } else {
                  square.setForeground(Color.BLACK);
               }
               if (pieceValue > 0) {
                  if (pieceValue == 1) {
                     if (dotGrid[row][col]) {
                        square.setIcon(new ImageIcon(whitePawnCapture));
                     } else {
                        square.setIcon(new ImageIcon(whitePawn));
                     }
                  } else if (pieceValue == 3) {
                     if (dotGrid[row][col]) {
                        square.setIcon(new ImageIcon(whiteKnightCapture));
                     } else {
                        square.setIcon(new ImageIcon(whiteKnight));
                     }
                  } else if (pieceValue == 4) {
                     if (dotGrid[row][col]) {
                        square.setIcon(new ImageIcon(whiteBishopCapture));
                     } else {
                        square.setIcon(new ImageIcon(whiteBishop));
                     }
                  } else if (pieceValue == 5) {
                     if (dotGrid[row][col]) {
                        square.setIcon(new ImageIcon(whiteRookCapture));
                     } else {
                        square.setIcon(new ImageIcon(whiteRook));
                     }
                  } else if (pieceValue == 9) {
                     if (dotGrid[row][col]) {
                        square.setIcon(new ImageIcon(whiteQueenCapture));
                     } else {
                        square.setIcon(new ImageIcon(whiteQueen));
                     }
                  } else if (pieceValue == 15) {
                     square.setIcon(new ImageIcon(whiteKing));
                  }

               } else {
                  if (pieceValue == -1) {
                     if (dotGrid[row][col]) {
                        square.setIcon(new ImageIcon(blackPawnCapture));
                     } else {
                        square.setIcon(new ImageIcon(blackPawn));
                     }
                  } else if (pieceValue == -3) {
                     if (dotGrid[row][col]) {
                        square.setIcon(new ImageIcon(blackKnightCapture));
                     } else {
                        square.setIcon(new ImageIcon(blackKnight));
                     }
                  } else if (pieceValue == -4) {
                     if (dotGrid[row][col]) {
                        square.setIcon(new ImageIcon(blackBishopCapture));
                     } else {
                        square.setIcon(new ImageIcon(blackBishop));
                     }
                  } else if (pieceValue == -5) {
                     if (dotGrid[row][col]) {
                        square.setIcon(new ImageIcon(blackRookCapture));
                     } else {
                        square.setIcon(new ImageIcon(blackRook));
                     }
                  } else if (pieceValue == -9) {
                     if (dotGrid[row][col]) {
                        square.setIcon(new ImageIcon(blackQueenCapture));
                     } else {
                        square.setIcon(new ImageIcon(blackQueen));
                     }
                  } else if (pieceValue == -15) {
                     square.setIcon(new ImageIcon(blackKing));
                  }
               }    
            }
            if ((row == formerSquareX && col == formerSquareY) || (row == currentSquareX && col == currentSquareY)) {
               square.setBackground(movement);
            }
         }
      }
      frame.revalidate();
   }
}