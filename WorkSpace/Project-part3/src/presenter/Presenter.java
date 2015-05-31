package presenter;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze;
import observer.Observable;
import observer.Observer;
import model.Model;
import view.View;

public class Presenter implements Observer {
	View v;
	Model m;
	public Presenter(TestMVPCommand tmc,View v,Model m) {
		this.v=v;
		this.m=m;
		HashMap<String,Command> comm=new HashMap<String, Command>();
		comm.put("Testmvp", tmc);
		v.setCommands(comm);
	}
	public Presenter() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void update(Observable o,Object args){
			//if the view notified the presenter
		   if(o == v) {
					Command newComm=v.getUserCommand();
					newComm.doCommand("");
		   }
		   
		   //if the model notified the presenter
		   if(o == m) {
			   m.getMaze();
			   v.displayMaze(new Maze(10,10));
		         
		   }

		   
		  
		}

	public interface Command {
		void doCommand(String arg);
	}
	public class TestMVPCommand implements Command {

		@Override
		public void doCommand(String arg) {
			m.generateMaze(10, 10);
			
		}

	}
}


