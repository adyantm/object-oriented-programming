package hw09;

import java.util.ArrayList;
import java.util.NoSuchElementException;
//I worked on the assignment alone, using only course-provided materials.
/**
 * Class represents linkedList data structure.
 *
 * @author adyantm
 * @version 1.0
 * @param <T> type
 */

public class LinkedList<T> {
    /**
     * hw09.Node head. First node.
      */
    private Node<T> head;
    /**
     * size of hw09.hw09.LinkedList. int.
     */
    private int size;

    /**
     * Empty Constructor that sets head and size to default.
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Adds note at specified index.
     *
     * @param data  T
     * @param index int
     */
    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index needs to be "
                    + "between 0 and size");
        } else if (data == null) {
            throw new IllegalArgumentException("Data should "
                    + "have a value");
        }
        Node<T> temp = new Node<>(data, null);
        Node<T> headN = head;

        if (size == 0) {
            head = temp;
            head.setNext(head);
        } else if (index == 0) {
            temp.setNext(head.getNext());
            temp.setData(head.getData());
            head.setNext(temp);
            head.setData(data);
        } else if (index == size) {
            while (headN.getNext() != head) {
                headN = headN.getNext();
            }
            headN.setNext(temp);
            temp.setNext(head);
        } else {
            for (int i = 0; i < index - 1; i++) {
                headN = headN.getNext();
            }
            temp.setNext(headN.getNext());
            headN.setNext(temp);
        }
        size++;
    }

    /**
     * Removes specified index.
     *
     * @param index int
     * @return T
     */
    public T removeFromIndex(int index) {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Index needs to be "
                    + "between 0 and size");
        }
        T dataTemp;
        Node<T> temp = head;

        if (index == 0) {
            dataTemp = head.getData();
            head.setData(head.getNext().getData());
            head.setNext(head.getNext().getNext());
        } else if (index == size) {
            while (temp.getNext().getNext() != head) {
                temp = temp.getNext();
            }
            dataTemp = temp.getNext().getData();
            temp.setNext(head);
        } else {
            for (int i = 1; i < index; i++) {
                temp = temp.getNext();
            }
            dataTemp = temp.getNext().getData();
            temp.setNext(temp.getNext().getNext());
        }
        if (size - 1 == 0) {
            head = null;
        }
        size --;
        return dataTemp;
    }

    /**
     * Clears the list.
     */
    public void clear() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        head = null;
        size = 0;
    }

    /**
     * Gets data from index.
     *
     * @param index int
     * @return T
     */
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index needs to be "
                    + "between 0 and size");
        } else if (index == 0) {
            if (size == 0) {
                throw new IllegalArgumentException();
            }
            return head.getData();
        } else {
            Node<T> setter = head;
            for (int i = 0; i < index; i++) {
                setter = setter.getNext();
            }
            return setter.getData();
        }
    }

    /**
     * Returns true if the list is emmpty.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Converts to an hw01cs1332.ArrayList.
     *
     * @return hw01cs1332.ArrayList<T/>
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> a = new ArrayList<T>();
        Node<T> curr = head;

        while (curr != null) {
            a.add(curr.getData());
            curr = curr.getNext();
        }
        return a;
    }

    /**
     * Creates a fizzBuzz list.
     *
     * @return hw09.hw09.LinkedList of type String
     */
    public LinkedList<String> fizzBuzzLinkedList() {
        LinkedList<String> fizzBuzz = new LinkedList<String>();
        for (int i = 1; i <= this.size; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzz.addAtIndex("FizzBuzz", i - 1);
            } else if (i % 3 == 0 && i % 5 != 0) {
                fizzBuzz.addAtIndex("Fizz", i - 1);
            } else if (i % 3 != 0 && i % 5 == 0) {
                fizzBuzz.addAtIndex("Buzz", i - 1);
            } else {
                fizzBuzz.addAtIndex("" + i + ": "
                        + this.get(i - 1).toString(), i - 1);
            }
        }
        return fizzBuzz;
    }
}
