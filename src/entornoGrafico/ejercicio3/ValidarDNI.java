package entornoGrafico.ejercicio3;

public class ValidarDNI {

  public static boolean comprobarDNI(String dni) {

    boolean letraCorrecta;
    boolean numeroCorrecto;

    String letra = dni.substring(8, 9); // obtenemos la letra del DNI
    letra = letra.toUpperCase(); // convertimos la letra a mayúscula por la posibilidad de que sea minúscula
    int numero = Integer.parseInt(dni.substring(0, 8)); // obtenemos los números del DNI

    String[] arrayLetras = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V",
        "H", "L", "C", "K", "E" };

    // averiguamos la posicion en la que deberia estar la letra según el número del
    // DNI
    int posicion = numero % 23;

    // comprobamos letra
    if (letra.equals(arrayLetras[posicion])) {
      letraCorrecta = true;
    } else {
      letraCorrecta = false;
    }

    // comprobamos numero
    if (Integer.toString(numero).length() == 8) {
      numeroCorrecto = true;
    } else {
      numeroCorrecto = false;
    }

    if (letraCorrecta == true && numeroCorrecto == true) {
      return true;
    } else {
      return false;
    }

  }

}
