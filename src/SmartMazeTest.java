import java.awt.BasicStroke;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.TreeSet;
import javax.imageio.ImageIO;
import javax.swing.*;

public class SmartMazeTest implements KeyListener {
	public static final Color BLACK = Color.BLACK;
	public static final Color BLUE = Color.BLUE;
	public static final Color CYAN = Color.CYAN;
	public static final Color DARK_GRAY = Color.DARK_GRAY;
	public static final Color GRAY = Color.GRAY;
	public static final Color GREEN = Color.GREEN;
	public static final Color LIGHT_GRAY = Color.LIGHT_GRAY;
	public static final Color MAGENTA = Color.MAGENTA;
	public static final Color ORANGE = Color.ORANGE;
	public static final Color PINK = Color.PINK;
	public static final Color RED = Color.RED;
	public static final Color WHITE = Color.WHITE;
	public static final Color YELLOW = Color.YELLOW;

	public SmartMazeTest() {
		// TODO Auto-generated constructor stub
	}

	private int X;
	private int Y;
	private HashMap<String, Cell> maze;
	private ArrayList<Cell> idealPath;
	private Cell currentCell;
	private static Color penColor;
	private int moveNumber;
	// default colors
	private static final Color DEFAULT_PEN_COLOR = BLACK;
	private static final Color DEFAULT_CLEAR_COLOR = WHITE;
	private String currentCellKey = "";
	private String lastMove = "";
	private int finishX = 5; 
	private int finishY = 3; 
	private static int startX = 1; 
	private static int startY = 3;

	private BufferedImage offscreenImage, onscreenImage;
	// current pen radius
	private static double penRadius;
	// current font
	private static Font font;
	private Graphics2D offscreen, onscreen;
	// default pen radius
	private final double DEFAULT_PEN_RADIUS = 0.002;
	// default font
	private final Font DEFAULT_FONT = new Font("SansSerif", Font.PLAIN, 16);
	// default canvas size is DEFAULT_SIZE-by-DEFAULT_SIZE
	private final int DEFAULT_SIZE = 512;
	private int width = DEFAULT_SIZE;
	private int height = DEFAULT_SIZE;
	// the frame for drawing to the screen
	private JFrame frame;
	// boundary of drawing canvas, 0% border
	// private static final double BORDER = 0.05;
	private final double BORDER = 0.00;
	private final double DEFAULT_XMIN = 0.0;
	private final double DEFAULT_XMAX = 1.0;
	private final double DEFAULT_YMIN = 0.0;
	private final double DEFAULT_YMAX = 1.0;
	private double xmin, ymin, xmax, ymax;
	// for synchronization
	private Object mouseLock = new Object();

	public SmartMazeTest(int X, int Y) {
		this.X = X;
		this.Y = Y;
		setXscale(0, X + 2);
		setYscale(0, Y + 2);
		init();
	}

	public SmartMazeTest(HashMap<String, Cell> maze) {
		int maxX = 0;
		int maxY = 0;
		this.maze = maze;
		for (Cell cell : maze.values()) {
			if (maxX < cell.getX()) {
				maxX = cell.getX();
			}
			if (maxY < cell.getY()) {
				maxY = cell.getY();
			}
		}
		this.X = maxX;
		this.Y = maxY;
		setXscale(0, X + 2);
		setYscale(0, Y + 2);

		init();
	}

	private void init() {
		// Init for StandardDraw

		if (frame != null)
			frame.setVisible(false);
		frame = new JFrame();
		offscreenImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		onscreenImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		offscreen = offscreenImage.createGraphics();
		onscreen = onscreenImage.createGraphics();
		offscreen.setColor(DEFAULT_CLEAR_COLOR);
		offscreen.fillRect(0, 0, width, height);
		setPenColor();
		setPenRadius();
		setFont();
		// add antialiasing
		RenderingHints hints = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		offscreen.addRenderingHints(hints);
		// frame stuff
		ImageIcon icon = new ImageIcon(onscreenImage);
		JLabel draw = new JLabel(icon);
		frame.setContentPane(draw);
		frame.addKeyListener(this); // JLabel cannot get keyboard focus
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes all
																// windows
		frame.setTitle("Smart Maze");
		frame.pack();
		frame.requestFocusInWindow();
		frame.setVisible(true);
		onscreen.drawImage(offscreenImage, 0, 0, null);
		frame.repaint();

	}

