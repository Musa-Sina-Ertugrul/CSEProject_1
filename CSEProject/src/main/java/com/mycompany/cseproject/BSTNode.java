/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cseproject;

/**
 *
 * @author musasina
 */
public class BSTNode {
    String data;
    int value;
    String meaning;
    BSTNode right;
    BSTNode left;
    
    
    public BSTNode(String data,String meaning){
        this.data = data;
        this.meaning = meaning;
        this.left = null;
        this.right = null;
        this.value = (int) this.data.charAt(1);
    }
}
