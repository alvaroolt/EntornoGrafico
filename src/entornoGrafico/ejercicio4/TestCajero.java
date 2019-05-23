package entornoGrafico.ejercicio4;

/**
 * Cajero de cambio: devuelve y desglosa el cambio en billetes y monedas de forma "ideal"; es decir, con el menor número de billetes y monedas posibles.
 * Componentes gráficos: 
 * 
 * Etiquetas.
 * Caja de texto para introducir dinero a cambiar. 
 * Cajas de texto para billetes y monedas. 
 * Botón para calcular.
 * 
 * @author Alvaro Leiva Toledano
 * @version 1.0
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestCajero {

  private JFrame frame_cajero;
  private JTextField dineroACambiar;
  private JTextField textField_1cent;
  private JTextField textField_2cent;
  private JTextField textField_5cent;
  private JTextField textField_10cent;
  private JTextField textField_20cent;
  private JTextField textField_50cent;
  private JTextField textField_1euro;
  private JTextField textField_2euros;
  private JTextField textField_5euros;
  private JTextField textField_10euros;
  private JTextField textField_20euros;
  private JTextField textField_50euros;
  private JTextField textField_100euros;
  private JTextField textField_200euros;
  private JTextField textField_500euros;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          TestCajero window = new TestCajero();
          window.frame_cajero.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  int cont500e;
  int cont200e;
  int cont100e;
  int cont50e;
  int cont20e;
  int cont10e;
  int cont5e;
  int cont2e;
  int cont1e;
  int cont50cent;
  int cont20cent;
  int cont10cent;
  int cont5cent;
  int cont2cent;
  int cont1cent;

  /**
   * Create the application.
   */
  public TestCajero() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame_cajero = new JFrame();
    frame_cajero.setResizable(false);
    frame_cajero.setTitle("Cajero");
    frame_cajero.setBounds(450, 200, 450, 318);
    frame_cajero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame_cajero.getContentPane().setLayout(null);

    dineroACambiar = new JTextField();
    dineroACambiar.setFont(new Font("Tahoma", Font.PLAIN, 16));
    dineroACambiar.setBounds(54, 28, 97, 26);
    frame_cajero.getContentPane().add(dineroACambiar);
    dineroACambiar.setColumns(10);

    JLabel label_1cent = new JLabel("1 cent");
    label_1cent.setBounds(26, 84, 38, 26);
    frame_cajero.getContentPane().add(label_1cent);

    JLabel label_2cent = new JLabel("2 cent");
    label_2cent.setBounds(26, 121, 38, 26);
    frame_cajero.getContentPane().add(label_2cent);

    JLabel label_5cent = new JLabel("5 cent");
    label_5cent.setBounds(26, 158, 38, 26);
    frame_cajero.getContentPane().add(label_5cent);

    JLabel label_10cent = new JLabel("10 cent");
    label_10cent.setBounds(26, 195, 38, 26);
    frame_cajero.getContentPane().add(label_10cent);

    JLabel label_20cent = new JLabel("20 cent");
    label_20cent.setBounds(26, 232, 38, 26);
    frame_cajero.getContentPane().add(label_20cent);

    JLabel label_50cent = new JLabel("50 cent");
    label_50cent.setBounds(162, 84, 46, 26);
    frame_cajero.getContentPane().add(label_50cent);

    JLabel label_1euro = new JLabel("1€");
    label_1euro.setBounds(162, 121, 46, 26);
    frame_cajero.getContentPane().add(label_1euro);

    JLabel label_2euros = new JLabel("2€");
    label_2euros.setBounds(162, 158, 46, 26);
    frame_cajero.getContentPane().add(label_2euros);

    JLabel label_5euros = new JLabel("5€");
    label_5euros.setBounds(162, 195, 46, 26);
    frame_cajero.getContentPane().add(label_5euros);

    JLabel label_10euros = new JLabel("10€");
    label_10euros.setBounds(162, 232, 46, 26);
    frame_cajero.getContentPane().add(label_10euros);

    JLabel label_20euros = new JLabel("20€");
    label_20euros.setBounds(310, 84, 38, 26);
    frame_cajero.getContentPane().add(label_20euros);

    JLabel label_50euros = new JLabel("50€");
    label_50euros.setBounds(310, 121, 38, 26);
    frame_cajero.getContentPane().add(label_50euros);

    JLabel label_100euros = new JLabel("100€");
    label_100euros.setBounds(310, 158, 38, 26);
    frame_cajero.getContentPane().add(label_100euros);

    JLabel label_200euros = new JLabel("200€");
    label_200euros.setBounds(310, 195, 38, 26);
    frame_cajero.getContentPane().add(label_200euros);

    JLabel label_500euros = new JLabel("500€");
    label_500euros.setBounds(310, 232, 38, 26);
    frame_cajero.getContentPane().add(label_500euros);

    textField_1cent = new JTextField();
    textField_1cent.setBackground(Color.LIGHT_GRAY);
    textField_1cent.setEditable(false);
    textField_1cent.setBounds(74, 87, 38, 20);
    frame_cajero.getContentPane().add(textField_1cent);
    textField_1cent.setColumns(10);

    textField_2cent = new JTextField();
    textField_2cent.setBackground(Color.LIGHT_GRAY);
    textField_2cent.setEditable(false);
    textField_2cent.setColumns(10);
    textField_2cent.setBounds(74, 124, 38, 20);
    frame_cajero.getContentPane().add(textField_2cent);

    textField_5cent = new JTextField();
    textField_5cent.setBackground(Color.LIGHT_GRAY);
    textField_5cent.setEditable(false);
    textField_5cent.setColumns(10);
    textField_5cent.setBounds(74, 161, 38, 20);
    frame_cajero.getContentPane().add(textField_5cent);

    textField_10cent = new JTextField();
    textField_10cent.setBackground(Color.LIGHT_GRAY);
    textField_10cent.setEditable(false);
    textField_10cent.setColumns(10);
    textField_10cent.setBounds(74, 198, 38, 20);
    frame_cajero.getContentPane().add(textField_10cent);

    textField_20cent = new JTextField();
    textField_20cent.setBackground(Color.LIGHT_GRAY);
    textField_20cent.setEditable(false);
    textField_20cent.setColumns(10);
    textField_20cent.setBounds(74, 235, 38, 20);
    frame_cajero.getContentPane().add(textField_20cent);

    textField_50cent = new JTextField();
    textField_50cent.setBackground(Color.LIGHT_GRAY);
    textField_50cent.setEditable(false);
    textField_50cent.setColumns(10);
    textField_50cent.setBounds(218, 87, 38, 20);
    frame_cajero.getContentPane().add(textField_50cent);

    textField_1euro = new JTextField();
    textField_1euro.setBackground(Color.LIGHT_GRAY);
    textField_1euro.setEditable(false);
    textField_1euro.setColumns(10);
    textField_1euro.setBounds(218, 124, 38, 20);
    frame_cajero.getContentPane().add(textField_1euro);

    textField_2euros = new JTextField();
    textField_2euros.setBackground(Color.LIGHT_GRAY);
    textField_2euros.setEditable(false);
    textField_2euros.setColumns(10);
    textField_2euros.setBounds(218, 161, 38, 20);
    frame_cajero.getContentPane().add(textField_2euros);

    textField_5euros = new JTextField();
    textField_5euros.setBackground(Color.LIGHT_GRAY);
    textField_5euros.setEditable(false);
    textField_5euros.setColumns(10);
    textField_5euros.setBounds(218, 198, 38, 20);
    frame_cajero.getContentPane().add(textField_5euros);

    textField_10euros = new JTextField();
    textField_10euros.setBackground(Color.LIGHT_GRAY);
    textField_10euros.setEditable(false);
    textField_10euros.setColumns(10);
    textField_10euros.setBounds(218, 235, 38, 20);
    frame_cajero.getContentPane().add(textField_10euros);

    textField_20euros = new JTextField();
    textField_20euros.setBackground(Color.LIGHT_GRAY);
    textField_20euros.setEditable(false);
    textField_20euros.setColumns(10);
    textField_20euros.setBounds(358, 87, 38, 20);
    frame_cajero.getContentPane().add(textField_20euros);

    textField_50euros = new JTextField();
    textField_50euros.setBackground(Color.LIGHT_GRAY);
    textField_50euros.setEditable(false);
    textField_50euros.setColumns(10);
    textField_50euros.setBounds(358, 124, 38, 20);
    frame_cajero.getContentPane().add(textField_50euros);

    textField_100euros = new JTextField();
    textField_100euros.setBackground(Color.LIGHT_GRAY);
    textField_100euros.setEditable(false);
    textField_100euros.setColumns(10);
    textField_100euros.setBounds(358, 161, 38, 20);
    frame_cajero.getContentPane().add(textField_100euros);

    textField_200euros = new JTextField();
    textField_200euros.setBackground(Color.LIGHT_GRAY);
    textField_200euros.setEditable(false);
    textField_200euros.setColumns(10);
    textField_200euros.setBounds(358, 198, 38, 20);
    frame_cajero.getContentPane().add(textField_200euros);

    textField_500euros = new JTextField();
    textField_500euros.setBackground(Color.LIGHT_GRAY);
    textField_500euros.setEditable(false);
    textField_500euros.setColumns(10);
    textField_500euros.setBounds(358, 235, 38, 20);
    frame_cajero.getContentPane().add(textField_500euros);

    JButton botonCambio = new JButton("Cambio");
    botonCambio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        try {

          double dinero = Double.parseDouble(dineroACambiar.getText());

          desglosarDinero(dinero);

          textField_1cent.setText("" + cont1cent);
          textField_2cent.setText("" + cont2cent);
          textField_5cent.setText("" + cont5cent);
          textField_10cent.setText("" + cont10cent);
          textField_20cent.setText("" + cont20cent);
          textField_50cent.setText("" + cont50cent);
          textField_1euro.setText("" + cont1e);
          textField_2euros.setText("" + cont2e);
          textField_5euros.setText("" + cont5e);
          textField_10euros.setText("" + cont10e);
          textField_20euros.setText("" + cont20e);
          textField_50euros.setText("" + cont50e);
          textField_100euros.setText("" + cont100e);
          textField_200euros.setText("" + cont200e);
          textField_500euros.setText("" + cont500e);

        } catch (Exception ee) {

          JOptionPane.showMessageDialog(null, "Error, valor introducido erróneo");
        }
      }
    });
    botonCambio.setFont(new Font("Tahoma", Font.PLAIN, 16));
    botonCambio.setBounds(251, 28, 111, 27);
    frame_cajero.getContentPane().add(botonCambio);
  }

  private void desglosarDinero(double dinero) {
    
    cont500e = 0;
    cont200e = 0;
    cont100e = 0;
    cont50e = 0;
    cont20e = 0;
    cont10e = 0;
    cont5e = 0;
    cont2e = 0;
    cont1e = 0;
    cont50cent = 0;
    cont20cent = 0;
    cont10cent = 0;
    cont5cent = 0;
    cont2cent = 0;
    cont1cent = 0;

    while (dinero >= 500) {
      cont500e++;
      dinero -= 500;
    }
    while (dinero >= 200) {
      cont200e++;
      dinero -= 200;
    }
    while (dinero >= 100) {
      cont100e++;
      dinero -= 100;
    }
    while (dinero >= 50) {
      cont50e++;
      dinero -= 50;
    }
    while (dinero >= 20) {
      cont20e++;
      dinero -= 20;
    }
    while (dinero >= 10) {
      cont10e++;
      dinero -= 10;
    }
    while (dinero >= 5) {
      cont5e++;
      dinero -= 5;
    }
    while (dinero >= 2) {
      cont2e++;
      dinero -= 2;
    }
    while (dinero >= 1) {
      cont1e++;
      dinero -= 1;
    }
    while (dinero >= 0.50) {
      cont50cent++;
      dinero -= 0.50;
    }
    while (dinero >= 0.20) {
      cont20cent++;
      dinero -= 0.20;
    }
    while (dinero >= 0.10) {
      cont10cent++;
      dinero -= 0.10;
    }
    while (dinero >= 0.05) {
      cont5cent++;
      dinero -= 0.05;
    }
    while (dinero >= 0.02) {
      cont2cent++;
      dinero -= 0.02;
    }

    while (dinero > 0.01) {
      cont1cent++;
      dinero -= 2;
    }
  }

}
