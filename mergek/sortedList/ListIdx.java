package com.alpha.mergek.sortedList;

class ListIdx implements Comparable<ListIdx> {

	int listIdx;
	int dataValue;

	public ListIdx(int listIdx, int dataValue) {
		this.listIdx = listIdx;
		this.dataValue = dataValue;
	}

	@Override
	public String toString() {
		return String.format("[listIndex : %d , data : %d]", listIdx, dataValue);
	}

	@Override
	public int compareTo(ListIdx arg0) {
		return this.dataValue - arg0.dataValue;
	}

}