import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class LifeFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args){
		//create board object and initialize
		LifeBoard board = new LifeBoard();
		board.initBoard();		
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				LifeFrame life = new LifeFrame();
				life.add(new LifePanel(board));
				life.pack();
				life.setDefaultCloseOperation(EXIT_ON_CLOSE);
				life.setTitle("Conway's Game of Life");
				life.setVisible(true);
			}
		});
	}
}
