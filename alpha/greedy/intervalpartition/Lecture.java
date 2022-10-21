package com.alpha.greedy.intervalpartition;

// sort lecture by start time
public class Lecture implements Comparable<Lecture> {

	private int startTime;
	private int endTime;
	private String lectureId;

	public Lecture(int startTime, int endTime,String lectureId) {
		this.setLectureId(lectureId);
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Lecture o) {
		return this.startTime - o.startTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public String getLectureId() {
		return lectureId;
	}

	public void setLectureId(String lectureId) {
		this.lectureId = lectureId;
	}

}
