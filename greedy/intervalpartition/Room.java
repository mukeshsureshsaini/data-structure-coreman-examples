package com.alpha.greedy.intervalpartition;

import java.util.ArrayList;
import java.util.List;

// sort room by lastLecture finish time
public class Room implements Comparable<Room> {

	private int lastLectureFinishTime;
	private int roomId;
	private List<Lecture> allLectures = new ArrayList<>();
	
	
	public Room(Lecture lecture,int roomId) {
		this.roomId = roomId;
		addLecture(lecture);
	}

	public int getLastLectureFinishTime() {
		return lastLectureFinishTime;
	}

	public int getRoomId() {
		return roomId;
	}

	public List<Lecture> getAllLectures() {
		return allLectures;
	}

	public void setLastLectureFinishTime(int lastLectureFinishTime) {
		this.lastLectureFinishTime = lastLectureFinishTime;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public void setAllLectures(List<Lecture> allLectures) {
		this.allLectures = allLectures;
	}

	public void addLecture(Lecture lecture) {
		allLectures.add(lecture);
		lastLectureFinishTime = lecture.getEndTime();

	}

	@Override
	public int compareTo(Room o) {
		return this.lastLectureFinishTime - o.getLastLectureFinishTime();
	}

}
