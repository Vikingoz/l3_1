import java.util.*;

public class MyArrayList<T> implements List {

    //Количество элементов
    private final int INIT_SIZE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int size = 0;


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size > 0 ? true : false;
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
                return currentIndex < size && array[currentIndex] != null;
            }

            public T next() {
                if (currentIndex + 1 > size) {
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
        Object[] rArray = new Object[size];
        System.arraycopy(array, 0, rArray, 0, size);
        return rArray;
    }

    public boolean add(Object o) {
        if(size == array.length - 1) {
            Object[] newArray = new Object[size + INIT_SIZE];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size++] = o;
        return true;
    }

    public Object remove(int index) {
        int numMoved = size - index - 1;
        Object returnElement = array[index];
        System.arraycopy(array, index + 1, array, index, numMoved);
        array[--size] = null;
        return returnElement;
    }

    public boolean remove(Object o) {
        if (o == null) {
            return false;
        }

        for (int i = 0; i <= size; i++) {
            if (array[i] != null && array[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        //Object[] barray = new Object[array.length - 1];

        //System.arraycopy();
        return false;
    }

    private class MyListIterator implements ListIterator {
        private int currentIndex;

        public MyListIterator() {
            this.currentIndex = 0;
        }

        public MyListIterator(int currentIndex) {
            this.currentIndex = currentIndex;
        }

        public boolean hasNext() {
            return currentIndex < size && array[currentIndex] != null;
        }

        public Object next() {
            if (currentIndex + 1 > size) {
                throw new NoSuchElementException();
            } else {
                /*int i = currentIndex;
                Object next = get(i);
                currentIndex = i + 1;*/
                return array[currentIndex++];

            }
        }

        public boolean hasPrevious() {
            return currentIndex > 0 && array[currentIndex - 1] != null;
        }

        public Object previous() {
            if (currentIndex - 1 < 0) {
                throw new NoSuchElementException();
            } else {
                return (T) array[currentIndex--];
            }
        }

        public int nextIndex() {

            return currentIndex + 1 > size ? size : currentIndex + 1;
        }

        public int previousIndex() {
            return currentIndex - 1 < 0 ? -1 : currentIndex - 1;
        }

        public void remove() {
            MyArrayList.this.remove(currentIndex);
        }

        public void set(Object o) {
            MyArrayList.this.set(currentIndex - 1, o);
        }

        public void add(Object o) {
            MyArrayList.this.add(currentIndex, o);
        }
    }
    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the {@code set} operation
     *         is not supported by this list
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and
     *         this list does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()})
     */
    public Object set(int index, Object element) {
        //System.out.println("index index (" + index + ") = " + element.toString());
        if (element == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object returnElement = array[index];

        //System.arraycopy(array, index + 1, array, index, numMoved);
        array[index] = element;
        return returnElement;
    }

    public void add(int index, Object element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(size == array.length - 1) {
            Object[] newArray = new Object[size + INIT_SIZE];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    public ListIterator listIterator() {
        return new MyListIterator();
    }

    public ListIterator listIterator(int index) {
        return new MyListIterator(index);
    }

    //*************************//

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

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
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
        Object[] rArray = new Object[size];
        System.arraycopy(array, 0, rArray, 0, size);
        return rArray;
        //return array;
    }
}
