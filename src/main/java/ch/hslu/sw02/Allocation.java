package ch.hslu.sw02;

import java.util.Objects;

final public class Allocation implements Comparable<Allocation> {
    final private int startAdress;
    final private int memorySize;

    public Allocation(final int startAdress, final int memorySize) {
        this.startAdress = startAdress;
        this.memorySize = memorySize;
    }

    public Allocation(final Allocation alloc)
    {
        this.startAdress = alloc.getStartAdress();
        this.memorySize = alloc.getMemorySize();
    }

    public int getStartAdress() {
        return this.startAdress;
    }

    public int getMemorySize() {
        return this.memorySize;
    }

    @Override
    final public boolean equals(final Object object) {
        if(object == this) {
            return true;
        }
        if (!(object instanceof Allocation)) {
            return false;
        }
        final Allocation other = (Allocation) object;
        return (this.memorySize == other.memorySize) && (this.startAdress == other.startAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startAdress, memorySize);
    }

    @Override
    public int compareTo(Allocation o) {
        return Integer.compare(this.startAdress, o.startAdress);
    }

    @Override
    public String toString() {
        return "Allocation[Address:" + this.startAdress + "; Size:" + this.memorySize + "]";
    }
}
