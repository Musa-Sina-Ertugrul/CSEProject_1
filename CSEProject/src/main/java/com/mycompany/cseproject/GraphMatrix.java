/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cseproject;

/**
 *
 * @author musasina
 */
public class GraphMatrix {

    int[][] array;

    public GraphMatrix(int vertices) {
        array = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                array[i][j] = 0;
            }
        }
    }

    void insert(int value, int vertex1, int vertex2) {
        this.array[vertex1 - 1][vertex2 - 1] = value;
        this.array[vertex2 - 1][vertex1 - 1] = value;
    }

    void display() {
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }
    // this method finds way
    Integer[] mst(int node) {
        Integer[] arrayWay = new Integer[this.array.length];
        int num;
        if (node != 0) {
            num = this.array[0][node];
        } else {
            num = this.array[0][1];
        }
        for (int i = 0; i < arrayWay.length; i++) {
            arrayWay[i] = -1;
        }
        int index = node;
        arrayWay[0] = node;
        // this part chose minimum and not visited node then repeate loop for found node
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array.length; j++) {
                if (!this.isThere(j, arrayWay)) {
                    if (num > this.array[node][j] && node != j) {
                        if (this.array[node][j] != 0) {
                            num = this.array[node][j];
                            index = j;
                        }
                    }
                }
            }
            node = index;
            arrayWay[i] = index;
            num = 100;
        }
        return arrayWay;
    }

    boolean isThere(int value, Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
    
    void printMst(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            char vertex = (char) ((int) array[i] + 65);
            System.out.print("---> " + String.valueOf(vertex) + " ");
        }

    }
}
