import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Class that implements Set and only handles Squares
 *
 * @author sbranham6
 * @version 1
 */

public class SquareSet implements Set<Square> {

    private class SquareSetIterator implements Iterator<Square> {
        private int cursor = 0;

        public boolean hasNext() {
            return cursor <= lastIndex;
        }

        public Square next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[cursor++];
        }

        public void remove() {
            SquareSet.this.remove(cursor - 1);
        }
    }

    private Square[] elements = new Square[0];
    private int lastIndex;

    /**
     * Creates an empty array of squares
     */
    public SquareSet() {
        lastIndex = -1;
    }

    /**
     * Creates an array containing specified squares
     * @param c = any collection of squares
     */
    public SquareSet(Collection<Square> c) {
        this();
        for (Square s : c) {
            this.add(s);
        }
    }

    /**
     * adds an element if it's not present, otherwise returns false.
     * @param e - element to be added
     * @return boolean - true if the set didn't contain the element
     */
    public boolean add(Square e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (e.getFile() < 'a' || e.getFile() > 'h'
                || e.getRank() < '1' || e.getRank() > '8') {
            throw new InvalidSquareException("" + e.getFile() + e.getRank());
        }
        if (elements.length == 0 && lastIndex == elements.length - 1) {
            elements = Arrays.copyOf(elements, (elements.length + 1) * 2);
        } else if (lastIndex == elements.length - 1) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        for (Object o : elements) {
            if ((o instanceof Square) && ((Square) o).equals(e)) {
                return false;
            }
        }
        elements[++lastIndex] = e;
        return true;
    }

    /**
     * True iff set has an element e : (o==null ? e==null : o.equals(e)).
     * @param o - element whose presence is to be tested
     * @return true if set contains o
     */
    public boolean contains(Object o) {
        for (Square s: elements) {
            if (s != null && s.equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * True if set contains whole collection or collection = subset of big set
     * @param c - collection to be checked
     * @return true if set contains all elements in collection
     */
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!(this.contains(o))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares equality, true if other is also a set w/ same size and contents
     * @param  o - object to be compared
     * @return true if specified object is equal
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        } else if (!(o instanceof Set)) {
            return false;
        }
        Set that = (Set) o;
        if (this.size() == that.size() && this.containsAll(that)) {
            return true;
        }
        return false;
    }

    /**
     * Returns the sum of the hash codes of the elements in the set
     * @return hash code integer
     */
    public int hashCode() {
        int sum = 0;
        for (Square s: elements) {
            if (s != null) {
                sum += s.hashCode();
            }
        }
        return sum;
    }

    /**
     * Boolean representing whether set is empty
     * @return true if this set contains no elements
     */
    public boolean isEmpty() {
        return !(this.size() > 0);
    }

    /**
     * Returns an iterator over the elements in this set. The elements are
     * returned in no particular order
     * @return an iterator over the elements in this set
     */
    public Iterator<Square> iterator() {
        return new SquareSetIterator();
    }

    /**
     * Returns the number of elements in this set (its cardinality).
     * @return the number of elements in this set (its cardinality)
     */
    public int size() {
        return lastIndex + 1;
    }

    /**
     * Returns array of all elements in the set in the order they were added
     * @return array containing elements in this set
     */
    public Object[] toArray() {
        Object[] r = new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            if (elements[i] != null) {
                r[i] = elements[i];
            }
        }
        return r;
    }

    /**
     * Returns array w/ all elements in the set, runtime type is the same as the
     * parameter if parameter type fits set type. Otherwise a new array is
     * allocated.
     * @param a = array into which the elements are stored
     * @param <T> = TODO IDK!!!!!!
     * @return array w/ all elements in the set
     */
    public <T> T[] toArray(T[] a) {
        if (a == null) {
            throw new NullPointerException();
        }
        if (!a.getClass().isAssignableFrom(elements.getClass())) {
            throw new ArrayStoreException();
        }
        if (a.length < this.size()) {
            a = (T[]) new Object[size()];
        }
        for (int i = 0; i < this.size(); i++) {
            a[i] = (T) elements[i];
        }
        return a;
    }

    /**
     * Adds all elements in a collection if they aren't already there
     * @param c : collection to be added, must be in the Square hierarchy
     * @return boolean whether or not the set has been modified
     */
    public boolean addAll(Collection<? extends Square> c) {
        boolean modified = false;
        for (Square s : c) {
            if (this.add(s)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes specified element form the set
     * @param o - object to be removed if present
     * @return true if set contained the specified element
     */
    public boolean remove(Object o) {
        Square[] r = new Square[size()];
        int i = 0;
        boolean flag = false;
        for (Square s : elements) {
            if (s != null && s.equals(o)) {
                flag = true;
                this.lastIndex--;
            }
            if (s != null && !s.equals(o)) {
                r[i] = s;
                i++;
            }
        }
        elements = r;
        return flag;
    }

    /**
     * Removes all the elements from the set.
     */
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes elements from set as specified by a collection.
     * @param c : collection with elements to be removed
     * @return boolean whether or not the set was modified
     */
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * Retains only the elements specified by passed collection.
     * @param c : collecion with elements to be retained
     * @return boolean whether or not the set was modified
     */
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

}
