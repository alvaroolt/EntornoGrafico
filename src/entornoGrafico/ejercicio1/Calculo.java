package entornoGrafico.ejercicio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Calculo implements ActionListener {

  private JTextField textoAncho;
  private JTextField textoAlto;
  private JTextField resultado;

  public double calcularArea(double ancho, double alto) {

    return alto * ancho;

  }

  public double calcularPerimetro(double ancho, double alto) {

    return alto * 2 + ancho * 2;

  }

  public Calculo(JTextField ancho, JTextField alto, JTextField resultado) {

    this.textoAncho = ancho;
    this.textoAlto = alto;
    this.resultado = resultado;

  }

  public void actionPerformed(ActionEvent e) {

    double ancho = Double.parseDouble(textoAncho.getText());
    double alto = Double.parseDouble(textoAlto.getText());

    this.resultado.setText("" + calcularArea(ancho, alto) + "area - " + calcularPerimetro(ancho, alto) + "perimetro");
  }

}