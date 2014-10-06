package ua.kpi.JavaLabs.lab2;

/**
 * Created by dmytro_veres on 23.09.14.
 */
public interface MyList {
    void add(Object o);
    void add(int index, Object element);
    void addAll(Object[] c);
    void addAll(int index, Object[] c);
    Object get(int index);
    Object remove(int index);
    void set(int index, Object element);
    int indexOf(Object o);
    int size();
    Object[] toArray();
}
