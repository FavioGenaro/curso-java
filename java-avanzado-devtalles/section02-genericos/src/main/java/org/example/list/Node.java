package org.example.list;

// Un nodo representa un elemento en la lista
public class Node<T> {

    T data;
    Node<T> next;

    // constructor
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
