package eu.navispeed;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class Referee {

    public static int[] evaluate(int[] choice, int[] solution) {
        Set<Integer> presentChar = new HashSet<>();
        int wellPlaced = 0;


        for (int i = 0; i < choice.length; ++i) { //Present
            for (int j = 0; j < choice.length; ++j) {
                if (choice[i] == solution[j]) {
                    presentChar.add(choice[i]);
                }
            }
        }

        for (int i = 0; i < choice.length; ++i) { //WelPlaced
            wellPlaced += (choice[i] == solution[i] ? 1 : 0);
        }
        return new int[] {presentChar.size() - wellPlaced, wellPlaced};
    }

    public static boolean isValid(int[] solution, Choice c) {

        if (solution.length != c.choice.length) {
            throw new InvalidParameterException("Length are different");
        }

        //5555
        //1234
        //5512


        int[] evaluate = evaluate(c.choice, solution);
        return evaluate[0] == c.present && evaluate[1] == c.wellPlaced;
    }
}
