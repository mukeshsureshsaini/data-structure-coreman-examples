package com.alpha.greedy.intervalpartition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class IntervalPartitioning {

	public static void main(String[] args) {

		List<Lecture> lectures = new ArrayList<>();

		lectures.add(new Lecture(900, 1030, "A"));
		lectures.add(new Lecture(900, 1230, "B"));
		lectures.add(new Lecture(900, 1030, "C"));
		lectures.add(new Lecture(1100, 1230, "D"));
		lectures.add(new Lecture(1100, 1400, "E"));
		lectures.add(new Lecture(1300, 1430, "F"));
		lectures.add(new Lecture(1300, 1430, "G"));
		lectures.add(new Lecture(1400, 1630, "H"));
		lectures.add(new Lecture(1500, 1630, "I"));
		lectures.add(new Lecture(1500, 1630, "J"));

		Collections.sort(lectures);
		int roomCount = partition(lectures);

		System.out.println("Required room : " + roomCount);
	}

	public static int partition(List<Lecture> lectures) {
		
		List<Room> allRooms = new ArrayList<>();
		PriorityQueue<Room> pq = new PriorityQueue<>();

		int roomCount = 0;
		

		
		Room firstRoom = new Room(lectures.get(0), ++roomCount);
		pq.add(firstRoom);	
		allRooms.add(firstRoom);
		

		for (int i = 1; i < lectures.size(); i++) {
			Room currentRoom = pq.peek();
			Lecture currentLecture = lectures.get(i);
			if (currentRoom.getLastLectureFinishTime() <= currentLecture.getStartTime()) {
				currentRoom = pq.remove();
				currentRoom.addLecture(currentLecture);
				pq.add(currentRoom);

			} else {
				Room newRoom = new Room(currentLecture, ++roomCount);
				pq.add(newRoom);
				allRooms.add(newRoom);

			}

		}

		for (Room room : allRooms) {
			for (Lecture lecture : room.getAllLectures()) {
				System.out.printf("Room Id : %d , lecture id : %s, Start time : %s , end time : %s\n", room.getRoomId(),
						lecture.getLectureId(), lecture.getStartTime(), lecture.getEndTime());
			}

		}
		

		return roomCount;

	}
}
