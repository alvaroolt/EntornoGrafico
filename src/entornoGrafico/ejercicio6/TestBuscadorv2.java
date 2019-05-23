package entornoGrafico.ejercicio6;

import java.awt.Color;
/**
 * Realiza un programa que diga cuántas ocurrencias de una palabra hay en un fichero. 
 * 
 * @author Alvaro Leiva Toledano
 * @version 2.0
 */
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestBuscadorv2 {

  private JFrame frmBuscador;
  private JTextField textFieldRutaFichero;
  private JTextField textFieldPalabra;
  private JTextField textFieldOcurrencias;
  File fichero;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          TestBuscadorv2 window = new TestBuscadorv2();
          window.frmBuscador.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public TestBuscadorv2() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmBuscador = new JFrame();
    frmBuscador.setTitle("Buscador de ocurrencias");
    frmBuscador.setResizable(false);
    frmBuscador.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
    frmBuscador.setBounds(450, 200, 450, 269);
    frmBuscador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmBuscador.getContentPane().setLayout(null);

    JLabel labelRutaFichero = new JLabel("Ruta del fichero");
    labelRutaFichero.setFont(new Font("Tahoma", Font.PLAIN, 14));
    labelRutaFichero.setBounds(30, 97, 113, 23);
    frmBuscador.getContentPane().add(labelRutaFichero);

    JLabel labelPalabra = new JLabel("Palabra");
    labelPalabra.setFont(new Font("Tahoma", Font.PLAIN, 14));
    labelPalabra.setBounds(213, 33, 61, 23);
    frmBuscador.getContentPane().add(labelPalabra);

    textFieldRutaFichero = new JTextField();
    textFieldRutaFichero.setEditable(false);
    textFieldRutaFichero.setFont(new Font("Tahoma", Font.PLAIN, 10));
    textFieldRutaFichero.setBounds(153, 93, 254, 31);
    frmBuscador.getContentPane().add(textFieldRutaFichero);
    textFieldRutaFichero.setColumns(10);

    textFieldPalabra = new JTextField();
    textFieldPalabra.setFont(new Font("Tahoma", Font.PLAIN, 14));
    textFieldPalabra.setColumns(10);
    textFieldPalabra.setBounds(284, 29, 123, 31);
    frmBuscador.getContentPane().add(textFieldPalabra);

    JButton btnComprobar = new JButton("Comprobar");
    btnComprobar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {

        String nombreFichero = textFieldRutaFichero.getText();
        String palabra = textFieldPalabra.getText();

        try {
          textFieldOcurrencias.setText("" + buscarOcurrencias(nombreFichero, palabra));
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    });
    btnComprobar.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnComprobar.setBounds(30, 163, 113, 44);
    frmBuscador.getContentPane().add(btnComprobar);

    JLabel labelOcurrencias = new JLabel("Ocurrencias");
    labelOcurrencias.setFont(new Font("Tahoma", Font.PLAIN, 14));
    labelOcurrencias.setBounds(185, 174, 89, 23);
    frmBuscador.getContentPane().add(labelOcurrencias);

    textFieldOcurrencias = new JTextField();
    textFieldOcurrencias.setEditable(false);
    textFieldOcurrencias.setBackground(Color.LIGHT_GRAY);
    textFieldOcurrencias.setFont(new Font("Tahoma", Font.PLAIN, 14));
    textFieldOcurrencias.setColumns(10);
    textFieldOcurrencias.setBounds(284, 170, 123, 31);
    frmBuscador.getContentPane().add(textFieldOcurrencias);

    JButton btnElegirFichero = new JButton("Seleccionar fichero");
    btnElegirFichero.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {

        JFileChooser fc = new JFileChooser();

        int seleccionado = fc.showOpenDialog(frmBuscador.getContentPane());
        if (seleccionado == JFileChooser.APPROVE_OPTION) {
          fichero = fc.getSelectedFile();
          textFieldRutaFichero.setText(fichero.getAbsolutePath());
        }

      }
    });
    btnElegirFichero.setFont(new Font("Tahoma", Font.PLAIN, 13));
    btnElegirFichero.setBounds(30, 22, 145, 44);
    frmBuscador.getContentPane().add(btnElegirFichero);
  }

  private int buscarOcurrencias(String nombreFichero, String palabra) throws IOException {

    int contador = 0;

    try {

      BufferedReader br = new BufferedReader(new FileReader(fichero));

      String linea = "";

      while (linea != null) {
        linea = br.readLine();

        // Creo un array donde almacenaré cada palabra del fichero. Se inicializa para
        // evitar que en el for-each pueda dar un error.
        String[] palabrasFichero = new String[] { "" };

        if (linea != null) {
          palabrasFichero = linea.split(" "); // split separa las palabras para almacenarse
        }

        // Recorre el array palabrasFichero[], y si coincide con la palabra a buscar,
        // aumenta el contador
        for (String i : palabrasFichero) {
          if (i.equals(palabra)) {
            contador++;
          }
        }
      }

      // Se cierra el fichero.
      br.close();

    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "Error, fichero no encontrado");
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Error al leer el fichero");
    }
    return contador;
  }
}
