import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class App {
    private static int contador = 0;
    private static int limiteClicks = 0;
    private static String figuraActual = "";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 600); // Tamaño de la ventana
            frame.setLocationRelativeTo(null); // Centra la ventana en el monitor

            // Panel principal con BorderLayout
            JPanel mainPanel = new JPanel(new BorderLayout());

            // Panel lateral izquierdo
            JPanel leftPanel = new JPanel();
            leftPanel.setPreferredSize(new Dimension(200, 0)); // Ancho fijo, alto flexible
            leftPanel.setBackground(Color.LIGHT_GRAY);
            leftPanel.setLayout(null); // Usar diseño absoluto para los botones

            // Panel derecho (ocupa el espacio restante)
            PanelDibujo rightPanel = new PanelDibujo();
            rightPanel.setBackground(Color.WHITE);

            JButton jb_fuente = new JButton("fuente");
            JButton jb_linea = new JButton("linea");
            JButton jb_circulo = new JButton("circulo");
            JButton jb_rectangulo = new JButton("rectangulo");
            JButton jb_rectanguloRedondeado = new JButton("rectangulo redondeado");
            JButton jb_Color = new JButton("color");
            JButton jb_poligono = new JButton("poligono");
            JButton jb_limpiar = new JButton("limpiar");

            jb_linea.setBounds(30, 10, 100, 25);
            jb_circulo.setBounds(30, 40, 100, 25);
            jb_rectangulo.setBounds(30, 70, 100, 25);
            jb_rectanguloRedondeado.setBounds(30, 100, 100, 25);
            jb_fuente.setBounds(30, 130, 100, 25);
            jb_Color.setBounds(30, 160, 100, 25);
            jb_poligono.setBounds(30, 190, 100, 25);
            jb_limpiar.setBounds(30, 220, 100, 25);

            ActionListener actionListener = e -> {
                JButton source = (JButton) e.getSource();
                String figura = source.getText();
                contador = 0;
                switch (figura) {
                    case "fuente":
                        // Lógica para seleccionar fuente
                        limiteClicks = 1;
                        figuraActual = figura;
                        break;
                    case "linea":

                        limiteClicks = 2;
                        figuraActual = figura;
                        break;
                    case "circulo":
                        limiteClicks = 1;
                        figuraActual = figura;
                        break;
                    case "rectangulo":
                        limiteClicks = 2;
                        figuraActual = figura;
                        break;
                    case "rectangulo redondeado":
                        limiteClicks = 1;
                        figuraActual = figura;
                        break;
                    case "limpiar":
                        rightPanel.limpiar();
                        break;
                    case "color":
                        figuraActual = figura;
                        Figura.color = JColorChooser.showDialog(null, "Selecciona un color", Figura.color);
                        break;
                    case "poligono":
                        limiteClicks = 5; // Ilimitado hasta doble click
                        figuraActual = figura;
                        break;

                }
            };
            jb_linea.addActionListener(actionListener);
            jb_circulo.addActionListener(actionListener);
            jb_rectangulo.addActionListener(actionListener);
            jb_rectanguloRedondeado.addActionListener(actionListener);
            jb_limpiar.addActionListener(actionListener);
            jb_fuente.addActionListener(actionListener);
            jb_Color.addActionListener(actionListener);
            jb_poligono.addActionListener(actionListener);

            Point[] puntos = new Point[5];
            rightPanel.addMouseListener(new java.awt.event.MouseAdapter() {

                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        // System.out.println("Click izquierdo en: " + e.getX() + ", " + e.getY());
                        // Aquí va tu lógica al hacer click izquierdo
                        System.out.println("Click izquierdo en: " + e.getX() + ", " + e.getY());
                        puntos[contador] = new Point(e.getX(), e.getY());

                        switch (figuraActual) {
                            case "fuente":
                                // Lógica para seleccionar fuente
                                rightPanel.agregarFigura(new Texto("Hola mundo", puntos[0].x, puntos[0].y));
                                break;
                            case "linea":
                                // Lógica para dibujar línea
                                if (contador < limiteClicks - 1) {
                                    contador++;
                                } else {
                                    rightPanel.agregarFigura(
                                            new Linea(puntos[0].x, puntos[0].y, puntos[1].x, puntos[1].y));
                                    contador = 0;
                                }

                                break;
                            case "circulo":
                                // Lógica para dibujar círculo
                                rightPanel.agregarFigura(new Circulo(puntos[0].x, puntos[0].y, 30));
                                contador = 0;
                                break;
                            case "rectangulo":
                                // Lógica para dibujar rectángulo
                                rightPanel.agregarFigura(new Rectangulo(puntos[0].x, puntos[0].y, 100, 50));
                                contador = 0;
                                break;
                            case "rectangulo redondeado":
                                rightPanel.agregarFigura(
                                        new RectanguloRedondeado(puntos[0].x, puntos[0].y, 100, 50, 20, 20));
                                contador = 0;
                                break;
                            case "poligono":
                                if (contador < limiteClicks - 1) {
                                    contador++;
                                } else {
                                    int[] x = new int[limiteClicks];
                                    int[] y = new int[limiteClicks];
                                    for (int i = 0; i < limiteClicks; i++) {
                                        x[i] = puntos[i].x;
                                        y[i] = puntos[i].y;
                                    }
                                    rightPanel.agregarFigura(new Poligono(x, y, limiteClicks, Figura.color));
                                    contador = 0;
                                }
                                break;

                        }

                    }
                }
            });

            leftPanel.add(jb_linea);
            leftPanel.add(jb_circulo);
            leftPanel.add(jb_rectangulo);
            leftPanel.add(jb_rectanguloRedondeado);
            leftPanel.add(jb_limpiar);
            leftPanel.add(jb_fuente);
            leftPanel.add(jb_Color);
            leftPanel.add(jb_poligono);

            // Agregar los paneles al panel principal
            mainPanel.add(leftPanel, BorderLayout.WEST);
            mainPanel.add(rightPanel, BorderLayout.CENTER);

            frame.setContentPane(mainPanel);
            frame.setVisible(true);
        });
    }
}
