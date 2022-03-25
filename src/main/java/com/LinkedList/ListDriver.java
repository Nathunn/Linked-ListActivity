package com.LinkedList;

public class ListDriver {

    public static void main(String[] args) {

        LinkedList<String> linkedlist = new SingleLinkedList<>();

        linkedlist.addFirst("1st"); // WHEN ADDING FIRST - SHIFT RIGHT
        linkedlist.addFirst("2nd");
        linkedlist.addFirst("3rd");
        linkedlist.addFirst("4th");
        linkedlist.addFirst("5th");

        linkedlist.addLast("6th"); // WHEN ADDING TO LAST - SHIFT TO LEFT
        linkedlist.addLast("7th");
        linkedlist.addLast("8th");

        System.out.println(linkedlist);
        System.out.println("Size: " + linkedlist.size());

        System.out.println(linkedlist.pollFirst());
        System.out.println(linkedlist.pollLast());
        System.out.println(linkedlist);

        linkedlist.clear();
        System.out.println(linkedlist);

        System.out.println("Size: " + linkedlist.size());



    }
}
