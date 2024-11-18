package dumshenko.daniil;

public interface Stackable {
    boolean isEmpty();

    boolean isFull();

    void addElementToStack(int element);

    int deleteElementFromStack();

    int readTop();
}
