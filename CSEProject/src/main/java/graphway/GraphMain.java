/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphway;

/**
 *
 * @author musasina
 */
public class GraphMain {

    public static void main(String[] args) {
        // Testing
        
        /*GraphMatrix graph = new GraphMatrix(8);
        graph.insert(12, 1, 2);
        graph.insert(20, 1, 4);
        graph.insert(17, 1, 3);
        graph.insert(21, 2, 3);
        graph.insert(19, 2, 8);
        graph.insert(4, 3, 4);
        graph.insert(6, 3, 7);
        graph.insert(88, 3, 5);
        graph.insert(15, 4, 6);
        graph.insert(13, 4, 7);
        graph.insert(30, 5, 6);
        graph.insert(37, 5, 7);
        graph.insert(19,5, 8);
        graph.insert(44, 6, 7);
        graph.display();
        System.out.println("");
        Integer[] array = graph.mst(1);
        graph.printMst(array);*/
        GraphMatrix graph = new GraphMatrix(6);
        graph.insert(10, 1, 2);
        graph.insert(5, 1, 3);
        graph.insert(3, 1, 4);
        graph.insert(4, 2, 3);
        graph.insert(12, 3, 5);
        graph.insert(30, 3, 6);
        graph.insert(16, 5, 6);
        Integer[] array = graph.mst(3);
        graph.printMst(array);
        
    }
}
