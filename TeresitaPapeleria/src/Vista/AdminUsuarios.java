package Vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import Controlador.MetodosTeresita;
import Modelo.Conexion;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.BorderLayout;

public class AdminUsuarios {

	private JFrame PLU;
	private JTextField txtidu;
	private JTextField txtnombre;
	private JTextField txtap;
	private JTextField txtam;
	private JTextField txtusername;
	private JTextField txtpass;
	private JTextField txttc;
	private JTextField txttipo;
	private JTextField txtiddir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUsuarios window = new AdminUsuarios();
					window.PLU.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PLU = new JFrame();
		PLU.getContentPane().setBackground(new Color(255, 234, 248));
		PLU.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminUsuarios.class.getResource("/img/08TeresitaLogo.png")));
		PLU.setTitle("ADMIN — USUARIOS");
		PLU.setBounds(100, 100, 940, 884);
		PLU.setLocationRelativeTo(null);
		
		PLU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	     JPanel panel = new JPanel();
	        panel.setLayout(null); // Establecer layout a null
	        panel.setBackground(new Color(253, 242, 249));
	        PLU.getContentPane().add(panel);
	        
	        JLabel lblp = new JLabel("USUARIOS");
	        lblp.setForeground(new Color(128, 128, 128));
	        lblp.setHorizontalAlignment(SwingConstants.CENTER);
	        lblp.setFont(new Font("Dubai", Font.BOLD, 20));
	        lblp.setBounds(405, 99, 200, 50); // Cambia la posición y el tamaño
	        panel.add(lblp);
	        
	        JLabel lblt = new JLabel("");
	        lblt.setBounds(442, 0, 119, 110);
	        panel.add(lblt);
	        Image foto = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/08TeresitaLogo.png"));
	        lblt.setIcon(new ImageIcon(foto.getScaledInstance(lblt.getWidth(), lblt.getHeight(), Image.SCALE_SMOOTH)));
		
	        JLabel lbl = new JLabel("ID");
	        lbl.setHorizontalAlignment(SwingConstants.CENTER);
	        lbl.setForeground(new Color(249, 128, 170));
	        lbl.setFont(new Font("Dubai", Font.BOLD, 17));
	        lbl.setBounds(110, 29, 119, 28);
	        panel.add(lbl);
	      

	        
	        JLabel lblnomp = new JLabel("NOMBRE");
	        lblnomp.setForeground(new Color(249, 128, 170));
	        lblnomp.setHorizontalAlignment(SwingConstants.CENTER);
	        lblnomp.setFont(new Font("Dubai", Font.BOLD, 17));
	        lblnomp.setBounds(110, 127, 119, 28);
	        panel.add(lblnomp);
	        
	      
	        
	        JLabel lbltamano = new JLabel("APELLIDO PATERNO\r\n");
	        lbltamano.setHorizontalAlignment(SwingConstants.CENTER);
	        lbltamano.setForeground(new Color(249, 128, 170));
	        lbltamano.setFont(new Font("Dubai", Font.BOLD, 17));
	        lbltamano.setBounds(91, 220, 173, 28);
	        panel.add(lbltamano);
	        
	       
	        
	        JLabel lblcostoc = new JLabel("APELLIDO MATERNO");
	        lblcostoc.setHorizontalAlignment(SwingConstants.CENTER);
	        lblcostoc.setForeground(new Color(249, 128, 170));
	        lblcostoc.setFont(new Font("Dubai", Font.BOLD, 17));
	        lblcostoc.setBounds(91, 319, 173, 28);
	        panel.add(lblcostoc);
	        
	     
	        JLabel lblCostov = new JLabel("USERNAME");
	        lblCostov.setHorizontalAlignment(SwingConstants.CENTER);
	        lblCostov.setForeground(new Color(249, 128, 170));
	        lblCostov.setFont(new Font("Dubai", Font.BOLD, 17));
	        lblCostov.setBounds(110, 414, 119, 28);
	        panel.add(lblCostov);
	        
	 
	        
	        JLabel lblcant = new JLabel("TELÉFONO CELULAR");
	        lblcant.setHorizontalAlignment(SwingConstants.CENTER);
	        lblcant.setForeground(new Color(249, 128, 170));
	        lblcant.setFont(new Font("Dubai", Font.BOLD, 17));
	        lblcant.setBounds(81, 591, 167, 28);
	        panel.add(lblcant);
	        
	      
	        
	        
	        //TABLA CON LISTENER
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setFont(new Font("Dubai", Font.BOLD, 15));
	        scrollPane.setBounds(332, 159, 557, 518);
	        panel.add(scrollPane);

	        JTable tablausuarios = new JTable();
	        tablausuarios.setBackground(Color.WHITE); // Fondo blanco
	        tablausuarios.setForeground(new Color(128, 128, 128)); // Texto gris
	        tablausuarios.setFont(new Font("Dubai", Font.BOLD, 15)); // Fuente Dubai Bold 15
	        tablausuarios.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                PreparedStatement ps = null;
	                ResultSet rs = null;
	             
	                try {
	                    Conexion cx = new Conexion();
	                    Connection cn = cx.conectar();
	                    int fila = tablausuarios.getSelectedRow();
	                    String idp = tablausuarios.getValueAt(fila, 0).toString();
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
	        tablausuarios.setModel(new DefaultTableModel(
	            new Object[][] {},
	            new String[] {}
	        ));
	        scrollPane.setViewportView(tablausuarios);

	        try {
	            DefaultTableModel modelo = new DefaultTableModel();
	            tablausuarios.setModel(modelo);
	            
	            txtidu = new JTextField();
	            txtidu.setEnabled(false);
	            txtidu.setHorizontalAlignment(SwingConstants.CENTER);
	            txtidu.setForeground(Color.GRAY);
	            txtidu.setFont(new Font("Dubai", Font.BOLD, 16));
	            txtidu.setColumns(10);
	            txtidu.setBounds(58, 96, 225, 38);
	            panel.add(txtidu);
	            
	            
	            
	            //REGISTRAR PRODUCTO
	            JButton btnRegistrar = new JButton("REGISTRAR");
	            btnRegistrar.addActionListener(new ActionListener() {
	            	public void actionPerformed(ActionEvent e) {
	            				MetodosTeresita mt=new MetodosTeresita();
	            				
	            				
	            				String nombre = txtnombre.getText();
	            				String ap = txtap.getText();
	            				String am = txtam.getText();
	            				String username = txtusername.getText();
	            				String password = txtpass.getText();
	            				int tc = Integer.parseInt(txttc.getText());
	            				String tipo = txttipo.getText();
	            				int idDir = Integer.parseInt(txtiddir.getText());

	            				mt.setNombre(nombre);
	            				mt.setAp(ap);
	            				mt.setAm(am);
	            				mt.setUsername(username);
	            				mt.setPassword(password);
	            				mt.setTc(tc);
	            				mt.setTipo(tipo);
	            				mt.setIddir(idDir);

	            			        
	            				if (nombre.isEmpty() || ap.isEmpty() || am.isEmpty() || username.isEmpty() || 
	            					    password.isEmpty() || tipo.isEmpty()) {
	            					JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
	            				}else {
	            					
	            				
	            				if(mt.insertarProducto()) {
	            					JOptionPane.showMessageDialog(null, "¡USUARIO REGISTRADO ÉXITOSAMENTE!");
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
	    				lbl.setVisible(true);
	    				txtid.setVisible(true);
	    				try {
	    					Conexion cx=new Conexion();
	    					Connection cn=cx.conectar();
	    					int fila=tablausuarios.getSelectedRow();
	    					String idp=tablausuarios.getValueAt(fila, 0).toString();
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
	    					tablausuarios.setModel(modelo);
	    					
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
	            
	            txtidu = new JTextField();
	            txtidu.setHorizontalAlignment(SwingConstants.CENTER);
	            txtidu.setForeground(Color.GRAY);
	            txtidu.setFont(new Font("Dubai", Font.BOLD, 16));
	            txtidu.setEnabled(false);
	            txtidu.setColumns(10);
	            txtidu.setBounds(53, 54, 225, 38);
	            panel.add(txtidu);
	            
	            txtnombre = new JTextField();
	            txtnombre.setHorizontalAlignment(SwingConstants.CENTER);
	            txtnombre.setForeground(Color.GRAY);
	            txtnombre.setFont(new Font("Dubai", Font.BOLD, 16));
	            txtnombre.setColumns(10);
	            txtnombre.setBounds(53, 156, 225, 38);
	            panel.add(txtnombre);
	            
	            txtap = new JTextField();
	            txtap.setHorizontalAlignment(SwingConstants.CENTER);
	            txtap.setForeground(Color.GRAY);
	            txtap.setFont(new Font("Dubai", Font.BOLD, 16));
	            txtap.setColumns(10);
	            txtap.setBounds(53, 258, 225, 38);
	            panel.add(txtap);
	            
	            txtam = new JTextField();
	            txtam.setHorizontalAlignment(SwingConstants.CENTER);
	            txtam.setForeground(Color.GRAY);
	            txtam.setFont(new Font("Dubai", Font.BOLD, 16));
	            txtam.setColumns(10);
	            txtam.setBounds(53, 347, 225, 38);
	            panel.add(txtam);
	            
	            txtusername = new JTextField();
	            txtusername.setHorizontalAlignment(SwingConstants.CENTER);
	            txtusername.setForeground(Color.GRAY);
	            txtusername.setFont(new Font("Dubai", Font.BOLD, 16));
	            txtusername.setColumns(10);
	            txtusername.setBounds(53, 442, 225, 38);
	            panel.add(txtusername);
	            
	            JLabel lblContrasea = new JLabel("CONTRASEÑA");
	            lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
	            lblContrasea.setForeground(new Color(249, 128, 170));
	            lblContrasea.setFont(new Font("Dubai", Font.BOLD, 17));
	            lblContrasea.setBounds(91, 502, 173, 28);
	            panel.add(lblContrasea);
	            
	            txtpass = new JTextField();
	            txtpass.setHorizontalAlignment(SwingConstants.CENTER);
	            txtpass.setForeground(Color.GRAY);
	            txtpass.setFont(new Font("Dubai", Font.BOLD, 16));
	            txtpass.setColumns(10);
	            txtpass.setBounds(53, 528, 225, 38);
	            panel.add(txtpass);
	            
	            txttc = new JTextField();
	            txttc.setHorizontalAlignment(SwingConstants.CENTER);
	            txttc.setForeground(Color.GRAY);
	            txttc.setFont(new Font("Dubai", Font.BOLD, 16));
	            txttc.setColumns(10);
	            txttc.setBounds(53, 618, 225, 38);
	            panel.add(txttc);
	            
	            JLabel lblTipo = new JLabel("TIPO");
	            lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
	            lblTipo.setForeground(new Color(249, 128, 170));
	            lblTipo.setFont(new Font("Dubai", Font.BOLD, 17));
	            lblTipo.setBounds(81, 666, 167, 28);
	            panel.add(lblTipo);
	            
	            txttipo = new JTextField();
	            txttipo.setHorizontalAlignment(SwingConstants.CENTER);
	            txttipo.setForeground(Color.GRAY);
	            txttipo.setFont(new Font("Dubai", Font.BOLD, 16));
	            txttipo.setColumns(10);
	            txttipo.setBounds(53, 698, 225, 38);
	            panel.add(txttipo);
	            
	            JLabel lblIdDireccin = new JLabel("ID DIRECCIÓN");
	            lblIdDireccin.setHorizontalAlignment(SwingConstants.CENTER);
	            lblIdDireccin.setForeground(new Color(249, 128, 170));
	            lblIdDireccin.setFont(new Font("Dubai", Font.BOLD, 17));
	            lblIdDireccin.setBounds(81, 746, 167, 28);
	            panel.add(lblIdDireccin);
	            
	            txtiddir = new JTextField();
	            txtiddir.setHorizontalAlignment(SwingConstants.CENTER);
	            txtiddir.setForeground(Color.GRAY);
	            txtiddir.setFont(new Font("Dubai", Font.BOLD, 16));
	            txtiddir.setColumns(10);
	            txtiddir.setBounds(53, 770, 225, 38);
	            panel.add(txtiddir);
	            
	            JButton btnRegistrar_1 = new JButton("REGISTRAR");
	            btnRegistrar_1.setForeground(Color.WHITE);
	            btnRegistrar_1.setFont(new Font("Dubai", Font.BOLD, 18));
	            btnRegistrar_1.setBackground(new Color(255, 128, 172));
	            btnRegistrar_1.setBounds(332, 739, 148, 43);
	            panel.add(btnRegistrar_1);
	            
	            JButton btnEditar_1 = new JButton("EDITAR");
	            btnEditar_1.setForeground(Color.WHITE);
	            btnEditar_1.setFont(new Font("Dubai", Font.BOLD, 18));
	            btnEditar_1.setBackground(new Color(155, 155, 155));
	            btnEditar_1.setBounds(535, 739, 148, 43);
	            panel.add(btnEditar_1);
	            
	            JButton btnEliminar_1 = new JButton("ELIMINAR");
	            btnEliminar_1.setForeground(Color.WHITE);
	            btnEliminar_1.setFont(new Font("Dubai", Font.BOLD, 18));
	            btnEliminar_1.setBackground(new Color(255, 128, 172));
	            btnEliminar_1.setBounds(740, 739, 148, 43);
	            panel.add(btnEliminar_1);


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
