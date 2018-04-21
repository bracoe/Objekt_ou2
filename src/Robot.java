/**
 * 
 */

/**
 * An abstact class describing the metods needed for a robot in order to 
 * traverse the maze and find a goal. The move metod is unique for each robot.
 * @author Bram Coenen
 *
 */
public abstract class Robot {
	private Position position;
	protected Maze maze;
	
	/**
	 * Makes a robot with the given maze. The start position in the
	 * maze is set as the robots current position.
	 * @param maze
	 */
	Robot(Maze maze){
		this.maze = maze; 
		this.position = maze.getStartPosition();
	}
	
	/**
	 * Moves the robot using an algorithm. This method is meant to be 
	 * overridden, by the children of this class.
	 */
	public abstract void move();
	
	/**
	 * GEt the current position of the robot.
	 * @return Position The current position the robot is at. 
	 */
	public Position getCurrentPosition() {
		return this.position;
	}
	/**
	 * Sets the current position the robot is at.
	 * @param currentPosition The current position the robot is at.
	 */
	protected void setCurrentPosition(Position currentPosition) {
		this.position = currentPosition;
	}
	
	/**
	 * Checks in the maze if the robot has reached the goal.
	 * @return true if current position is goal, else false.
	 */
	public boolean hasReachedGoal() {
		return this.maze.isGoal(position);
	}
	
	
}
