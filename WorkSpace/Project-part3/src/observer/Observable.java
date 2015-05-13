package observer;

import java.util.ArrayList;

public class Observable {
	
	ArrayList<Observer> observers;
	
	public void notifyObserver(Observable os,String args){
		for(Observer o : observers){
			o.update(os,args);
		}
		
	}
	public void addObserver(Observer o){
		observers.add(o);
	}

}
