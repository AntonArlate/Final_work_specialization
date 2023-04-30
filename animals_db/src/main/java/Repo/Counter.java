package Repo;

public class Counter implements AutoCloseable {
    private int value;

    public Counter() {
        this.value = 0;
    }

    public void add() {
        this.value++;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public void close() {
        System.out.println("Counter value: " + this.getValue());
    }
}
