package com.LinkedList;

import java.util.StringJoiner;

public class SingleLinkedList<E> implements LinkedList<E> { // BE CAREFUL WITH ORDER.

    private Node head; // need these for the linkedlist
    private Node tail; // need these for the linkedlist
    private int counter;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(E element) {

        Node newNode = new Node(element, head); // Takes care of steps 1 & 2.

        if(head == null)
        {
            head = newNode;
            tail = head;
        } else {
            head = newNode;
        }

    }

    public void addLast(E element) {

        Node newNode = new Node(element, null);
        tail.next = newNode;
        tail = newNode;

    }

    public E pollFirst() {
        E element;
        if(head == null)
        {
            element = null;

        }
        else {

            element = head.element;

            if(head == tail)
            {
                head = null;
                tail = null;
            } else {
                Node next = head.next;
                head.next = null;
                head = next;
            }
        }
        return element;
    }

    public E pollLast() {

        E element;
        if(head == null)
        {
            element = null;
        } else {
            element = tail.element;
            if(head == tail)
            {
                head = null;
                tail = null;
            } else {
                Node current = head;
                Node previous = head;

                //Walking the List
                while(current.next != null)
                {
                    previous = current;
                    current = current.next;
                }
                tail = previous;
                tail.next = null;
            }
        }
        return element;
    }

    public E peekFirst() {
        return head.element;
    }

    public E peekLast() {
        return tail.element;
    }

    public void clear() {
        Node current = head;
        while(current.next != null)
        {
            Node next = current.next;
            current.next = null;
            current = next;
        }
        head = null;
        tail = null;
    }

    public boolean contains(E element) {

        boolean contains = false;
        Node current = head;
        while(current != null)
        {
            Node next = current.next;
            if(current.element == element)
            {
                contains = true;
                break; // No need to continue scrubbing list if we already found what we need.
            }
            current = next;
        }
        return contains;
    }

    public int size() {
        int counter = 0;
        if(head != null)
        {
            if(head == tail)
            {
                counter++;
            } else {
                Node current = head;
                while(current != null)
                {
                    counter++;
                    current = current.next;
                }
            }
        }


        return counter;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder("[");
        StringJoiner joiner = new StringJoiner(", ");
        Node current = head;
        if(current != null)
        {
            while(current != null)
            {
                joiner.add(current.element.toString());
                current = current.next;
            }
        }
        builder.append(joiner);
        builder.append("]");

        return builder.toString();
    }

    private class Node { // Imported as an inner class

        E element;
        Node next;

        public Node(E element, Node next) { //This will create Nodes (NEEDS TO BE IN INNER CLASS)
            this.element = element;
            this.next = next;
        }
    }
}
