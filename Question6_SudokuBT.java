//package etud.fr.univ_montpellier.iut.SudokuBT.generateTest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SudokuBT {

	int n;
	int s;
	int[][] grid;


	public SudokuBT(int n) {
		this.n = n;
		this.s = (int) Math.sqrt(n);
		this.grid = new int[n][n];
	}

	private boolean solutionChecker() {
		boolean[] tabValeur = new boolean[n+1];

		for(int k = 1 ; k < n+1 ; k++){
			tabValeur[k] = false;
		}

		int valueH;
		for(int i = 0; i < n ; i ++){
			for(int j = 0 ; j < n ; j++) {
				valueH = this.grid[i][j];
				if(tabValeur[valueH]){
					return false;
				}
				else{
					tabValeur[valueH] = true;
				}
			}
			for(int k = 1 ; k < n+1 ; k++){
				tabValeur[k] = false;
			}
		}
		for(int j = 0 ; j < n ; j++){
			for(int i = 0 ; i < n ; i++){
				valueH = this.grid[i][j];
				if(tabValeur[valueH]){
					return false;
				}
				else{
					tabValeur[valueH] = true;
				}

			}
			for(int k = 1 ; k < n+1 ; k++){
				tabValeur[k] = false;
			}
		}

		for(int i = 0 ; i < n ; i += s){
			for(int j = 0 ; j < n ; j += s){

				for(int k = i ; k < i + s ; k++){
					for(int l = j ; l < j + s ; l++){
						valueH = this.grid[k][l];
						if(tabValeur[valueH]){
							return false;
						}
						else{
							tabValeur[valueH] = true;
						}
					}
				}

				for(int k = 1 ; k < n+1 ; k++){
					tabValeur[k] = false;
				}
			}
		}
		return true;
	}

	private void generateSolution() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.grid[i][j] = (int) (Math.random() * n + 1);
			}
		}
	}

	private int[] nextIJ(int i, int j){
		if(i == n-1 && j == n-1){
			return new int[]{-1,-1};
		}
		if(j == n-1){
			return new int[]{i+1,0};
		}
		return new int[]{i,j+1};
	}

	public boolean findSolution(int i, int j) {
		int[] update;

		if (i == -1 && j == -1) {
			if(solutionChecker()){
				System.out.println(this);
				return true;
			}
			else{
				return false;
			}
		}
		for (int k = 1; k < n+1; k++) {
			this.grid[i][j] = k;
			update = nextIJ(i, j);
			if (findSolution(update[0], update[1])) {
				return true;
			}
		}
		this.grid[i][j] = 0;
		return false;
	}

	public boolean findSolutionAll(int i, int j) {
		int[] update;

		if (i == -1 && j == -1) {
			if(solutionChecker()){
				System.out.println(this);
				return false;
			}
			else{
				return false;
			}
		}	
		for (int k = 1; k < n+1; k++) {
			this.grid[i][j] = k;
			update = nextIJ(i, j);
			if (findSolutionAll(update[0], update[1])) {
				return true;
			}
		}
		this.grid[i][j] = 0;
		return false;
	}

	//fonction pour la resolution backtrack de sudoku
	public boolean absentSurLigne (int k, int grille[][], int i) {
        for (int j=0; j < 4; j++)
            if (grille[i][j] == k)
                return false;
        return true;
    }

	public boolean absentSurColonne (int k, int grille[][], int j)
	{
	    for (int i=0; i < 4; i++)
	        if (grille[i][j] == k)
	            return false;
	    return true;
	}

	public boolean absentSurBloc (int k, int grille[][], int i, int j)
	{
	    int _i = i-(i%2), _j = j-(j%2);  // ou encore : _i = 2*(i/2), _j = 2*(j/2);
	    for (i=_i; i < _i+2; i++)
	        for (j=_j; j < _j+2; j++)
	            if (grille[i][j] == k)
	                return false;
	    return true;
	}

	public boolean estValide (int grille[][], int position){
	    if (position == 4*4){
	    	System.out.println(afficher(grille));
	    	//System.out.println(this);
	        return true;
	    }

	    int i = position/4, j = position%4;

	    if (grille[i][j] != 0)
	        return estValide(grille, position+1);

	    for (int k=1; k <= 4; k++)
	    {
	        if (absentSurLigne(k,grille,i) && absentSurColonne(k,grille,j) && absentSurBloc(k,grille,i,j))
	        {
	            grille[i][j] = k;

	            if ( estValide (grille, position+1) )
	                return true;
	        }
	    }
	    grille[i][j] = 0;

	    return false;
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < 4; i++) {
			str += "\n" + Arrays.toString(this.grid[i]);
		}
		return str + "\n";
	}

	public String afficher(int t[][]) {
		String str = "[";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				String ch = j <= 3 ? ","  : "";
				str += ""+t[i][j]+""+ch;
			}
			str += "]\n[";
		}
		return str + "\n";
	}
	
}