	/**
	 * Draw a line from (x0, y0) to (x1, y1).
	 * 
	 * @param x0
	 *            the x-coordinate of the starting point
	 * @param y0
	 *            the y-coordinate of the starting point
	 * @param x1
	 *            the x-coordinate of the destination point
	 * @param y1
	 *            the y-coordinate of the destination point
	 */
	public void line(double x0, double y0, double x1, double y1) {
		offscreen.draw(new Line2D.Double(scaleX(x0), scaleY(y0), scaleX(x1),
				scaleY(y1)));
		// draw();
	}
	
	public void label(String text, double x, double y){
		
		offscreen.drawString(text, (float)scaleX(x + .3), (float)scaleY(y + .5));
		
	}

	// a test client
	public static void main(String[] args) {
		SmartMazeTest smartMaze = new SmartMazeTest(getSampleMaze());
		smartMaze.loadIdealMovePath();
		smartMaze.setCurrentCellKey(startX + "," + startY);
		smartMaze.setCurrentCell(smartMaze.getMaze().get(
				smartMaze.getCurrentCellKey()));

	}

	private static HashMap<String, Cell> getSampleMaze() {

		HashMap<String, Cell> sampleMaze = new HashMap<String, Cell>();
		sampleMaze.put("1,1", new Cell(false, true, true, true, 1, 1));
		sampleMaze.put("1,2", new Cell(false, false, true, true, 1, 2));
		sampleMaze.put("1,3", new Cell(true, false, false, true, 1, 3));
		sampleMaze.put("1,4", new Cell(true, true, false, true, 1, 4));
		sampleMaze.put("1,5", new Cell(true, true, false, true, 1, 5));
		sampleMaze.put("2,1", new Cell(false, true, false, true, 2, 1));
		sampleMaze.put("2,2", new Cell(true, false, true, true, 2, 2));
		sampleMaze.put("2,3", new Cell(false, true, true, false, 2, 3));
		sampleMaze.put("2,4", new Cell(false, false, false, false, 2, 4));
		sampleMaze.put("2,5", new Cell(true, false, true, false, 2, 5));
		sampleMaze.put("3,1", new Cell(false, true, false, false, 3, 1));
		sampleMaze.put("3,2", new Cell(false, false, true, true, 3, 2));
		sampleMaze.put("3,3", new Cell(false, false, true, true, 3, 3));
		sampleMaze.put("3,4", new Cell(true, false, true, false, 3, 4));
		sampleMaze.put("3,5", new Cell(true, true, false, true, 3, 5));
		sampleMaze.put("4,1", new Cell(false, true, false, false, 4, 1));
		sampleMaze.put("4,2", new Cell(false, false, false, true, 4, 2));
		sampleMaze.put("4,3", new Cell(false, false, false, true, 4, 3));
		sampleMaze.put("4,4", new Cell(false, false, false, true, 4, 4));
		sampleMaze.put("4,5", new Cell(true, false, true, false, 4, 5));
		sampleMaze.put("5,1", new Cell(false, true, true, false, 5, 1));
		sampleMaze.put("5,2", new Cell(true, false, true, false, 5, 2));
		sampleMaze.put("5,3", new Cell(true, true, true, false, 5, 3));
		sampleMaze.put("5,4", new Cell(false, true, true, false, 5, 4));
		sampleMaze.put("5,5", new Cell(true, false, true, true, 5, 5));
		return sampleMaze;
	}

	/**
	 * Set the x-scale
	 * 
	 * @param min
	 *            the minimum value of the x-scale
	 * @param max
	 *            the maximum value of the x-scale
	 */
	public void setXscale(double min, double max) {
		double size = max - min;
		synchronized (mouseLock) {
			xmin = min - BORDER * size;
			xmax = max + BORDER * size;
		}
	}

