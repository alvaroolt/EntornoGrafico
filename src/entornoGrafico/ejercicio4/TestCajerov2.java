package entornoGrafico.ejercicio4;

import java.awt.Color;
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
 * @version 2.0
 */
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestCajerov2 {

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
          TestCajerov2 window = new TestCajerov2();
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
  public TestCajerov2() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame_cajero = new JFrame();
    frame_cajero.setResizable(false);
    frame_cajero.setTitle("Cajero");
    frame_cajero.setBounds(450, 200, 544, 433);
    frame_cajero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame_cajero.getContentPane().setLayout(null);

    dineroACambiar = new JTextField();
    dineroACambiar.setFont(new Font("Tahoma", Font.PLAIN, 16));
    dineroACambiar.setBounds(115, 28, 97, 26);
    frame_cajero.getContentPane().add(dineroACambiar);
    dineroACambiar.setColumns(10);

    textField_1cent = new JTextField();
    textField_1cent.setBackground(Color.LIGHT_GRAY);
    textField_1cent.setEditable(false);
    textField_1cent.setBounds(98, 87, 38, 20);
    frame_cajero.getContentPane().add(textField_1cent);
    textField_1cent.setColumns(10);

    textField_2cent = new JTextField();
    textField_2cent.setBackground(Color.LIGHT_GRAY);
    textField_2cent.setEditable(false);
    textField_2cent.setColumns(10);
    textField_2cent.setBounds(98, 146, 38, 20);
    frame_cajero.getContentPane().add(textField_2cent);

    textField_5cent = new JTextField();
    textField_5cent.setBackground(Color.LIGHT_GRAY);
    textField_5cent.setEditable(false);
    textField_5cent.setColumns(10);
    textField_5cent.setBounds(98, 212, 38, 20);
    frame_cajero.getContentPane().add(textField_5cent);

    textField_10cent = new JTextField();
    textField_10cent.setBackground(Color.LIGHT_GRAY);
    textField_10cent.setEditable(false);
    textField_10cent.setColumns(10);
    textField_10cent.setBounds(98, 273, 38, 20);
    frame_cajero.getContentPane().add(textField_10cent);

    textField_20cent = new JTextField();
    textField_20cent.setBackground(Color.LIGHT_GRAY);
    textField_20cent.setEditable(false);
    textField_20cent.setColumns(10);
    textField_20cent.setBounds(98, 339, 38, 20);
    frame_cajero.getContentPane().add(textField_20cent);

    textField_50cent = new JTextField();
    textField_50cent.setBackground(Color.LIGHT_GRAY);
    textField_50cent.setEditable(false);
    textField_50cent.setColumns(10);
    textField_50cent.setBounds(264, 87, 38, 20);
    frame_cajero.getContentPane().add(textField_50cent);

    textField_1euro = new JTextField();
    textField_1euro.setBackground(Color.LIGHT_GRAY);
    textField_1euro.setEditable(false);
    textField_1euro.setColumns(10);
    textField_1euro.setBounds(264, 146, 38, 20);
    frame_cajero.getContentPane().add(textField_1euro);

    textField_2euros = new JTextField();
    textField_2euros.setBackground(Color.LIGHT_GRAY);
    textField_2euros.setEditable(false);
    textField_2euros.setColumns(10);
    textField_2euros.setBounds(264, 212, 38, 20);
    frame_cajero.getContentPane().add(textField_2euros);

    textField_5euros = new JTextField();
    textField_5euros.setBackground(Color.LIGHT_GRAY);
    textField_5euros.setEditable(false);
    textField_5euros.setColumns(10);
    textField_5euros.setBounds(264, 273, 38, 20);
    frame_cajero.getContentPane().add(textField_5euros);

    textField_10euros = new JTextField();
    textField_10euros.setBackground(Color.LIGHT_GRAY);
    textField_10euros.setEditable(false);
    textField_10euros.setColumns(10);
    textField_10euros.setBounds(264, 339, 38, 20);
    frame_cajero.getContentPane().add(textField_10euros);

    textField_20euros = new JTextField();
    textField_20euros.setBackground(Color.LIGHT_GRAY);
    textField_20euros.setEditable(false);
    textField_20euros.setColumns(10);
    textField_20euros.setBounds(431, 87, 38, 20);
    frame_cajero.getContentPane().add(textField_20euros);

    textField_50euros = new JTextField();
    textField_50euros.setBackground(Color.LIGHT_GRAY);
    textField_50euros.setEditable(false);
    textField_50euros.setColumns(10);
    textField_50euros.setBounds(431, 146, 38, 20);
    frame_cajero.getContentPane().add(textField_50euros);

    textField_100euros = new JTextField();
    textField_100euros.setBackground(Color.LIGHT_GRAY);
    textField_100euros.setEditable(false);
    textField_100euros.setColumns(10);
    textField_100euros.setBounds(431, 212, 38, 20);
    frame_cajero.getContentPane().add(textField_100euros);

    textField_200euros = new JTextField();
    textField_200euros.setBackground(Color.LIGHT_GRAY);
    textField_200euros.setEditable(false);
    textField_200euros.setColumns(10);
    textField_200euros.setBounds(431, 273, 38, 20);
    frame_cajero.getContentPane().add(textField_200euros);

    textField_500euros = new JTextField();
    textField_500euros.setBackground(Color.LIGHT_GRAY);
    textField_500euros.setEditable(false);
    textField_500euros.setColumns(10);
    textField_500euros.setBounds(431, 339, 38, 20);
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
    botonCambio.setBounds(287, 28, 111, 27);
    frame_cajero.getContentPane().add(botonCambio);

    JLabel c1 = new JLabel("001");
    c1.setBounds(10, 73, 64, 49);
    Image imgc1 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\001.png").getImage();
    ImageIcon img001 = new ImageIcon(imgc1.getScaledInstance(c1.getWidth(), c1.getHeight(), Image.SCALE_DEFAULT));
    c1.setIcon(img001);
    frame_cajero.getContentPane().add(c1);

    JLabel c2 = new JLabel("002");
    c2.setBounds(10, 132, 64, 49);
    Image imgc2 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\002.png").getImage();
    ImageIcon img002 = new ImageIcon(imgc2.getScaledInstance(c2.getWidth(), c2.getHeight(), Image.SCALE_DEFAULT));
    c2.setIcon(img002);
    frame_cajero.getContentPane().add(c2);
    
    JLabel c5 = new JLabel("005");
    c5.setBounds(10, 198, 64, 49);
    Image imgc5 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\005.jpg").getImage();
    ImageIcon img005 = new ImageIcon(imgc5.getScaledInstance(c5.getWidth(), c5.getHeight(), Image.SCALE_DEFAULT));
    c5.setIcon(img005);
    frame_cajero.getContentPane().add(c5);
    
    JLabel c10 = new JLabel("010");
    c10.setBounds(10, 259, 64, 49);
    Image imgc10 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\010.png").getImage();
    ImageIcon img010 = new ImageIcon(imgc10.getScaledInstance(c10.getWidth(), c10.getHeight(), Image.SCALE_DEFAULT));
    c10.setIcon(img010);
    frame_cajero.getContentPane().add(c10);
    
    JLabel c20 = new JLabel("020");
    c20.setBounds(10, 325, 64, 49);
    Image imgc20 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\020.png").getImage();
    ImageIcon img020 = new ImageIcon(imgc20.getScaledInstance(c20.getWidth(), c20.getHeight(), Image.SCALE_DEFAULT));
    c20.setIcon(img020);
    frame_cajero.getContentPane().add(c20);
    
    JLabel c50 = new JLabel("050");
    c50.setBounds(176, 73, 64, 49);
    Image imgc50 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\050.png").getImage();
    ImageIcon img050 = new ImageIcon(imgc50.getScaledInstance(c50.getWidth(), c50.getHeight(), Image.SCALE_DEFAULT));
    c50.setIcon(img050);
    frame_cajero.getContentPane().add(c50);
    
    JLabel e1 = new JLabel("100");
    e1.setBounds(176, 132, 64, 49);
    Image imge1 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\1.png").getImage();
    ImageIcon img100 = new ImageIcon(imge1.getScaledInstance(e1.getWidth(), e1.getHeight(), Image.SCALE_DEFAULT));
    e1.setIcon(img100);
    frame_cajero.getContentPane().add(e1);
    
    JLabel e2 = new JLabel("200");
    e2.setBounds(176, 198, 64, 49);
    Image imge2 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\2.png").getImage();
    ImageIcon img200 = new ImageIcon(imge2.getScaledInstance(e2.getWidth(), e2.getHeight(), Image.SCALE_DEFAULT));
    e2.setIcon(img200);
    frame_cajero.getContentPane().add(e2);
    
    JLabel b5 = new JLabel("500");
    b5.setBounds(176, 267, 64, 32);
    Image imgb5 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\5.jpg").getImage();
    ImageIcon img500 = new ImageIcon(imgb5.getScaledInstance(b5.getWidth(), b5.getHeight(), Image.SCALE_DEFAULT));
    b5.setIcon(img500);
    frame_cajero.getContentPane().add(b5);
    
    JLabel b10 = new JLabel("1000");
    b10.setBounds(176, 333, 64, 32);
    Image imgb10 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\10.jpg").getImage();
    ImageIcon img1000 = new ImageIcon(imgb10.getScaledInstance(b10.getWidth(), b10.getHeight(), Image.SCALE_DEFAULT));
    b10.setIcon(img1000);
    frame_cajero.getContentPane().add(b10);
    
    JLabel b20 = new JLabel("2000");
    b20.setBounds(349, 81, 64, 32);
    Image imgb20 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\20.jpg").getImage();
    ImageIcon img2000 = new ImageIcon(imgb20.getScaledInstance(b20.getWidth(), b20.getHeight(), Image.SCALE_DEFAULT));
    b20.setIcon(img2000);
    frame_cajero.getContentPane().add(b20);
    
    JLabel b50 = new JLabel("5000");
    b50.setBounds(349, 140, 64, 32);
    Image imgb50 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\50.jpg").getImage();
    ImageIcon img5000 = new ImageIcon(imgb50.getScaledInstance(b50.getWidth(), b50.getHeight(), Image.SCALE_DEFAULT));
    b50.setIcon(img5000);
    frame_cajero.getContentPane().add(b50);
    
    JLabel b100 = new JLabel("10000");
    b100.setBounds(349, 206, 64, 32);
    Image imgb100 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\100.jpg").getImage();
    ImageIcon img10000 = new ImageIcon(imgb100.getScaledInstance(b100.getWidth(), b100.getHeight(), Image.SCALE_DEFAULT));
    b100.setIcon(img10000);
    frame_cajero.getContentPane().add(b100);
    
    JLabel b200 = new JLabel("20000");
    b200.setBounds(349, 267, 64, 32);
    Image imgb200 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\200.jpg").getImage();
    ImageIcon img20000 = new ImageIcon(imgb200.getScaledInstance(b200.getWidth(), b200.getHeight(), Image.SCALE_DEFAULT));
    b200.setIcon(img20000);
    frame_cajero.getContentPane().add(b200);
    
    JLabel b500 = new JLabel("50000");
    b500.setBounds(349, 333, 64, 32);
    Image imgb500 = new ImageIcon(
        "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio4\\imagenes\\500.jpg").getImage();
    ImageIcon img50000 = new ImageIcon(imgb500.getScaledInstance(b500.getWidth(), b500.getHeight(), Image.SCALE_DEFAULT));
    b500.setIcon(img50000);
    frame_cajero.getContentPane().add(b500);
    
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
