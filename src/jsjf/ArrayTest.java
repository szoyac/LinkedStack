 package jsjf;

import java.util.Scanner;
import jsjf.exceptions.EmptyCollectionException;

/**
 * @author Stephen Zoyac 
 * @Date: 9/13/20 
 * Fall 2020
 * ADT - Stack Program 1 
 * This program runs a menu for an ArrayStack, which implements the StackADT. 
 * The menu has 5 options, 1 to push an element on the stack, 2 to pop 
 * an element on the stack,  3 to see the element on top of the stack,
 * 4 to display all the elements of the stack, and 5 to close the program. 
 * If the stack is empty, and if the user tries to pop, peek, or display 
 * an empty stack, the exception will be caught, and the program will continue.
 */
public class ArrayTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayStack<String> stk = new ArrayStack<String>();

        int menu = 0;
        do {
            System.out.println("Stack Menu Selections\n1.push \n2.pop "
                    + "\n3.peek \n4.display \n5.exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            menu = Integer.parseInt(input.next());
            switch (menu) {

                case 1:
                    System.out.print("Enter element: ");
                    String element = input.next();
                    stk.push(element);
                    break;
                case 2:
                    if (stk.isEmpty()) {
                        try {
                            throw new EmptyCollectionException("stack");
                        } catch (EmptyCollectionException e) {
                            System.out.println(e);
                            System.out.println();
                            break;

                        }

                    }

                    System.out.println("Popped element is " + stk.peek());
                    stk.pop();
                    break;
                case 3:
                    if (stk.isEmpty()) {
                        try {
                            throw new EmptyCollectionException("stack");
                        } catch (EmptyCollectionException e) {
                            System.out.println(e);
                            System.out.println();
                            break;
                            
                        }
                    }
                    System.out.println("Element at the top of the stack is " + stk.peek());
                    break;
                case 4:
                    
                    stk.Display();
                    System.out.println();
                    break;
                case 5:
                    System.exit(0);
                    break;

            }

        } while (menu <= 5);

    }

}
