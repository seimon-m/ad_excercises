package ch.hslu.sw13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Wordproblem {

    private static final Logger LOG = LogManager.getLogger(Wordproblem.class);

    public static boolean isWordLanguage(final String string) {
        State actualState = State.z0;
        char[] words = string.toCharArray();

        for (char word : words) {
            switch (word) {
                case '0':
                    switch (actualState) {
                        case z0:
                            actualState = State.z1;
                            break;

                        case z2:
                            actualState = State.z4;
                            break;

                        default:
                            return false;
                    }
                    break;

                case '1':
                    switch (actualState) {
                        case z1:
                        case z3:
                        case z4:
                            actualState = State.z2;
                            break;

                        case z2:
                            actualState = State.z3;
                            break;

                        default:
                            return false;
                    }
                    break;

                default:
                    return false;
            }
        }
        return State.z4.equals(actualState) || State.z1.equals(actualState);
    }
}
