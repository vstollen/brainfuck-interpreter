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
			while (positiveList.size() < currentState) {
				positiveList.add(0);
			}
			
			positiveList.add(currentState, positiveList.get(currentState) + 1);
		} else {
			while (negativeList.size() < currentState * -1) {
				negativeList.add(0);
			}
			
			negativeList.add(currentState * -1, negativeList.get(currentState * -1) + 1);
		}
	}
	
	public void decrease() {
		if (currentState >= 0) {
			while (positiveList.size() < currentState) {
				positiveList.add(0);
			}
			
			positiveList.add(currentState, positiveList.get(currentState) - 1);
		} else {
			while (negativeList.size() < currentState * -1) {
				negativeList.add(0);
			}
			
			negativeList.add(currentState * -1, negativeList.get(currentState * -1) - 1);
		}
	}
	
	public int getCurrent() {
		if (currentState >= 0) {
			return positiveList.get(currentState);
		}else {
			return negativeList.get(currentState * -1);
		}
	}

}
