package com.GA2.Q2;

import java.util.Scanner;


public class DriverClass {
	public static class Node{  
        int data;  
        Node left;  
        Node right;  
  
        public Node(int data){  
            this.data = data;  
            this.left = null;  
            this.right = null;  
        }  
      }   
      public Node root;  
      public DriverClass()
      {
    	  root=null;
      }
      public void insert(int data) {    
          Node newNode = new Node(data);  
          if(root == null){  
              root = newNode;  
              return;  
            }  
          else {  
              Node current = root, parent = null;  
  
              while(true) {  
                  parent = current;
                  if(data < current.data) {  
                      current = current.left;  
                      if(current == null) {  
                          parent.left = newNode;  
                          return;  
                      }  
                  }   
                  else {  
                      current = current.right;  
                      if(current == null) {  
                          parent.right = newNode;  
                          return;  
                      }  
                  }  
              }  
          }  
      }  
      public void inOrderTraversal(Node root)
      {
    	  if(root==null)
    	  {
    		  System.out.println("Tree is empty");
    		  return;
    	  }
    	  else
    	  {
    		  if(root.left!=null)
    			  inOrderTraversal(root.left);
    		  System.out.println(root.data);
    		  if(root.right!=null)
    			  inOrderTraversal(root.right);
    			  
    	  }
      }

	public static void main(String[] args) {
		DriverClass b = new DriverClass();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of values to insert into BST :");
		int n = sc.nextInt();
		System.out.println("Enter the values:");
		for(int i=0;i<n;i++)
		{
			b.insert( sc.nextInt());
		}
		System.out.println("Binary search tree after insertion:");  
		b.inOrderTraversal(b.root);
		sc.close();
	}

}
