package model;

import observer.Observable;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;

public class MyModel extends Observable implements Model {

	@Override
	public void generateMaze(int rows, int cols) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Maze getMaze() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void solveMaze(Maze m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Solution getSolution() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
