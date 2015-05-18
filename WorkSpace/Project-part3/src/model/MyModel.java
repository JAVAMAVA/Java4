package model;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import observer.Observable;
import algorithms.mazeGenerators.DFSMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;

/**
 * 
 * MyModel is an observable type class from the MVP pattern that implements Model
 * 
 * @author Michael & Amit
 * @see Model
 * @see Observable
 * 
 */

public class MyModel extends java.util.Observable implements Model { 
	
	ThreadPoolExecutor pool;
	HashMap<Maze,Solution> mazeSolutions;
	HashMap<String,Maze> mazeNames;
	Maze currMaze;
	
	public MyModel() {
		//initialize the threadpool setting 
		pool = new ThreadPoolExecutor(0, 0, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4));
		//pool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2));
		HashMap<Maze,Solution> mazeSolutions = new HashMap<Maze,Solution>();
		
	}
	/**
	 * generateMaze is a public method for generating a maze
	 * the method uses the threadpool
	 * @param maze hold the generated maze 
	 *  
	 */

	@Override
	public void generateMaze(String name,int rows, int cols ) { 
		System.out.println("Generating Maze");
		Maze maze = null;
		
		Future<Maze> m = pool.submit(new Callable<Maze>(){
			@Override
			public Maze call() throws Exception {
				DFSMazeGenerator dm = new DFSMazeGenerator();
				return (dm.generateMaze(rows, cols));
			}
		}
		);
		try {
			maze  = m.get();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}
		mazeNames.put(name, maze);
		notifyObserver(this, "generate maze");
		currMaze = maze;
	}
	/**
	 * getMaze sends the maze that was generated last
	 */
	@Override
	public Maze getMaze() {
		System.out.println("getting maze");
		
		notifyObserver(this, "get maze");
		return currMaze;
	}

	@Override
	public void solveMaze(Maze m) {
		System.out.println("Solving Maze");
		
		Future<Maze> sm = pool.submit(new Callable<Maze>(){

			@Override
			public Maze call() throws Exception {
				
				return null;
			}
			
			
			
			
		});
		
		notifyObserver(this, "solve maze");
		
	}

	@Override
	public Solution getSolution(String name) {
		switch(checkHash(name)){
		case "null":
			break;
		case "maze":
			break;
		case "solution":
			break;
			
		}
		
			
		notifyObserver(this, "get solution");
		return null;
	}

	@Override
	public void stop() {
		
		
		
	}
	/**
	 * this method checks if the maze solution is already in the hashmap
	 * @param mazeName used to check if solution exists already 
	 * @return if solution exist,solution,if maze,maze,if nothing,null
	 */
	
	public String checkHash(String name){
		Maze m;
		if(mazeNames.get(name) != null){
			m = mazeNames.get(name);
			if(mazeSolutions.get(m) != null)
				return "solution";
			else
				return "maze";
			
		}
		else
			return "null";
	}
	
	public void modelThreadpool(Callable v){ //submitting into the threadpool
		
		
		
		
	}
	
	public void saveToFile(){
		
		
	}
	
	
}
