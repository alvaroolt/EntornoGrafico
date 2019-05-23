package entornoGrafico.ejercicio5;

/**
 * Escribe un programa que guarde en un fichero el contenido de otros dos ficheros,
 * de tal forma que en el fichero resultante aparezcan las líneas de los primeros
 * dos ficheros mezcladas, es decir, la primera línea será del primer fichero,
 * la segunda será del segundo fichero, la tercera será la siguiente del primer fichero, etc.
 * 
 * @author Alvaro Leiva Toledano
 * @version 1.0
 */
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestMezclador {

  private JFrame frmMezclador;
  private JTextField textFieldFichero1;
  private JTextField textFieldFichero2;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          TestMezclador window = new TestMezclador();
          window.frmMezclador.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public TestMezclador() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmMezclador = new JFrame();
    frmMezclador.setResizable(false);
    frmMezclador.setTitle("Mezclador de ficheros");
    frmMezclador.setBounds(450, 200, 450, 214);
    frmMezclador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmMezclador.getContentPane().setLayout(null);

    JLabel labelFichero1 = new JLabel("Nombre del fichero nº1");
    labelFichero1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    labelFichero1.setBounds(36, 47, 152, 24);
    frmMezclador.getContentPane().add(labelFichero1);

    JLabel labelFichero2 = new JLabel("Nombre del fichero nº1");
    labelFichero2.setFont(new Font("Tahoma", Font.PLAIN, 14));
    labelFichero2.setBounds(36, 112, 152, 24);
    frmMezclador.getContentPane().add(labelFichero2);

    textFieldFichero1 = new JTextField();
    textFieldFichero1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    textFieldFichero1.setBounds(198, 47, 108, 28);
    frmMezclador.getContentPane().add(textFieldFichero1);
    textFieldFichero1.setColumns(10);

    textFieldFichero2 = new JTextField();
    textFieldFichero2.setFont(new Font("Tahoma", Font.PLAIN, 14));
    textFieldFichero2.setColumns(10);
    textFieldFichero2.setBounds(198, 111, 108, 28);
    frmMezclador.getContentPane().add(textFieldFichero2);

    JButton btnMezclar = new JButton("Mezclar");
    btnMezclar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {

        String nombreFichero1 = textFieldFichero1.getText();
        String nombreFichero2 = textFieldFichero2.getText();

        mezclarFicheros(nombreFichero1, nombreFichero2);

      }
    });
    btnMezclar.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnMezclar.setBounds(323, 76, 89, 34);
    frmMezclador.getContentPane().add(btnMezclar);
  }

  private void mezclarFicheros(String nombreFichero1, String nombreFichero2) {

    try {

      BufferedReader br1 = new BufferedReader(
          new FileReader("C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio5\\ficheros\\"
              + nombreFichero1 + ".txt"));

      BufferedReader br2 = new BufferedReader(
          new FileReader("C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio5\\ficheros\\"
              + nombreFichero2 + ".txt"));

      BufferedWriter bw3 = new BufferedWriter(new FileWriter(
          "C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio5\\ficheros\\fichero3.txt"));

      ArrayList<String> lineasFichero1 = new ArrayList<String>();
      ArrayList<String> lineasFichero2 = new ArrayList<String>();

      String linea = "";
      while (linea != null) {
        linea = br1.readLine();
        if (linea != null) {
          lineasFichero1.add(linea);
        }
      }

      linea = "";
      while (linea != null) {
        linea = br2.readLine();
        if (linea != null) {
          lineasFichero2.add(linea);
        }
      }

      // esta variable me ayuda a saber cuándo debe terminar el bucle siguiente
      int mayorCantidadLineas;
      if (lineasFichero2.size() >= lineasFichero1.size()) {
        mayorCantidadLineas = lineasFichero1.size();
      } else {
        mayorCantidadLineas = lineasFichero2.size();
      }

      for (int i = 0; i < mayorCantidadLineas; i++) {
        if (lineasFichero1.size() >= i + 1) {
          bw3.write(lineasFichero1.get(i) + "\n");
        }
        if (lineasFichero2.size() >= i + 1) {
          bw3.write(lineasFichero2.get(i) + "\n");
        }
      }

      bw3.close();
      br1.close();
      br2.close();

      JOptionPane.showMessageDialog(null, "Fichero mezclado creado correctamente");

    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "Error, ficheros no encontrados");
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Error al leer los ficheros");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error inesperado");
    }

  }
}
