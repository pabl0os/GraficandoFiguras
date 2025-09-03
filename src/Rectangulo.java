import java.awt.Graphics;

public class Rectangulo extends Figura {
    private int x, y, ancho, alto;

    public Rectangulo(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawRect(x, y, ancho, alto);
    }
}
