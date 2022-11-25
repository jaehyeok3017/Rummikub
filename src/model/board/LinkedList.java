package model.board;

import java.util.ArrayList;

public class LinkedList {
    public static class Node {
        private final String data;
        private Node next;

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        public String getData() {
            return this.data;
        }
    }

    private static Node head;

    public LinkedList() {
        head = null;
    }

    public static void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void addLast(String data) {
        Node newNode = new Node(data);

        if (head == null) head = newNode;
        else {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
    }

    public static void addMid(String data) {
        Node newNode = new Node(data);
        Node preNode = head;

        for (int i = 1; i < 2; i++)
            preNode = preNode.next;

        newNode.next = preNode.next;
        preNode.next = newNode;
    }

    public static void remove(String data) {
        Node preNode = head;
        Node tempNode = head.next;

        if (data.equals(preNode.getData())) {
            head = preNode.next;
            preNode.next = null;
        }

        while (tempNode != null) {
            if (data.equals(tempNode.getData())) {
                preNode.next = tempNode.next;
                tempNode.next = null;
                break;
            } else {
                preNode = tempNode;
                tempNode = tempNode.next;
            }
        }

        if (tempNode.next == null)
            System.out.println(data + "노드가 존재하지 않습니다.");
    }

    public static void printList() {
        if (head == null) System.out.println("리스트가 비어 있습니다");
        else {
            Node tempNode = head;
            while (tempNode != null) {
                if (tempNode.next != null) {
                    System.out.print(tempNode.getData() + " -> ");
                } else System.out.print(tempNode.getData());
                tempNode = tempNode.next;
            }
            System.out.println();
        }
    }
}