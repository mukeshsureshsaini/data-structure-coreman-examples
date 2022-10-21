package com.alpha.exhaustive;

import java.util.ArrayList;
import java.util.List;

public class DiceSum {

	public static void diceSum(int numberOfDices, int desiredSum) {

		diceSum(numberOfDices, desiredSum, new ArrayList<>());
	}

	public static void diceSum(int numberOfDice, int desiredSum, List<Integer> choicesSoFar) {
		if (numberOfDice == 0) {
			if (desiredSum == choicesSoFar.stream().mapToInt(Integer::intValue).sum()) {
				System.out.println(choicesSoFar);
			}
		} else {
			for (int i = 1; i <= 6; i++) {

				choicesSoFar.add(i);
				diceSum(numberOfDice - 1, desiredSum, choicesSoFar);
				choicesSoFar.remove(choicesSoFar.size() - 1);

			}
		}
	}

	public static void main(String[] args) {
		diceSum(3, 16);
	}

}