	/**
	 * Set the y-scale
	 * 
	 * @param min
	 *            the minimum value of the y-scale
	 * @param max
	 *            the maximum value of the y-scale
	 */
	public void setYscale(double min, double max) {
		double size = max - min;
		synchronized (mouseLock) {
			ymin = min - BORDER * size;
			ymax = max + BORDER * size;
		}
	}

	/**
	 * Set the x-scale to be the default (between 0.0 and 1.0).
	 */
	public void setXscale() {
		setXscale(DEFAULT_XMIN, DEFAULT_XMAX);
	}

	/**
	 * Set the y-scale to be the default (between 0.0 and 1.0).
	 */
	public void setYscale() {
		setYscale(DEFAULT_YMIN, DEFAULT_YMAX);
	}

	/**
	 * Display on-screen and turn off animation mode: subsequent calls to
	 * drawing methods such as <tt>line()</tt>, <tt>circle()</tt>, and
	 * <tt>square()</tt> will be displayed on screen when called. This is the
	 * default.
	 */
	/**
	 * Set the pen color to the given color. The available pen colors are BLACK,
	 * BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY, MAGENTA, ORANGE, PINK,
	 * RED, WHITE, and YELLOW.
	 * 
	 * @param color
	 *            the Color to make the pen
	 */
	public void setPenColor(Color color) {
		penColor = color;
		offscreen.setColor(penColor);
	}

	/**
	 * Draw filled circle of radius r, centered on (x, y).
	 * 
	 * @param x
	 *            the x-coordinate of the center of the circle
	 * @param y
	 *            the y-coordinate of the center of the circle
	 * @param r
	 *            the radius of the circle
	 * @throws IllegalArgumentException
	 *             if the radius of the circle is negative
	 */
	// helper functions that scale from user coordinates to screen coordinates
	// and back
	private double scaleX(double x) {
		return width * (x - xmin) / (xmax - xmin);
	}

	private double scaleY(double y) {
		return height * (ymax - y) / (ymax - ymin);
	}

	private double factorX(double w) {
		return w * width / Math.abs(xmax - xmin);
	}

	private double factorY(double h) {
		return h * height / Math.abs(ymax - ymin);
	}

	/**
	 * Draw one pixel at (x, y).
	 * 
	 * @param x
	 *            the x-coordinate of the pixel
	 * @param y
	 *            the y-coordinate of the pixel
	 */
	private void pixel(double x, double y) {
		offscreen.fillRect((int) Math.round(scaleX(x)),
				(int) Math.round(scaleY(y)), 1, 1);
	}

	/**
	 * Set the pen color to the default color (black).
	 */
	private void setPenColor() {
		setPenColor(DEFAULT_PEN_COLOR);
	}

	/**
	 * Set the pen size to the default (.002).
	 */
	private void setPenRadius() {
		setPenRadius(DEFAULT_PEN_RADIUS);
	}

