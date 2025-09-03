import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


// Clase personalizada para el panel de dibujo
public class PanelDibujo extends JPanel {
    private List<Figura> figuras = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Figura f : figuras) {
            f.dibujar(g);
        }
    }

    public void agregarFigura(Figura f) {
        figuras.add(f);
        repaint();
    }

    public void limpiar() {
        figuras.clear();
        repaint();
    }
}
