package Vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class AdminProductos {

    private JFrame PLP;
    private JTextField txtnomp;
    private JTextField txttamano;
    private JTextField txtcostoc;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminProductos window = new AdminProductos();
                    window.PLP.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminProductos() {
        initialize();
    }

    private void initialize() {
        PLP = new JFrame();
        PLP.setTitle("ADMIN — PRODUCTOS");
        PLP.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminProductos.class.getResource("/img/08TeresitaLogo.png")));
        PLP.setBounds(100, 100, 1184, 866);
        PLP.setLocationRelativeTo(null);
        PLP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null); // Establecer layout a null
        panel.setBackground(new Color(253, 242, 249));
        PLP.getContentPane().add(panel);
        
        JLabel lblp = new JLabel("PRODUCTOS");
        lblp.setForeground(new Color(128, 128, 128));
        lblp.setHorizontalAlignment(SwingConstants.CENTER);
        lblp.setFont(new Font("Dubai", Font.BOLD, 22));
        lblp.setBounds(430, 114, 200, 50); // Cambia la posición y el tamaño
        panel.add(lblp);
        
        JLabel lblt = new JLabel("");
        lblt.setBounds(470, 10, 110, 110);
        panel.add(lblt);
        Image foto = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/08TeresitaLogo.png"));
        lblt.setIcon(new ImageIcon(foto.getScaledInstance(lblt.getWidth(), lblt.getHeight(), Image.SCALE_SMOOTH)));
        
        JLabel lblnomp = new JLabel("NOMBRE");
        lblnomp.setForeground(new Color(249, 128, 170));
        lblnomp.setHorizontalAlignment(SwingConstants.CENTER);
        lblnomp.setFont(new Font("Dubai", Font.BOLD, 17));
        lblnomp.setBounds(115, 207, 119, 28);
        panel.add(lblnomp);
        
        txtnomp = new JTextField();
        txtnomp.setFont(new Font("Dubai", Font.BOLD, 18));
        txtnomp.setBounds(62, 245, 225, 38);
        panel.add(txtnomp);
        txtnomp.setColumns(10);
        
        JLabel lbltamano = new JLabel("TAMAÑO");
        lbltamano.setHorizontalAlignment(SwingConstants.CENTER);
        lbltamano.setForeground(new Color(249, 128, 170));
        lbltamano.setFont(new Font("Dubai", Font.BOLD, 17));
        lbltamano.setBounds(399, 207, 119, 28);
        panel.add(lbltamano);
        
        txttamano = new JTextField();
        txttamano.setFont(new Font("Dubai", Font.BOLD, 18));
        txttamano.setColumns(10);
        txttamano.setBounds(355, 245, 225, 38);
        panel.add(txttamano);
        
        JLabel lblcostoc = new JLabel("COSTO (C)");
        lblcostoc.setHorizontalAlignment(SwingConstants.CENTER);
        lblcostoc.setForeground(new Color(249, 128, 170));
        lblcostoc.setFont(new Font("Dubai", Font.BOLD, 17));
        lblcostoc.setBounds(676, 207, 119, 28);
        panel.add(lblcostoc);
        
        txtcostoc = new JTextField();
        txtcostoc.setFont(new Font("Dubai", Font.BOLD, 18));
        txtcostoc.setColumns(10);
        txtcostoc.setBounds(624, 245, 225, 38);
        panel.add(txtcostoc);
        
        JLabel lblCostov = new JLabel("COSTO (V)");
        lblCostov.setHorizontalAlignment(SwingConstants.CENTER);
        lblCostov.setForeground(new Color(249, 128, 170));
        lblCostov.setFont(new Font("Dubai", Font.BOLD, 17));
        lblCostov.setBounds(940, 207, 119, 28);
        panel.add(lblCostov);
        
        textField = new JTextField();
        textField.setFont(new Font("Dubai", Font.BOLD, 18));
        textField.setColumns(10);
        textField.setBounds(880, 245, 225, 38);
        panel.add(textField);
    }
}
