package LevyCKurve;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.concurrent.ThreadLocalRandom;

public class Wikipedia extends JPanel {

    public float x, y, län, alpha_winkel;
    public int iteration_n;
    int x;

    public void paint(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	Wikipedia(x, y, län, alpha_winkel, iteration_n, g2d);
    }

    public void Wikipedia(double x, double y, double län, double alpha_winkel, int iteration_n, Graphics2D g) {
	double fx = x;
	double fy = y;
	double länge = län;
	double alpha = alpha_winkel;
	int it_n = iteration_n;
	if (it_n > 0) {
	    länge = (länge / Math.sqrt(2));
	    Wikipedia(fx, fy, länge, (alpha + 45), (it_n - 1), g); // Rekursiver Aufruf
	    fx = (fx + (länge * Math.cos(Math.toRadians(alpha + 45))));
	    fy = (fy + (länge * Math.sin(Math.toRadians(alpha + 45))));
	    Wikipedia(fx, fy, länge, (alpha - 45), (it_n - 1), g); // Rekursiver Aufruf
	    } else {
		Color[] A = {Color.RED, Color.ORANGE, Color.BLUE, Color.DARK_GRAY};
		g.setColor(A[ThreadLocalRandom.current().nextInt(0, A.length)]); // Um verschiedene Farbwerte auszuwählen
		g.drawLine((int) fx, (int) fy, (int) (fx + (länge * Math.cos(Math.toRadians(alpha)))), (int) (fy + (länge * Math.sin(Math.toRadians(alpha)))));
	    }
    }

    public static void main(String[] args) {
	Wikipedia punkte = new Wikipedia();
	punkte.x = 500; // x-Wert festlegen
	punkte.y = 300; // y-Wert festlegen
	punkte.län = 300; // Längenwert festlegen
	punkte.alpha_winkel = 90; // Winkelwert festlegen
	punkte.iteration_n = 20; // Iterationswert festlegen

	JFrame frame = new JFrame("Punkte");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(punkte);
	frame.setSize(1000, 1000);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);

    }
}

