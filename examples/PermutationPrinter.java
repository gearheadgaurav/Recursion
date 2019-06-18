package examples;

class PermutationPrinter{
	
	public static void main(String[] args){
		//input handling needs to be implemented.
		new PermutationPrinter().printAllPermutations(args[0].toCharArray());
	}

	public void printAllPermutations(char[] input){
		printAllPermutations(input, 0);
	}

	private void printAllPermutations(char[] input, int start){
		if(input == null){
			System.out.println("input is null");
			return;
		}


		// base case
		if(start == input.length-1){
			System.out.println("Permutation >>>>> " + new String(input));
		}

		
		for(int j=start; j< input.length; j++){
			swap(input, start, j); //make a choice for start element
			printAllPermutations(input, start+1);
			swap(input, j , start); //restore the array
		}

	}

	private void swap(char[] arr, int index1, int index2){
		char temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;


	}
}