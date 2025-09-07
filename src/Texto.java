import java.awt.Graphics;

public class Texto extends Figura {
    private String texto;
    private int x, y;

    public Texto(String texto, int x, int y) {
        this.texto = texto;
        this.x = x;
        this.y = y;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Figura.color);

        g.drawString(texto, x, y);
    }
}
