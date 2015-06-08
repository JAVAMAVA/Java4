package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class BoardCell extends Canvas {
	
	Image img;
	String wallside; //to know the currect image
	
	
	public BoardCell(Composite parent, int style, Image img) {
		super(parent, style | SWT.DOUBLE_BUFFERED);
		this.img = img;
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				e.gc.drawImage(img, 0, 0, img.getImageData().x, img.getImageData().y, 0, 0, getSize().x, getSize().y);
			}
		});
		
		
	}

}
