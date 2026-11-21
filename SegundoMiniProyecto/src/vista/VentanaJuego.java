
package vista;
import logica.Carta;
import logica.Jugador;


public class VentanaJuego extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaJuego.class.getName());

    private Jugador jugadorActualObj;
    private Jugador jugadorRivalObj;
    private int turnoNumero = 1;
    private Carta cartaSeleccionada = null;
    private boolean usadoEsteTurno = false;

    public VentanaJuego(Jugador j1, Jugador j2) {
        initComponents();
        this.jugadorActualObj = j1;
        this.jugadorRivalObj = j2;
        panelCartasMano.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 10));
        btnAtacar.addActionListener(this::btnAtacarActionPerformed);
        setLocationRelativeTo(null);
        if (this.jugadorActualObj.getEnergy() < 1) {
    this.jugadorActualObj.setEnergy(1);
    panelMano.setOpaque(true);
panelMano.setBackground(new java.awt.Color(18, 25, 42)); 
}
         aplicarEstiloPokemonTCG();
    PanelConFondo fondo = new PanelConFondo("/imagenes/fondo.jpg");
fondo.setLayout(new java.awt.BorderLayout());
jPanel1.setOpaque(false);
hacerPanelesTransparentes(jPanel1);
fondo.add(jPanel1, java.awt.BorderLayout.CENTER);
setContentPane(fondo);
    

java.awt.Dimension dimActivo = new java.awt.Dimension(140, 190);
for (javax.swing.JLabel lbl : new javax.swing.JLabel[]{activoActual, activoRival}) {
    lbl.setPreferredSize(dimActivo);
    lbl.setMinimumSize(dimActivo);
    lbl.setMaximumSize(dimActivo);
    lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
}

java.awt.Dimension dimBanco = new java.awt.Dimension(130, 160);
for (javax.swing.JLabel lbl : new javax.swing.JLabel[]{banco1Actual, banco2Actual, banco1Rival, banco2Rival}) {
    lbl.setPreferredSize(dimBanco);
    lbl.setMinimumSize(dimBanco);
    lbl.setMaximumSize(dimBanco);
    lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
}
        actualizarTablero();
    }

    private void mostrarImagen(javax.swing.JLabel label, String archivo, int ancho, int alto) {
        java.net.URL url = getClass().getResource("/imagenes/" + archivo);
        if (url == null) {
            label.setIcon(null);
            label.setText(archivo);
            return;
        }
        java.awt.Image img = new javax.swing.ImageIcon(url).getImage()
                .getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
        label.setIcon(new javax.swing.ImageIcon(img));
        label.setText("");
    }

    private javax.swing.ImageIcon cargarIcono(String archivo, int ancho, int alto) {
        java.net.URL url = getClass().getResource("/imagenes/" + archivo);
        if (url == null) {
            return null;
        }
        java.awt.Image img = new javax.swing.ImageIcon(url).getImage()
                .getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
        return new javax.swing.ImageIcon(img);
    }

    private String nombreArchivo(String nombreCarta) {
        String n = java.text.Normalizer.normalize(nombreCarta, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase()
                .replace(" ", "");
        return n + ".jpg";
    }
private void hacerPanelesTransparentes(java.awt.Container contenedor) {
    for (java.awt.Component comp : contenedor.getComponents()) {
        if (comp instanceof javax.swing.JPanel) {
            if (comp != panelCartasMano) {
                ((javax.swing.JPanel) comp).setOpaque(false);
            }
            hacerPanelesTransparentes((java.awt.Container) comp);
        }
    }
}
    private void cargarMano() {
        panelCartasMano.removeAll();
        cartaSeleccionada = null;
        for (Carta carta : jugadorActualObj.getMano()) {
            javax.swing.JButton boton = new javax.swing.JButton();
            boton.setPreferredSize(new java.awt.Dimension(96, 132));
            boton.setIcon(cargarIcono(nombreArchivo(carta.getNombreCarta()), 90, 126));
            if (boton.getIcon() == null) {
                boton.setText(carta.getNombreCarta());
            }
            boton.addActionListener(e -> seleccionarCarta(carta, boton));
            panelCartasMano.add(boton);
        }
        panelCartasMano.revalidate();
        panelCartasMano.repaint();
    }

    private void seleccionarCarta(Carta carta, javax.swing.JButton boton) {
        for (java.awt.Component c : panelCartasMano.getComponents()) {
            ((javax.swing.JButton) c).setBorder(javax.swing.UIManager.getBorder("Button.border"));
        }
        cartaSeleccionada = carta;
        boton.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 3));
    }