	/**
	 * Set the radius of the pen to the given size.
	 * 
	 * @param r
	 *            the radius of the pen
	 * @throws IllegalArgumentException
	 *             if r is negative
	 */
	private void setPenRadius(double r) {
		if (r < 0)
			throw new IllegalArgumentException("pen radius must be nonnegative");
		penRadius = r;
		float scaledPenRadius = (float) (r * DEFAULT_SIZE);
		BasicStroke stroke = new BasicStroke(scaledPenRadius,
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		// BasicStroke stroke = new BasicStroke(scaledPenRadius);
		offscreen.setStroke(stroke);
	}

	/**
	 * Set the font to the default font (sans serif, 16 point).
	 */
	private void setFont() {
		setFont(DEFAULT_FONT);
	}

	/**
	 * Set the font to the given value.
	 * 
	 * @param f
	 *            the font to make text
	 */
	private void setFont(Font f) {
		font = f;
	}

	/**
	 * Clear the screen to the default color (white).
	 */
	private void clear() {
		clear(DEFAULT_CLEAR_COLOR);
	}

	/**
	 * Clear the screen to the given color.
	 * 
	 * @param color
	 *            the Color to make the background
	 */
	private void clear(Color color) {
		offscreen.setColor(color);
		offscreen.fillRect(0, 0, width, height);
		offscreen.setColor(penColor);
		// draw();
	}

	/**
	 * This method cannot be called directly.
	 */
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * This method cannot be called directly.
	 */
	public void keyPressed(KeyEvent e) {
		System.out.println("moveNumber:" + moveNumber);
		drawMaze();
		if (moreMoves()) {
			proceedToNextCell();
			drawMaze();
			if (!onIdealPath()) {
				String message = "Move number " + moveNumber
						+ " put you on the incorrect path.\n";
				message = message + "Current cell: " + currentCell.getX() + ","
						+ currentCell.getY() + "\n";
				message = message + "Correct cell: "
						+ idealPath.get(moveNumber).getX() + ","
						+ idealPath.get(moveNumber).getY();

				//JOptionPane.showMessageDialog(null, message, "Maze Status",
						//JOptionPane.PLAIN_MESSAGE);

			}
		} else {
			JOptionPane.showMessageDialog(null, "No more moves to validate",
					"Maze Status", JOptionPane.PLAIN_MESSAGE);
		}
		this.moveNumber++;
	}

	public void drawMaze() {
		clear();
		setPenColor(SmartMazeTest.RED);
		filledCircle(getCurrentCellX() + .5, getCurrentCellY() + .5, 0.375);

		setPenColor(SmartMazeTest.BLACK);
		for (Cell cell : maze.values()) {
			int x = cell.getX();
			int y = cell.getY();
			if (cell.hasSouthWall())
				line(x, y, x + 1, y);
			if (cell.hasNorthWall())
				line(x, y + 1, x + 1, y + 1);
			if (cell.hasWestWall())
				line(x, y, x, y + 1);
			if (cell.hasEastWall())
				line(x + 1, y, x + 1, y + 1);
		}
		label("Start", startX, startY);
		label("Finish", finishX, finishY);
		onscreen.drawImage(offscreenImage, 0, 0, null);
		frame.repaint();

	}

	/**
	 * This method cannot be called directly.
	 */
	public void keyReleased(KeyEvent e) {
	}

	public void filledCircle(double x, double y, double r) {
		if (r < 0)
			throw new IllegalArgumentException(
					"circle radius must be nonnegative");
		double xs = scaleX(x);
		double ys = scaleY(y);
		double ws = factorX(2 * r);
		double hs = factorY(2 * r);
		if (ws <= 1 && hs <= 1)
			pixel(x, y);
		else
			offscreen.fill(new Ellipse2D.Double(xs - ws / 2, ys - hs / 2, ws,
					hs));
		onscreen.drawImage(offscreenImage, 0, 0, null);
		frame.repaint();
	}

	public void proceedToNextCell() {

		currentCell = maze.get(currentCellKey);
		
		if(currentCell.getX() == finishX){
			
			if(currentCell.getY() == finishY)
				
			System.out.println("Finish");
		}

		if (currentCell.getNumberOfWalls() == 3) {

			if (!currentCell.hasWestWall()) {

				getCurrentCell().getWallMap().put("West", new Boolean(true));

				currentCellKey = (currentCell.getX() + -1) + ","
						+ currentCell.getY();
				
				maze.get(currentCellKey).getWallMap().put("East", new Boolean(true));

			} else if (!currentCell.hasNorthWall()) {

				getCurrentCell().getWallMap().put("North", new Boolean(true));

				currentCellKey = currentCell.getX() + ","
						+ (currentCell.getY() + 1);
				
				maze.get(currentCellKey).getWallMap().put("South", new Boolean(true));

			} else if (!currentCell.hasEastWall()) {

				getCurrentCell().getWallMap().put("East", new Boolean(true));

				currentCellKey = (currentCell.getX() + 1) + ","
						+ currentCell.getY();
				
				maze.get(currentCellKey).getWallMap().put("West", new Boolean(true));

			} else if (!currentCell.hasSouthWall()) {

				getCurrentCell().getWallMap().put("South", new Boolean(true));

				currentCellKey = currentCell.getX() + ","
						+ (currentCell.getY() - 1);
				
				maze.get(currentCellKey).getWallMap().put("North", new Boolean(true));
			}

		} else if (!currentCell.hasWestWall() && !lastMove.equals("east")) {

			currentCellKey = (currentCell.getX() + -1) + ","
					+ currentCell.getY();

			lastMove = "west";

		} else if (!currentCell.hasNorthWall() && !lastMove.equals("south")) {

			currentCellKey = currentCell.getX() + ","
					+ (currentCell.getY() + 1);

			lastMove = "north";

		} else if (!currentCell.hasEastWall() && !lastMove.equals("west")) {

			currentCellKey = (currentCell.getX() + 1) + ","
					+ currentCell.getY();

			lastMove = "east";

		} else if (!currentCell.hasSouthWall() && !lastMove.equals("north")) {

			currentCellKey = currentCell.getX() + ","
					+ (currentCell.getY() + -1);

			lastMove = "south";
		}

		System.out.println(lastMove);

	}

	public String getCurrentCellKey() {
		return currentCellKey;
	}

	public void setCurrentCellKey(String currentCellKey) {
		this.currentCellKey = currentCellKey;
	}

	public String getLastMove() {
		return lastMove;
	}

	public void setLastMove(String lastMove) {
		this.lastMove = lastMove;
	}

	public int getCurrentCellX() {
		return this.currentCell.getX();

	}

	public int getCurrentCellY() {
		return this.currentCell.getY();

	}

	public HashMap<String, Cell> getMaze() {
		return maze;
	}

	public void setMaze(HashMap<String, Cell> maze) {
		this.maze = maze;
	}

	public Cell getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}

