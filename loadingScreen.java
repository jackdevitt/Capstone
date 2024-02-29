import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.Runnable;
import java.awt.Font;
import java.awt.Color;
import java.awt.FontMetrics;

public class loadingScreen extends JPanel {
   
   public static int temp = 0;
   public static int loadingProgress = 0;
   public static int loadingItems = 2;
   public static int percent = 0;
   public static int width = -1;
   public static int height = -1;
   public static int animIndex = 0;
   public static int animSpeed = 250;
   public static boolean playAnim = false;
   public static Thread animThread;
   public static String[][] loadingMessages = {{"Loading Zobrist values.", "Loading Zobrist values..", "Loading Zobrist values..."}, {"Loading Transposition data.", "Loading Transposition data..", "Loading Transposition data..."}};
   
   public loadingScreen() {
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      width = screenSize.width;
      height = screenSize.height;
      playAnim = true;
      animThread = new Thread(new AnimPlayer());
      animThread.start();
   }
   
   public void incrementPercent(int increase) {
      percent += increase;
   }
   
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setFont(new Font("Helvetica", 1, 25));
      FontMetrics fm = g.getFontMetrics();
      g.drawString(loadingMessages[loadingProgress][animIndex], (width - fm.stringWidth(loadingMessages[loadingProgress][0])) / 2, height / 2 - 75);
      g.setColor(Color.BLUE);
      g.fillRect(width / 2 - 250, height / 2 - 25, (500 / 100) * (percent), 50);
      g.setColor(Color.BLACK);
      g.drawRect(width / 2 - 250, height / 2 - 25, 500, 50);
      g.drawString("" + percent + "%", (width - fm.stringWidth("" + percent + "%")) / 2, (height / 2 + 10));
   }
   
   public static class AnimPlayer implements Runnable {
   
      @Override
      public void run() {
         while (playAnim) {
            chessGUI.loading.repaint();
            animIndex++;
            if (animIndex == 3) {
               animIndex = 0;
            }
            try {
               Thread.sleep(loadingScreen.animSpeed);
            } catch (InterruptedException ie) {
               ie.printStackTrace();
            }
         } 
      }
   }
}