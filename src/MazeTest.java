import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Test;

/**
 * 
 */

/**
 * @author bram
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
    Reader noStartReader = new StringReader(noStart);
    
    
    

	@Test
	public void tesConstructionCorrectMaze() throws IOException{
		new Maze(correctReader);
	}
	
	@Test (expected = IOException.class)
	public void tesConstructionNoGoal() throws IOException{
		new Maze(noGoalReader);
	}
	
	@Test (expected = IOException.class)
	public void tesConstructionNoStart() throws IOException{
		new Maze(noStartReader);
	}
	
	
	@Test
	public void testIsMovable() throws IOException{
		Maze maze = new Maze(correctReader);
		Position pos = new Position(2,1);
		assertTrue("Should be movable!", maze.isMovable(pos));
		
	}
	
	@Test
	public void testNullIsNotMovable() throws IOException{
		Maze maze = new Maze(correctReader);
		Position pos = null;
		assertFalse("Should be movable!", maze.isMovable(pos));
		
	}
	
	@Test
	public void testIsMovableFalse() throws IOException{
		Maze maze = new Maze(correctReader);
		Position pos = new Position(0,0);
		assertFalse("Should not be movable!", maze.isMovable(pos));
		
	}
	
	@Test
	public void testIsGoal() throws IOException{
		Maze maze = new Maze(correctReader);
		Position pos = new Position(8,6);
		assertTrue("Should be goal!", maze.isGoal(pos));	
	}
	
	@Test
	public void testNullIsNotGoalFalse() throws IOException{
		Maze maze = new Maze(correctReader);
		Position pos = null;
		assertFalse("Should not be goal!", maze.isGoal(pos));	
	}
	
	@Test
	public void testIsGoalFalse() throws IOException{
		Maze maze = new Maze(correctReader);
		Position pos = new Position(5,4);
		assertFalse("Should not be goal!", maze.isGoal(pos));	
	}
	
	@Test
	public void testGetStartPosition() throws IOException{
		Maze maze = new Maze(correctReader);
		Position startPos = new Position(1,0);
		assertTrue("Should start goal!", maze.getStartPosition().equals(startPos));	
	}
	
	@Test
	public void testGetFalseStartPosition() throws IOException{
		Maze maze = new Maze(correctReader);
		Position startPos = new Position(4,5);
		assertFalse("Should start goal!", maze.getStartPosition().equals(startPos));	
	}
}
