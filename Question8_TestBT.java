public class Test{
	public static void main(String args[]) {
		SudokuBT test = new SudokuBT(4);
		int grille[][] =
		    {
			{1, 0, 3, 4},
			{3, 4, 0, 2},
			{2, 1, 4, 0},
			{0, 3, 2, 1}
		    };
		int grille2[][] =
		    {
			{9,0,0,1,0,0,0,0,5},
			{0,0,5,0,9,0,2,0,1},
			{8,0,0,0,4,0,0,0,0},
			{0,0,0,0,8,0,0,0,0},
			{0,0,0,7,0,0,0,0,0},
			{0,0,0,0,2,6,0,0,9},
			{2,0,0,3,0,0,0,0,6},
			{0,0,0,2,0,0,9,0,0},
			{0,0,1,9,0,4,5,7,0}
		    };
		test.estValide(grille,0);
		//test.findSolution(0,0);
	}
}