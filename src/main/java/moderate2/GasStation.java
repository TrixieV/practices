package moderate2;

/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station
to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once
in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique


 */
public class GasStation {
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0;
        int lowestIndex = 0;
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }
        for (int i = 0; i < gas.length; i++) {
            remain = remain + gas[i] - cost[i];
            if (remain < 0) {
                remain = 0;
                lowestIndex = i + 1;
            }
        }
        return lowestIndex;
    }
}
