package dumshenko.daniil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(5);
    }

    @Test
    void shouldReturnAddedElement() {
        //Given


        //When
        stack.addElementToStack(10);
        stack.addElementToStack(20);
        stack.addElementToStack(30);
        stack.addElementToStack(40);

        assertEquals(40, stack.readTop());

        stack.addElementToStack(50);

        //Then
        assertTrue(stack.isFull());
    }

    @Test
    void shouldDeleteElementFromStack() {
        //Given


        //When
        stack.addElementToStack(10);
        stack.addElementToStack(20);
        stack.addElementToStack(40);
        stack.addElementToStack(50);
        stack.addElementToStack(60);

        int topElement = stack.readTop();

        stack.deleteElementFromStack();

        int topElementAfterDeleted = stack.readTop();

        //Then
        assertNotEquals(topElementAfterDeleted, topElement);
    }

    @Test
    void shouldReturnTopElement() {
        //Given

        //When
        stack.addElementToStack(10);
        stack.addElementToStack(20);
        stack.addElementToStack(40);
        stack.addElementToStack(50);
        stack.addElementToStack(60);

        int topElement = stack.readTop();

        //Then
        assertEquals(60, topElement);
    }

    @Test
    void shouldReturnIsEmpty() {
        //Given


        //When
        assertTrue(stack.isEmpty());

        //Then
        stack.addElementToStack(10);
        assertFalse(stack.isEmpty());
    }

    @Test
    void shouldReturnIsFull() {
        //Given
        stack.addElementToStack(10);
        stack.addElementToStack(20);
        stack.addElementToStack(30);
        stack.addElementToStack(40);
        stack.addElementToStack(50);


        //When
        assertTrue(stack.isFull());

        //Then
        stack.deleteElementFromStack();
        assertFalse(stack.isFull());
    }

    @Test
    void shouldReturnOptionalTopElement() {
        // Given
        stack.addElementToStack(10);
        stack.addElementToStack(20);
        stack.addElementToStack(30);

        // When
        Optional<Integer> topElement = stack.getTopOptional();

        // Then
        assertTrue(topElement.isPresent());
        assertEquals(30, topElement.get());

        // Check for empty Optional
        stack.deleteElementFromStack();
        stack.deleteElementFromStack();
        stack.deleteElementFromStack();
        Optional<Integer> emptyElement = stack.getTopOptional();
        assertTrue(emptyElement.isEmpty());
    }
}