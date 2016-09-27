import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.lang.Math;
import java.util.Random;
import javax.swing.JPanel;

public class Shapes extends JPanel
{
  private int choice;
  private int winWidth;
  private int winHeight;
  private int repeatNumber;

  public Shapes(int width, int height, int userChoice, int count)
  {
    winWidth = width;
    winHeight = height;
    choice = userChoice;
    repeatNumber = count; /* rectangle with inscribed oval 
                             should be created this many times */
  }

  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    /* create a rectangle with inscribed oval per loop */
    for (int i = 1; i < repeatNumber+1; i++) {

      /* calculate origin/dimension of new shape */
      float scaleFactor = (float)Math.pow(Math.sqrt(0.5), i);
      float aspectRatio = (float)winHeight/winWidth;
      int newWidth = Math.round(winWidth * scaleFactor);
      int newHeight = Math.round(winHeight * scaleFactor);
      int newOriginX = (winWidth - newWidth) / 2;
      int newOriginY = (winHeight - newHeight) / 2;
      
      switch (choice) {
        case 1: 
          /* draw a series of rects */
          g.setColor(generateColor());
          g.drawRect(i * 10, Math.round(i * 10 * aspectRatio),
                     i * 50, Math.round(i * 50 * aspectRatio));
          break;

        case 2: 
          /* draw a seris of ovals */
          g.setColor(generateColor());
          g.drawRect(i * 10, Math.round(i * 10 * aspectRatio),
                     i * 50, Math.round(i * 50 * aspectRatio));
          g.drawOval(i * 10, Math.round(i * 10 * aspectRatio),
                     i * 50, Math.round(i * 50 * aspectRatio));
          break;

        case 3: 
          /* create a filled rect with a random color */
          g.setColor(generateColor());
          g.fillRect(newOriginX, newOriginY, newWidth, newHeight);

          /* create a filled oval with a random color */
          g.setColor(generateColor());
          g.fillOval(newOriginX, newOriginY, newWidth, newHeight);
          break;
      }
    }

    /* draw diagonal line to prove alignment */
    g.setColor(Color.BLACK);
    g.drawLine(0, 0, winWidth, winHeight);
  }

  /* generate a random color (for filling) */
  private Color generateColor() {
    Random rand = new Random();
    float r = rand.nextFloat();
    float g = rand.nextFloat();
    float b = rand.nextFloat();
    Color randomColor = new Color (r, g, b);
    return randomColor;
  }
} // end class Shapes