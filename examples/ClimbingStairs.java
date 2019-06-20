/**
* find ways to climb a stair of n steps. 
* input is stair size = n, steps you can take at a time [1, 2]
* 
*/

package examples;

class ClimbingStairs{

	public static void main(String[] args){
		int height = Integer.valueOf(args[0]);
		int[] steps = new int[args.length - 1];
		for(int i=1; i< args.length; i++){
			steps[i-1] = Integer.valueOf(args[i]);
		}

		System.out.println("No of ways to climb the stair: " 
			+ countWaysToClimbAStair(height, steps));
	}

	public static int countWaysToClimbAStair(int height, int[] steps){
		return countWaysToClimbAStairHelper(height, steps);
	} 

	private static int countWaysToClimbAStairHelper(int height, int[] steps){
		if(height < 0){
			return 0;
		}

		if(height == 0){
			return 1;
		}

		int count = 0;
		for(int i=0; i< steps.length; i++){
			count = count + countWaysToClimbAStairHelper(height-steps[i], steps);
		}

		return count;
	} 
	
}