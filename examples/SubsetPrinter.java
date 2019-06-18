package examples;

class SubsetPrinter{
	private static int no_subsets = 0;

	public static void main(String[] args){
		//input validation

		new SubsetPrinter().printAllSubsets(args[0].toCharArray());
		System.out.println("no of subsets: " + no_subsets);
	}

	public void printAllSubsets(char[] arr){
		printAllSubsets(new char[arr.length], arr, 0, 0);
	}

	private void printAllSubsets(char[] currSubset, char[] arr, int currSubsetIndex, int startIndex){
		//base case
		if(startIndex == arr.length){
			no_subsets++;
			System.out.println("Set >>>> " + new String(currSubset));
			return;
		}
		
		// branch where curret element is not included
		printAllSubsets(currSubset, arr, currSubsetIndex, startIndex+1);

		//branch where current element is included
		currSubset = cloneCharArray(currSubset, currSubsetIndex);
		currSubset[currSubsetIndex] = arr[startIndex];

		printAllSubsets(currSubset, arr, currSubsetIndex+1, startIndex+1);

	}

	private char[] cloneCharArray(char[] currSubset, int currentSize){
		char[] clonedArray = new char[currSubset.length];
		for(int i=0; i < currentSize; i++){
			clonedArray[i] = currSubset[i];
		}

		return clonedArray;
	}
}