package entornoGrafico.ejercicio1;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Marco extends JFrame {

  public Marco() {

    setTitle("Calculadora de Área y Perímetro");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Toolkit pantalla = Toolkit.getDefaultToolkit();

    // Obtiene el tamaño de la pantalla que ejecuta el programa
    Dimension tamanoPantalla = pantalla.getScreenSize();

    int altoPantalla = tamanoPantalla.height;
    int anchoPantalla = tamanoPantalla.width;

    // defino el tamaño y posición del marco según el alto y el ancho de la pantalla
    setSize(anchoPantalla / 2, altoPantalla / 2);
    setLocation(anchoPantalla / 4, altoPantalla / 4);

    setResizable(false);

    setLayout(new FlowLayout());
    Container cp = getContentPane();

    cp.add(new JLabel("Ancho: "));
    JTextField ancho = new JTextField(25);
    cp.add(ancho);
    
    cp.add(new JLabel("Alto: "));
    JTextField alto = new JTextField(25);
    cp.add(alto);
    
    JButton boton = new JButton("Calcular");
    cp.add(boton);
    
    JTextField resultado = new JTextField(20);
    resultado.setEditable(false);
    cp.add(resultado);
    
    boton.addActionListener(new Calculo(alto, ancho, resultado));
  }

}
