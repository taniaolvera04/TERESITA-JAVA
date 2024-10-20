package Vista;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.EtchedBorder;

import Controlador.MetodosTeresita;
import Modelo.Conexion; // Importa la clase Conexion

public class Login {
    JFrame PL;
    private JLabel fondo;
    private JLabel teresita; 
    private JLabel lblu;
    private JTextField txtu;
    private JLabel teresitacr;
    private JPasswordField txtc;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.PL.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        initialize();
    }

    private void initialize() {
        PL = new JFrame();
        PL.setResizable(false);
        PL.setTitle("LOGIN");
        PL.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/08TeresitaLogo.png")));
        PL.setBounds(100, 100, 1040, 784);
        PL.setLocationRelativeTo(null); //CENTRAR PANTALLA
        PL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PL.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(253, 242, 249));
        panel.setBorder(null);
        panel.setBounds(191, 78, 533, 578);
        PL.getContentPane().add(panel);
        panel.setLayout(null);
        
        JPanel shadowPanel = new JPanel();
        shadowPanel.setBackground(new Color(252, 186, 210));
        shadowPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(244, 132, 191), new Color(244, 132, 191), new Color(244, 132, 191), new Color(244, 132, 191)));
        shadowPanel.setBounds(246, 126, 533, 578);
        PL.getContentPane().add(shadowPanel);
        shadowPanel.setLayout(null);

        teresita = new JLabel(""); 
        teresita.setHorizontalAlignment(SwingConstants.CENTER);
        teresita.setBounds(145, 0, 208, 213);
        panel.add(teresita);
        Image foto3 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/08TeresitaLogo.png"));
        teresita.setIcon(new ImageIcon(foto3.getScaledInstance(teresita.getWidth(), teresita.getHeight(), Image.SCALE_SMOOTH)));

        lblu = new JLabel("USUARIO");
        lblu.setForeground(new Color(244, 132, 191));
        lblu.setHorizontalAlignment(SwingConstants.CENTER);
        lblu.setFont(new Font("Dubai", Font.BOLD, 20));
        lblu.setBounds(217, 246, 94, 21);
        panel.add(lblu);

        txtu = new JTextField();
        txtu.setForeground(new Color(145, 79, 172));
        txtu.setHorizontalAlignment(SwingConstants.CENTER);
        txtu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtu.getText().length() >= 50) {
                    e.consume();
                }
            }
        });
        txtu.setFont(new Font("Dubai", Font.PLAIN, 18));
        txtu.setBounds(92, 277, 337, 43);
        panel.add(txtu);
        txtu.setColumns(10);

        JLabel lblc = new JLabel("CONTRASEÑA");
        lblc.setForeground(new Color(244, 132, 191));
        lblc.setHorizontalAlignment(SwingConstants.CENTER);
        lblc.setFont(new Font("Dubai", Font.BOLD, 20));
        lblc.setBounds(187, 355, 166, 21);
        panel.add(lblc);

        teresitacr = new JLabel("©2024 PAPELERÍA TERESITA");
        teresitacr.setForeground(new Color(128, 128, 128));
        teresitacr.setHorizontalAlignment(SwingConstants.CENTER);
        teresitacr.setFont(new Font("Dubai", Font.BOLD, 17));
        teresitacr.setBounds(114, 537, 305, 31);
        panel.add(teresitacr);
        
        txtc = new JPasswordField();
        txtc.setHorizontalAlignment(SwingConstants.CENTER);
        txtc.setForeground(new Color(145, 79, 172));
        txtc.setFont(new Font("Dubai", Font.PLAIN, 18));
        txtc.setBounds(92, 386, 337, 43);
        panel.add(txtc);
        
        JButton btnLogin = new JButton("INICIAR SESIÓN");
        btnLogin.setBounds(145, 461, 225, 43);
        panel.add(btnLogin);
        btnLogin.setFont(new Font("Dubai", Font.BOLD, 20));
        btnLogin.setBackground(new Color(254, 163, 181));
        btnLogin.setForeground(new Color(255, 255, 255));
        
        
        
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MetodosTeresita mt = new MetodosTeresita();
                String usuario = txtu.getText();
                String pass = String.valueOf(txtc.getPassword());
                
                if (usuario.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tienes campos vacíos");
                } else {
                    Connection conectar = null;
                    PreparedStatement ps = null;
                    ResultSet rs = null;
                    try {
                        Conexion conexion = new Conexion(); // Crear una instancia de Conexion
                        conectar = conexion.conectar(); // Conectar a la base de datos
                        
                        String usserCorrecto = null;
                        String passCorrecta = null;
                        String tipo = null;

                        ps = conectar.prepareStatement("SELECT username, password, tipo FROM usuario WHERE username=?");
                        ps.setString(1, usuario);
                        rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            usserCorrecto = rs.getString(1);
                            passCorrecta = rs.getString(2);
                            tipo = rs.getString(3);
                        }

                        if (usserCorrecto != null && pass != null && pass.equals(passCorrecta)) {
                            if (tipo != null) {
                                if (tipo.equalsIgnoreCase("ADMIN")) {
                                    JOptionPane.showMessageDialog(null, "¡BIENVENIDO, ADMIN!");
                  
                                    // Redirigir a la interfaz de Admin
                                    PL.dispose();
                                } else if (tipo.equalsIgnoreCase("VENDEDOR")) {
                                    JOptionPane.showMessageDialog(null, "¡BIENVENIDO, VENDEDOR!");
                                    // Redirigir a la interfaz de Vendedor
                                    PL.dispose();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                        }

                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, "Acceso Denegado");
                    } finally {
                        // Cerrar recursos
                        try {
                            if (rs != null) rs.close();
                            if (ps != null) ps.close();
                            if (conectar != null) conectar.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        });

        fondo = new JLabel("            ");
        fondo.setBounds(0, 0, 1026, 747);
        PL.getContentPane().add(fondo);
        Image foto = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/fondo.png"));
        fondo.setIcon(new ImageIcon(foto.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
    }
}
