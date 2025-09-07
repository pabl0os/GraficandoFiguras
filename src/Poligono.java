import java.awt.Graphics;
import java.awt.Color;

public class Poligono extends Figura {
    private int[] xPoints, yPoints;
    private int nPoints;
    private Color color;

    public Poligono(int[] xPoints, int[] yPoints, int nPoints, Color color) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.nPoints = nPoints;
        this.color = color;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.drawPolygon(xPoints, yPoints, nPoints);
    }
}
