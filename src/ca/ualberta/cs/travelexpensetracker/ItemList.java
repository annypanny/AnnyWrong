package ca.ualberta.cs.travelexpensetracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;

public class ItemList implements Serializable {

	private static final long serialVersionUID = -4750213902436607593L;
	
	protected ArrayList<Item> itemList;
	protected ArrayList<NewListener> listener;
	
	public ItemList(){	
		itemList = new ArrayList<Item>();
		listener = new ArrayList<NewListener>();
	}
	
	public Collection<Item> getItem() {
		return itemList;
	}

	public void addItem(Item sample_item) {
		itemList.add(sample_item);
		
	}

	public Item chooseItem() throws EmptyStackException{
		int size = itemList.size();
		if (size <= 0) {
			throw new EmptyStackException();
		}
		int pos = 0;
		return itemList.get(pos);
	}

	public void editItem() {
		notifylistener();	
	}

//  abram hindle https://www.youtube.com/watch?v=7zKCuqScaRE 2015-01-25
	private void notifylistener() {
		// TODO Auto-generated method stub
		for (NewListener newListener: listener) {
			newListener.update();
		}
	}
	
	public void deleteItem(Item sample_Expense) {		
		itemList.remove(sample_Expense);	
		notifylistener();
	}
	
	public boolean include (Item sample_Expense) {
		return itemList.contains(sample_Expense);
	}
	
	public void addNewListener(NewListener lis) {
		listener.add(lis);
	}
	
	public void removeNewListener (NewListener lis) {
		listener.remove(lis);
	}
	
	

}
