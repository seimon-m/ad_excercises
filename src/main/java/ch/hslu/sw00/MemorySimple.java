package ch.hslu.sw00;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MemorySimple implements Memory {

    private static final Logger LOG = LogManager.getLogger(MemorySimple.class);
    private int memorySize;
    private List<Boolean> reserved;

    public MemorySimple(final int memorySize) {
        this.memorySize = memorySize;
        reserved = new ArrayList<>(memorySize);
        for (int i = 0; i < memorySize; i++) {
            reserved.add(i, false);
        }
    }

    private int findEmptySpace() {
        return reserved.indexOf(false);
    }

    @Override
    public Allocation malloc(int memorySize) {
        int firstEmptyIndex = findEmptySpace();
        for (int i = firstEmptyIndex; i < firstEmptyIndex + memorySize; i++) {
            reserved.add(i, true);
        }
        return new Allocation(firstEmptyIndex, memorySize);
    }

    @Override
    public void free(Allocation alloc) {
        int startAdress = alloc.getStartAdress();
        int memorySize = alloc.getMemorySize();
        for (int i = startAdress; i < startAdress + memorySize; i++) {
            reserved.add(i, false);
        }
    }

    private boolean isBlockFree(final int startAdress, final int memorySize) {
        for (int i = startAdress; i < startAdress + memorySize; i++) {
            if (reserved.get(i)) {
                return false;
            }
        }
        return true;
    }

    private int getReservedMemory() {
        int counter = 0;
        for (boolean e : reserved) {
            if (e) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        int res = getReservedMemory();
        return "MemorySimple[" +
                "Belegt: " + res +
                "; Frei: " + (memorySize - res) +
                ']';
    }
}
