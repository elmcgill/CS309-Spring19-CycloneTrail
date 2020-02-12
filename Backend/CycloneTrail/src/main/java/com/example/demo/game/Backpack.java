package com.example.demo.game;

/**
 * Backpack class is used in the GameInstance class to store objects the player buys, or uses while on the trail
 * 
 * 
 * @author Ethan McGill
 *
 */
public class Backpack {
	
	private BPObject[] backpack;
	private boolean isFull = false;
	
	/**
	 * 
	 * Backpack constructor 
	 * 
	 */
	public Backpack() {
		this.backpack = new BPObject[9];
		this.isFull = false;
	}
	
	/**
	 * Get the backpack with all of its items, the backpack is an array of backpack items
	 * 
	 * 
	 * @return BPObject[] backpack
	 */
	public BPObject[] getBackpack() {
		return backpack;
	}
	
	/**
	 * Get the object at the given index of the backpack
	 * 
	 * @param int index
	 * @return BPObject object
	 */
	public BPObject getObjectAtIndex(int index) {
		return backpack[index];
	}
	
	/**
	 * Set the object at the given backpack index to the given backpack object
	 * 
	 * @param int index
	 * @param BPObject object
	 */
	public void setObjectAtIndex(int index, BPObject object) {
		this.backpack[index] = object;
	}
	
	/**
	 * Given a BPObject, the first object of this given type is removed from the backpack
	 * 
	 * @param BPObject object
	 */
	public void removeObject(BPObject object) {
		for(int i=0; i<9; i++) {
			if(backpack[i] == object) {
				backpack[i] = null;
				return;
			}
		}
	}
	
	/**
	 * If there is space in the backpack, the given object is inserted into the first available slot in the backpack
	 * 
	 * 
	 * @param BPObject object
	 */
	public void insertObject(BPObject object) {
		for(int i=0; i<9; i++) {
			if(this.backpack[i] == null) {
				this.backpack[i] = object;
				return;
			}
		}
	}
	
	/**
	 * Finds the amount objects in the backpack
	 * 
	 * @return int count
	 */
	public int length() {
		int count =0;
		for(int i=0; i<9; i++) {
			if(this.backpack[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Gets the backpack object as a string
	 * 
	 * 
	 * @return String result
	 */
	public String toString() {
		String toReturn = "";
		for(int i=0; i< this.backpack.length; i++) {
			if(this.backpack[i] == BPObject.FOOD) {
				toReturn += "Food ";
			}
			if(this.backpack[i] == BPObject.SCHOOL_SUPPLIES) {
				toReturn += "School Supplies ";
			}
			if(this.backpack[i] == BPObject.WATER) {
				toReturn += "Water ";
			}
		}
		return toReturn;
	}
	
	/**
	 * Checks if the backpack is full, if it is, sets the isFull variable to true, if it is not full the isFull variable set to false
	 * 
	 * 
	 */
	public void setIsFull() {
		int count =0;
		for(int i=0; i<9; i++) {
			if(backpack[i] != null) {
				count++;
			}
		}
		if(count == 9) {
			this.isFull = true;
		}
		else {
			this.isFull = false;
		}
	}
	
	/**
	 * Gets if the backpack is full
	 * 
	 * @return boolean isFull
	 */
	public boolean getIsFull() {
		return isFull;
	}
	
	/**
	 * Gets the count of each item in the backpack. The index 0 of the returned array is foodCount, index 1 is waterCount, index 2 is suppliesCount
	 * 
	 * 
	 * @return int[] items
	 */
	public int[] getItemCounts() {
		int[] items = new int[3];
		int foodCount =0;
		int waterCount =0;
		int suppliesCount=0;
		items[0] = foodCount;
		items[1] = waterCount;
		items[2] = suppliesCount;
		for(int i=0; i<9; i++) {
			BPObject ob = this.getObjectAtIndex(i);
			if(ob == BPObject.FOOD) {
				foodCount++;
				items[0] = foodCount;
			}
			if(ob == BPObject.WATER) {
				waterCount++;
				items[1] = waterCount;
			}
			if(ob == BPObject.SCHOOL_SUPPLIES) {
				suppliesCount++;
				items[2] = suppliesCount;
			}
		}
		return items;
	}
	
	/**
	 * Removes the item at the given index from the backpack
	 * 
	 * 
	 * @param int index
	 */
	public void removeFromIndex(int index) {
		this.backpack[index] = null;
	}

}