/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cseproject;

/**
 *
 * @author musasina
 */
public class BST {

    BSTNode root;

    public BST() {
        this.root = null;
    }
    // this method inserts node
    BSTNode insert(BSTNode node, BSTNode newNode) {
        if (node == null) {
            return newNode;
        }
        if (node.value > newNode.value) {
            node.left = this.insert(node.left, newNode);
            return node;
        } else {
            node.right = this.insert(node.right, newNode);
            return node;
        }
    }

    void postOrder(BSTNode node) {
        if (node.left != null) {
            this.postOrder(node.left);
        }
        if (node.right != null) {
            this.postOrder(node.right);
        }
        System.out.print(node.data + " ");
    }
    
    void search(String word){
        BSTNode node = this.root;
        int value = (int) word.charAt(1);
        while(node.data.equals(word) && node != null){
            if(value< node.value)
                node = node.left;
            else
                node = node.right;
        }
        
        if(node== null)
            return;
        System.out.println(node.data + " " + node.meaning);
    }
}
