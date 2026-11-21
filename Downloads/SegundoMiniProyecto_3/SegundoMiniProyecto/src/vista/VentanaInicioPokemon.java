/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import logica.CreadorMazosPDefecto;
import logica.Juego;
import logica.Jugador;

public class VentanaInicioPokemon extends JFrame {

    private Image imagenFondo;
    private JTextField jugador1;
    private JTextField jugador2;
    private JComboBox<String> mazoJugador1;
    private JComboBox<String> mazoJugador2;
    private JButton verMazos;
    private JButton btnIniciar;

    public VentanaInicioPokemon() {
        cargarImagenFondo();
        construirInterfaz();
        setTitle("Pokémon TCG - Univalle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(980, 560);
        setMinimumSize(new Dimension(920, 520));
        setLocationRelativeTo(null);
    }

    private void cargarImagenFondo() {
        URL url = getClass().getResource("/imagenes/fondoInicio.jpg");
        if (url != null) {
            imagenFondo = new ImageIcon(url).getImage();
        }
    }

    private void construirInterfaz() {
        jugador1 = new JTextField(15);
        jugador2 = new JTextField(15);
        String[] mazos = {"Mazo Agua", "Mazo Fuego", "Mazo Rayo"};
        mazoJugador1 = new JComboBox<>(mazos);
        mazoJugador2 = new JComboBox<>(mazos);
        verMazos = new JButton("VER MAZOS");
        btnIniciar = new JButton("INICIAR PARTIDA");

        JPanel panelFondo = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (imagenFondo != null) {
                    g2.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                    GradientPaint sombra = new GradientPaint(
                            0, 0, new Color(10, 15, 30, 155),
                            0, getHeight(), new Color(10, 15, 30, 190));
                    g2.setPaint(sombra);
                    g2.fillRect(0, 0, getWidth(), getHeight());
                } else {
                    GradientPaint gp = new GradientPaint(
                            0, 0, new Color(18, 28, 56),
                            getWidth(), getHeight(), new Color(42, 18, 38));
                    g2.setPaint(gp);
                    g2.fillRect(0, 0, getWidth(), getHeight());
                }
                g2.dispose();
            }
        };

        JPanel contenedor = new JPanel();
        contenedor.setOpaque(false);
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        contenedor.setBorder(new EmptyBorder(18, 30, 22, 30));

