package com.alpha.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/***
 * 
 * @author a13218298
 * 
 *         Single interval and multiple task
 * 
 *         or single resource and multiple jobs
 *
 */

public class IntervalScheduling {

	public static void main(String[] args) {

		List<Interval> intervals = buildInputData();

		Set<Interval> result = schedule(intervals);

		for (Interval interval : result) {
			System.out.printf(" task Name : %s, start : %d , end : %d\n", interval.getId(), interval.getStartTime(),
					interval.getEndTime());
		}
	}

	public static Set<Interval> schedule(List<Interval> input) {

		Collections.sort(input);
		Set<Interval> result = new TreeSet<>();
		Interval last = input.get(0);
		result.add(last);

		for (int i = 1; i < input.size(); i++) {

			Interval current = input.get(i);
			if (current.isCompatible(last)) {
				result.add(current);
				last = current;
			}

		}

		return result;

	}

	public static List<Interval> buildInputData() {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(0, 6, "a"));
		intervals.add(new Interval(1, 3, "b"));
		intervals.add(new Interval(3, 4, "c"));
		intervals.add(new Interval(3, 8, "d"));
		intervals.add(new Interval(4, 7, "e"));
		intervals.add(new Interval(5, 9, "f"));
		intervals.add(new Interval(6, 10, "g"));
		intervals.add(new Interval(8, 11, "h"));

		return intervals;
	}

}

class Interval implements Comparable<Interval> {

	private int startTime;
	private int endTime;
	final private String id;

	public Interval(int s, int e, String id) {
		this.startTime = s;
		this.endTime = e;
		this.id = id;
	}

	@Override
	public int compareTo(Interval o) {
		return this.endTime - o.endTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public String getId() {
		return id;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public boolean isCompatible(Interval o) {
		return this.startTime >= o.endTime;
	}
}
