package com.company;

import java.util.Stack;

public class BinaryTree {

    Node root;
    Stack stack = new Stack();

    public void traversePreOrder(Node current){
        if(current==null){
            return;
        }
        stack.push(current.value);
        traversePreOrder(current.left);
        traversePreOrder(current.right);
    }
}
