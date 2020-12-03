
package jsjf;

import jsjf.exceptions.*;
import java.util.Arrays;

/**
 * An array implementation of a stack which the bottom of the stack is fixed at
 * index 0.
 *
 */
public class ArrayStack<T> implements StackADT<T> {

    private final static int DEFAULT_CAPACITY = 100;

    private int top;
    private T[] stack;

    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty stack using the specified capacity.
     *
     * @param initialCapacity the initial size of the array
     */
    public ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) (new Object[initialCapacity]);

    }

    /**
     * Adds the specified element to the top of this stack, expanding the
     * capacity of the array if necessary.
     *
     * @param element generic element to be pushed onto stack
     */
    public void push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }

        stack[top] = element;
        top++;
    }

    /**
     * Creates a new array to store the contents of this stack with twice the
     * capacity of the old one.
     */
    public void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    /**
     * Removes the element at the top of this stack and returns a reference to
     * it.
     *
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            try{
            throw new EmptyCollectionException("stack");
            }catch(EmptyCollectionException e){
                System.out.println(e);
            }
        }

        top--;
        T result = stack[top];
        stack[top] = null;

        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack. The element
     * is not removed from the stack.
     *
     * @return element on top of stack.
     * @throws EmptyCollectionException if stack is empty.
     */
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            try{
            throw new EmptyCollectionException("stack");
            }catch(EmptyCollectionException e){
                System.out.println(e);
                return stack[top];
            }
        }
        return stack[top - 1];
    }

    /**
     * Returns true if this stack contains no elements.
     *
     * @return true if the stack is empty
     */

    public boolean isEmpty() {
        if (top > 0) {
            return false;
        }

        return true;

    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in the stack
     */
    public int size() {

       
        return top;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return a string representation of the stack
     */

    public String toString() {
        String strElement = "";
        for(int i = 0; i < top; i++)
            strElement = (String)stack[i];
            
        return strElement;
    }
    /**
    * Displays elements inside of the stack.
    * @return elements of the stack
    */
    
    public void Display(){
        
       if (isEmpty()) {
            try{
            throw new EmptyCollectionException("stack");
            }catch(EmptyCollectionException e){
                System.out.println(e);
            }
        }

        for (int i = 0; i < top; i++){
                  System.out.print(stack[i].toString()+ " ");
                  
        }
        
        
    
    }

}
