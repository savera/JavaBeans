import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SantaList implements MouseListener {

	ArrayList<JLabel> santa;

	public static void main(String[] args) {

		SantaList list = new SantaList();

		list.frame();

	}

	public void frame() {

		JFrame frame = new JFrame();

		JPanel panel = new JPanel();

		frame.setVisible(true);

		frame.setSize(1600, 700);

		panel.setVisible(true);

		panel.setSize(1600, 700);

		santa = new ArrayList<JLabel>();

		JLabel merryChristmas = loadImageFromTheInternet("http://www.seniorcarectrs.com/wp-content/uploads/2013/12/Merry-Christmas-Clip-Art1.jpg");

		santa.add(merryChristmas);

		JLabel chris2 = loadImageFromTheInternet("http://images.clipartpanda.com/-9TRjjG5Te.png");

		santa.add(chris2);

		JLabel chris3 = loadImageFromTheInternet("http://www.picgifs.com/clip-art/cartoons/christmas-snoopy/clip-art-christmas-snoopy-998015.jpg");

		santa.add(chris3);

		JLabel chris4 = loadImageFromTheInternet("http://www.clipartlord.com/wp-content/uploads/2013/04/christmas-tree16.png");

		santa.add(chris4);

		JLabel chris5 = loadImageFromTheInternet("http://images.clipartpanda.com/bribery-clipart-christmas_present_2.png");

		santa.add(chris5);

		panel.add(merryChristmas);

		frame.add(panel);

		frame.pack();

		frame.addMouseListener(this);
	}

	private JLabel loadImageFromTheInternet(String imageUrl) {

		try {

			URL url = new URL(imageUrl);

			Icon icon = new ImageIcon(url);

			return new JLabel(icon);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

		return null;

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
		System.out.println("hi");
		
		int size = santa.size();
		
		int rand = new Random().nextInt(size); 
		
		santa.get(rand);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
