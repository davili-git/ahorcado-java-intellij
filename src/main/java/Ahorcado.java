import java.util.Scanner;
import java.util.Random;

public class Ahorcado {
    public static void main(String[] args) {
        // Lista de palabras para el juego del ahorcado
        String[] palabras = {"programacion", "java", "ahorcado", "desarrollo", "codigo"};

        // Seleccionar una palabra aleatoria de la lista
        Random random = new Random();
        String palabraSecreta = palabras[random.nextInt(palabras.length)];

        // Crear un array para la palabra adivinada
        char[] adivinada = new char[palabraSecreta.length()];
        for (int i = 0; i < adivinada.length; i++) {
            adivinada[i] = '_';
        }

        // Variables para el juego
        int intentos = 6;
        boolean juegoTerminado = false;
        Scanner scanner = new Scanner(System.in);

        // Iniciar el juego
        System.out.println("¡Bienvenido al juego del ahorcado!");

        while (intentos > 0 && !juegoTerminado) {
            System.out.println("Palabra: " + new String(adivinada));
            System.out.println("Te quedan " + intentos + " intentos.");
            System.out.print("Introduce una letra: ");
            char letra = scanner.nextLine().charAt(0);

            boolean letraEncontrada = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    adivinada[i] = letra;
                    letraEncontrada = true;
                }
            }

            if (!letraEncontrada) {
                intentos--;
                System.out.println("Letra incorrecta. Pierdes un intento.");
            }

            // Verificar si la palabra ha sido adivinada
            juegoTerminado = true;
            for (int i = 0; i < adivinada.length; i++) {
                if (adivinada[i] == '_') {
                    juegoTerminado = false;
                    break;
                }
            }
        }

        // Mostrar el resultado del juego
        if (juegoTerminado) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("Has perdido. La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }
}