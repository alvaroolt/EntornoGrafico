package entornoGrafico.ejercicio2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DistanciaEntrePuntos extends JFrame {
  private JTextField x1_1;
  private JTextField y1_1;
  private JTextField x2_1;
  private JTextField y2_1;
  private JTextField resultado;

  public DistanciaEntrePuntos() {
    setTitle("Calculadora de Distancias");
    setBounds(200, 200, 482, 231);

    JPanel panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);
    panel.setLayout(null);

    JLabel lblPuntoX = new JLabel("Punto X1");
    lblPuntoX.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblPuntoX.setBounds(33, 26, 57, 22);
    panel.add(lblPuntoX);

    JLabel lblNewLabel = new JLabel("Punto X2");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblNewLabel.setBounds(128, 30, 57, 14);
    panel.add(lblNewLabel);

    JLabel lblPuntoY = new JLabel("Punto Y1");
    lblPuntoY.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblPuntoY.setBounds(33, 105, 57, 14);
    panel.add(lblPuntoY);

    JLabel lblPuntoY_1 = new JLabel("Punto Y2");
    lblPuntoY_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblPuntoY_1.setBounds(128, 105, 57, 14);
    panel.add(lblPuntoY_1);

    x1_1 = new JTextField();
    x1_1.setBounds(33, 48, 57, 20);
    panel.add(x1_1);
    x1_1.setColumns(10);

    y1_1 = new JTextField();
    y1_1.setBounds(33, 123, 57, 20);
    panel.add(y1_1);
    y1_1.setColumns(10);

    x2_1 = new JTextField();
    x2_1.setBounds(128, 48, 57, 20);
    panel.add(x2_1);
    x2_1.setColumns(10);

    y2_1 = new JTextField();
    y2_1.setBounds(128, 123, 57, 20);
    panel.add(y2_1);
    y2_1.setColumns(10);

    JButton btnCalcularDistancia = new JButton("Calcular distancia");
    btnCalcularDistancia.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        double x1 = Double.parseDouble(x1_1.getText());
        double y1 = Double.parseDouble(y1_1.getText());
        double x2 = Double.parseDouble(x2_1.getText());
        double y2 = Double.parseDouble(y2_1.getText());
        
        resultado.setText(""+CalcularDistancia(x1, y1, x2, y2));
      }
    });
    btnCalcularDistancia.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnCalcularDistancia.setBounds(247, 39, 146, 35);
    panel.add(btnCalcularDistancia);

    resultado = new JTextField();
    resultado.setBackground(Color.LIGHT_GRAY);
    resultado.setBounds(258, 123, 135, 20);
    resultado.setEditable(false);
    panel.add(resultado);
    resultado.setColumns(10);
  }

  private double CalcularDistancia(double x1, double y1, double x2, double y2) {

    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}
