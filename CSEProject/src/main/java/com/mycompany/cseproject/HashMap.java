/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cseproject;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author musasina
 */
public class HashMap {
    HashNode[] array;
    int length;
    public HashMap(int length){
        this.array = new HashNode[length];
        this.length = length;
        for(int i = 0;i<this.length;i++){
            this.array[i] = new HashNode();
        }
    }
    
    int hash(String data){
        return data.charAt(0)%length;
    }
    
    void show(){
        for(int i = 0;i<this.array.length;i++){
            array[i].bst.postOrder(array[i].bst.root);
            System.out.println("");
        }
    }
    // this send to bst insert method
    void insert(String data,String meaning){
        int index = this.hash(data);
        BSTNode node = new BSTNode(data,meaning);
        this.array[index].bst.root = this.array[index].bst.insert(this.array[index].bst.root, node);
    }
    // this part read from txt and send them to insert method
    void insertFromTxT() throws FileNotFoundException, IOException{
        Scanner infTaker = new Scanner(System.in);
        String fileWay = infTaker.nextLine();
        File file = new File(fileWay);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String[] words;
        while((line = br.readLine()) != null){
             words=line.split(" ", 2);
             this.insert(words[0], words[1]);
        }
    }
    
    void search(String word){
        int index = this.hash(word);
        this.array[index].bst.search(word);
    }
}
