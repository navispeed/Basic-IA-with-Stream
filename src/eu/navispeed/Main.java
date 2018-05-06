package eu.navispeed;

import eu.navispeed.ia.StreamIa;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {


    public static final int LENGTH = 7;
    public static final int BASE = 10;

    private static int[] generateRandomConbinaison(int length, int usable) {
        Random r = new Random();
        return IntStream.generate(() -> r.nextInt(usable)).limit(length).toArray();
    }

    public static void main(String[] args) {
        StreamIa streamIa = new StreamIa(BASE - 1, LENGTH);
        System.out.println("Nb element:" + streamIa.length());

        int combinaison[] = generateRandomConbinaison(LENGTH, BASE);

        System.out.println("Combinaison " + Arrays.toString(combinaison));

        int[] play;
        while (true) {
            System.out.println("Nb element:" + streamIa.length());
            play = streamIa.play();
            System.out.println("Try " + Arrays.toString(play));

            int[] evaluate = Referee.evaluate(play, combinaison);
            if (Arrays.equals(play, combinaison)) {
                break;
            }
            streamIa.response(new Choice(evaluate[0], evaluate[1], play));
        }

        System.out.println("Finish, response: " + Arrays.toString(play));

	// write your code here
    }
}
