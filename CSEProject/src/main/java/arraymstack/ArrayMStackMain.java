/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraymstack;

/**
 *
 * @author musasina
 */
public class ArrayMStackMain {

    public static void main(String[] args) {
        //Testing
        ArrayMStack arrayStack = new ArrayMStack(5, 2);
        arrayStack.push(0, 1);
        arrayStack.push(0, 1);
        arrayStack.push(0, 1);
        arrayStack.push(0, 1);
        arrayStack.push(0, 1);
        arrayStack.push(1, 1);
        arrayStack.push(1, 1);
        arrayStack.push(1, 1);
        System.out.println(arrayStack.pop(1));
        System.out.println(arrayStack.pop(1));
        System.out.println(arrayStack.pop(1));
        arrayStack.printThis();
        System.out.println();
        arrayStack.printEnds();
    }
}
