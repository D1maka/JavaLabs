package ua.kpi.JavaLabs.lab2;

import java.util.LinkedList;

/**
 * Created by dmytro_veres on 23.09.14.
 */
public class MyLinkedList implements MyList{

    private int size;
    private Node start;
    private Node end;

    public MyLinkedList() {
        this.size = 0;
    }

    @Override
    public void add(Object o) {
        Node node = null;
        if (this.size == 0) {
            node = new Node(null, o, null);
            this.start = node;
            this.end = node;
        } else {
            node = new Node(this.end, o, null);
            this.end.next = node;
            this.end = node;
        }

        size++;
    }

    @Override
    public void add(int index, Object element) {
        if (size == 0 && index == 0) {
            add(element);
            return;
        }
        if (index == 0 && size != 0) {
            final Node newNode = new Node(null, element, start);
            start.previous = newNode;
            start = newNode;
        } else if (index == size) {
            final Node newNode = new Node(end, element, null);
            end.next = newNode;
            end = newNode;
        } else {
            final Node currentNode = getNode(index);
            final Node newNode = new Node(currentNode.previous, element, currentNode.next);
            if (currentNode.previous != null) {
                currentNode.previous.next = newNode;
            }
            if (currentNode.next != null) {
                currentNode.next.previous = newNode;
            }
        }
        size++;
    }

    @Override
    public void addAll(Object[] c) {
        for (Object obj : c) {
            add(obj);
        }
    }

    @Override
    public void addAll(int index, Object[] c) {
        for (int i = 0; i < c.length; i++) {
            add(index - i, c[i]);
        }
    }

    @Override
    public Object get(int index) {
        final Node currentNode = getNode(index);

        return currentNode.value;
    }

    @Override
    public Object remove(int index) {
        Node currentNode = null;
        if (index == 0 && size != 0) {
            currentNode = start;
            start = start.next;
        } else if (index == size - 1) {
            currentNode = end;
            end = end.previous;
        } else {
            currentNode = getNode(index);
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
        size--;

        return currentNode.value;
    }

    @Override
    public void set(int index, Object element) {
        Node currentNode = getNode(index);
        currentNode.value = element;
    }

    @Override
    public int indexOf(Object o) {
        Node currentNode = start;
        int index = -1;
        if (o == null) {
            while (currentNode != null) {
                index++;
                if (currentNode.value == o) {
                    return index;
                }
                currentNode = currentNode.next;
            }
        } else {
            while (currentNode != null) {
                index++;
                if (currentNode.value.equals(o)) {
                    return index;
                }
                currentNode = currentNode.next;
            }
        }

        return -1;
    }

    @Override
    public Object[] toArray() {
        final Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = this.get(i);
        }
        return array;
    }

    @Override
    public int size() {
        return this.size;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = null;
        if (this.size / 2 >= index) {
            currentNode = this.start;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = this.end;
            for (int i = this.size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
        }

        return currentNode;
    }

    private static class Node {
        Object value;
        Node next;
        Node previous;

        Node(Node previous, Object value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}


