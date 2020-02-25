package ch.hslu.sw00;

public interface Memory {

    public Allocation malloc(final int memorySize);

    public void free(final Allocation alloc);
}
