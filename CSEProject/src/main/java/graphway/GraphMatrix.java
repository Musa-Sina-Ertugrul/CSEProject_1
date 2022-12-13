/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphway;

/**
 *
 * @author musasina
 */
public class GraphMatrix {

    int[][] array;
    boolean[] visited;

    public GraphMatrix(int vertices) {
        array = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                array[i][j] = 0;
            }
        }
        this.visited = new boolean[vertices];
        for (int i = 0; i < this.visited.length; i++) {
            this.visited[i] = false;
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
        for (int i = 0; i < arrayWay.length; i++) {
            arrayWay[i] = -1;
        }
        int index = 0;
        // this part chose minimum and not visited node then repeate loop for found node
        for (int i = 0; i < this.array.length; i++) {
            if (!this.visited[node]) {
                this.visited[node] = true;
                arrayWay[i] = node;
                index++;
                int[] arrayTmp = new int[this.array.length];
                for (int j = 0; j < this.array[node].length; j++) {
                    if (j != node && !this.visited[j] && this.array[node][j] != 0) {
                        Integer[] visitedTmp = arrayWay.clone();
                        arrayTmp[j] = this.mstHelper(j, visitedTmp,index);
                    } else {
                        arrayTmp[j] = 5000;
                    }
                }
                node = this.minIndex(arrayTmp);
                
            }

        }
        return arrayWay;
    }

    int mstHelper(int node, Integer[] visitedTmp,int count) {
        visitedTmp[count]=node;
        count++;
        if (visitedTmp[visitedTmp.length-1] != -1 && count == this.array.length) {
            return -2000;
        }
        int num = 0;
        int[] arrayWay = new int[visitedTmp.length];
        for (int i = 0; i < arrayWay.length; i++) {
            if (!this.isThere(i, visitedTmp) && this.array[node][i] != 0) {
                Integer[] visitedNextTmp = visitedTmp.clone();
                int cost =  this.array[node][i];
                num = cost + this.mstHelper(i, visitedNextTmp,count);
                arrayWay[i] = num;
            } else {
                arrayWay[i] = 0;
            }

        }
        int returnNum = arrayWay[this.minIndex(arrayWay)];
        return returnNum;
    }

    boolean isFinished(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            if (!array[i]) {
                return false;
            }
        }
        return true;
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

    int minIndex(int[] array) {
        int num = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (num > array[i]) {
                index = i;
                num = array[i];
            }
        }
        return index;
    }
}