private void aplicarEstiloPokemonTCG() {
   
    java.awt.Font fuenteTitulo = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 15);
    java.awt.Font fuenteBadge = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13);
    java.awt.Font fuenteBoton = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12);

    estilizarBadge(turno, new java.awt.Color(20, 25, 40, 220), new java.awt.Color(255, 215, 0), fuenteTitulo);
    estilizarBadge(jugadorActual, new java.awt.Color(20, 25, 40, 220), java.awt.Color.WHITE, fuenteTitulo);
    estilizarBadge(puntosActual, new java.awt.Color(16, 85, 45, 230), new java.awt.Color(120, 255, 170), fuenteBadge);
    estilizarBadge(puntosRival, new java.awt.Color(120, 25, 35, 230), new java.awt.Color(255, 150, 150), fuenteBadge);

    estilizarBadge(psActivoActual, new java.awt.Color(22, 110, 50, 230), java.awt.Color.WHITE, fuenteBadge);
    estilizarBadge(psActivoRival, new java.awt.Color(150, 30, 40, 230), java.awt.Color.WHITE, fuenteBadge);
    estilizarBadge(energiaActivoActual, new java.awt.Color(20, 90, 160, 230), new java.awt.Color(180, 235, 255), fuenteBadge);
    estilizarBadge(energiaActivoRival, new java.awt.Color(20, 90, 160, 230), new java.awt.Color(180, 235, 255), fuenteBadge);

    javax.swing.JLabel[] slots = {
        activoActual, activoRival, banco1Actual, banco2Actual, banco1Rival, banco2Rival
    };
    for (javax.swing.JLabel slot : slots) {
        slot.setOpaque(true);
        slot.setBackground(new java.awt.Color(15, 20, 35, 145)); // Cristal oscuro semitransparente
        slot.setForeground(new java.awt.Color(210, 225, 245));
        slot.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        slot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        slot.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 215, 0, 180), 2, true),
                javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)
        ));
    }


    estilizarBoton(btnAtacar, new java.awt.Color(211, 47, 47), java.awt.Color.WHITE, fuenteBoton);      // Rojo Combate
    estilizarBoton(btnEnergia, new java.awt.Color(2, 136, 209), java.awt.Color.WHITE, fuenteBoton);    // Azul Energía
    estilizarBoton(btnBanco, new java.awt.Color(56, 142, 60), java.awt.Color.WHITE, fuenteBoton);      // Verde Campo
    estilizarBoton(btnEvolucionar, new java.awt.Color(0, 150, 136), java.awt.Color.WHITE, fuenteBoton);// Turquesa Evolución
    estilizarBoton(btnActivo, new java.awt.Color(245, 124, 0), java.awt.Color.WHITE, fuenteBoton);     // Naranja Retirada
    estilizarBoton(btnEntrenador, new java.awt.Color(123, 31, 162), java.awt.Color.WHITE, fuenteBoton);// Morado Partidario
    estilizarBoton(btnTurno, new java.awt.Color(255, 193, 7), new java.awt.Color(25, 25, 25), fuenteBoton); // Dorado Fin de Turno

    panelCartasMano.setOpaque(true);
    panelCartasMano.setBackground(new java.awt.Color(12, 16, 28, 210));
    panelCartasMano.setBorder(javax.swing.BorderFactory.createTitledBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 181, 246), 2),
            " TU MANO (Haz clic en una carta para seleccionarla) ",
            javax.swing.border.TitledBorder.LEFT,
            javax.swing.border.TitledBorder.TOP,
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12),
            new java.awt.Color(144, 202, 249)
    ));

    txtRegistro.setBackground(new java.awt.Color(15, 20, 32));
    txtRegistro.setForeground(new java.awt.Color(230, 240, 255));
    txtRegistro.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 12));
    txtRegistro.setEditable(false);
    txtRegistro.setLineWrap(true);
    txtRegistro.setWrapStyleWord(true);
}

private void estilizarBadge(javax.swing.JLabel lbl, java.awt.Color fondo, java.awt.Color texto, java.awt.Font fuente) {
    lbl.setOpaque(true);
    lbl.setBackground(fondo);
    lbl.setForeground(texto);
    lbl.setFont(fuente);
    lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255, 90), 1, true),
            javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 10)
    ));
}

