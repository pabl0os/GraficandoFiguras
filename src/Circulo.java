import java.awt.Graphics;

public class Circulo extends Figura {
    private int x, y, radio;

    public Circulo(int x, int y, int radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawOval(x - radio, y - radio, radio * 2, radio * 2);
    }
}
