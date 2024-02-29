import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Zobrist {
   
   public static FileWriter writer;
   public static int[][][] hashmap = new int[8][8][12];
   
   public static boolean connect() {
      try {
         writer = new FileWriter("ZobristData.txt");
      } catch (IOException ie) {
         ie.printStackTrace();
      }
      return writer == null;
   }
   
   public static void initalize() {
      for (int row = 0; row < 8; row++) {
         for (int col = 0; col < 8; col++) {
            for (int index = 0; index < 12; index++) {
               hashmap[row][col][index] = (int)((Math.random() * (99999 - 10000 + 1)) + 10000);
               try {
                  if (index != 11) {
                     writer.write("" + hashmap[row][col][index] + ",");
                  } else {
                     writer.write("" + hashmap[row][col][index]);
                  }
               } catch (IOException ie) {
                  ie.printStackTrace();
               }
            }
            chessGUI.loading.incrementPercent(((100 / loadingScreen.loadingItems) / 64) * (row + col));
            try {
               writer.write("\n");
            } catch (IOException ie) {
               ie.printStackTrace();
            }
         }
      }
   } 
}