package entornoGrafico.ejercicio5;

/**
 * Escribe un programa que guarde en un fichero el contenido de otros dos ficheros,
 * de tal forma que en el fichero resultante aparezcan las líneas de los primeros
 * dos ficheros mezcladas, es decir, la primera línea será del primer fichero,
 * la segunda será del segundo fichero, la tercera será la siguiente del primer fichero, etc.
 * 
 * @author Alvaro Leiva Toledano
 * @version 2.0
 */
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestMezcladorv2 {

  private JFrame frmMezclador;
  private JTextField textFieldRutaFichero1;
  private JTextField textFieldRutaFichero2;
  File fichero1;
  File fichero2;
  File fichero3;
//  private String textoFichero3;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          TestMezcladorv2 window = new TestMezcladorv2();
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
  public TestMezcladorv2() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmMezclador = new JFrame();
    frmMezclador.setResizable(false);
    frmMezclador.setTitle("Mezclador de ficheros");
    frmMezclador.setBounds(450, 200, 616, 425);
    frmMezclador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmMezclador.getContentPane().setLayout(null);

    JLabel labelRutaFichero1 = new JLabel("Ruta del fichero nº1");
    labelRutaFichero1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    labelRutaFichero1.setBounds(36, 91, 141, 24);
    frmMezclador.getContentPane().add(labelRutaFichero1);

    JLabel labelRutaFichero2 = new JLabel("Ruta del fichero nº2");
    labelRutaFichero2.setFont(new Font("Tahoma", Font.PLAIN, 14));
    labelRutaFichero2.setBounds(36, 147, 152, 24);
    frmMezclador.getContentPane().add(labelRutaFichero2);

    textFieldRutaFichero1 = new JTextField();
    textFieldRutaFichero1.setEditable(false);
    textFieldRutaFichero1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    textFieldRutaFichero1.setBounds(187, 90, 368, 28);
    frmMezclador.getContentPane().add(textFieldRutaFichero1);
    textFieldRutaFichero1.setColumns(10);

    textFieldRutaFichero2 = new JTextField();
    textFieldRutaFichero2.setEditable(false);
    textFieldRutaFichero2.setFont(new Font("Tahoma", Font.PLAIN, 14));
    textFieldRutaFichero2.setColumns(10);
    textFieldRutaFichero2.setBounds(187, 146, 368, 28);
    frmMezclador.getContentPane().add(textFieldRutaFichero2);

    JButton btnMezclar = new JButton("Mezclar");
    btnMezclar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {

        String nombreFichero1 = textFieldRutaFichero1.getText();
        String nombreFichero2 = textFieldRutaFichero2.getText();

        mezclarFicheros(nombreFichero1, nombreFichero2);

      }
    });
    btnMezclar.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnMezclar.setBounds(473, 24, 101, 45);
    frmMezclador.getContentPane().add(btnMezclar);

    JButton btnElegirFichero1 = new JButton("Seleccionar fichero nº1");
    btnElegirFichero1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {

        JFileChooser fc1 = new JFileChooser();

        int seleccionado = fc1.showOpenDialog(frmMezclador.getContentPane());
        if (seleccionado == JFileChooser.APPROVE_OPTION) {
          fichero1 = fc1.getSelectedFile();
          textFieldRutaFichero1.setText(fichero1.getAbsolutePath());
        }
      }
    });
    btnElegirFichero1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnElegirFichero1.setBounds(36, 24, 191, 45);
    frmMezclador.getContentPane().add(btnElegirFichero1);

    JButton btnElegirFichero2 = new JButton("Seleccionar fichero nº2");
    btnElegirFichero2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        JFileChooser fc2 = new JFileChooser();

        int seleccionado = fc2.showOpenDialog(frmMezclador.getContentPane());
        if (seleccionado == JFileChooser.APPROVE_OPTION) {
          fichero2 = fc2.getSelectedFile();
          textFieldRutaFichero2.setText(fichero2.getAbsolutePath());
        }
      }
    });
    btnElegirFichero2.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnElegirFichero2.setBounds(261, 24, 191, 45);
    frmMezclador.getContentPane().add(btnElegirFichero2);

    JTextArea areaFichero = new JTextArea();
    areaFichero.setFont(new Font("Monospaced", Font.PLAIN, 11));
    areaFichero.setEditable(false);
    areaFichero.setBounds(36, 188, 538, 171);
    frmMezclador.getContentPane().add(areaFichero);

    JScrollPane scrollPane = new JScrollPane(areaFichero, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setBounds(36, 188, 538, 171);
    frmMezclador.getContentPane().add(scrollPane);
  }

  private void mezclarFicheros(String nombreFichero1, String nombreFichero2) {

    try {

      BufferedReader br1 = new BufferedReader(new FileReader(fichero1));

      BufferedReader br2 = new BufferedReader(new FileReader(fichero2));
      
      BufferedReader br3 = new BufferedReader(new FileReader(fichero3));

      BufferedWriter bw3 = new BufferedWriter(new FileWriter(fichero3));

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

      String textoFichero3 = "";
      linea = "";
      while (linea != null) {
        linea = br3.readLine();
        if (linea != null) {
          textoFichero3 += linea + "\n";
        }
      }

      areaFichero.append(textoFichero3);

      bw3.close();
      br1.close();
      br2.close();
      br3.close();

    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "Error, ficheros no encontrados");
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Error al leer los ficheros");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error inesperado");
    }

  }
}
