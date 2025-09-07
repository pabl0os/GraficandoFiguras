import java.awt.Graphics;

public class RectanguloRedondeado extends Figura {
    private int x, y, ancho, alto, arcW, arcH;

    public RectanguloRedondeado(int x, int y, int ancho, int alto, int arcW, int arcH) {
        this.x = x; this.y = y; this.ancho = ancho; this.alto = alto;
        this.arcW = arcW; this.arcH = arcH;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Figura.color);

        g.drawRoundRect(x, y, ancho, alto, arcW, arcH);
    }
}