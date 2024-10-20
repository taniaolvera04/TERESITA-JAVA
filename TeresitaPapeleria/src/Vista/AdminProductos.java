package Vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import Controlador.MetodosTeresita;
import Modelo.Conexion;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminProductos {

    private JFrame PLP;
    private JTextField txtnomp;
    private JTextField txttamano;
    private JTextField txtcostoc;
    private JTextField txtcostov;
    private JTextField txtstock;
    private JTable table;
    private JTextField txtid;

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
        PLP.setBounds(100, 100, 1164, 770);
        PLP.setLocationRelativeTo(null);
        PLP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null); // Establecer layout a null
        panel.setBackground(new Color(253, 242, 249));
        PLP.getContentPane().add(panel);
        
        JLabel lblp = new JLabel("PRODUCTOS");
        lblp.setForeground(new Color(128, 128, 128));
        lblp.setHorizontalAlignment(SwingConstants.CENTER);
        lblp.setFont(new Font("Dubai", Font.BOLD, 20));
        lblp.setBounds(469, 97, 200, 50); // Cambia la posición y el tamaño
        panel.add(lblp);
        
        JLabel lblt = new JLabel("");
        lblt.setBounds(514, 0, 119, 110);
        panel.add(lblt);
        Image foto = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/08TeresitaLogo.png"));
        lblt.setIcon(new ImageIcon(foto.getScaledInstance(lblt.getWidth(), lblt.getHeight(), Image.SCALE_SMOOTH)));
	
        
		
        JLabel lbl = new JLabel("ID");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setForeground(new Color(249, 128, 170));
        lbl.setFont(new Font("Dubai", Font.BOLD, 17));
        lbl.setBounds(110, 71, 119, 28);
        panel.add(lbl);
      

        
        JLabel lblnomp = new JLabel("NOMBRE");
        lblnomp.setForeground(new Color(249, 128, 170));
        lblnomp.setHorizontalAlignment(SwingConstants.CENTER);
        lblnomp.setFont(new Font("Dubai", Font.BOLD, 17));
        lblnomp.setBounds(110, 164, 119, 28);
        panel.add(lblnomp);
        
        txtnomp = new JTextField();
        txtnomp.setForeground(new Color(128, 128, 128));
        txtnomp.setHorizontalAlignment(SwingConstants.CENTER);
        txtnomp.setFont(new Font("Dubai", Font.BOLD, 16));
        txtnomp.setBounds(58, 197, 225, 38);
        panel.add(txtnomp);
        txtnomp.setColumns(10);
        
        JLabel lbltamano = new JLabel("TAMAÑO (CM,G,ML)");
        lbltamano.setHorizontalAlignment(SwingConstants.CENTER);
        lbltamano.setForeground(new Color(249, 128, 170));
        lbltamano.setFont(new Font("Dubai", Font.BOLD, 17));
        lbltamano.setBounds(86, 270, 173, 28);
        panel.add(lbltamano);
        
        txttamano = new JTextField();
        txttamano.setForeground(new Color(128, 128, 128));
        txttamano.setHorizontalAlignment(SwingConstants.CENTER);
        txttamano.setFont(new Font("Dubai", Font.BOLD, 16));
        txttamano.setColumns(10);
        txttamano.setBounds(58, 308, 225, 38);
        panel.add(txttamano);
        
        JLabel lblcostoc = new JLabel("COSTO (C)");
        lblcostoc.setHorizontalAlignment(SwingConstants.CENTER);
        lblcostoc.setForeground(new Color(249, 128, 170));
        lblcostoc.setFont(new Font("Dubai", Font.BOLD, 17));
        lblcostoc.setBounds(110, 385, 119, 28);
        panel.add(lblcostoc);
        
        txtcostoc = new JTextField();
        txtcostoc.setForeground(new Color(128, 128, 128));
        txtcostoc.setHorizontalAlignment(SwingConstants.CENTER);
        txtcostoc.setFont(new Font("Dubai", Font.BOLD, 16));
        txtcostoc.setColumns(10);
        txtcostoc.setBounds(58, 423, 225, 38);
        panel.add(txtcostoc);
        
        JLabel lblCostov = new JLabel("COSTO (V)");
        lblCostov.setHorizontalAlignment(SwingConstants.CENTER);
        lblCostov.setForeground(new Color(249, 128, 170));
        lblCostov.setFont(new Font("Dubai", Font.BOLD, 17));
        lblCostov.setBounds(110, 495, 119, 28);
        panel.add(lblCostov);
        
        txtcostov = new JTextField();
        txtcostov.setForeground(new Color(128, 128, 128));
        txtcostov.setHorizontalAlignment(SwingConstants.CENTER);
        txtcostov.setFont(new Font("Dubai", Font.BOLD, 16));
        txtcostov.setColumns(10);
        txtcostov.setBounds(58, 528, 225, 38);
        panel.add(txtcostov);
        
        JLabel lblcant = new JLabel("CANTIDAD");
        lblcant.setHorizontalAlignment(SwingConstants.CENTER);
        lblcant.setForeground(new Color(249, 128, 170));
        lblcant.setFont(new Font("Dubai", Font.BOLD, 17));
        lblcant.setBounds(110, 609, 119, 28);
        panel.add(lblcant);
        
        txtstock = new JTextField();
        txtstock.setForeground(new Color(128, 128, 128));
        txtstock.setHorizontalAlignment(SwingConstants.CENTER);
        txtstock.setFont(new Font("Dubai", Font.BOLD, 16));
        txtstock.setColumns(10);
        txtstock.setBounds(58, 641, 225, 38);
        panel.add(txtstock);
        
        
        //TABLA CON LISTENER
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setFont(new Font("Dubai", Font.BOLD, 15));
        scrollPane.setBounds(340, 157, 534, 488);
        panel.add(scrollPane);

        JTable tablap = new JTable();
        tablap.setBackground(Color.WHITE); // Fondo blanco
        tablap.setForeground(new Color(128, 128, 128)); // Texto gris
        tablap.setFont(new Font("Dubai", Font.BOLD, 15)); // Fuente Dubai Bold 15
        tablap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PreparedStatement ps = null;
                ResultSet rs = null;
                lbl.setVisible(true);
                txtid.setVisible(true);
                try {
                    Conexion cx = new Conexion();
                    Connection cn = cx.conectar();
                    int fila = tablap.getSelectedRow();
                    String idp = tablap.getValueAt(fila, 0).toString();
                    ps = cn.prepareStatement("SELECT id_p, nombrep, tamano, costoc, costov, stock FROM producto WHERE id_p=?");
                    ps.setString(1, idp);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        txtid.setText(rs.getString("id_p"));
                        txtnomp.setText(rs.getString("nombrep"));
                        txttamano.setText(rs.getString("tamano"));
                        txtcostoc.setText(rs.getString("costoc"));
                        txtcostov.setText(rs.getString("costov"));
                        txtstock.setText(rs.getString("stock"));
                    }

                } catch (Exception e2) {
                    System.out.println(e2.toString());
                }
            }
        });
        tablap.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {}
        ));
        scrollPane.setViewportView(tablap);

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tablap.setModel(modelo);
            
            txtid = new JTextField();
            txtid.setEnabled(false);
            txtid.setHorizontalAlignment(SwingConstants.CENTER);
            txtid.setForeground(Color.GRAY);
            txtid.setFont(new Font("Dubai", Font.BOLD, 16));
            txtid.setColumns(10);
            txtid.setBounds(58, 96, 225, 38);
            panel.add(txtid);
            
            
            
            //REGISTRAR PRODUCTO
            JButton btnRegistrar = new JButton("REGISTRAR");
            btnRegistrar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            				MetodosTeresita mt=new MetodosTeresita();
            				String nombrep=txtnomp.getText();
            				double costoc=Double.parseDouble(txtcostoc.getText());
            				double costov=Double.parseDouble(txtcostov.getText());
            				String tamano=txttamano.getText();
            				int stock=Integer.parseInt(txtstock.getText());
            				
            				mt.setNombrep(nombrep);
            				mt.setTamano(tamano);
            				mt.setCostoc(costoc);
            				mt.setCostov(costov);
            				mt.setStock(stock);
            				if(nombrep.isEmpty() || tamano.isEmpty()){
            					JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
            				}else {
            					
            				
            				if(mt.insertarProducto()) {
            					JOptionPane.showMessageDialog(null, "¡PRODUCTO REGISTRADO ÉXITOSAMENTE!");
            				}else {
            					JOptionPane.showMessageDialog(null, "¡ERROR AL REGISTRAR!");
            				}
            				}
            				
            	}
            });
            btnRegistrar.setBackground(new Color(255, 128, 172)); 
            btnRegistrar.setForeground(new Color(255, 255, 255)); 
            btnRegistrar.setFont(new Font("Dubai", Font.BOLD, 18));
            btnRegistrar.setBounds(948, 213, 148, 43);
            panel.add(btnRegistrar);
            
            
            //BOTON DE EDITAR
            
            JButton btnEditar = new JButton("EDITAR");
            btnEditar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		MetodosTeresita mt=new 	MetodosTeresita();
    				
    				String nombrep=txtnomp.getText();
    				double costoc=Double.parseDouble(txtcostoc.getText());
    				double costov=Double.parseDouble(txtcostov.getText());
    				String tamano=txttamano.getText();
    				int stock=Integer.parseInt(txtstock.getText());
    				
    				mt.setNombrep(nombrep);
    				mt.setTamano(tamano);
    				mt.setCostoc(costoc);
    				mt.setCostov(costov);
    				mt.setStock(stock);
    				mt.setIdp(Integer.parseInt(txtid.getText()));
    				
    				if(mt.actualizarProducto()) {
    					JOptionPane.showMessageDialog(null, "¡ACTUALIZACIÓN EXITOSA!");
    					
    				}else {       
    					JOptionPane.showMessageDialog(null, "¡ERROR!");
    				}
            	}
            });
            btnEditar.setForeground(Color.WHITE);
            btnEditar.setFont(new Font("Dubai", Font.BOLD, 18));
            btnEditar.setBackground(new Color(155, 155, 155));
            btnEditar.setBounds(948, 370, 148, 43);
            panel.add(btnEditar);
            
            JButton btnEliminar = new JButton("ELIMINAR");
            btnEliminar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		PreparedStatement ps=null;
    				DefaultTableModel modelo=new DefaultTableModel();
    			
    				try {
    					Conexion cx=new Conexion();
    					Connection cn=cx.conectar();
    					int fila=tablap.getSelectedRow();
    					String idp=tablap.getValueAt(fila, 0).toString();
    		         	ps=cn.prepareStatement("DELETE FROM producto WHERE id_p=?");
    					ps.setString(1, idp);
    					ps.execute();
    					 txtid.setText("");
                         txtnomp.setText("");
                         txttamano.setText("");
                         txtcostoc.setText("");
                         txtcostov.setText("");
                         txtstock.setText("");
                        JOptionPane.showMessageDialog(null, "EL PRODUCTO SE ELIMINÓ");
    		

    					}catch(Exception e2) {
    						System.out.println(e2.toString());

    					
    			}
            	}
            });
            btnEliminar.setForeground(Color.WHITE);
            btnEliminar.setFont(new Font("Dubai", Font.BOLD, 18));
            btnEliminar.setBackground(new Color(255, 128, 172));
            btnEliminar.setBounds(948, 526, 148, 43);
            panel.add(btnEliminar);
            
            JButton btnCargar = new JButton("*");
            btnCargar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		try {
    					DefaultTableModel modelo=new DefaultTableModel();
    					tablap.setModel(modelo);
    					
    					PreparedStatement ps=null;
    					ResultSet rs=null;
    					
    					Conexion cn=new Conexion();
    					Connection conectar=cn.conectar();
    					
    					String sql="SELECT * FROM producto";
    					ps=conectar.prepareStatement(sql);
    					rs=ps.executeQuery();
    					
    					
    					ResultSetMetaData rmds=(ResultSetMetaData)rs.getMetaData();
    					int cantcol=rmds.getColumnCount();
    					modelo.addColumn("ID_P");
    					modelo.addColumn("NOMBRE");
    					modelo.addColumn("TAMAÑO");
    					modelo.addColumn("COSTO (C)");
    					modelo.addColumn("COSTO (V)");
    					modelo.addColumn("CANTIDAD");
    					
    					while(rs.next()) {
    						Object[]filas=new Object[cantcol];
    						for(int i=0;i<cantcol;i++) {
    							filas[i]=rs.getObject(i+1);
    						}
    						modelo.addRow(filas);
    					}
    					
    				}catch(SQLException ex) {
    					System.err.println(ex.getMessage());
    					
    				}
            	}
            });
            btnCargar.setForeground(new Color(255, 255, 255));
            btnCargar.setFont(new Font("Dubai", Font.BOLD, 18));
            btnCargar.setBackground(new Color(155, 155, 155));
            btnCargar.setBounds(823, 102, 51, 43);
            panel.add(btnCargar);


            PreparedStatement ps = null;
            ResultSet rs = null;

            Conexion cn = new Conexion();
            Connection conectar = cn.conectar();

            String sql = "SELECT id_p, nombrep, tamano, costoc, costov, stock FROM producto";
            ps = conectar.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rmds = (ResultSetMetaData) rs.getMetaData();
            int cantcol = rmds.getColumnCount();
            modelo.addColumn("ID_P");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("TAMAÑO");
            modelo.addColumn("COSTO (C)");
            modelo.addColumn("COSTO (V)");
            modelo.addColumn("CANTIDAD");

            while (rs.next()) {
                Object[] filas = new Object[cantcol];
                for (int i = 0; i < cantcol; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }


    }
}
