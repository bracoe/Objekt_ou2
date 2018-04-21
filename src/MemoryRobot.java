import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 */

/**
 * This class extends the Robot class and gives it a unique move algorithm.
 * This is done be using a depth-first search.
 * @author Bram Coenen
 *
 */
public class MemoryRobot extends Robot {
	Position nextPosition = null;
	Stack<Position> backTrackStack;
	List<Position> seenList;
	boolean goBack;
	
	/**
	 * @param maze
	 */
	public MemoryRobot(Maze maze) {
		super(maze);
		backTrackStack = new Stack<Position>();
		seenList = new ArrayList<Position>();
		
		seenList.add(getCurrentPosition());
		goBack = addUnSeenPositionsToStack();
	}
	
	/**
	 * Moves the robot one position, either backwards or to a new position.
	 * If the prevois move did not find new positions, the goBack flag will
	 * be set and the robot will go back to its' last saved position.
	 */
	@Override
	public void move() {
		if(goBack) {
			if(backTrackStack.empty()) {
				System.out.println("Nowhere to go!");
			}
			else {
				setCurrentPosition(backTrackStack.pop());
			}
			
		}
		else {
			backTrackStack.push(getCurrentPosition());
			setCurrentPosition(nextPosition);
			seenList.add(getCurrentPosition());
		}
		
		goBack = addUnSeenPositionsToStack();
	}
	
	/**
	 * Adds all the positions which are not in the seenList to the nextPosition. 
	 * The positions are check and push from north to east going 
	 * clockwards. 
	 * @return true if a new position is added to the nextPosition.
	 */
	private boolean addUnSeenPositionsToStack() {
		boolean foundNewPath = false;
		Position posNorth = getCurrentPosition().getPosToNorth();
		Position posEast = getCurrentPosition().getPosToEast();
		Position posSouth = getCurrentPosition().getPosToSouth();
		Position posWest = getCurrentPosition().getPosToWest();
		if(maze.isMovable(posNorth) && !seenList.contains(posNorth)) {
			nextPosition = posNorth;
			foundNewPath = true;
		} else if(maze.isMovable(posEast) && !seenList.contains(posEast)) {
			nextPosition = posEast;
			foundNewPath = true;
		} else if(maze.isMovable(posSouth)&& !seenList.contains(posSouth)) {
			nextPosition = posSouth;
			foundNewPath = true;
		} else if(maze.isMovable(posWest) && !seenList.contains(posWest)) {
			nextPosition = posWest;
			foundNewPath = true;
		}
		
		return !foundNewPath;
	}

}
