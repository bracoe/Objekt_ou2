/**
 * 
 */

/**
 * @author Bram Coenen
 *
 */
public class RightHandRuleRobot extends Robot {
	String facing;
	/**
	 * @param maze
	 */
	public RightHandRuleRobot(Maze maze) {
		super(maze);
		facing = "north";
	}
	
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
