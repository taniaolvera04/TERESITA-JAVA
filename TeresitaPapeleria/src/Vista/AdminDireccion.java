package Vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import Controlador.MetodosTeresita;
import Modelo.Conexion;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDireccion {

    private JFrame dir;
    private JTextField txtiddir;
    private JTextField txtcalle;
    private JTextField txtcol;
    private JTextField txtnumero;
    private JTextField txtcp;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminDireccion window = new AdminDireccion();
                    window.dir.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminDireccion() {
        initialize();
    }

    private void initialize() {
        dir = new JFrame();
        dir.getContentPane().setBackground(new Color(255, 255, 255));
        dir.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminDireccion.class.getResource("/img/08TeresitaLogo.png")));
        dir.setTitle("ADMIN — DIRECCIÓN");
        dir.setResizable(false);
        dir.setBounds(100, 100, 904, 680);
        dir.setLocationRelativeTo(null);
        dir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        dir.getContentPane().setLayout(null);
        
        
        
        JLabel lblp = new JLabel("DIRECCIÓN");
        lblp.setBackground(new Color(255, 221, 222));
        lblp.setForeground(new Color(255, 113, 181));
        lblp.setHorizontalAlignment(SwingConstants.CENTER);
        lblp.setFont(new Font("Dubai", Font.BOLD, 20));
        lblp.setBounds(332, 104, 200, 50); 
        dir.getContentPane().add(lblp);
        
        JLabel lblt = new JLabel("");
        lblt.setBounds(377, 0, 119, 110);
        dir.getContentPane().add(lblt);
        Image foto = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/08TeresitaLogo.png"));
        lblt.setIcon(new ImageIcon(foto.getScaledInstance(lblt.getWidth(), lblt.getHeight(), Image.SCALE_SMOOTH)));
        
        JLabel lblid = new JLabel("ID");
        lblid.setHorizontalAlignment(SwingConstants.CENTER);
        lblid.setForeground(new Color(249, 128, 170));
        lblid.setFont(new Font("Dubai", Font.BOLD, 17));
        lblid.setBounds(75, 82, 119, 28);
        dir.getContentPane().add(lblid);
        
        txtiddir = new JTextField();
        txtiddir.setHorizontalAlignment(SwingConstants.CENTER);
        txtiddir.setForeground(Color.GRAY);
        txtiddir.setFont(new Font("Dubai", Font.BOLD, 16));
        txtiddir.setEnabled(false);
        txtiddir.setColumns(10);
        txtiddir.setBounds(28, 116, 225, 38);
        dir.getContentPane().add(txtiddir);
        
        JLabel lblCalle = new JLabel("CALLE");
        lblCalle.setHorizontalAlignment(SwingConstants.CENTER);
        lblCalle.setForeground(new Color(249, 128, 170));
        lblCalle.setFont(new Font("Dubai", Font.BOLD, 17));
        lblCalle.setBounds(75, 189, 119, 28);
        dir.getContentPane().add(lblCalle);
        
        txtcalle = new JTextField();
        txtcalle.setBackground(new Color(255, 242, 254));
        txtcalle.setHorizontalAlignment(SwingConstants.CENTER);
        txtcalle.setForeground(Color.GRAY);
        txtcalle.setFont(new Font("Dubai", Font.BOLD, 16));
        txtcalle.setColumns(10);
        txtcalle.setBounds(28, 227, 225, 38);
        dir.getContentPane().add(txtcalle);
        
        JLabel lblCol = new JLabel("COL");
        lblCol.setHorizontalAlignment(SwingConstants.CENTER);
        lblCol.setForeground(new Color(249, 128, 170));
        lblCol.setFont(new Font("Dubai", Font.BOLD, 17));
        lblCol.setBounds(75, 293, 119, 28);
        dir.getContentPane().add(lblCol);
        
        txtcol = new JTextField();
        txtcol.setHorizontalAlignment(SwingConstants.CENTER);
        txtcol.setForeground(Color.GRAY);
        txtcol.setFont(new Font("Dubai", Font.BOLD, 16));
        txtcol.setColumns(10);
        txtcol.setBackground(new Color(255, 242, 254));
        txtcol.setBounds(28, 325, 225, 38);
        dir.getContentPane().add(txtcol);
        
        JLabel lblNmero = new JLabel("NÚMERO");
        lblNmero.setHorizontalAlignment(SwingConstants.CENTER);
        lblNmero.setForeground(new Color(249, 128, 170));
        lblNmero.setFont(new Font("Dubai", Font.BOLD, 17));
        lblNmero.setBounds(75, 396, 119, 28);
        dir.getContentPane().add(lblNmero);
        
        txtnumero = new JTextField();
        txtnumero.setHorizontalAlignment(SwingConstants.CENTER);
        txtnumero.setForeground(Color.GRAY);
        txtnumero.setFont(new Font("Dubai", Font.BOLD, 16));
        txtnumero.setColumns(10);
        txtnumero.setBackground(new Color(255, 242, 254));
        txtnumero.setBounds(28, 434, 225, 38);
        dir.getContentPane().add(txtnumero);
        
        JLabel lblCdigoPostal = new JLabel("CÓDIGO POSTAL");
        lblCdigoPostal.setHorizontalAlignment(SwingConstants.CENTER);
        lblCdigoPostal.setForeground(new Color(249, 128, 170));
        lblCdigoPostal.setFont(new Font("Dubai", Font.BOLD, 17));
        lblCdigoPostal.setBounds(68, 497, 146, 28);
        dir.getContentPane().add(lblCdigoPostal);
        
        txtcp = new JTextField();
        txtcp.setHorizontalAlignment(SwingConstants.CENTER);
        txtcp.setForeground(Color.GRAY);
        txtcp.setFont(new Font("Dubai", Font.BOLD, 16));
        txtcp.setColumns(10);
        txtcp.setBackground(new Color(255, 242, 254));
        txtcp.setBounds(28, 535, 225, 38);
        dir.getContentPane().add(txtcp);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setFont(new Font("Dubai", Font.BOLD, 15));
        scrollPane.setBounds(312, 172, 533, 373);
        dir.getContentPane().add(scrollPane);
        
        
        JTable tabladir = new JTable();
        tabladir.setBackground(Color.WHITE); 
        tabladir.setForeground(new Color(128, 128, 128)); 
        tabladir.setFont(new Font("Dubai", Font.BOLD, 15)); 
        tabladir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PreparedStatement ps = null;
                ResultSet rs = null;
             
                try {
                    Conexion cx = new Conexion();
                    Connection cn = cx.conectar();
                    int fila = tabladir.getSelectedRow();
                    String iddir = tabladir.getValueAt(fila, 0).toString();
                    ps = cn.prepareStatement("SELECT id_dir, calle, col, numero, cp FROM direccion WHERE id_dir=?");
                    ps.setString(1, iddir);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        txtiddir.setText(rs.getString("id_dir"));
                        txtcalle.setText(rs.getString("calle"));
                        txtcol.setText(rs.getString("col"));
                        txtnumero.setText(rs.getString("numero"));
                        txtcp.setText(rs.getString("cp"));
                      
                    }

                } catch (Exception e2) {
                    System.out.println(e2.toString());
                }
            }
        });
        tabladir.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {}
        ));
        scrollPane.setViewportView(tabladir);
        
	
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tabladir.setModel(modelo);
            
            JButton btnRegistrar = new JButton("REGISTRAR");
            btnRegistrar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		MetodosTeresita mt=new MetodosTeresita();
    				String calle=txtcalle.getText();
    			    String col=txtcol.getText();
    			    int numero=Integer.parseInt(txtnumero.getText());
    				int cp=Integer.parseInt(txtcp.getText());
    				
    				mt.setCalle(calle);
    				mt.setCol(col);
    				mt.setNumero(numero);
    				mt.setCp(cp);
    				
    				if(calle.isEmpty() || col.isEmpty()){
    					JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
    				}else {
    					
    				
    				if(mt.insertarDir()) {
    					JOptionPane.showMessageDialog(null, "¡DIRECCIÓN REGISTRADA ÉXITOSAMENTE!");
    				}else {
    					JOptionPane.showMessageDialog(null, "¡ERROR AL REGISTRAR!");
    				}
    				}
            	}
            });
            btnRegistrar.setForeground(Color.WHITE);
            btnRegistrar.setFont(new Font("Dubai", Font.BOLD, 18));
            btnRegistrar.setBackground(new Color(255, 128, 172));
            btnRegistrar.setBounds(313, 566, 148, 43);
            dir.getContentPane().add(btnRegistrar);
            
            
            JButton btnEditar = new JButton("EDITAR");
            btnEditar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
                    
            		MetodosTeresita mt=new 	MetodosTeresita();
    				
    				String calle=txtcalle.getText();
    				String col=txtcol.getText();
    				int numero=Integer.parseInt(txtnumero.getText());
    				int cp=Integer.parseInt(txtcp.getText());
    				
    				mt.setCalle(calle);
    				mt.setCol(col);
    				mt.setNumero(numero);
    				mt.setCp(cp);
    				mt.setIddir(Integer.parseInt(txtiddir.getText()));
    				
    				if(mt.actualizarDir()) {
    					JOptionPane.showMessageDialog(null, "¡ACTUALIZACIÓN EXITOSA!");
    					
    				}else {       
    					JOptionPane.showMessageDialog(null, "¡ERROR!");
    				}
            		
            	}
            });
            btnEditar.setForeground(Color.WHITE);
            btnEditar.setFont(new Font("Dubai", Font.BOLD, 18));
            btnEditar.setBackground(new Color(155, 155, 155));
            btnEditar.setBounds(508, 566, 148, 43);
            dir.getContentPane().add(btnEditar);
            
            JButton btnEliminar = new JButton("ELIMINAR");
            btnEliminar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		PreparedStatement ps=null;
    				DefaultTableModel modelo=new DefaultTableModel();
    				try {
    					Conexion cx=new Conexion();
    					Connection cn=cx.conectar();
    					int fila=tabladir.getSelectedRow();
    					String iddir=tabladir.getValueAt(fila, 0).toString();
    		         	ps=cn.prepareStatement("DELETE FROM direccion WHERE id_dir=?");
    					ps.setString(1, iddir);
    					ps.execute();
    					 txtiddir.setText("");
                         txtcalle.setText("");
                         txtcol.setText("");
                         txtcp.setText("");
                         txtnumero.setText("");
                        
                        JOptionPane.showMessageDialog(null, "DIRECCIÓN ELIMINADA");
                       
    		

    					}catch(Exception e2) {
    						System.out.println(e2.toString());

    					}
            	}
            });
            btnEliminar.setForeground(Color.WHITE);
            btnEliminar.setFont(new Font("Dubai", Font.BOLD, 18));
            btnEliminar.setBackground(new Color(255, 128, 172));
            btnEliminar.setBounds(697, 566, 148, 43);
            dir.getContentPane().add(btnEliminar);
            
            
            
            JButton btnCargar = new JButton("*");
            btnCargar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		try {
    					DefaultTableModel modelo=new DefaultTableModel();
    					tabladir.setModel(modelo);
    					
    					PreparedStatement ps=null;
    					ResultSet rs=null;
    					
    					Conexion cn=new Conexion();
    					Connection conectar=cn.conectar();
    					
    					String sql="SELECT * FROM direccion";
    					ps=conectar.prepareStatement(sql);
    					rs=ps.executeQuery();
    					
    					
    					ResultSetMetaData rmds=(ResultSetMetaData)rs.getMetaData();
    					int cantcol=rmds.getColumnCount();
    					modelo.addColumn("ID_DIR");
    					modelo.addColumn("CALLE");
    					modelo.addColumn("COLONIA");
    					modelo.addColumn("NÚMERO");
    					modelo.addColumn("CÓDIGO POSTAL");
    				
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
            btnCargar.setForeground(Color.WHITE);
            btnCargar.setFont(new Font("Dubai", Font.BOLD, 18));
            btnCargar.setBackground(new Color(155, 155, 155));
            btnCargar.setBounds(794, 104, 51, 43);
            dir.getContentPane().add(btnCargar);
            
        
        //AL EJECUTAR APARECE
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion cn = new Conexion();
        Connection conectar = cn.conectar();

        String sql = "SELECT * FROM direccion";
        ps = conectar.prepareStatement(sql);
        rs = ps.executeQuery();

        ResultSetMetaData rmds = (ResultSetMetaData) rs.getMetaData();
        int cantcol = rmds.getColumnCount();
        modelo.addColumn("ID_DIR");
        modelo.addColumn("CALLE");
        modelo.addColumn("COLONIA");
        modelo.addColumn("NÚMERO");
        modelo.addColumn("CÓDIGO POSTAL");
      

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
