/**
* find number of subsets for given non-zero, unique natural numbers that match a given sum
* input = array of numbers and a number that indicates the sum
*/

package examples;

class MatchSubsets{
	public static void main(String[] args){
		int sum = Integer.valueOf(args[0]);
		int[] arr = new int[args.length - 1];
		for(int i=1; i< args.length; i++){
			arr[i-1] = Integer.valueOf(args[i]);
		}

		System.out.println("No. of matching subsets:" + countMatchingSubsets(arr, sum));
	}

	public static int countMatchingSubsets(int[] arr, int sum){
		return countMatchingSubsetsHelper(arr, sum, 0);

	}

	private static int countMatchingSubsetsHelper(int[] arr, int sum, int index){
		//base condition
		if(sum == 0){
			return 1;
		}

		//guard
		if(sum < 0 || index == arr.length){
			return 0;
		}

		int count = countMatchingSubsetsHelper(arr, sum , index+1) + 
						countMatchingSubsetsHelper(arr, sum - arr[index], index+1);

		return count;

	}
}
