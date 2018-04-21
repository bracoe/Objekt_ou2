import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Bram Coenen
 *
 */
public class MemoryRobotTest {
	static Maze maze;
	static String s="*S**********\n" + 
			  		"*          *\n" + 
			  		"********** *\n" + 
			  		"*    *     *\n" + 
			  		"*** ** * * *\n" + 
			  		"*      * * *\n" + 
			  		"********G***";
	// create a new StringReader
	static Reader reader = new StringReader(s);
	
	@BeforeClass
	static public void initMaze() {
		try {
			maze = new Maze(reader);
		}
		catch(IOException ex){
			fail("Could not create maze!");
		}
	}
	@Test
	public void testContruction() {
		new MemoryRobot(maze);
	}
	
	@Test
	public void testPositionAtCreation() {
		MemoryRobot memBot = new MemoryRobot(maze);
		assertTrue("memBot did not start at start position!",maze.getStartPosition().equals(memBot.getCurrentPosition()));
	}
	
	@Test
	public void testIsGoalPositionAtCreation() {
		MemoryRobot memBot = new MemoryRobot(maze);
		assertFalse("memBot started at goal position!",maze.isGoal(memBot.getCurrentPosition()));
	}
	
	@Test
	public void testPositionEastAtCreation() {
		MemoryRobot memBot = new MemoryRobot(maze);
		assertTrue("memBot did not start at start position!",memBot.getCurrentPosition().getPosToEast().equals(maze.getStartPosition().getPosToEast()));
	}
	
	@Test
	public void testMove() {
		MemoryRobot memBot = new MemoryRobot(maze);
		memBot.move();
		assertEquals("memBot did not go to right position!", memBot.getCurrentPosition(),maze.getStartPosition().getPosToSouth());
	}
	
	@Test
	public void testGoalCanBeFound() {
		int moves = 0;
		MemoryRobot memBot = new MemoryRobot(maze);
		System.out.println("Starting!");
		
		for(int i = 0; i < 50; i++) {
			memBot.move();
			moves++;
			if(maze.isGoal(memBot.getCurrentPosition())){
				break;
			}
		}
		System.out.println("Moves: " + moves);
		assertTrue("memBot did not find goal position!",maze.isGoal(memBot.getCurrentPosition()));
	}

}
