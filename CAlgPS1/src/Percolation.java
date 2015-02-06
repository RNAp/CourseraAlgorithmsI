
public class Percolation {
	private int[][] percolation;
	private QuickUnionUF UF;
	//private int[] topOpen;		//an array that records 
	private int findIntFromIndex(int i, int j){   // this methods converts array index to ints that can be used in UF class
		int N=percolation.length;
		return (i-1)*N+j;
	}
	
	public Percolation(int N)  {	// create N-by-N grid, with all sites blocked: 0 labels blocked
		percolation = new int[N][N];
		UF=new QuickUnionUF(N*N);
		//topOpen=new int[N];
	}
	public void open(int i, int j){ 	// open site (row i, column j) if it is not open already
		percolation[i-1][j-1]=1;
		//if(i==1) topOpen[j-1]=1;
	}
	public boolean isOpen(int i, int j){     // is site (row i, column j) open?
		return percolation[i-1][j-1]==1;
	}
	public boolean isFull(int i, int j){     // is site (row i, column j) full?
		int UFint=findIntFromIndex(i,j);
		for(int k=0; k<percolation.length; k++){
			if(UF.connected(k, UFint)) return true;
		}
		return false;
	}
	public boolean percolates(){             // does the system percolate?
		for(int i=0;i<percolation.length;i++){
			if(isFull(percolation.length, i+1)) return true;
		}
		return false;
	}
		
	public static void main(String[] args ) { // test client (optional)

	}
}