        JLabel tituloPokemon = new JLabel("POKÉMON TCG UNIVALLE", SwingConstants.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                Font font = new Font("Segoe UI Black", Font.BOLD, 42);
                g2.setFont(font);
                FontMetrics fm = g2.getFontMetrics();
                String texto = getText();
                int x = (getWidth() - fm.stringWidth(texto)) / 2;
                int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();

                g2.setColor(new Color(0, 0, 0, 180));
                g2.drawString(texto, x + 4, y + 4);

                g2.setColor(new Color(28, 69, 135));
                for (int dx = -2; dx <= 2; dx++) {
                    for (int dy = -2; dy <= 2; dy++) {
                        if (dx != 0 || dy != 0) {
                            g2.drawString(texto, x + dx, y + dy);
                        }
                    }
                }

                g2.setColor(new Color(255, 203, 5));
                g2.drawString(texto, x, y);
                g2.dispose();
            }
        };
        tituloPokemon.setPreferredSize(new Dimension(760, 58));
        tituloPokemon.setMaximumSize(new Dimension(820, 58));
        tituloPokemon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("  ELIGE TU ENTRENADOR Y TU MAZO PARA EL COMBATE  ", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        subtitulo.setForeground(new Color(240, 245, 255));
        subtitulo.setOpaque(true);
        subtitulo.setBackground(new Color(220, 38, 38, 215));
        subtitulo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 203, 5), 2),
                new EmptyBorder(5, 16, 5, 16)));
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel filaJugadores = new JPanel(new GridBagLayout());
        filaJugadores.setOpaque(false);
        filaJugadores.setMaximumSize(new Dimension(860, 250));

        JPanel tarjeta1 = crearTarjetaEntrenador("ENTRENADOR 1", jugador1, mazoJugador1);
        JPanel tarjeta2 = crearTarjetaEntrenador("ENTRENADOR 2", jugador2, mazoJugador2);
        JPanel centroVs = crearInsigniaPokebolaVS();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 12, 0, 12);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        filaJugadores.add(tarjeta1, gbc);

        gbc.weightx = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 1;
        filaJugadores.add(centroVs, gbc);

        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        filaJugadores.add(tarjeta2, gbc);

        JPanel filaBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 24, 0));
        filaBotones.setOpaque(false);

        estilizarBoton(verMazos, new Color(42, 117, 187), new Color(61, 142, 219), Color.WHITE, new Color(255, 203, 5));
        estilizarBoton(btnIniciar, new Color(227, 53, 13), new Color(255, 76, 36), Color.WHITE, new Color(255, 203, 5));

        verMazos.setPreferredSize(new Dimension(190, 46));
        btnIniciar.setPreferredSize(new Dimension(230, 46));

        verMazos.addActionListener(e -> {
            JTextArea area = new JTextArea(CreadorMazosPDefecto.describirTodos());
            area.setEditable(false);
            area.setRows(20);
            area.setColumns(30);
            JOptionPane.showMessageDialog(
                    this,
                    new JScrollPane(area),
                    "Mazos disponibles",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        btnIniciar.addActionListener(e -> {
            String nombre1 = jugador1.getText().trim();
            String nombre2 = jugador2.getText().trim();

            if (nombre1.isEmpty() || nombre2.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Los dos entrenadores necesitan un nombre.",
                        "Datos incompletos",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            String nombreMazo1 = (String) mazoJugador1.getSelectedItem();
            String nombreMazo2 = (String) mazoJugador2.getSelectedItem();

            Jugador jugadorUno = Juego.crearJugador(nombreMazo1, nombre1);
            Jugador jugadorDos = Juego.crearJugador(nombreMazo2, nombre2);

            new VentanaJuego(jugadorUno, jugadorDos).setVisible(true);
            dispose();
        });

        filaBotones.add(verMazos);
        filaBotones.add(btnIniciar);

        contenedor.add(tituloPokemon);
        contenedor.add(Box.createVerticalStrut(6));
        contenedor.add(subtitulo);
        contenedor.add(Box.createVerticalStrut(24));
        contenedor.add(filaJugadores);
        contenedor.add(Box.createVerticalStrut(26));
        contenedor.add(filaBotones);

        panelFondo.add(contenedor);
        setContentPane(panelFondo);
    }

    private JPanel crearTarjetaEntrenador(String titulo, JTextField campoNombre, JComboBox<String> comboMazo) {
        final Color[] colorBorde = { obtenerColorPorMazo((String) comboMazo.getSelectedItem()) };

        JPanel tarjeta = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                Shape rect = new RoundRectangle2D.Double(2, 2, getWidth() - 5, getHeight() - 5, 22, 22);
                g2.setColor(new Color(16, 22, 38, 215));
                g2.fill(rect);

                g2.setClip(rect);
                g2.setColor(new Color(colorBorde[0].getRed(), colorBorde[0].getGreen(), colorBorde[0].getBlue(), 65));
                g2.fillRect(0, 0, getWidth(), 44);
                g2.setClip(null);

                g2.setStroke(new BasicStroke(3f));
                g2.setColor(colorBorde[0]);
                g2.draw(rect);
                g2.dispose();
            }
        };

        tarjeta.setOpaque(false);
        tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
        tarjeta.setBorder(new EmptyBorder(12, 24, 18, 24));
        tarjeta.setPreferredSize(new Dimension(310, 215));

        JLabel lblTitulo = new JLabel(titulo, SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
        lblTitulo.setForeground(new Color(255, 203, 5));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblNombre = new JLabel("Nombre del entrenador:");
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblNombre.setForeground(new Color(220, 230, 245));
        lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        campoNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
        campoNombre.setHorizontalAlignment(JTextField.CENTER);
        campoNombre.setBackground(new Color(245, 248, 255));
        campoNombre.setForeground(new Color(20, 25, 40));
        campoNombre.setMaximumSize(new Dimension(240, 34));
        campoNombre.setPreferredSize(new Dimension(240, 34));
        campoNombre.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 203, 5), 2),
                new EmptyBorder(4, 10, 4, 10)));

        JLabel lblMazo = new JLabel("Selecciona tu mazo:");
        lblMazo.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblMazo.setForeground(new Color(220, 230, 245));
        lblMazo.setAlignmentX(Component.CENTER_ALIGNMENT);

        comboMazo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        comboMazo.setMaximumSize(new Dimension(240, 34));
        comboMazo.setPreferredSize(new Dimension(240, 34));
        comboMazo.setCursor(new Cursor(Cursor.HAND_CURSOR));

        comboMazo.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                colorBorde[0] = obtenerColorPorMazo((String) comboMazo.getSelectedItem());
                tarjeta.repaint();
            }
        });

        tarjeta.add(lblTitulo);
        tarjeta.add(Box.createVerticalStrut(18));
        tarjeta.add(lblNombre);
        tarjeta.add(Box.createVerticalStrut(5));
        tarjeta.add(campoNombre);
        tarjeta.add(Box.createVerticalStrut(14));
        tarjeta.add(lblMazo);
        tarjeta.add(Box.createVerticalStrut(5));
        tarjeta.add(comboMazo);

        return tarjeta;
    }

    private Color obtenerColorPorMazo(String mazo) {
        if (mazo == null) return new Color(255, 203, 5);
        if (mazo.contains("Agua")) return new Color(56, 189, 248);
        if (mazo.contains("Fuego")) return new Color(249, 115, 22);
        if (mazo.contains("Rayo")) return new Color(250, 204, 21);
        return new Color(255, 203, 5);
    }

    private JPanel crearInsigniaPokebolaVS() {
        JPanel pokebola = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int d = 64;
                int x = (getWidth() - d) / 2;
                int y = (getHeight() - d) / 2;

                g2.setColor(new Color(227, 53, 13));
                g2.fillArc(x, y, d, d, 0, 180);

                g2.setColor(new Color(245, 245, 245));
                g2.fillArc(x, y, d, d, 180, 180);

                g2.setColor(new Color(20, 24, 35));
                g2.setStroke(new BasicStroke(4f));
                g2.drawOval(x, y, d, d);
                g2.drawLine(x, y + d / 2, x + d, y + d / 2);

                int b = 22;
                g2.setColor(new Color(255, 203, 5));
                g2.fillOval(x + (d - b) / 2, y + (d - b) / 2, b, b);
                g2.setStroke(new BasicStroke(3f));
                g2.setColor(new Color(20, 24, 35));
                g2.drawOval(x + (d - b) / 2, y + (d - b) / 2, b, b);

                g2.setFont(new Font("Segoe UI Black", Font.BOLD, 10));
                FontMetrics fm = g2.getFontMetrics();
                String vs = "VS";
                g2.drawString(vs, x + (d - fm.stringWidth(vs)) / 2, y + d / 2 + fm.getAscent() / 2 - 1);
                g2.dispose();
            }
        };
        pokebola.setOpaque(false);
        pokebola.setPreferredSize(new Dimension(74, 74));
        return pokebola;
    }

    private void estilizarBoton(JButton boton, Color colorBase, Color colorHover, Color texto, Color borde) {
        boton.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
        boton.setForeground(texto);
        boton.setBackground(colorBase);
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borde, 2),
                new EmptyBorder(8, 18, 8, 18)));

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(colorHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorBase);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaInicioPokemon().setVisible(true));
    }

/**
 *
 * @author Sara Arcila
 */
    
}
