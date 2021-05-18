package com.epam.honchar.myCollection;

import java.util.*;
import java.util.function.Predicate;

/**
 * Class MyCollection with fields <b>CAPACITY</b>, <b>items</b> and <b>size</b>.
 *
 * @version 1.8
 * @autor Denys Honchar
 */
public class MyCollection<E> implements List<E> {
    private static final int CAPACITY = 1000;
    private static final String NOTIMPL = "Not yet implemented";
    private Object[] items;
    private int size;

    public MyCollection() {
        this.items = new Object[CAPACITY];
        this.size = 0;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        MyCollection that = (MyCollection) object;

        if (CAPACITY != that.CAPACITY) {
            return false;
        }
        if (size != that.size) {
            return false;
        }
        return Arrays.equals(items, that.items);
    }

    private void ensureCapacity() {
        int newSize = (items.length * 3) / 2 + 1;
        if ((size + 1) == items.length) {
            items = Arrays.copyOf(items, newSize);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public Iterator iterator() {
        return new IteratorForEntity();
    }

    public Iterator<E> iterator(Predicate<E> predicate) {
        return (Iterator<E>) new IteratorForEntity(predicate);
    }


    @Override
    public E[] toArray() {
        return (E[]) Arrays.copyOf(items, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(items, size, a.getClass());
        }
        System.arraycopy(items, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean remove(Object object) {
        if (contains(object)) {
            remove(indexOf(object));
            return true;
        }
        return false;
    }

    public boolean isCollNotNull(Collection<?> collection) {
        return collection != null;
    }

    public boolean isObjectNotNull(Object object) {
        return object != null;
    }

    public boolean checkIndex(int index) {
        return index >= 0 && index <= size();
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        if (!collection.isEmpty()) {
            for (Object object : collection) {
                add(object);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Object object) {
        ensureCapacity();
        items[size++] = object;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        if (checkIndex(index) && !collection.isEmpty() && isCollNotNull(collection)) {
            for (Object object : collection) {
                add(index++, (E) object);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(items, null);
        size = 0;
    }

    @Override
    public E get(int index) {
        if (checkIndex(index)) {
            return (E) items[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public E set(int index, E element) {
        if (checkIndex(index) && isObjectNotNull(element)) {
            items[index] = element;
            return (E) items[index];
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, Object element) {
        if (checkIndex(index) && isObjectNotNull(element)) {
            System.arraycopy(items, index, items, index + 1, size - index);
            items[index] = element;
            size++;
        }
    }

    @Override
    public E remove(int index) {
        if (checkIndex(index)) {
            E oldValue = (E) items[index];
            int value = size - index - 1;
            if (value > 0) {
                System.arraycopy(items, index + 1, items, index, value);
            }
            items[--size] = null;
            return oldValue;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(Object object) {
        if (isObjectNotNull(object)) {
            for (int i = 0; i < size; i++) {
                if (items[i] == null || object.equals(items[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (isObjectNotNull(object)) {
            int index = 0;
            for (int i = 0; i < items.length; i++) {
                if (object.equals(items[i])) {
                    index = i;
                }
            }
            return index;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException(NOTIMPL);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException(NOTIMPL);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException(NOTIMPL);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (isCollNotNull(collection)) {
            boolean changed = false;
            for (int i = size() - 1; i >= 0; i--) {
                Object obj = get(i);
                if (!collection.contains(obj)) {
                    remove(i);
                    changed = true;
                }
            }
            return changed;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (isCollNotNull(collection)) {
            for (int i = size; i >= 0; i--) {
                if (collection.contains(items[i])) {
                    remove(items[i]);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        if (isCollNotNull(collection)) {
            for (Object e : collection) {
                if (!contains(e)) {
                    return false;
                }
            }
        }
        return true;
    }

    private class IteratorForEntity implements Iterator<E> {
        private int cursor = -1;
        private int lastRet;
        private Predicate<E> predicate;

        public IteratorForEntity() {
            this.predicate = (par -> true);
        }

        public IteratorForEntity(Predicate<E> predicate) {
            this.predicate = predicate;
        }


        public boolean hasNext() {
            for (int i = cursor; i <= items.length; i++) {
                if (predicate.test((E) items[i])) {
                    return cursor != size;
                }
            }
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] array = MyCollection.this.items;
            if (i >= array.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return (E) array[lastRet = cursor];
        }

        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            try {
                MyCollection.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }
}