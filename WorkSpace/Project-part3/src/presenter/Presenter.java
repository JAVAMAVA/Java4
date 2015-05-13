package presenter;

import observer.Observable;
import observer.Observer;
import model.Model;
import view.View;

public class Presenter implements Observer {
	View v;
	Model m;
	@Override
	public void update(Observable o,Object args){
			//if the view notified the presenter
		   if(o == v) {
					
		   }
		   
		   //if the model notified the presenter
		   if(o == m) {
		         
		   }

		   
		  
		}


}
