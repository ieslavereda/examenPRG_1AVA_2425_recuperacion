import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final String LETRAS_MAYUSCULAS = "ABCDEFGHIJKLMNÑOPQRSTUWXYZ";
    public static final String VOCALES = "AEIOUaeiou";
    public static final String NUMEROS = "0123456789";

    public static void main(String[] args) {
        System.out.println("Password Amore1 correcto?: " + ejercicio1b("Amore1"));
        System.out.println("Password Amore correcto?: " + ejercicio1b("Amore"));
        System.out.println("Password amore1 correcto?: " + ejercicio1b("amore1"));
        System.out.println("Password Amore correcto?: " + ejercicio1b("Amore"));
        System.out.println("Password Amore1 correcto?: " + ejercicio1("Amore1"));
        System.out.println("Password Amore correcto?: " + ejercicio1("Amore"));
        System.out.println("Password amore1 correcto?: " + ejercicio1("amore1"));
        System.out.println("Password Amore correcto?: " + ejercicio1("Amore"));
        ejercicio2(1);
        ejercicio2(5);
        System.out.println("Vocales en el texto: " + ejercicio3("Hola como Estas?"));
        System.out.println("Vocales en el texto: " + ejercicio3("Hl cm sts?"));
        System.out.println("Vocales en el texto: " + ejercicio3b("Hola como Estas?"));
        System.out.println("Vocales en el texto: " + ejercicio3b("Hl cm sts?"));

        String[][] notasPRG = {
                {"Juan Alegre", "5.6"},
                {"Miquel Perez", "4"},
                {"Pere Major", "9.21"},
                {"Anna Lopez", "7.90"},
                {"Sonia Gomez", "8.53"},
                {"Ageda Garcia", "6.65"},
                {"Lluna Navarro", "9.99"},
                {"Pepa Navarro", "9.99"},
        };

        System.out.println("Media: " + ejercicio4a(notasPRG));
        System.out.println("Alumnos con máxima nota: " + Arrays.toString(ejercicio4b(notasPRG)));
        System.out.println("Posición de nAVARRO: " + ejercicio4c(notasPRG, "nAVARRO"));
        System.out.println("Posición de Anna: " + ejercicio4c(notasPRG, "Anna"));
        System.out.println("Posición de Dabiz: " + ejercicio4c(notasPRG, "Dabiz"));
        System.out.println("Notas: " + Arrays.toString(ejercicio4d(notasPRG)));
    }

    public static boolean ejercicio1(String password) {
        String letrasMinusculas = LETRAS_MAYUSCULAS.toLowerCase();
        boolean minusculas = false, mayusculas = false, numeros = false;
        for (int i = 0; i < password.length(); i++) {
            if (!minusculas && password.charAt(i) >= 'a' && password.charAt(i) < 'z') {
                minusculas = true;
            }
            if (!mayusculas && password.charAt(i) >= 'A' && password.charAt(i) < 'B') {
                mayusculas = true;
            }

            if (!numeros && password.charAt(i) >= '0' && password.charAt(i) < '9') {
                numeros = true;
            }

        }
        return mayusculas && minusculas && numeros;
    }

    public static boolean ejercicio1b(String password) {
        String letrasMinusculas = LETRAS_MAYUSCULAS.toLowerCase();
        boolean minusculas = false, mayusculas = false, numeros = false;
        for (int i = 0; i < password.length(); i++) {
            if (!minusculas && letrasMinusculas.indexOf(password.charAt(i)) != -1)
                minusculas = true;
            else if (!mayusculas && LETRAS_MAYUSCULAS.indexOf(password.charAt(i)) != -1)
                mayusculas = true;
            else if (!numeros && NUMEROS.indexOf(password.charAt(i)) != -1)
                numeros = true;
        }
        return mayusculas && minusculas && numeros;
    }

    public static void ejercicio2(int numero) {
        for (int i = 0; i < numero; i++) {
            int k = numero - i;
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= k; j++) {
                System.out.print(j + " ");
            }
            for (int j = k - 1; j > 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    public static int ejercicio3(String cadena) {
        if (cadena.length() == 0)
            return 0;
        if (VOCALES.indexOf(cadena.charAt(0)) != -1)
            return 1 + ejercicio3(cadena.substring(1));
        return ejercicio3(cadena.substring(1));
    }

    public static int ejercicio3b(String cadena) {
        if (cadena.length() == 0)
            return 0;
        for (int i = 0; i < VOCALES.length(); i++) {
            if (cadena.charAt(0) == VOCALES.charAt(i))
                return 1 + ejercicio3b(cadena.substring(1));
        }
        return ejercicio3b(cadena.substring(1));
    }

    public static double ejercicio4a(String[][] notasPRG) {
        double suma = 0.0;
        for (String[] notas : notasPRG) {
            suma += Double.parseDouble(notas[1]);
        }
        return suma / notasPRG.length;
    }

    public static String[] ejercicio4b(String[][] notasPRG) {
        double maximo = -1.0;
        for (String[] notas : notasPRG) {
            if (maximo < Double.parseDouble(notas[1]))
                maximo = Double.parseDouble(notas[1]);
        }
        int numeroMaxNota = 0;
        for (int i = 0; i < notasPRG.length; i++) {
            if (maximo == Double.parseDouble(notasPRG[i][1]))
                numeroMaxNota++;
        }
        String[] maximaNota = new String[numeroMaxNota];
        int k = 0;
        for (int i = 0; i < notasPRG.length; i++) {
            if (maximo == Double.parseDouble(notasPRG[i][1]))
                maximaNota[k++] = notasPRG[i][0];
        }
        return maximaNota;
    }

    public static int ejercicio4c(String[][] notasPRG, String nombre) {
        for (int i = 0; i < notasPRG.length; i++) {
            if (notasPRG[i][0].toLowerCase().contains(nombre.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    public static double[] ejercicio4d(String[][] notasPRG) {
        double[] notas = new double[notasPRG.length];

        for (int i = 0; i < notasPRG.length; i++) {
            notas[i] = Double.parseDouble(notasPRG[i][1]);
        }

        for (int i = 1; i < notas.length; i++) {
            for (int j = 0; j < i; j++) {
                if (notas[j] < notas[i]) {
                    double aux = notas[j];
                    notas[j] = notas[i];
                    notas[i] = aux;
                }
            }
        }

        return notas;
    }


}