package view;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;
import observer.Observable;
import presenter.Presenter;
import presenter.Presenter.Command;


public class MyView extends Observable implements View {
	HashMap<String, Command> comm=new HashMap<String,Command>();
	@Override
	public void start() {
		notifyObserver(this, "");//I dont know what is this
		
	}

	@Override
	public void setCommands(HashMap<String, Command> comm) {
		this.comm=comm;
		
	}

	@Override
	public Command getUserCommand() {
		
		Command t=new Presenter().new TestMVPCommand();
		return t;
	}

	@Override
	public void displayMaze(Maze m) {
		System.out.println("displaying maze");
		
	}

	@Override
	public void displaySolution(Solution s) {
		// TODO Auto-generated method stub
		
	}

}
