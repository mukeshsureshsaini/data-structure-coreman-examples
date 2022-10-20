public class SqrtDecompositionRMQ {

	int[] blockMin;
	int[] data;
	int noOfBlocks;
	int blockSize;

	public SqrtDecompositionRMQ(int[] data) {
		this.data = data;
		int len = data.length;
		blockSize = (int) Math.floor(Math.sqrt(len));
		noOfBlocks = (int) Math.ceil(len * 1.0D / blockSize);
		blockMin = new int[noOfBlocks];
		preporcess(data, len);
	}

	private void preporcess(int[] data, int len) {

		int blockArrIndex = 0;
		int min = Integer.MAX_VALUE;
		int counter = 0;

		for (int i = 0; i < len; i++, counter += 1) {
			if (counter == blockSize) {
				blockMin[blockArrIndex++] = min;
				min = Integer.MAX_VALUE;
				counter = 0;
			}
			min = Math.min(min, data[i]);
		}
		blockMin[blockArrIndex] = min;

	//	System.out.println(Arrays.toString(blockMin));

	}

	public int rangeMin(int startIndex, int endIndex) {
		if(startIndex < 0 || endIndex >= data.length) throw new ArrayIndexOutOfBoundsException();
		int startIndexBlock = startIndex / blockSize;
		int endIndexBlock = (int) Math.ceil(endIndex * 1.0D / blockSize);
		if (startIndexBlock == endIndexBlock) {
			return minInSubarray(startIndex, endIndex);
		}
		 
		

		
		/**
		 * represent the end index in terms of nth block 
		 * 
		 * 
		 * 0st block end index = 0* blocksize + blocksize-1 
		 * 1st block end index = 1* blocksize + blockSize-1 
		 * 2nd block end index = 2* blocksize + blocksize-1
		 * 
		 * 
		 */
		int startingBlockendIndex = startIndexBlock *blockSize + blockSize -1;  // (startIndexBlock+1)*blockLength -1
		int endingBlockStartIndex = (endIndex/blockSize)*blockSize; // it will be a multiple of blockLenth 0 ,b ,2b, 3b,4b....
		
		
		int min = minInSubarray(startIndex, startingBlockendIndex);
		min = Math.min(min, minInSubarray(endingBlockStartIndex, endIndex));
		for(int j = startIndexBlock+1 ; j < endIndexBlock ;j++) {
			min = Math.min(min, blockMin[j]);
		}
		return min;
	}

	private int minInSubarray(int startIndex, int endIndex) {
		int min = Integer.MAX_VALUE;
		for (int i = startIndex; i <= endIndex; i++) {
			min = Math.min(min, data[i]);
		}
		return min;
	}

	public static void main(String[] args) {
		SqrtDecompositionRMQ sqrtDecomposition = new SqrtDecompositionRMQ(
				new int[] { 31, 41, 59, 26, 53, 58, 97, 93, 23, 84, 62, 43, 33, 83, 27, 95, 2, 88, 41, 97 });
		
		System.out.print(sqrtDecomposition.rangeMin(0, 20));

	}

}