private void estilizarBoton(javax.swing.JButton btn, java.awt.Color fondo, java.awt.Color texto, java.awt.Font fuente) {
    btn.setBackground(fondo);
    btn.setForeground(texto);
    btn.setFont(fuente);
    btn.setFocusPainted(false);
    btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btn.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255, 140), 1, true),
            javax.swing.BorderFactory.createEmptyBorder(8, 14, 8, 14)
    ));
}
    private void actualizarTablero() {
     
        turno.setText("TURNO: " + turnoNumero);
        jugadorActual.setText("JUEGA " + jugadorActualObj.getNombre().toUpperCase());
        puntosActual.setText(jugadorActualObj.getNombre() + " " + jugadorActualObj.getPuntos() + "/3");
        puntosRival.setText(jugadorRivalObj.getNombre() + " " + jugadorRivalObj.getPuntos() + "/3");

        if (jugadorActualObj.getPokemonActivo() != null) {
            logica.pokemones.Pokemon activo = jugadorActualObj.getPokemonActivo();
            mostrarImagen(activoActual, nombreArchivo(activo.getNombreCarta()), 140, 190);
            psActivoActual.setText("PS " + activo.getPs());
            energiaActivoActual.setText("ENERGIA: " + activo.getEnergiaAcumulada());
        } else {
            activoActual.setIcon(null);
            activoActual.setText("SIN ACTIVO");
            psActivoActual.setText("PS 0");
            energiaActivoActual.setText("ENERGIA: 0");
        }

        if (jugadorRivalObj.getPokemonActivo() != null) {
            logica.pokemones.Pokemon rival = jugadorRivalObj.getPokemonActivo();
            mostrarImagen(activoRival, nombreArchivo(rival.getNombreCarta()), 140, 190);
            psActivoRival.setText("PS " + rival.getPs());
            energiaActivoRival.setText("ENERGIA: " + rival.getEnergiaAcumulada());
        } else {
            activoRival.setIcon(null);
            activoRival.setText("SIN ACTIVO");
            psActivoRival.setText("PS 0");
            energiaActivoRival.setText("ENERGIA: 0");
        }

        mostrarEspacioBanco(banco1Actual, jugadorActualObj.getBanco()[0], "BANCO 1");
        mostrarEspacioBanco(banco2Actual, jugadorActualObj.getBanco()[1], "BANCO 2");
        mostrarEspacioBanco(banco1Rival, jugadorRivalObj.getBanco()[0], "BANCO 1");
        mostrarEspacioBanco(banco2Rival, jugadorRivalObj.getBanco()[1], "BANCO 2");

        cargarMano();
    }

    private void mostrarEspacioBanco(javax.swing.JLabel label, logica.pokemones.Pokemon pokemon, String textoVacio) {
        if (pokemon != null) {
            mostrarImagen(label, nombreArchivo(pokemon.getNombreCarta()), 130, 160);
        } else {
            label.setIcon(null);
            label.setText(textoVacio);
        }
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new PanelConFondo("/imagenes/fondo.jpg");
        jPanel2 = new javax.swing.JPanel();
        turno = new javax.swing.JLabel();
        jugadorActual = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        puntosActual = new javax.swing.JLabel();
        puntosRival = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnEnergia = new javax.swing.JButton();
        btnEntrenador = new javax.swing.JButton();
        btnBanco = new javax.swing.JButton();
        btnActivo = new javax.swing.JButton();
        btnEvolucionar = new javax.swing.JButton();
        btnAtacar = new javax.swing.JButton();
        btnTurno = new javax.swing.JButton();
        panelMano = new javax.swing.JPanel();
        panelCartasMano = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        banco1Rival = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        activoRival = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        banco2Rival = new javax.swing.JLabel();
        barPsActivoRival = new javax.swing.JProgressBar();
        energiaActivoRival = new javax.swing.JLabel();
        psActivoRival = new javax.swing.JLabel();
        energiaActivoActual = new javax.swing.JLabel();
        barPsActivoActual = new javax.swing.JProgressBar();
        jPanel11 = new javax.swing.JPanel();
        banco1Actual = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        banco2Actual = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        activoActual = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRegistro = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        psActivoActual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        turno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        turno.setText("TURNO: 3");

        jugadorActual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jugadorActual.setText("JUEGA SARA");

        jLabel3.setText("PUNTOS:");

        puntosActual.setText("Sara 0/3");

        puntosRival.setText("juan 1/3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(puntosActual)
                .addGap(29, 29, 29)
                .addComponent(puntosRival)
                .addGap(337, 337, 337)
                .addComponent(turno)
                .addGap(75, 75, 75)
                .addComponent(jugadorActual)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jugadorActual)
                    .addComponent(turno))
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(puntosActual)
                    .addComponent(puntosRival))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnEnergia.setText("ADJUNTAR ENERGIA");
        btnEnergia.addActionListener(this::btnEnergiaActionPerformed);

        btnEntrenador.setText("JUGAR ENTRENADOR");
        btnEntrenador.addActionListener(this::btnEntrenadorActionPerformed);

        btnBanco.setText("PONER EN BANCO");
        btnBanco.addActionListener(this::btnBancoActionPerformed);

        btnActivo.setText("RETIRAR ACTIVO");
        btnActivo.addActionListener(this::btnActivoActionPerformed);

        btnEvolucionar.setText("EVOLUCIONAR");
        btnEvolucionar.addActionListener(this::btnEvolucionarActionPerformed);

        btnAtacar.setText("ATACAR");
        btnAtacar.addActionListener(this::btnAtacarActionPerformed);

        btnTurno.setText("PASAR TURNO");
        btnTurno.addActionListener(this::btnTurnoActionPerformed);

        panelCartasMano.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout panelManoLayout = new javax.swing.GroupLayout(panelMano);
        panelMano.setLayout(panelManoLayout);
        panelManoLayout.setHorizontalGroup(
            panelManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelManoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCartasMano, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelManoLayout.setVerticalGroup(
            panelManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManoLayout.createSequentialGroup()
                .addComponent(panelCartasMano, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEvolucionar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEnergia))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEntrenador, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAtacar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btnTurno)))
                .addGap(50, 50, 50)
                .addComponent(panelMano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEnergia)
                            .addComponent(btnEntrenador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBanco)
                            .addComponent(btnActivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEvolucionar)
                            .addComponent(btnAtacar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTurno))
                    .addComponent(panelMano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(244, 253, 254));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel10.setPreferredSize(new java.awt.Dimension(130, 160));

        banco1Rival.setText("BANCO 1");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(banco1Rival)
                .addGap(0, 72, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(banco1Rival)
                .addGap(0, 138, Short.MAX_VALUE))
        );

        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel14.setPreferredSize(new java.awt.Dimension(140, 190));

        activoRival.setText("ACTIVO");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(activoRival)
                .addGap(0, 92, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(activoRival)
                .addGap(0, 168, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(244, 253, 254));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel13.setPreferredSize(new java.awt.Dimension(130, 160));

        banco2Rival.setText("BANCO 2");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(banco2Rival)
                .addGap(0, 72, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(banco2Rival)
                .addGap(0, 138, Short.MAX_VALUE))
        );

        energiaActivoRival.setText("ENERGIA: 3");

        psActivoRival.setText("PS 60/80");

        energiaActivoActual.setText("ENERGIA: 4");

        jPanel11.setBackground(new java.awt.Color(244, 253, 254));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel11.setPreferredSize(new java.awt.Dimension(130, 160));

        banco1Actual.setText("BANCO 1");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(banco1Actual)
                .addGap(0, 72, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(banco1Actual)
                .addGap(0, 138, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(244, 253, 254));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel12.setPreferredSize(new java.awt.Dimension(130, 160));

        banco2Actual.setText("BANCO 2");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(banco2Actual)
                .addGap(0, 72, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(banco2Actual)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel7.setPreferredSize(new java.awt.Dimension(140, 190));

        activoActual.setText("ACTIVO");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(activoActual)
                .addGap(0, 92, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(activoActual)
                .addGap(0, 168, Short.MAX_VALUE))
        );

        txtRegistro.setColumns(20);
        txtRegistro.setRows(5);
        jScrollPane1.setViewportView(txtRegistro);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE EVENTOS");

        psActivoActual.setText("PS 50/70");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel1)
                                .addGap(78, 78, 78)))
                        .addGap(118, 118, 118)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(energiaActivoRival)
                            .addComponent(energiaActivoActual)
                            .addComponent(psActivoRival)
                            .addComponent(psActivoActual)
                            .addComponent(barPsActivoRival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barPsActivoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(energiaActivoRival)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(psActivoRival)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(barPsActivoRival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(energiaActivoActual)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(psActivoActual)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(barPsActivoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnergiaActionPerformed

    if (jugadorActualObj.getEnergy() < 1) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "Ya usaste tu energía de este turno.",
                "Sin energía disponible",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    java.util.ArrayList<logica.pokemones.Pokemon> opciones = new java.util.ArrayList<>();
    java.util.ArrayList<String> nombresOpciones = new java.util.ArrayList<>();

    if (jugadorActualObj.getPokemonActivo() != null) {
        opciones.add(jugadorActualObj.getPokemonActivo());
        nombresOpciones.add("Activo: " + jugadorActualObj.getPokemonActivo().getNombreCarta()
                + " (Energía: " + jugadorActualObj.getPokemonActivo().getEnergiaAcumulada() + ")");
    }
    for (int i = 0; i < jugadorActualObj.getBanco().length; i++) {
        logica.pokemones.Pokemon p = jugadorActualObj.getBanco()[i];
        if (p != null) {
            opciones.add(p);
            nombresOpciones.add("Banco " + (i + 1) + ": " + p.getNombreCarta()
                    + " (Energía: " + p.getEnergiaAcumulada() + ")");
        }
    }

    if (opciones.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "No tienes Pokémon en el campo para adjuntar energía.",
                "Campo vacío",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    Object seleccion = javax.swing.JOptionPane.showInputDialog(
            this,
            "¿A qué Pokémon deseas adjuntar energía (" + jugadorActualObj.getTipoEnergia() + ")?",
            "Adjuntar Energía",
            javax.swing.JOptionPane.QUESTION_MESSAGE,
            null,
            nombresOpciones.toArray(),
            nombresOpciones.get(0));

    if (seleccion == null) {
        return;
    }

    int indice = nombresOpciones.indexOf(seleccion.toString());
    logica.pokemones.Pokemon elegido = opciones.get(indice);


    elegido.setEnergiaAcumulada(elegido.getEnergiaAcumulada() + 1);
    jugadorActualObj.setEnergy(jugadorActualObj.getEnergy() - 1);

    txtRegistro.append(jugadorActualObj.getNombre() + " adjuntó 1 energía a "
            + elegido.getNombreCarta() + ".\n");
    actualizarTablero();

    }//GEN-LAST:event_btnEnergiaActionPerformed

    private void btnBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBancoActionPerformed

    if (cartaSeleccionada == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "Primero selecciona una carta de tu mano.",
                "Ninguna carta seleccionada",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (!(cartaSeleccionada instanceof logica.pokemones.Pokemon) 
            || (cartaSeleccionada instanceof logica.pokemones.Evo.PokemonEvo)) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "Solo puedes bajar Pokémon básicos al campo.",
                "Carta inválida",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    logica.pokemones.Pokemon pokemonBajar = (logica.pokemones.Pokemon) cartaSeleccionada;

    if (jugadorActualObj.getPokemonActivo() == null) {
        jugadorActualObj.setPokemonActivo(pokemonBajar);
        jugadorActualObj.getMano().remove(cartaSeleccionada);
        txtRegistro.append(jugadorActualObj.getNombre() + " colocó a " 
                + pokemonBajar.getNombreCarta() + " como Activo.\n");
        actualizarTablero();
        return;
    }

    logica.pokemones.Pokemon[] banco = jugadorActualObj.getBanco();
    if (banco[0] == null) {
        jugadorActualObj.setBanco(pokemonBajar, 0);
        jugadorActualObj.getMano().remove(cartaSeleccionada);
        txtRegistro.append(jugadorActualObj.getNombre() + " puso a " 
                + pokemonBajar.getNombreCarta() + " en Banco 1.\n");
        actualizarTablero();
    } else if (banco[1] == null) {
        jugadorActualObj.setBanco(pokemonBajar, 1);
        jugadorActualObj.getMano().remove(cartaSeleccionada);
        txtRegistro.append(jugadorActualObj.getNombre() + " puso a " 
                + pokemonBajar.getNombreCarta() + " en Banco 2.\n");
        actualizarTablero();
    } else {
        javax.swing.JOptionPane.showMessageDialog(this,
                "Tu banco ya está lleno (máximo 2 Pokémon).",
                "Banco lleno",
                javax.swing.JOptionPane.WARNING_MESSAGE);
    }
     
    }//GEN-LAST:event_btnBancoActionPerformed

    private void btnActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivoActionPerformed

    logica.pokemones.Pokemon activo = jugadorActualObj.getPokemonActivo();

    if (activo == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "No tienes un Pokémon Activo para retirar.",
                "Sin Pokémon Activo",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    java.util.ArrayList<Integer> indicesBanco = new java.util.ArrayList<>();
    java.util.ArrayList<String> nombresBanco = new java.util.ArrayList<>();
    for (int i = 0; i < jugadorActualObj.getBanco().length; i++) {
        if (jugadorActualObj.getBanco()[i] != null) {
            indicesBanco.add(i);
            nombresBanco.add("Banco " + (i + 1) + ": " + jugadorActualObj.getBanco()[i].getNombreCarta());
        }
    }

    if (indicesBanco.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "No tienes Pokémon en el banco para reemplazar al Activo.",
                "Banco vacío",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int costoRetiro = activo.getCostoRetirada();
    if (activo.getEnergiaAcumulada() < costoRetiro) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "Energía insuficiente para retirar a " + activo.getNombreCarta()
                + " (requiere " + costoRetiro + " de energía).",
                "Energía insuficiente",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    Object seleccion = javax.swing.JOptionPane.showInputDialog(
            this,
            "¿Qué Pokémon del banco pasará a ser el nuevo Activo?\n(Costo de retirada: " + costoRetiro + " energía)",
            "Retirar Pokémon Activo",
            javax.swing.JOptionPane.QUESTION_MESSAGE,
            null,
            nombresBanco.toArray(),
            nombresBanco.get(0));

    if (seleccion == null) {
        return;
    }

    int posElegida = indicesBanco.get(nombresBanco.indexOf(seleccion.toString()));
    logica.pokemones.Pokemon nuevoActivo = jugadorActualObj.getBanco()[posElegida];

    activo.setEnergiaAcumulada(activo.getEnergiaAcumulada() - costoRetiro);
    jugadorActualObj.setPokemonActivo(nuevoActivo);
    jugadorActualObj.setBanco(activo, posElegida);

    txtRegistro.append(jugadorActualObj.getNombre() + " retiró a " + activo.getNombreCarta()
            + " y envió a " + nuevoActivo.getNombreCarta() + " como Activo.\n");
    actualizarTablero(); 
    }//GEN-LAST:event_btnActivoActionPerformed

    private void btnEvolucionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvolucionarActionPerformed

    if (cartaSeleccionada == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "Primero selecciona una carta de Evolución de tu mano.",
                "Ninguna carta seleccionada",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (!(cartaSeleccionada instanceof logica.pokemones.Evo.PokemonEvo)) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "La carta seleccionada no es una Evolución.",
                "Carta inválida",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    logica.pokemones.Evo.PokemonEvo evo = (logica.pokemones.Evo.PokemonEvo) cartaSeleccionada;
    String preEvoRequerida = evo.getEvolucionaDe();

    java.util.ArrayList<String> ubicaciones = new java.util.ArrayList<>();
    java.util.ArrayList<Integer> codigosLugar = new java.util.ArrayList<>(); 

    logica.pokemones.Pokemon activo = jugadorActualObj.getPokemonActivo();
    if (activo != null && activo.getNombreCarta().equalsIgnoreCase(preEvoRequerida)) {
        ubicaciones.add("Activo: " + activo.getNombreCarta() + " (PS: " + activo.getPs() + ")");
        codigosLugar.add(-1);
    }

    for (int i = 0; i < jugadorActualObj.getBanco().length; i++) {
        logica.pokemones.Pokemon b = jugadorActualObj.getBanco()[i];
        if (b != null && b.getNombreCarta().equalsIgnoreCase(preEvoRequerida)) {
            ubicaciones.add("Banco " + (i + 1) + ": " + b.getNombreCarta() + " (PS: " + b.getPs() + ")");
            codigosLugar.add(i);
        }
    }

    if (ubicaciones.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "No tienes a " + preEvoRequerida + " en el campo para evolucionarlo a " + evo.getNombreCarta() + ".",
                "No se puede evolucionar",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int lugarElegido = codigosLugar.get(0);
    if (ubicaciones.size() > 1) {
        Object sel = javax.swing.JOptionPane.showInputDialog(
                this,
                "¿Cuál " + preEvoRequerida + " deseas evolucionar a " + evo.getNombreCarta() + "?",
                "Elegir Pokémon a Evolucionar",
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                null,
                ubicaciones.toArray(),
                ubicaciones.get(0));
        if (sel == null) {
            return;
        }
        lugarElegido = codigosLugar.get(ubicaciones.indexOf(sel.toString()));
    }

    logica.pokemones.Pokemon base = (lugarElegido == -1)
            ? jugadorActualObj.getPokemonActivo()
            : jugadorActualObj.getBanco()[lugarElegido];

    if (base.isEvolucionBloqueada()) {
        javax.swing.JOptionPane.showMessageDialog(this,
                base.getNombreCarta() + " no puede evolucionar en este turno.",
                "Evolución bloqueada",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    evo.setEnergiaAcumulada(base.getEnergiaAcumulada());
    if (lugarElegido == -1) {
        jugadorActualObj.setPokemonActivo(evo);
    } else {
        jugadorActualObj.setBanco(evo, lugarElegido);
    }

    jugadorActualObj.getMano().remove(cartaSeleccionada);
    txtRegistro.append(jugadorActualObj.getNombre() + " evolucionó a " + base.getNombreCarta()
            + " en " + evo.getNombreCarta() + ".\n");
    actualizarTablero();
    }//GEN-LAST:event_btnEvolucionarActionPerformed

    private void btnTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnoActionPerformed

    usadoEsteTurno = false;
        
        if (jugadorActualObj.getPokemonActivo() == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "Debes colocar un Pokémon Activo antes de pasar el turno.",
                "Falta Pokémon Activo",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (jugadorActualObj.getPokemonActivo() != null) {
        jugadorActualObj.getPokemonActivo().setTurboVelocidadUsada(false);
        jugadorActualObj.getPokemonActivo().setEvolucionBloqueada(false);
    }
    for (logica.pokemones.Pokemon p : jugadorActualObj.getBanco()) {
        if (p != null) {
            p.setTurboVelocidadUsada(false);
            p.setEvolucionBloqueada(false);
        }
    }

    Jugador temp = jugadorActualObj;
    jugadorActualObj = jugadorRivalObj;
    jugadorRivalObj = temp;

    turnoNumero++;
    txtRegistro.append("----------------------------------\n");
    txtRegistro.append("Turno " + turnoNumero + ": juega " + jugadorActualObj.getNombre() + "\n");

    if (turnoNumero >= 3) {
        if (!jugadorActualObj.getMazo().isEmpty()) {
            Carta robada = jugadorActualObj.getMazo().remove(0);
            jugadorActualObj.getMano().add(robada);
            txtRegistro.append(jugadorActualObj.getNombre() + " robó: " + robada.getNombreCarta() + "\n");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                    jugadorActualObj.getNombre() + " se quedó sin cartas en el mazo.\n¡"
                    + jugadorRivalObj.getNombre() + " gana la partida!",
                    "Fin del juego",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            new VentanaInicio().setVisible(true);
            dispose();
            return;
        }
    }

    if (jugadorActualObj.getEnergy() < 1) {
        jugadorActualObj.setEnergy(1);
    }

    actualizarTablero();

    }//GEN-LAST:event_btnTurnoActionPerformed

    private void btnAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtacarActionPerformed

    logica.pokemones.Pokemon atacante = jugadorActualObj.getPokemonActivo();
    logica.pokemones.Pokemon defensor = jugadorRivalObj.getPokemonActivo();

    if (atacante == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "No tienes un Pokémon Activo para atacar.",
                "Sin Pokémon Activo",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (defensor == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "El rival no tiene un Pokémon Activo.",
                "Sin objetivo",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    java.util.ArrayList<logica.Ataque> ataques = atacante.getAtaques();
    if (atacante.getEnergiaAcumulada() < ataques.get(0).getCosto()) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "No tienes suficiente energía para atacar (necesitas " + ataques.get(0).getCosto() + ").",
                "Energía insuficiente",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int indiceAtaque = 0;
    if (atacante.isEX() && ataques.size() > 1 && ataques.get(1).getCosto() <= atacante.getEnergiaAcumulada()) {
        String[] opcionesAtaques = {
            "1. " + ataques.get(0).getNombre() + " (Costo: " + ataques.get(0).getCosto() + ")",
            "2. " + ataques.get(1).getNombre() + " (Costo: " + ataques.get(1).getCosto() + ")"
        };
        int eleccion = javax.swing.JOptionPane.showOptionDialog(
                this,
                "¿Qué ataque deseas usar con " + atacante.getNombreCarta() + "?",
                "Elegir Ataque",
                javax.swing.JOptionPane.DEFAULT_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesAtaques,
                opcionesAtaques[0]);

        if (eleccion == javax.swing.JOptionPane.CLOSED_OPTION) {
            return; 
        }
        indiceAtaque = eleccion;
    }

    atacante.atacar(indiceAtaque, defensor);
    txtRegistro.append(atacante.getNombreCarta() + " usó " + ataques.get(indiceAtaque).getNombre()
            + " contra " + defensor.getNombreCarta() + ".\n");

    if (defensor.getPs() <= 0) {
        txtRegistro.append("¡" + defensor.getNombreCarta() + " ha sido derrotado!\n");

        if (defensor.isEX()) {
            jugadorActualObj.setPuntos(jugadorActualObj.getPuntos() + 2);
            txtRegistro.append(jugadorActualObj.getNombre() + " gana 2 puntos por derrotar a un Pokémon EX.\n");
        } else {
            jugadorActualObj.setPuntos(jugadorActualObj.getPuntos() + 1);
            txtRegistro.append(jugadorActualObj.getNombre() + " gana 1 punto.\n");
        }

        jugadorRivalObj.setPokemonActivo(null);

        if (jugadorActualObj.getPuntos() >= 3) {
            actualizarTablero();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "¡" + jugadorActualObj.getNombre() + " gana el juego con " + jugadorActualObj.getPuntos() + " puntos!",
                    "¡Victoria!",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            new VentanaInicio().setVisible(true);
            dispose();
            return;
        }
        java.util.ArrayList<Integer> indicesBanco = new java.util.ArrayList<>();
        java.util.ArrayList<String> nombresBanco = new java.util.ArrayList<>();
        for (int i = 0; i < jugadorRivalObj.getBanco().length; i++) {
            if (jugadorRivalObj.getBanco()[i] != null) {
                indicesBanco.add(i);
                nombresBanco.add("Banco " + (i + 1) + ": " + jugadorRivalObj.getBanco()[i].getNombreCarta());
            }
        }

        if (!indicesBanco.isEmpty()) {
            Object elegidoObj = javax.swing.JOptionPane.showInputDialog(
                    this,
                    jugadorRivalObj.getNombre() + ", elige tu nuevo Pokémon Activo del banco:",
                    "Reemplazar Pokémon Activo",
                    javax.swing.JOptionPane.QUESTION_MESSAGE,
                    null,
                    nombresBanco.toArray(),
                    nombresBanco.get(0));

            int posElegida = (elegidoObj != null)
                    ? indicesBanco.get(nombresBanco.indexOf(elegidoObj.toString()))
                    : indicesBanco.get(0);

            logica.pokemones.Pokemon nuevoActivo = jugadorRivalObj.getBanco()[posElegida];
            jugadorRivalObj.setBanco(null, posElegida);
            jugadorRivalObj.setPokemonActivo(nuevoActivo);
            txtRegistro.append(nuevoActivo.getNombreCarta() + " pasa a ser el Activo de " + jugadorRivalObj.getNombre() + ".\n");
        } else {
            actualizarTablero();
            javax.swing.JOptionPane.showMessageDialog(this,
                    jugadorRivalObj.getNombre() + " se quedó sin Pokémon en juego.\n¡"
                    + jugadorActualObj.getNombre() + " gana la partida!",
                    "¡Victoria!",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            new VentanaInicio().setVisible(true);
            dispose();
            return;
        }
    }

    btnAtacar.setEnabled(true);
    actualizarTablero();
    btnAtacar.setEnabled(false);   
    }//GEN-LAST:event_btnAtacarActionPerformed

    private void btnEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrenadorActionPerformed

    if (cartaSeleccionada == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "Primero selecciona una carta de Entrenador de tu mano.",
                "Sin carta seleccionada",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (!(cartaSeleccionada instanceof logica.CartasEntrenador.CartaEntrenador)) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "La carta seleccionada no es una carta de Entrenador.",
                "Carta inválida",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    logica.CartasEntrenador.CartaEntrenador entrenador =
            (logica.CartasEntrenador.CartaEntrenador) cartaSeleccionada;

    if (entrenador.isSupport() && usadoEsteTurno) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "Ya jugaste una carta de Partidario en este turno.",
                "Límite de Partidario",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    logica.pokemones.Pokemon objetivo = null;
    if (entrenador.requiereObjetivo()) {
        java.util.ArrayList<logica.pokemones.Pokemon> candidatos = new java.util.ArrayList<>();
        java.util.ArrayList<String> nombres = new java.util.ArrayList<>();

        if (jugadorActualObj.getPokemonActivo() != null) {
            candidatos.add(jugadorActualObj.getPokemonActivo());
            nombres.add("Activo: " + jugadorActualObj.getPokemonActivo().getNombreCarta()
                    + " (PS: " + jugadorActualObj.getPokemonActivo().getPs() + ")");
        }
        for (int i = 0; i < jugadorActualObj.getBanco().length; i++) {
            if (jugadorActualObj.getBanco()[i] != null) {
                candidatos.add(jugadorActualObj.getBanco()[i]);
                nombres.add("Banco " + (i + 1) + ": " + jugadorActualObj.getBanco()[i].getNombreCarta()
                        + " (PS: " + jugadorActualObj.getBanco()[i].getPs() + ")");
            }
        }

        if (candidatos.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "No tienes Pokémon en juego para aplicar esta carta.",
                    "Sin objetivo",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        String mensaje = entrenador.getAvisoObjetivo().isEmpty()
                ? "Elige el Pokémon objetivo para " + entrenador.getNombreCarta() + ":"
                : entrenador.getAvisoObjetivo();

        Object elegido = javax.swing.JOptionPane.showInputDialog(
                this,
                mensaje,
                "Seleccionar Objetivo",
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                null,
                nombres.toArray(),
                nombres.get(0));

        if (elegido == null) {
            return;
        }
        objetivo = candidatos.get(nombres.indexOf(elegido.toString()));
    }

    boolean activada = entrenador.ActivarCarta(jugadorActualObj, objetivo);
    if (!activada) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "No se pudo activar la carta en este momento.",
                "No disponible",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (entrenador.isSupport()) {
        usadoEsteTurno = true;
    }

    jugadorActualObj.getMano().remove(cartaSeleccionada);
    txtRegistro.append(jugadorActualObj.getNombre() + " jugó " + entrenador.getNombreCarta()
            + (objetivo != null ? " en " + objetivo.getNombreCarta() : "") + ".\n");

    cartaSeleccionada = null;
    actualizarTablero();        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrenadorActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activoActual;
    private javax.swing.JLabel activoRival;
    private javax.swing.JLabel banco1Actual;
    private javax.swing.JLabel banco1Rival;
    private javax.swing.JLabel banco2Actual;
    private javax.swing.JLabel banco2Rival;
    private javax.swing.JProgressBar barPsActivoActual;
    private javax.swing.JProgressBar barPsActivoRival;
    private javax.swing.JButton btnActivo;
    private javax.swing.JButton btnAtacar;
    private javax.swing.JButton btnBanco;
    private javax.swing.JButton btnEnergia;
    private javax.swing.JButton btnEntrenador;
    private javax.swing.JButton btnEvolucionar;
    private javax.swing.JButton btnTurno;
    private javax.swing.JLabel energiaActivoActual;
    private javax.swing.JLabel energiaActivoRival;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jugadorActual;
    private javax.swing.JPanel panelCartasMano;
    private javax.swing.JPanel panelMano;
    private javax.swing.JLabel psActivoActual;
    private javax.swing.JLabel psActivoRival;
    private javax.swing.JLabel puntosActual;
    private javax.swing.JLabel puntosRival;
    private javax.swing.JLabel turno;
    private javax.swing.JTextArea txtRegistro;
    // End of variables declaration//GEN-END:variables
}
