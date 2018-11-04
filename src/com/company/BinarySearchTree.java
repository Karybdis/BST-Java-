package com.company;

public class BinarySearchTree
{
    public static Node root=null;

    public void Store(Node root,int data)
    {
        if (data < root.getData())
        {
            if (root.getLeft() == null)
                root.setLeft(new Node(data));
            else Store(root.getLeft(), data);
        }
        else if (data > root.getData())
        {
            if (root.getRight() == null)
                root.setRight(new Node(data));
            else Store(root.getRight(), data);
        }
    }

    public void PreOrder(Node root)
    {
        System.out.print(root.getData() + " ");
        if (root.getLeft() != null)
            PreOrder(root.getLeft());
        if (root.getRight() != null)
            PreOrder(root.getRight());
    }

    public void InOrder(Node root)
    {
        if (root.getLeft() != null)
            InOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        if (root.getRight() != null)
            InOrder(root.getRight());
    }

    public void PostOrder(Node root)
    {
        if (root.getLeft() != null)
            PostOrder(root.getLeft());
        if (root.getRight() != null)
            PostOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }

    public boolean Search(Node root,int data)
    {
        if (data < root.getData())
        {
            if (root.getLeft() != null)
            {
                if (Search(root.getLeft(),data) == true)
                {
                    System.out.print(root.getData() + " ");
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else if (data > root.getData())
        {
            if (root.getRight() != null)
            {
                if (Search(root.getRight(),data) == true)
                {
                    System.out.print(root.getData() + " ");
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else
        {
            System.out.print(root.getData()+" ");
            return true;
        }
    }

    public void DeleteNode(Node root,Node parent,int data)
    {

        if (data < root.getData())
        {
            if (root.getLeft() != null)
                DeleteNode(root.getLeft(),root,data);
        }
        else if (data > root.getData())
        {
            if (root.getRight() != null)
                DeleteNode(root.getRight(),root,data);
        }
        else Delete(root,parent);

    }

//    public void Delete(Node root,Node parent)
//    {
//        Node node,node1;
//        if (root.getLeft()==null)
//            node=root.getRight();
//        else if (root.getRight()==null)
//            node=root.getLeft();
//        else
//        {
//            node1=root;
//            node=root.getLeft();
//            while(node.getRight()!=null)
//            {
//                node1=node;
//                node=node.getRight();
//            }
//            if (node1==root)
//                node1.setLeft(node.getLeft());
//            else
//                node1.setRight(node.getLeft());
//            root.setData(node.getData());
//            return;
//        }
//        if (root==parent) this.root = node;
//        else if (parent.getLeft()==root) parent.setLeft(node);
//        else parent.setRight(node);
//        return;
//    }


    public void Delete(Node root,Node parent)
    {
        Node node,node1;
       if (root.getLeft()!=null)
       {

            node1=root;
            node=root.getLeft();
            while(node.getRight()!=null)
            {
                node1=node;
                node=node.getRight();
            }
            if (node1==root)
                node1.setLeft(node.getLeft());
            else
                node1.setRight(node.getLeft());
            root.setData(node.getData());
            return;
        }
        else if (root.getRight()!=null)
       {
           node1=root;
           node=root.getRight();
           while(node.getLeft()!=null)
           {
               node1=node;
               node=node.getLeft();
           }
           if (node1==root)
               node1.setRight(node.getRight());
           else
               node1.setLeft(node.getRight());
           root.setData(node.getData());
           return;
       }
       else if (root==parent) this.root=null;
       else if (root==parent.getRight()) parent.setRight(null);
       else parent.setLeft(null);
    }
}
