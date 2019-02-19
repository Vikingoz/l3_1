import java.util.*;

public class MyArrayList<T> implements List {

    //Количество элементов
    private final int INIT_SIZE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;


    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer > 0 ? true : false;
    }
    /*пустое значение считаем не содержится*/
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        } else {
            for (int i = 0; i <= array.length; i++) {
                if (array[i] != null && array[i].equals(o)) {
                    return true;
                }
            }
            return false;
        }

    }

    public Iterator iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            public boolean hasNext() {
                return currentIndex < pointer && array[currentIndex] != null;
            }

            public T next() {
                if (currentIndex++ > pointer) {
                    throw new NoSuchElementException();
                } else {
                    return (T) array[currentIndex++];
                }
            }

            public void remove() {
                MyArrayList.this.remove(currentIndex);
                //throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public boolean add(Object o) {
        if(pointer == array.length - 1) {
            Object[] newArray = new Object[pointer + INIT_SIZE];
            System.arraycopy(array, 0, newArray, 0, pointer);
            array = newArray;
        }
        array[pointer++] = o;
        return true;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean addAll(Collection c) {
        return false;
    }

    public boolean addAll(int index, Collection c) {
        return false;
    }

    public void clear() {

    }

    public Object get(int index) {
        return (T) array[index];
    }

    public Object set(int index, Object element) {
        return null;
    }

    public void add(int index, Object element) {

    }

    public Object remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator listIterator() {
        return null;
    }

    public ListIterator listIterator(int index) {
        return null;
    }

    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    public Object[] toArray(Object[] a) {
        return array;
    }
}
