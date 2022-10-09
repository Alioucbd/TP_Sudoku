public class Test{
	public static void main(String args[]) {
		SudokuBT test = new SudokuBT(2);
		int grille[][] =
    {
        {1, 0, 3, 4},
		{3, 4, 0, 2},
		{2, 1, 4, 0},
		{0, 3, 2, 1}
    };
		test.estValide(grille,0);
		//test.findSolution(0,0);
	}
}