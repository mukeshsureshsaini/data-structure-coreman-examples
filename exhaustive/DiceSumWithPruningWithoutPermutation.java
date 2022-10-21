package com.alpha.exhaustive;

import java.util.ArrayList;
import java.util.List;

public class DiceSumWithPruningWithoutPermutation {

	public static void diceSum(int numberOfDices, int desiredSum) {

		diceSum(numberOfDices, 0, desiredSum, new ArrayList<>(),1);
	}

	public static void diceSum(int numberOfDice, int currentSum, int desiredSum, List<Integer> choicesSoFar,int minDiceValue) {
		if (numberOfDice == 0) {
			if (desiredSum == choicesSoFar.stream().mapToInt(Integer::intValue).sum()) {
				System.out.println(choicesSoFar);
			}
		} // sometimes the current sum is too high even we make minimum value i.e. 1
			// choice so currentSum + 1 * number of dice <= desired sum
			// sometimes the current sum is too low even we make the max value i.e. 6 choice
			// choice so currentSum + 6 * number of dice >= desired sum

		// why && ,why not || because we must stay in range too low even we make maximum
		// value choice && too high even we make min value choice
		else if (currentSum + (numberOfDice * 1) <= desiredSum && currentSum + (numberOfDice * 6) >= desiredSum) {
			for (int i = minDiceValue; i <= 6; i++) {

				choicesSoFar.add(i);
				diceSum(numberOfDice - 1, currentSum + i, desiredSum, choicesSoFar,i);
				choicesSoFar.remove(choicesSoFar.size() - 1);

			}
		}
	}

	public static void main(String[] args) {
		diceSum(3, 16);
	}

}
