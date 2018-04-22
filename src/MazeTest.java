import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Test;

/**
 * 
 */

/**
 * This class test the maze object. Instead of a file being given, a string
 * is made to represent a maze.
 * @author Bram Coenen
 *
 */
public class MazeTest {
	String normalMaze = "*S**********\n" + 
			  			"*          *\n" + 
			  			"* ******** *\n" + 
			  			"*    *   * *\n" + 
			  			"*** ** * * *\n" + 
			  			"*      * * *\n" + 
			  			"********G***";
	
	String noGoal = "*S**********\n" + 
		  			"*          *\n" + 
		  			"* ******** *\n" + 
		  			"*    *   * *\n" + 
		  			"*** ** * * *\n" + 
		  			"*      * * *\n" + 
		  			"************";
	String twoGoals = "*S**********\n" + 
  			"*          *\n" + 
  			"* ******G* *\n" + 
  			"*    *   * *\n" + 
  			"*G* ** * * *\n" + 
  			"*      * * *\n" + 
  			"************";
	String noStart ="************\n" + 
		  			"*          *\n" + 
		  			"* ******** *\n" + 
		  			"*    *   * *\n" + 
		  			"*** ** * * *\n" + 
		  			"*      * * *\n" + 
		  			"********G***";
	
	// create a new StringReader
    Reader correctReader = new StringReader(normalMaze);
    Reader noGoalReader = new StringReader(noGoal);
    Reader twoGoalsReader = new StringReader(twoGoals);
    Reader noStartReader = new StringReader(noStart);
    
    
    /**
     * Checks if the constructor returned null.
     * @throws IOException if the maze canot be constucted.
     */
	@Test
	public void tesConstructionCorrectMaze() throws IOException{
		Maze maze = new Maze(correctReader);
		assertNotNull("Constructor returned null",maze);
	}
	
	/**
     * Checks if the constucter throws an exception when there is no goal in
     * the maze.
     * @throws IOException if the maze canot be constucted.
     */
	@Test (expected = IOException.class)
	public void tesConstructionNoGoal() throws IOException{
		new Maze(noGoalReader);
	}
	
	/**
     * Checks if the constucter does not throw an exception 
     * when there are multiple goals in the maze.
     * @throws IOException if the maze canot be constucted.
     */
	@Test
	public void tesConstructionTwoGoals() throws IOException{
		new Maze(twoGoalsReader);
	}
	
	/**
     * Checks if the constucter throws an exception when there is no start
     * position in the maze.
     * @throws IOException if the maze canot be constucted.
     */
	@Test (expected = IOException.class)
	public void tesConstructionNoStart() throws IOException{
		new Maze(noStartReader);
	}
	
	/**
     * Checks if a position is movable in the maze.
     * @throws IOException if the maze canot be constucted.
     */
	@Test
	public void testIsMovable() throws IOException{
		Maze maze = new Maze(correctReader);
		Position pos = new Position(2,1);
		assertTrue("Should be movable!", maze.isMovable(pos));
		
	}
	
	/**
     * Checks if a null position is not movable in the maze.
     * @throws IOException if the maze canot be constucted.
     */
	@Test
	public void testNullIsNotMovable() throws IOException{
		Maze maze = new Maze(correctReader);
		Position pos = null;
		assertFalse("Should be movable!", maze.isMovable(pos));
		
	}
	
	/**
     * Checks if a wall position is not movable in the maze.
     * @throws IOException if the maze canot be constucted.
     */
	@Test
	public void testIsMovableFalse() throws IOException{
		Maze maze = new Maze(correctReader);
		Position pos = new Position(0,0);
		assertFalse("Should not be movable!", maze.isMovable(pos));
		
	}
	
	/**
     * Checks if a goal position is a goal.
     * @throws IOException if the maze canot be constucted.
     */
	@Test
	public void testIsGoal() throws IOException{
		Maze maze = new Maze(correctReader);
		Position pos = new Position(8,6);
		assertTrue("Should be goal!", maze.isGoal(pos));	
	}
	
	/**
     * Checks if a null position is not a goal.
     * @throws IOException if the maze canot be constucted.
     */
	@Test
	public void testNullIsNotGoalFalse() throws IOException{
		Maze maze = new Maze(correctReader);
		Position pos = null;
		assertFalse("Should not be goal!", maze.isGoal(pos));	
	}
	
	/**
     * Checks if a non-goal position is not a goal.
     * @throws IOException if the maze canot be constucted.
     */
	@Test
	public void testIsGoalFalse() throws IOException{
		Maze maze = new Maze(correctReader);
		Position pos = new Position(5,4);
		assertFalse("Should not be goal!", maze.isGoal(pos));	
	}
	
	/**
     * Checks if the maze returns the correct start position.
     * @throws IOException if the maze canot be constucted.
     */
	@Test
	public void testGetStartPosition() throws IOException{
		Maze maze = new Maze(correctReader);
		Position startPos = new Position(1,0);
		assertTrue("Should be start!", 
				maze.getStartPosition().equals(startPos));	
	}
	
	/**
     * Checks if start position is not null.
     * @throws IOException if the maze canot be constucted.
     */
	@Test
	public void testGetFalseStartPosition() throws IOException{
		Maze maze = new Maze(correctReader);
		Position startPos = null;
		assertFalse("Should not be start goal!", 
				maze.getStartPosition().equals(startPos));	
	}
}
