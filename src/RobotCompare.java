import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 
 */

/**
 * @author Bram Coenen
 *
 */
public class RobotCompare {
	/**
	 * @param args
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
	 * 
	 * @param maze
	 * @return
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
	 * 
	 * @param maze
	 * @return
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
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
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
