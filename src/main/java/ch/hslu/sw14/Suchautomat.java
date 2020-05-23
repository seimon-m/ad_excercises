package ch.hslu.sw14;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Suchautomat {

    private static final Logger LOG = LogManager.getLogger(Suchautomat.class);

    public static int stateSearch(final String a) {
        SearchState actualState = SearchState.z0;
        char[] string = a.toCharArray();
        int index = 0;

        do {
            switch (actualState) {
                case z0:
                    switch (string[index]) {
                        case 'A':
                            actualState = SearchState.z1;
                            break;
                        case 'S':
                        case 'N':
                        default:
                            actualState = SearchState.z0;
                            break;
                    }
                    break;
                case z1:
                    switch (string[index]) {
                        case 'A':
                            actualState = SearchState.z1;
                            break;
                        case 'N':
                            actualState = SearchState.z2;
                            break;
                        case 'S':
                        default:
                            actualState = SearchState.z0;
                            break;
                    }
                    break;
                case z2:
                    switch (string[index]) {
                        case 'A':
                            actualState = SearchState.z3;
                            break;
                        case 'N':
                        case 'S':
                        default:
                            actualState = SearchState.z0;
                            break;
                    }
                    break;
                case z3:
                    switch (string[index]) {
                        case 'A':
                            actualState = SearchState.z1;
                            break;
                        case 'N':
                            actualState = SearchState.z4;
                            break;
                        case 'S':
                        default:
                            actualState = SearchState.z0;
                            break;
                    }
                    break;
                case z4:
                    switch (string[index]) {
                        case 'A':
                            actualState = SearchState.z5;
                            break;
                        case 'N':
                        case 'S':
                        default:
                            actualState = SearchState.z0;
                            break;
                    }
                    break;
                case z5:
                    switch (string[index]) {
                        case 'A':
                            actualState = SearchState.z1;
                            break;
                        case 'N':
                            actualState = SearchState.z4;
                            break;
                        case 'S':
                            actualState = SearchState.z6;
                            break;
                        default:
                            actualState = SearchState.z0;
                            break;
                    }
                    break;
            }
            index++;
        } while ((actualState != SearchState.z6) && (index < a.length()));
        if (actualState == SearchState.z6) {
            return index - "ANANAS".length();
        } else {
            return -1;
        }
    }
}
