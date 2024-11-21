package dumshenko.daniil;

public class Main {
    public static void main(String[] args) {
        Stackable stack = new Stack(5);

        stack.addElementToStack(10);
        stack.addElementToStack(20);
        stack.addElementToStack(30);

        System.out.println("Верхній елемент: " + stack.readTop());
        System.out.println("Дістати елемент: " + stack.deleteElementFromStack());
        System.out.println("Чи порожній стек: " + stack.isEmpty());
        System.out.println("Чи повний стек: " + stack.isFull());

        stack.addElementToStack(40);
        stack.addElementToStack(50);
        stack.addElementToStack(60);
    }
}