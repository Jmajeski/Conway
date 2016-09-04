import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;


public class LifePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 500;
	private static final int WIDTH = 500;

	
	private LifeBoard board;
	
	//delete
	private int counter = 1;
	private int num;
	private ArrayList<int[][]> boardArr = new ArrayList<int[][]>();
	
	
	
	//constructor
	public LifePanel(LifeBoard board){
		setPreferredSize(new Dimension(HEIGHT, WIDTH));
		setBackground(Color.black);
		this.board = board;
		
		boardArr.add(board.getBoard());
		
		
		
		addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				handleMouseClick(e);
			}
		});
	}
	
	
	private void handleMouseClick(MouseEvent e){
		if (e.getButton() == MouseEvent.BUTTON1){
			if (counter == boardArr.size()){
				board.updateBoard();
				boardArr.add(board.getBoard());
				counter++;
				
				
			}
			
			else{
				counter++;
			}
				
			repaint();
			
		}
		
		else if ( e.getButton() == MouseEvent.BUTTON3){
			if ( counter > 1){
				counter--;
			
			}
			
			repaint();
				
		}

		return;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		//delete
		num = 0;
		
		for (int i = 0; i < LifeBoard.ARRAY_SIZE; i++){
			for (int j = 0; j < LifeBoard.ARRAY_SIZE; j++){
				if (boardArr.get(counter - 1)[i][j] == 1){
					g.setColor(Color.green);
					g.drawRect(i*5, j*5, 5, 5);
					num++;
				}

			
				
			}
		}
		g.setColor(Color.white);
		
		//delete
		g.drawString(Integer.toString(counter), 50, 50);
		g.drawString(Integer.toString(boardArr.size()), 75 , 75);
		g.drawString(Integer.toString(num), 100, 100);
		
		System.out.println(counter );
	}
	
	
}
