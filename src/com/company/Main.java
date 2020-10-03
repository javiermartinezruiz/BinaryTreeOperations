package com.company;

public class Main {

    private static BinaryTree createTree0(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node("*");
        binaryTree.root.left = new Node("+");
        binaryTree.root.right = new Node("+");

        binaryTree.root.left.left = new Node("3");
        binaryTree.root.left.right = new Node("2");
        binaryTree.root.right.left = new Node("4");
        binaryTree.root.right.right = new Node("5");
        return binaryTree;
    }

    private static BinaryTree createTree1(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node("*");
        binaryTree.root.left = new Node("+");
        binaryTree.root.right = new Node("1");
        binaryTree.root.left.left = new Node("5");
        binaryTree.root.left.right = new Node("/");
        binaryTree.root.left.right.left = new Node("2");
        binaryTree.root.left.right.right = new Node("2");
        return binaryTree;
    }

    private static BinaryTree createTree2(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node("*");
        binaryTree.root.left = new Node("+");
        binaryTree.root.right = new Node("-");

        binaryTree.root.left.left = new Node("5");
        binaryTree.root.left.right = new Node("/");
        binaryTree.root.left.right.left = new Node("2");
        binaryTree.root.left.right.right = new Node("2");

        binaryTree.root.right.left = new Node("3");
        binaryTree.root.right.right = new Node("3");

        return binaryTree;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = createTree0();
        binaryTree.traversePreOrder(binaryTree.root);
        System.out.println("Init: "+binaryTree.stack);

        String temp = null;

        Integer finalResult = null;

        while(!binaryTree.stack.empty()){
            //Evaluates if the value is an operator
            String value = (String) binaryTree.stack.pop();
            String value2 = (String) binaryTree.stack.pop();
            String operator = (String) binaryTree.stack.pop();
            System.out.println("Operator: "+operator);

            if(!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")){
                //Is a number
                temp = value;
                value = value2;
                value2 = operator;
                operator = (String) binaryTree.stack.pop();
            }

            Integer result = null;
            if(operator.equals("+")){
                result = Integer.parseInt(value) + Integer.parseInt(value2);
            }else if(operator.equals("-")){
                result = Integer.parseInt(value) - Integer.parseInt(value2);
            }else if(operator.equals("*")){
                result = Integer.parseInt(value) * Integer.parseInt(value2);
            }else if(operator.equals("/")){
                result = Integer.parseInt(value) / Integer.parseInt(value2);
            }
            System.out.println("Temp Result: "+result);
            if(!binaryTree.stack.isEmpty()){
                binaryTree.stack.push(result+"");
                System.out.println("After operation: "+binaryTree.stack);
                if(binaryTree.stack.size()<3){
                    binaryTree.stack.push(temp);
                    System.out.println("After adding temp: "+binaryTree.stack);
                }
            }

            finalResult = result;

        }

        System.out.println("Final Result: "+finalResult);

    }
}
