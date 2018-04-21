import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.BeforeClass;
import org.junit.Test;

public class RightHandRuleRobotTest {
	static Maze maze;
	static String s="*S**********\n" + 
			  		"*          *\n" + 
			  		"* ******** *\n" + 
			  		"*    *   * *\n" + 
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
		new RightHandRuleRobot(maze);
	}
	
	@Test
	public void testPositionAtCreation() {
		RightHandRuleRobot rightBot = new RightHandRuleRobot(maze);
		assertTrue("RightBot did not start at start position!",maze.getStartPosition().equals(rightBot.getCurrentPosition()));
	}
	
	@Test
	public void testIsGoalPositionAtCreation() {
		RightHandRuleRobot rightBot = new RightHandRuleRobot(maze);
		assertFalse("RightBot started at goal position!",maze.isGoal(rightBot.getCurrentPosition()));
	}
	
	@Test
	public void testPositionEastAtCreation() {
		RightHandRuleRobot rightBot = new RightHandRuleRobot(maze);
		assertTrue("RightBot did not start at start position!",rightBot.getCurrentPosition().getPosToEast().equals(maze.getStartPosition().getPosToEast()));
	}
	
	@Test
	public void testMove() {
		RightHandRuleRobot rightBot = new RightHandRuleRobot(maze);
		rightBot.move();
		assertEquals("RightBot started at goal position!", rightBot.getCurrentPosition(),maze.getStartPosition().getPosToSouth());
	}
	
	@Test
	public void testAlgorthim() {
		RightHandRuleRobot rightBot = new RightHandRuleRobot(maze);
		//rightBot.getCurrentPosition().printPosition();
		for(int i = 0; i < 21; i++) {
			rightBot.move();
			//rightBot.getCurrentPosition().printPosition();
		}
		assertTrue("RightBot started at goal position!",maze.isGoal(rightBot.getCurrentPosition()));
	}
	

}
