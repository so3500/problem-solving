package modern_java_in_action.ch13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.jetbrains.annotations.NotNull;

public class LoggerArrayList<E> implements List<E>, LoggerList<E> {

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@NotNull
	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@NotNull
	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@NotNull
	@Override
	public <T> T[] toArray(@NotNull T[] a) {
		return null;
	}

	@Override
	public boolean add(E e) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(@NotNull Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(@NotNull Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, @NotNull Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(@NotNull Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(@NotNull Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public E set(int index, E element) {
		return null;
	}

	@Override
	public void add(int index, E element) {

	}

	@Override
	public E remove(int index) {
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@NotNull
	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@NotNull
	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@NotNull
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}
}
