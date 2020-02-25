package ch.hslu.sw00;

import java.util.ArrayList;
import java.util.List;

public class MemorySimple implements Memory {

    private int memorySize;
    private List<Boolean> reserved;

    public MemorySimple(final int memorySize) {
        this.memorySize = memorySize;
        reserved = new ArrayList<>();
    }

    private int findEmptySpace() {
        return reserved.indexOf(false);
    }

    @Override
    public Allocation malloc(int memorySize) {
        return null;
    }

    @Override
    public void free(Allocation alloc) {

    }
}
