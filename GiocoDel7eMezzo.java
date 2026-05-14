import java.util.Random;
import java.util.Scanner;

public class SetteEMezzo {

    public static double pescaCarta() {
        Random rand = new Random();

        int carta = rand.nextInt(10) + 1;

        if (carta >= 8) {
            return 0.5;
        } else {
            return carta;
        }
    }

    public static void stampaCarta(double carta) {
        if (carta == 0.5) {
            System.out.println("Hai pescato una figura (0.5)");
        } else {
            System.out.println("Hai pescato: " + (int) carta);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double punteggioGiocatore = 0;
        double punteggioBanco = 0;

        String scelta;

        System.out.println("=== GIOCO DEL 7 E MEZZO ===");

        do {

            double carta = pescaCarta();

            stampaCarta(carta);

            punteggioGiocatore += carta;

            System.out.println("Punteggio attuale: " + punteggioGiocatore);

            if (punteggioGiocatore > 7.5) {
                System.out.println("Hai sballato! Hai perso.");
                input.close();
                return;
            }

            System.out.println("Vuoi pescare un'altra carta? (si/no)");
            scelta = input.nextLine();

        } while (scelta.equalsIgnoreCase("si"));

        System.out.println("\n--- Turno del banco ---");

        while (punteggioBanco < 5) {

            double cartaBanco = pescaCarta();

            System.out.print("Il banco ");

            stampaCarta(cartaBanco);

            punteggioBanco += cartaBanco;

            System.out.println("Punteggio banco: " + punteggioBanco);
        }

        if (punteggioBanco > 7.5) {
            System.out.println("Il banco ha sballato! Hai vinto!");
        }

        System.out.println("\n=== RISULTATO FINALE ===");
        System.out.println("Tuo punteggio: " + punteggioGiocatore);
        System.out.println("Punteggio banco: " + punteggioBanco);

        if (punteggioGiocatore > punteggioBanco || punteggioBanco > 7.5) {
            System.out.println("Hai vinto!");
        } else if (punteggioGiocatore < punteggioBanco) {
            System.out.println("Ha vinto il banco!");
        } else {
            System.out.println("Pareggio!");
        }

        input.close();
    }
}
