package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int choice,orderchoice,data;
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        print.print_home();
        Scanner scan=new Scanner(System.in);
        while (true)
        {
            System.out.print("Input Your Choice:");
            choice=scan.nextInt();
            switch (choice)
            {
                case 1:
                    if (BinarySearchTree.root==null)
                    {
                        System.out.print("Input number and -1 to end:");
                        while (scan.hasNextInt())
                        {
                            data = scan.nextInt();
                            if (data != -1)
                            {
                                if (BinarySearchTree.root == null)
                                    BinarySearchTree.root = new Node(data);
                                else binarySearchTree.Store(BinarySearchTree.root, data);
                            } else break;
                        }
                        System.out.println("Success");
                    }
                    else System.out.println("You Already Have A BST");
                    break;
                case 2:BinarySearchTree.root=null; System.out.println("Success"); break;
                case 3:
                    if (BinarySearchTree.root!=null)
                    {
                        System.out.println("1-Preorder,2-InOrder,3-PostOrder.Your Choice?");
                        orderchoice=scan.nextInt();

                        switch (orderchoice)
                        {
                            case 1: binarySearchTree.PreOrder(BinarySearchTree.root); System.out.println(); break;
                            case 2: binarySearchTree.InOrder(BinarySearchTree.root); System.out.println(); break;
                            case 3: binarySearchTree.PostOrder(BinarySearchTree.root); System.out.println(); break;
                        }
                    }
                    else System.out.println("Maybe You Need To Creat A New BST First");
                    break;
                case 4:
                    data = scan.nextInt();
                    if (BinarySearchTree.root == null)
                        BinarySearchTree.root = new Node(data);
                    else
                        binarySearchTree.Store(BinarySearchTree.root,data);
                    System.out.println("Success");
                    break;
                case 5:
                    if (BinarySearchTree.root!=null)
                    {
                        data = scan.nextInt();
                        binarySearchTree.DeleteNode(BinarySearchTree.root,BinarySearchTree.root,data);
                        System.out.println("Success");
                    }
                    else System.out.println("Maybe You Need To Creat A New BST First");
                    break;
                case 6:
                    if (BinarySearchTree.root!=null)
                    {
                        data=scan.nextInt();
                        if (binarySearchTree.Search(BinarySearchTree.root,data)==false)
                            System.out.print("Not Find");
                        System.out.println();
                    }
                    else System.out.println("Maybe You Need To Creat A New BST First");
                    break;
                case 0:System.exit(0);
            }
        }
    }
}
