import java.util.PriorityQueue;

public class MyTaskDemo {
	public static void main(String[] args) {

		PriorityQueue<Task> pq = new PriorityQueue<>();
		Task lastTask = null;

		for (int[] taskArray : new int[][] { { 2, 8 }, { 4, 5 }, { 5, 1 } }) {
			Task taskAddedInPQ = new Task(taskArray[0], taskArray[1]);
			pq.add(taskAddedInPQ);
		}
		int t = 16;
		int result = 0;
		while (!pq.isEmpty() && t > 0) {
			Task taskWithMinumumDuration = pq.poll();
			if (lastTask != null) {
				int whereIWasAtLastTime = lastTask.start;

				int whereIAmNow = taskWithMinumumDuration.start;
				int thisTaskDuration = taskWithMinumumDuration.duration;

				if (whereIWasAtLastTime < whereIAmNow) {
					result += (whereIAmNow - whereIWasAtLastTime) + thisTaskDuration;
				} else {
					result += (whereIWasAtLastTime) + thisTaskDuration;
				}

			} else {
				lastTask = taskWithMinumumDuration;
				result += lastTask.duration + lastTask.start;

			}
			t -= result;
		}
		System.out.println("----->" + result);
	}

}

class Task implements Comparable<Task> {
	int start;
	int duration;

	public Task(int startTime, int duration) {
		this.start = startTime;
		this.duration = duration;
	}

	public int compareTo(Task other) {
		return this.duration - other.duration;
	}

	@Override
	public String toString() {

		return start + ":" + duration;
	}
}
