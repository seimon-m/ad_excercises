/*
 * Copyright 2020 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.sw08.latch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Eine Rennbahn für das Pferderennen.
 */
public final class Turf {

    private static final Logger LOG = LogManager.getLogger(Turf.class);
    private static ArrayList<Thread> threads = new ArrayList<>();

    /**
     * Privater Konstruktor.
     */
    private Turf() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) throws InterruptedException {
        final int numberOfHorses = 5;
        final Synch starterBox = new Latch(numberOfHorses);
        for (int i = 0; i < numberOfHorses; i++) {
            threads.add(new Thread(new RaceHorse(starterBox), "Horse " + i));
            threads.get(i).start();
        }
        starterBox.release();
        //abort();
    }

    public static void abort() {
        for (int i = 0; i < 5; i++) {
            threads.get(i).interrupt();
        }
    }
}
