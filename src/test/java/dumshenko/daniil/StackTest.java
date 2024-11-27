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
        // When
        stack.addElementToStack(10);
        stack.addElementToStack(20);
        stack.addElementToStack(30);
        stack.addElementToStack(40);

        assertEquals(40, stack.readTop());

        stack.addElementToStack(50);

        // Then
        assertTrue(stack.isFull());
    }

    @Test
    void shouldDeleteElementFromStack() {
        // When
        stack.addElementToStack(10);
        stack.addElementToStack(20);
        stack.addElementToStack(40);
        stack.addElementToStack(50);
        stack.addElementToStack(60);

        int topElement = stack.readTop();

        stack.deleteElementFromStack();

        int topElementAfterDeleted = stack.readTop();

        // Then
        assertNotEquals(topElementAfterDeleted, topElement);
    }

    @Test
    void shouldReturnTopElement() {
        // When
        stack.addElementToStack(10);
        stack.addElementToStack(20);
        stack.addElementToStack(40);
        stack.addElementToStack(50);
        stack.addElementToStack(60);

        int topElement = stack.readTop();

        // Then
        assertEquals(60, topElement);
    }

    @Test
    void shouldReturnIsEmpty() {
        // When
        assertTrue(stack.isEmpty());

        // Then
        stack.addElementToStack(10);
        assertFalse(stack.isEmpty());
    }

    @Test
    void shouldReturnIsFull() {
        // Given
        stack.addElementToStack(10);
        stack.addElementToStack(20);
        stack.addElementToStack(30);
        stack.addElementToStack(40);
        stack.addElementToStack(50);

        // When
        assertTrue(stack.isFull());

        // Then
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

    @Test
    void shouldThrowExceptionWhenAddingToFullStack() {
        // Given
        stack.addElementToStack(10);
        stack.addElementToStack(20);
        stack.addElementToStack(30);
        stack.addElementToStack(40);
        stack.addElementToStack(50);

        // When & Then
        Exception exception = assertThrows(IllegalStateException.class, () -> stack.addElementToStack(60));
        assertEquals("Стек переповнений", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDeletingFromEmptyStack() {
        // When & Then
        Exception exception = assertThrows(IllegalStateException.class, stack::deleteElementFromStack);
        assertEquals("Стек порожній", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenReadingTopOfEmptyStack() {
        // When & Then
        Exception exception = assertThrows(IllegalStateException.class, stack::readTop);
        assertEquals("Стек порожній", exception.getMessage());
    }
}
