package com.alpha.misc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RunningMedian {

	public static void add(int element, Queue<Integer> minHeap, Queue<Integer> maxHeap) {

		if (!minHeap.isEmpty() && element < minHeap.peek()) {
			maxHeap.offer(element);
			if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.offer(maxHeap.poll());
			}
		} else {
			minHeap.offer(element);
			if (minHeap.size() > maxHeap.size() + 1) {
				maxHeap.offer(minHeap.poll());
			}
		}
	}

	public static double median(Queue<Integer> minHeap, Queue<Integer> maxHeap) {

		if (minHeap.size() == maxHeap.size())
			return (minHeap.peek() + maxHeap.peek()) * 1.0 / 2.0;
		else if (minHeap.size() > maxHeap.size())
			return minHeap.peek() * 1.0;
		else
			return maxHeap.peek() * 1.0;

	}

	public static void main(String[] args) {

		Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		Queue<Integer> minHeap = new PriorityQueue<>();

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int x : arr) {
			add(x, minHeap, maxHeap);
			System.out.println(median(minHeap, maxHeap));
		}

	}
}
