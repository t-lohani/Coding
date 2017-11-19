package array;

public class GasStation {

	public static void main(String[] args) {
		int[] gas = {4};
		int[] cost = {5};
		System.out.println(canCompleteCircuit(gas, cost));
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int cumSum = 0;
        int worst = Integer.MAX_VALUE;
        
        for (int i=0; i<gas.length; i++) {
            cumSum += gas[i] - cost[i];
            if (cumSum < worst) {
                worst = cumSum;
                index = i+1;
            }
        }
        
        return (cumSum < 0) ? -1:(index%gas.length);
    }
}
