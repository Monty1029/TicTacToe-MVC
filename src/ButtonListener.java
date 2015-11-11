import javax.swing.*;

import java.awt.event.*;

public class ButtonListener implements ActionListener {
	GUI gui;
	TicTacToe ttt;

	public ButtonListener(GUI g, TicTacToe t) {
		gui = g;
		ttt = t;
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource(); // Get the button pressed and
													// the action command
													// (button number).
		String command = button.getActionCommand();
		int row = Integer.parseInt(command.substring(0, 1));
		int col = Integer.parseInt(command.substring(1, 2));
		ttt.play(new Move(row, col));
		button.setText("" + ttt.getTurn());
		button.setEnabled(false);
		ttt.toggleTurn();
	}
}