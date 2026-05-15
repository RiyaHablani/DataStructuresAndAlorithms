class Station implements Comparable<Station> {
    int cost;
    int gas;
    int index;

    Station(int cost, int gas, int index) {
        this.cost = cost;
        this.gas = gas;
        this.index = index;
    }

    public int compareTo(Station that) {
        return (this.gas - this.cost) - (that.gas - that.cost);
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        PriorityQueue<Station> minpq = new PriorityQueue<>();

        for (int i = 0; i < cost.length; i++) {
            minpq.offer(new Station(cost[i], gas[i], i));
        }

        int totalGas = 0;
        int totalCost = 0;

        while (!minpq.isEmpty()) {
            Station curr = minpq.poll();

            totalGas += curr.gas;
            totalCost += curr.cost;
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            tank += gas[i] - cost[i];

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return start;
    }
}