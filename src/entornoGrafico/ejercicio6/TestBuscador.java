package entornoGrafico.ejercicio6;

/**
 * Realiza un programa que diga cuántas ocurrencias de una palabra hay en un fichero. 
 * 
 * @author Alvaro Leiva Toledano
 * @version 1.0
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestBuscador {

  private JFrame frmBuscador;
  private JTextField textFieldNombreFichero;
  private JTextField textFieldPalabra;
  private JTextField textFieldOcurrencias;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          TestBuscador window = new TestBuscador();
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
  public TestBuscador() {
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
    frmBuscador.setBounds(450, 200, 450, 300);
    frmBuscador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmBuscador.getContentPane().setLayout(null);

    JLabel labelNombreFichero = new JLabel("Nombre del fichero");
    labelNombreFichero.setFont(new Font("Tahoma", Font.PLAIN, 14));
    labelNombreFichero.setBounds(30, 50, 123, 23);
    frmBuscador.getContentPane().add(labelNombreFichero);

    JLabel labelPalabra = new JLabel("Palabra");
    labelPalabra.setFont(new Font("Tahoma", Font.PLAIN, 14));
    labelPalabra.setBounds(30, 95, 123, 23);
    frmBuscador.getContentPane().add(labelPalabra);

    textFieldNombreFichero = new JTextField();
    textFieldNombreFichero.setFont(new Font("Tahoma", Font.PLAIN, 14));
    textFieldNombreFichero.setBounds(163, 46, 123, 31);
    frmBuscador.getContentPane().add(textFieldNombreFichero);
    textFieldNombreFichero.setColumns(10);

    textFieldPalabra = new JTextField();
    textFieldPalabra.setFont(new Font("Tahoma", Font.PLAIN, 14));
    textFieldPalabra.setColumns(10);
    textFieldPalabra.setBounds(163, 91, 123, 31);
    frmBuscador.getContentPane().add(textFieldPalabra);

    JButton btnComprobar = new JButton("Comprobar");
    btnComprobar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {

        String nombreFichero = textFieldNombreFichero.getText();
        String palabra = textFieldPalabra.getText();

        try {
          textFieldOcurrencias.setText("" + buscarOcurrencias(nombreFichero, palabra));
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    });
    btnComprobar.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnComprobar.setBounds(296, 50, 123, 68);
    frmBuscador.getContentPane().add(btnComprobar);

    JLabel labelOcurrencias = new JLabel("Ocurrencias");
    labelOcurrencias.setFont(new Font("Tahoma", Font.PLAIN, 14));
    labelOcurrencias.setBounds(30, 178, 123, 23);
    frmBuscador.getContentPane().add(labelOcurrencias);

    textFieldOcurrencias = new JTextField();
    textFieldOcurrencias.setEditable(false);
    textFieldOcurrencias.setBackground(Color.LIGHT_GRAY);
    textFieldOcurrencias.setFont(new Font("Tahoma", Font.PLAIN, 14));
    textFieldOcurrencias.setColumns(10);
    textFieldOcurrencias.setBounds(163, 178, 123, 31);
    frmBuscador.getContentPane().add(textFieldOcurrencias);
  }

  private int buscarOcurrencias(String nombreFichero, String palabra) throws IOException {

    int contador = 0;

    try {

      BufferedReader br = new BufferedReader(
          new FileReader("C:\\Users\\Álvaro\\eclipse-workspace\\java18\\src\\entornoGrafico\\ejercicio6\\ficheros\\"
              + nombreFichero + ".txt"));

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