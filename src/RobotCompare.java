import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 
 */

/**
 * This class compares two robots in a given maze. The name of the maze file
 * should be given as an input argument. It tries to create a RightHandRobot 
 * and run it into the. Afterwards a MemoryRobot is constructed and also tested. 
 * @author Bram Coenen
 *
 */
public class RobotCompare {
	
	/**
	 * The main function which tries to constuct a maze from the given file.
	 * Then calls on the test funtions.
	 * @param args The name of the mazefile.
	 */
	public static void main(String[] args) {
		
		try {
			Maze maze = readMazeFromFile(args[0]);
			
			int rightBotMoves = testRightHandBot(maze);
			System.out.println("RightBot found goal after "
					+ rightBotMoves + " moves!");
			
			int memBotMoves = testMemBot(maze);
			System.out.println("Membot found goal after " 
								+ memBotMoves + " moves!");
			
		}
		catch(IOException ex){
			System.out.println("Maze could not be created due to IOexception "
								+ ex);
		}
	}
	
	/**
	 * The function which constructs the RightHandRobot and calls on move until
	 * this robot has found the goal.
	 * @param maze A Maze where the robot should be tested in.
	 * @return The number of moves it took for the robot.
	 */
	public static int testRightHandBot(Maze maze) {
		System.out.println("Putting a rightHandRobot in the maze...");
		int rightBotMoves = 0;
		RightHandRuleRobot rightBot = new RightHandRuleRobot(maze);
		while(!rightBot.hasReachedGoal()) {
			rightBot.move();
			rightBotMoves++;
		}
		return rightBotMoves;
	}
	
	/**
	 * The function which constructs the MemoryRobot and calls on move until
	 * this robot has found the goal.
	 * @param maze A Maze where the robot should be tested in.
	 * @return The number of moves it took for the robot.
	 */
	public static int testMemBot(Maze maze) {
		System.out.println("Putting a MemoryRobot in the maze...");
		int memBotMoves = 0;
		MemoryRobot memBot = new MemoryRobot(maze);
		while(!memBot.hasReachedGoal()) {
			memBot.move();
			memBotMoves++;
		}
		return memBotMoves;
	}
	
	/**
	 * This funtion creates a Maze from the given file.
	 * @param fileName A file to turn into a maze object.
	 * @return A Maze for the robots to be tested in.
	 * @throws IOException If the stream is not correct. Either it does not
	 * contain a start position or goal position. Or the reader 
	 * threw the exception.
	 */
	public static Maze readMazeFromFile(String fileName) throws IOException{
		
		Reader reader = null;
		Maze maze = null;
		
		try {
			System.out.println("Reading file...");
			reader = new FileReader(fileName);
			maze = new Maze(reader);
			System.out.println("Constucted maze...");
		}
		finally {
			try {
				if(reader != null) {
					reader.close();
				}
			}
			finally {
				
			}
			
		}
		
		return maze;
	}
}
