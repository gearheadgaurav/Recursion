package examples;

class CountPath{
	
	public static void main(String[] args){
		//validate input.
		new CountPath().countPath(
			Integer.valueOf(args[0]), Integer.valueOf(args[1]));
	}

	public void countPath(int noOfRows, int noOfColumns){
		int pathCount = countPath(0, 0, 0, noOfRows, noOfColumns);
		System.out.println("count path for rows: " + noOfRows + " and columns: " + noOfColumns+ " is: " + pathCount);
	}

	private int countPath(int pathCount, int rowLoc, int colLoc, int noOfRows, int noOfColumns){
		if(rowLoc == noOfRows-1 && colLoc == noOfColumns -1)
			return 1;

		if(rowLoc == noOfRows || colLoc == noOfColumns)
			return 0;
		
		pathCount = pathCount + countPath(pathCount, rowLoc+1, colLoc, noOfRows, noOfColumns);

		pathCount = pathCount + countPath(pathCount, rowLoc, colLoc+1, noOfRows, noOfColumns);

		return pathCount;
	}
}