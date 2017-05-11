package io.github.vstollen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Tape implements Collection<Integer>{
	
	int currentState;
	
	Tape tape;
	
	int[] values;
	
	public Tape() {
		this.currentState = 10;
		this.tape = new Tape(20, currentState);
	}
	
	//Constructs tape with specified size
	public Tape(int size, int currentState){
		this.currentState = currentState;
		values = new int[size];
		this.tape = this;
	}
	
	//Constructs tape with some entrys
	public Tape(Collection<Integer> entrys, int currentState) {
		this.currentState = currentState;
		this.tape = this;
		this.values = new int[entrys.size() + 20];
		
		Iterator<Integer> it = entrys.iterator();
		
		for (int i = 9; it.hasNext(); i++) {
			values[i] = it.next();
		}
	}
	
	
	public void increase(){
		
	}

	@Override
	public int size() {
		int size = 0;
		
		for (int i = 0; i < values.length; i++) {
			if (values[i] != 0) {
				size++;
			}
		}
		return size;
	}

	@Override
	public boolean isEmpty() {

		for (int i = 0; i < values.length; i++) {
			if (values[i] != 0) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean contains(Object o) {

		//null check
		if (o.equals(null)) {
			return false;
		}
		
		//int check
		if (!o.getClass().equals(Integer.class)) {
			return false;
		}
		
		int obj = (int) o;
		
		//search for value
		for (int i = 0; i < values.length; i++) {
			if (values[i] == obj) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Iterator<Integer> iterator() {
		//Generates an List with the values of the vales array
		List<Integer> valueList = new ArrayList<Integer>();
		for (int i = 0; i < values.length; i++){
			valueList.add(values[i]);
		}
		
		return valueList.iterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Integer e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