	public void loadIdealMovePath() {
		idealPath = new ArrayList<Cell>();
		idealPath.add(new Cell(1, 3));
		idealPath.add(new Cell(2, 3));
		idealPath.add(new Cell(2, 4));
		idealPath.add(new Cell(1, 4));
		idealPath.add(new Cell(2, 4));
		idealPath.add(new Cell(2, 5));
		idealPath.add(new Cell(1, 5));
		idealPath.add(new Cell(2, 5));
		idealPath.add(new Cell(2, 4));
		idealPath.add(new Cell(3, 4));
		idealPath.add(new Cell(3, 3));
		idealPath.add(new Cell(3, 2));
		idealPath.add(new Cell(3, 1));
		idealPath.add(new Cell(2, 1));
		idealPath.add(new Cell(2, 2));
		idealPath.add(new Cell(2, 1));
		idealPath.add(new Cell(3, 1));
		idealPath.add(new Cell(3, 2));
		idealPath.add(new Cell(3, 3));
		idealPath.add(new Cell(3, 4));
		idealPath.add(new Cell(2, 4));
		idealPath.add(new Cell(2, 3));
		idealPath.add(new Cell(1, 3));
		idealPath.add(new Cell(1, 2));
		idealPath.add(new Cell(1, 1));
		idealPath.add(new Cell(1, 2));
		idealPath.add(new Cell(1, 3));
		idealPath.add(new Cell(2, 3));
		idealPath.add(new Cell(2, 4));
		idealPath.add(new Cell(3, 4));
		idealPath.add(new Cell(3, 3));
		idealPath.add(new Cell(3, 2));
		idealPath.add(new Cell(3, 1));
		idealPath.add(new Cell(4, 1));
		idealPath.add(new Cell(4, 2));
		idealPath.add(new Cell(4, 3));
		idealPath.add(new Cell(4, 4));
		idealPath.add(new Cell(4, 5));
		idealPath.add(new Cell(3, 5));
		idealPath.add(new Cell(4, 5));
		idealPath.add(new Cell(4, 4));
		idealPath.add(new Cell(5, 4));
	}

	public boolean onIdealPath() {
		if (currentCell.getX() == idealPath.get(moveNumber).getX()
				&& currentCell.getY() == idealPath.get(moveNumber).getY()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean moreMoves() {
		if (idealPath == null) {
			return false;
		} else {
			if (moveNumber < idealPath.size()) {
				return true;
			} else {
				return false;
			}
		}
	}
}
