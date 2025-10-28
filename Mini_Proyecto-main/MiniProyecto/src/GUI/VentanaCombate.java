package GUI;

import Combate.Combate;
import Personajes.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class VentanaCombate extends JFrame {

    private final JTextArea logArea = new JTextArea();
    private final JButton btnAtacar = new JButton("⚔️ Atacar");
    private final JButton btnHabilidad = new JButton("✨ Habilidad");
    private final JButton btnPasar = new JButton("⏸️ Pasar Turno");

    private final JLabel[] lblHeroes = new JLabel[4];
    private final JLabel[] lblEnemigos = new JLabel[4];
    private final JProgressBar[] hpHeroes = new JProgressBar[4];
    private final JProgressBar[] hpEnemigos = new JProgressBar[4];

    private final List<Personaje> heroes;
    private final List<Personaje> enemigos;
    private Combate combate;
    private Personaje turnoActual;
    private Clip musicaFondo;

    public VentanaCombate(List<Personaje> heroes, List<Personaje> enemigos) {
        this.heroes = heroes;
        this.enemigos = enemigos;

        setTitle("Dragon Quest VIII - Batalla Épica");
        setSize(1000, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelCombate = new JPanel(new GridLayout(2, 4, 10, 10));
        panelCombate.setBackground(new Color(0, 20, 70));

        for (int i = 0; i < heroes.size(); i++) {
            JPanel panel = crearPanelPersonaje(heroes.get(i), new Color(20, 70, 160));
            lblHeroes[i] = (JLabel) panel.getComponent(0);
            hpHeroes[i] = (JProgressBar) panel.getComponent(1);
            panelCombate.add(panel);
        }
        for (int i = 0; i < enemigos.size(); i++) {
            JPanel panel = crearPanelPersonaje(enemigos.get(i), new Color(100, 30, 30));
            lblEnemigos[i] = (JLabel) panel.getComponent(0);
            hpEnemigos[i] = (JProgressBar) panel.getComponent(1);
            panelCombate.add(panel);
        }

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(10, 20, 60));
        panelBotones.add(btnAtacar);
        panelBotones.add(btnHabilidad);
        panelBotones.add(btnPasar);

        logArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(logArea);
        scroll.setPreferredSize(new Dimension(280, 0));

        add(panelCombate, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        add(scroll, BorderLayout.EAST);

        combate = new Combate((List<Personaje>) heroes, (List<Personaje>) enemigos, this);

        btnAtacar.addActionListener(e -> combate.ejecutarAccion(turnoActual, "ataque"));
        btnHabilidad.addActionListener(e -> combate.ejecutarAccion(turnoActual, "habilidad"));
        btnPasar.addActionListener(e -> combate.ejecutarAccion(turnoActual, "pasar"));

        reproducirMusica("Recursos/musica/batalla.wav");
        iniciarBatalla();
    }

    private JPanel crearPanelPersonaje(Personaje p, Color fondo) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("<html><center>" + p.getNombre() + "<br>HP: " + p.getHp() + "</center></html>", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setBackground(fondo);
        JProgressBar barra = new JProgressBar(0, p.getHpMax());
        barra.setValue(p.getHp());
        barra.setForeground(Color.GREEN);
        barra.setStringPainted(true);
        panel.add(label, BorderLayout.CENTER);
        panel.add(barra, BorderLayout.SOUTH);
        return panel;
    }

    public void registrarEvento(String mensaje) {
        logArea.append(mensaje + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    public void actualizarEstado() {
        for (int i = 0; i < heroes.size(); i++) {
            Personaje h = heroes.get(i);
            lblHeroes[i].setText("<html><center>" + h.getNombre() + "<br>HP: " + h.getHp() + "</center></html>");
            hpHeroes[i].setValue(h.getHp());
        }
        for (int i = 0; i < enemigos.size(); i++) {
            Personaje e = enemigos.get(i);
            lblEnemigos[i].setText("<html><center>" + e.getNombre() + "<br>HP: " + e.getHp() + "</center></html>");
            hpEnemigos[i].setValue(e.getHp());
        }
    }

    private void iniciarBatalla() {
        new Thread(() -> combate.iniciarCombate()).start();
    }

    public void setTurnoActual(Personaje p) {
        turnoActual = p;
    }

    public void reproducirMusica(String ruta) {
        try {
            musicaFondo = AudioSystem.getClip();
            musicaFondo.open(AudioSystem.getAudioInputStream(new File(ruta)));
            musicaFondo.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Error al reproducir música: " + e.getMessage());
        }
    }

    public void reproducirSonido(String ruta) {
        new Thread(() -> {
            try {
                Clip sonido = AudioSystem.getClip();
                sonido.open(AudioSystem.getAudioInputStream(new File(ruta)));
                sonido.start();
            } catch (Exception ignored) {}
        }).start();
    }

    public void detenerMusica() {
        if (musicaFondo != null && musicaFondo.isRunning()) {
            musicaFondo.stop();
        }
    }
}
