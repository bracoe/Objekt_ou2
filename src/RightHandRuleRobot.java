/**
 * 
 */

/**
 * This class extends the Robot class and gives it a unique move algorithm.
 * This is done be using a right-hand metod.
 * @author Bram Coenen
 *
 */
public class RightHandRuleRobot extends Robot {
	
	String facing;
	
	/**
	 * Creates a robot using a right-hand algoritm. Requires a maze to move in
	 * and set the deafault facing to north.
	 * @param maze
	 */
	public RightHandRuleRobot(Maze maze) {
		super(maze);
		facing = "north";
	}
	
	/**
	 * Tests if the robot can turn right from its current position.
	 * @return boolean true if the robot was able to move, else false.
	 */
	private boolean goToRight() {
		Position newPosition;
		switch (facing) {
			case "north":
				newPosition = getCurrentPosition().getPosToEast();
				facing = "east";
				break;
			case "east":
				newPosition = getCurrentPosition().getPosToSouth();
				facing = "south";
				break;
			case "south":
				newPosition = getCurrentPosition().getPosToWest();
				facing = "west";
				break;
			case "west":
				newPosition = getCurrentPosition().getPosToNorth();
				facing = "north";
				break;
			default:
				newPosition = getCurrentPosition();
				break;
		}
		if(maze.isMovable(newPosition)) {
			setCurrentPosition(newPosition);
			return true;
		}
		return false;
	}
	
	/**
	 * Turns the robot counterclockwise and tests if it can move to the
	 * position on the right.
	 */
	private void turnCounterClockwise() {
		boolean moved = false;
		Position newPosition;
		
		while(!moved) {
			switch (facing) {
				case "north":
					newPosition = getCurrentPosition().getPosToWest();
					facing = "west";
					break;
				case "east":
					newPosition = getCurrentPosition().getPosToNorth();
					facing = "north";
					break;
				case "south":
					newPosition = getCurrentPosition().getPosToEast();
					facing = "east";
					break;
				case "west":
					newPosition = getCurrentPosition().getPosToSouth();
					facing = "south";
					break;
				default:
					newPosition = getCurrentPosition();
					break;
			}
			if(maze.isMovable(newPosition)) {
				setCurrentPosition(newPosition);
				moved = true;
			}
		}
	}
	
	/**
	 * Implements the right-hand algorithm in order to move the robot.
	 */
	@Override
	public void move() {
		if(goToRight()){
			return;
		}
		else {
			turnCounterClockwise();
		}
	}	

}
