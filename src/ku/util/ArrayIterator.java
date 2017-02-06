package ku.util;

/**
 * ArrayIterator is the collections and data structures provide an Iterator.
 * 
 * @author Visurt Anuttivong
 * @version 5710546615
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
	/** attribute for the array we want to iterate over */
	private T[] array;
	/** attribute for remember its position in the collection */
	private int cursor;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over.
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.cursor = 0;
	}

	/**
	 * To check that next non-null element is exist or not.
	 * 
	 * @return true if there is an exist element. Otherwise false.
	 * 
	 */
	public boolean hasNext() {
		for (int i = cursor; i < array.length; i++)
			if (array[i] != null)
				return true;

		return false;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	public T next() {
		if (this.hasNext()) {
			if (array[cursor] != null) {
				cursor++;
				return array[cursor - 1];
			} else {
				for (int i = cursor; i < array.length; i++) {
					if (array[i] != null) {
						cursor = i + 1;
						return array[cursor - 1];
					}
				}
			}
		}
		throw new NoSuchElementException();
	}

	/**
	 * Remove the current element from array.
	 * 
	 * @throws IllegalStateException
	 *             if called more than once.
	 */
	public void remove() {
		if (array[cursor - 1] != null) {
			array[cursor - 1] = null;
		} else {
			throw new IllegalStateException();
		}
	}
}