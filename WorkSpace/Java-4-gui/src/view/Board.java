package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze;


public class Board extends Composite {
	Image wallHorizontal;
	Canvas[][] boardGame;
	Image wallVertical;
	Image way;
	private Display display;
	private Shell shell;

	public Board(Composite parent, int style,Display display,Shell shell) {
		super(parent, style | SWT.DOUBLE_BUFFERED);
		
		this.display=display;
		this.shell=shell;
		way=new Image(display,"Grass.jpg");
		
		
		
		setBackground(new Color(null, 255, 255, 255));
		addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				int x=getSize().x;
				int y=getSize().y;
				e.gc.drawImage(way,0,0,way.getImageData().width,way.getImageData().height,0,0,x,y);
				
			}
		});
	}

		
	/**
	 * The method drawMaze draws the maze it gets into the board. It draws each cell as a way and around it the wall, if the wall is vertical it draws the WallVertical and if the wall is horizontal it draws a WallHorizontal
	 * @param matrix - the {@link Maze} that need to draw in the board
	 */
	public void drawMaze(Maze matrix)
	{
		for(int i=0;i<matrix.getRows();i++)
		{
			for (int j=0;j<matrix.getCols();j++)
			{
				
			}
		}
		
	}
	public void ChangeWallHorizonal(Image wallHorizontal)
	{
		this.wallHorizontal=wallHorizontal;
	}
	
	public void ChangeWallVertical(Image wallVertical)
	{
		this.wallVertical=wallVertical;
	}
	
	public void ChangeWay(Image way)
	{
		this.way=way;
	}
	
}