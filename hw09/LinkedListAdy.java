package hw09;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedListAdy<T> {
    private Node<T> head;
    private int size;

    public LinkedListAdy() {
        this.head = null;
        this.size = 0;
    }

    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index needs to be "
                    + "between 0 and size");
        } else {
            Node<T> temp = new Node<>(data, null);
            Node<T> current = head;
            if (size == 0) { //ask someone about this
                head = temp;
                head.setNext(head);
            } else if (index == 0) {
                temp.setNext(head.getNext());
                temp.setData(head.getData());
                head.setNext(temp);
                head.setData(data);
            } else if (index == size) {
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(temp);
                temp.setNext(head); // does the end of a linkedList point to the beginning head node?
            } else {
                for (int i = 0; i < index - 1; i++) {
                    current = current.getNext();
                }
                temp.setNext(current.getNext());
                current.setNext(temp);
            }

        }
    }

    public T removeFromIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Index needs to be "
                    + "between 0 and size");
        }
        T data;
        Node<T> temp = new Node<>(head.getData(), null);
        Node<T> current = head;
        if(head.getNext() == null) {
            data = head.getData();
            head = null;
        }
        if (index == 0) {
            data = head.getData();
            head = head.getNext();
        } else if (index == size - 1) {
            while(current.getNext().getNext() != null) {
                current = current.getNext();
            }
            data = current.getNext().getData();
            current.setNext(null);
        } else {
            for (int i = 1; i < index ; i++) {
                current = current.getNext();
            }
            temp = current.getNext().getNext();
            data = current.getNext().getData();
            current.setNext(temp);
        }
        return data;
    }

    public void clear () {
        if(isEmpty()) {
            throw new NoSuchElementException("List is already clear");
        }
        head = null;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Index needs to be "
                    + "between 0 and size - 1");
        }
        Node<T> current = head;
        T data;
        for (int i = 0; i <= index ; i++) {
            current = current.getNext();
        }
        data = current.getData();
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> convert = new ArrayList<>();
        Node<T> current = head;
       while (current != null) {
           convert.add(current.getData());
           current = current.getNext();
       }
       return convert;
       /* if(current.getNext() == null) {
            convert.add(current.getData());
            return convert;
        }
        while (current.getNext() != null) {
            convert.add(current.getData());
            current = current.getNext();
        }
        return convert;*/
    }
}
