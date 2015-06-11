import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RosettaStone implements KeyListener, ActionListener {

	HashMap<String, String> language = new HashMap<String, String>();

	String key;

	JFrame frame = new JFrame();

	JPanel panel = new JPanel();

	JButton button = new JButton();

	public static void main(String[] args) {

		RosettaStone stone = new RosettaStone();

		stone.create();

	}

	public void create() {

		language.put("Hello", "Geia Sas");

		language.put("Name", "Onoma");

		language.put("Goodbye", "Antio");

		language.put("Morning", "Proi");
		
		language.put("Evening", "Apógev̱ma");
		
		language.put("Cat", "Gáta");
		
		language.put("Dog", "Skýlos");

		frame.setVisible(true);

		frame.setSize(1000, 1000);

		frame.add(panel);

		panel.setVisible(true);

		panel.setSize(1000, 1000);

		panel.add(button);

		key = getRandomKey(language);

		button.setText(key);

		button.setVisible(true);

		button.setSize(1000, 1000);

		button.addActionListener(this);

	}

	String getRandomKey(HashMap<String, String> map) {

		String[] keysAsArray = map.keySet().toArray(new String[0]);

		int randomness = new Random().nextInt(map.size());

		return keysAsArray[randomness];
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if(language.get(button.getText()) == null){
			
			button.setText(getRandomKey(language));
			
		}else
		
		button.setText(language.get(button.getText()));
		
	}
		
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
