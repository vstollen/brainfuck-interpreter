package io.github.vstollen;

import java.util.ArrayList;
import java.util.List;

public class Tape {
	
	int currentState;
	
	Tape tape;
	
	List<Integer> negativeList = new ArrayList<Integer>();
	List<Integer> positiveList = new ArrayList<Integer>();
	
	public Tape() {
		this.currentState = 10;
	}
	
	public void stepRight() {
		currentState++;
	}
	
	public void stepLeft() {
		currentState--;
	}
	
	public void increase() {
		if (currentState >= 0) {
			while (positiveList.size() - 2 < currentState) {
				positiveList.add(0);
			}
			
			positiveList.set(currentState, positiveList.get(currentState) + 1);
		} else {
			while (negativeList.size() - 2 < currentState * -1) {
				negativeList.add(0);
			}
			
			negativeList.set(currentState * -1, negativeList.get(currentState * -1) + 1);
		}
	}
	
	public void decrease() {
		if (currentState >= 0) {
			while (positiveList.size() -2 < currentState) {
				positiveList.add(0);
			}
			
			positiveList.set(currentState, positiveList.get(currentState) - 1);
		} else {
			while (negativeList.size() -2 < currentState * -1) {
				negativeList.add(0);
			}
			
			negativeList.set(currentState * -1, negativeList.get(currentState * -1) - 1);
		}
	}
	
	public int getCurrent() {
		if (currentState >= 0) {
			return positiveList.get(currentState);
		}else {
			return negativeList.get(currentState * -1);
		}
	}
	
	public void setCurrent(int i) {
		if (currentState >= 0) {
			positiveList.set(currentState, i);
		}else {
			negativeList.set(currentState * -1, i);
		}
	}

}
