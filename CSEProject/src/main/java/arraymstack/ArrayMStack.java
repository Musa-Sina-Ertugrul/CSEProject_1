/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraymstack;

/**
 *
 * @author musasina
 */
public class ArrayMStack<AnyType> {

    Object[] array;
    int[] ends;
    int length;
    int pieces;
    // I added base and it points this because, when we rebuild this item 
    //we cannot point new item with this clause so i point it with base pointer 
    ArrayMStack base;

    public ArrayMStack(int length, int piece) {
        // initiliaze 
        this.array = new Object[length * piece + piece - 1];
        this.ends = new int[piece - 1];
        this.length = length;
        this.pieces = piece;
        for (int i = 1; i < this.pieces; i++) {
            array[i * length + i - 1] = new String("|");
        }
        for (int i = 0; i < this.ends.length; i++) {
            this.ends[i] = (i + 1) * length + i;
        }
        base = this;
    }

    // This method pop items from stack
    Object pop(int index) {
        Object tmp = null;
        Object prevTmp = tmp;
        for (int i = 0; i < this.length; i++) {
            //point two adjacent index
            prevTmp = tmp;
            tmp = this.base.array[index * this.base.length + i + index];
            // checks did loop reach last index
            if ((tmp == null && i != 0) || this.base.array[index * this.base.length + i + index].equals(new String("|"))) {
                this.base.array[index * this.base.length + i + index - 1] = null;
                return prevTmp;
            }
            //checks is stack empty
            if (i == 0 && tmp == null) {
                return null;
            }

        }
        return prevTmp;
    }

    // this method push item to stack
    void push(int index, int value) {
        //this part push item
        for (int i = 0; i < this.length; i++) {
            if (this.base.array[index * this.base.length + i + index] == null) {
                this.base.array[index * this.base.length + i + index] = new Integer(value);
                return;
            }
            if (this.base.array[index * this.base.length + i + index].equals(new String("|"))) {
                break;
            }
        }
        // this part works if stack is full and rebuild array then push item
        this.reBuild();
        for (int i = 0; i < this.base.length; i++) {
            if (this.base.array[index * this.base.length + i + index] == null) {
                this.base.array[index * this.base.length + i + index] = new Integer(value);
                return;
            }
        }
    }
    //this method rebuild array when stack is full
    void reBuild() {
        // this part initiliaze array
        int oldLength = this.length;
        this.length = this.length * 2;
        ArrayMStack array = this;
        base = new ArrayMStack(this.length, this.pieces);
        int index = 0;
        for (int i = 0; i < this.pieces; i++) {
            // this part re push items
            while (array.array[oldLength * i + index] != null && !array.array[oldLength * i + index].equals(new String("|"))) {
                base.array[this.length * i + index + i] = array.array[oldLength * i + index + i];
                index++;
            }
            index = 0;
        }

    }

    int howManyBig(int value, int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (value > array[i]) {
                index++;
            }
            if (value < array[i]) {
                break;
            }
        }

        return index;
    }

    void printThis() {
        for (int i = 0; i < this.base.array.length; i++) {
            if (this.base.array[i] == null) {
                continue;
            }
            System.out.print(this.base.array[i].toString() + " ");
        }
    }

    boolean isThere(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    void printEnds() {
        for (int i = 0; i < this.base.ends.length; i++) {
            System.out.print(this.base.ends[i] + " ");
        }
    }
}
