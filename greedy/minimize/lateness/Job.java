package com.alpha.greedy.minimize.lateness;



// sort Jobs with their deadline
// Earliest deadline first
public class Job implements Comparable<Job> {

	private int id;
	private int processingTime;
	private int deadline;

	public Job(int id, int processingTime, int deadline) {

		this.id = id;
		this.processingTime = processingTime;
		this.deadline = deadline;

	}

	public int getId() {
		return id;
	}

	public int getProcessingTime() {
		return processingTime;
	}

	public int getDeadline() {
		return deadline;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	@Override
	public int compareTo(Job o) {
		return this.deadline - o.deadline;
	}

}
