package com.alpha.greedy.minimize.lateness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimizeLateness {

	public static void main(String[] args) {

		List<Job> jobs = new ArrayList<Job>();
		jobs.add(new Job(1, 3, 6));
		jobs.add(new Job(2, 2, 8));
		jobs.add(new Job(3, 1, 9));
		jobs.add(new Job(4, 4, 9));
		jobs.add(new Job(5, 3, 14));
		jobs.add(new Job(6, 2, 15));
		
		System.out.println("Minimum lateness : " + mimimumLateness(jobs));
	}

	public static int mimimumLateness(List<Job> jobs) {
		int lateness = 0;
		Collections.sort(jobs);
		int currentTime = 0;

		for (Job currentJob : jobs) {
			int startTime = currentTime;
			int endTime = startTime + currentJob.getProcessingTime();
			lateness += lateness(endTime, currentJob.getDeadline());
			currentTime = endTime;	
		}
		return lateness;

	}

	public static int lateness(int finishTime, int deadline) {
		return Integer.max(0, finishTime - deadline);
	}
}
