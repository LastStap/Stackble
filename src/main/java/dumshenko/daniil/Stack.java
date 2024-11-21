package dumshenko.daniil;

public class Stack implements Stackable {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int max) {
        this.maxSize = max;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    @Override
    public void addElementToStack(int element) {
        if (isFull()) {
            throw new IllegalStateException("Стек переповнений");
        }
        stackArray[++top] = element;
    }

    @Override
    public int deleteElementFromStack() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек порожній");
        }
        return stackArray[top--];
    }

    @Override
    public int readTop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек порожній");
        }
        return stackArray[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }
}
