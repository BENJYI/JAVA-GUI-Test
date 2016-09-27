import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public class GUITest {

  public static void main(String[] args) {
    String input = JOptionPane.showInputDialog(
        "Enter 1 to draw rectangles\n" +
        "Enter 2 to draw ovals\n" +
        "Enter 3 to draw concentric shape");

    int choice = Integer.parseInt(input);

    /* some variables.. */
    int winWidth = 400;
    int winHeight = 300;

    /* create window layout */

    JFrame frame = new JFrame();
    Shapes newShape = createPattern(winWidth, winHeight, choice, 5);
    frame.add(newShape, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }

  public static Shapes createPattern(int width, int height, 
                              int choice, int count) {
    Shapes newShape = new Shapes(width, height, choice, count);
    newShape.setPreferredSize(new Dimension(width, height));
    return newShape;
  }
}