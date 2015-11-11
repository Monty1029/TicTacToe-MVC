import javax.swing.*;
import java.awt.*;

public class GUI {

	private JFrame frame;
	private JButton[][] buttons;
	private ButtonListener bl;

	public GUI(TicTacToe t) {
		bl = new ButtonListener(this, t);
		createAndShowGUI();
	}

	public void createAndShowGUI() {
		frame = new JFrame("TicTacToe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		addComponentsToPane(frame.getContentPane());
	}

	public void addComponentsToPane(Container pane) {

		pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pane.setLayout(new GridLayout(3, 3));
		
		buttons = new JButton[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton();
				frame.add(buttons[i][j]);
				buttons[i][j].setActionCommand(""+i+j);
				buttons[i][j].addActionListener(bl);
			}
		}

		frame.setVisible(true);

	}
	
	public static void main(String[] args) {
		GUI g = new GUI(new TicTacToe());
	}
}
