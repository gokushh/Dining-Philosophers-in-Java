import java.util.concurrent.Semaphore;

/**
 * @authors
 * Breno Gusson de Almeida - 2018.1.08.031
 * Rafael Manfrinatti Bittar - 2016.1.08.017
 */
public class JantarDosFilosofos {

    private static final int N = 5;  // Numero de filosofos

    public static void main(String[] args) {
        // Cada garfo será um semáforo
        Semaphore[] garfo = new Semaphore[N];

        for (int i = 0; i < N; i++) {
            garfo[i] = new Semaphore(1);
        }

        // Cria os filosofos e inicia cada um executando a sua thread
        Filosofos[] filosofo = new Filosofos[N];

        for (int i = 0; i < N; i++) {
            filosofo[i] = new Filosofos(i, garfo[i], garfo[(i + 1) % N]);
            new Thread(filosofo[i]).start();
        }

    }

}