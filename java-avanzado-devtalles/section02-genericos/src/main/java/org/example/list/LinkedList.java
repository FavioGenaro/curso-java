package org.example.list;

public class LinkedList<T> {
    private Node<T> head; // Nodo inicial

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(head==null){
            head = newNode;
        }else{
            Node<T> current = head;
            while (current.next!=null){
                current = current.next;
            }
            // cuando sea null, el bucle se detiene y next pasa a ser el nuevo nodo
            current.next = newNode;
        }
    }

    public void printList(){
        Node<T> current = head;
        while (current != null){
            System.out.println("Elemento: " + current.data);
            current = current.next;
        }
    }

    public void updateList(T oldData, T newData){
        Node<T> current = head;
        while (current != null){
            // reemplaza el valor del primero que encuentra
            if(current.data.equals(oldData)) {
                current.data = newData;
                return;
            }
            current = current.next;
        }
    }

    public void delete(T data){

        if(head==null) {
            return;
        }
        // esta en el primer elemento
        if(head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> previus = head;

        // hasta que current sea el elemento a eliminar
        while (current != null && !current.data.equals(data)){
            previus = current;
            current = current.next;
        }

        if(current == null) {
            return;
        }
        // se elimina el elemento del medio o el current
        previus.next = current.next;
    }
}
