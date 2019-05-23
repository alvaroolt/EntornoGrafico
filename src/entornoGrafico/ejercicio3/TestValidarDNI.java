package entornoGrafico.ejercicio3;

/**
 * Pide un DNI y comprueba que es correcto, será correcto si 
 * tiene 9 caracteres y la letra es correcta.
 * 
 * @Alvaro Leiva Toledano
 * @version 1.0
 */
import java.awt.Color;
/**
 * Pide un DNI y comprueba que es correcto, será correcto si tiene 9 caracteres
 * y la letra es correcta.
 * 
 * @author Álvaro Leiva Toledano
 */
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestValidarDNI {

  private JFrame frmValidadorDeDni;
  private JTextField obtenerDNI;
  private JTextField comprobacion;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          TestValidarDNI window = new TestValidarDNI();
          window.frmValidadorDeDni.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public TestValidarDNI() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmValidadorDeDni = new JFrame();
    frmValidadorDeDni.setResizable(false);
    frmValidadorDeDni.setTitle("Validador de DNI");
    frmValidadorDeDni.setBounds(450, 200, 373, 202);
    frmValidadorDeDni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmValidadorDeDni.getContentPane().setLayout(null);

    JLabel lblDni = new JLabel("DNI");
    lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblDni.setBounds(70, 25, 39, 32);
    frmValidadorDeDni.getContentPane().add(lblDni);

    obtenerDNI = new JTextField();
    obtenerDNI.setFont(new Font("Tahoma", Font.PLAIN, 18));
    obtenerDNI.setBounds(143, 27, 144, 29);
    frmValidadorDeDni.getContentPane().add(obtenerDNI);
    obtenerDNI.setColumns(10);

    JButton btnNewButton = new JButton("Comprobar");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        try {

          String dni = obtenerDNI.getText();
          String mensaje = "";

          if (dni.length() != 9) {
            throw new Exception();
          }

          if (ValidarDNI.comprobarDNI(dni)) {
            mensaje = "Correcto";
          } else {
            mensaje = "Incorrecto";
          }

          comprobacion.setText(mensaje);
        } catch (Exception ee) {

          JOptionPane.showMessageDialog(null, "Error, valor introducido erróneo");
        }
      }
    });
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnNewButton.setBounds(27, 95, 132, 23);
    frmValidadorDeDni.getContentPane().add(btnNewButton);

    comprobacion = new JTextField();
    comprobacion.setBackground(Color.LIGHT_GRAY);
    comprobacion.setEditable(false);
    comprobacion.setBounds(201, 99, 86, 20);
    frmValidadorDeDni.getContentPane().add(comprobacion);
    comprobacion.setColumns(10);
  }

}