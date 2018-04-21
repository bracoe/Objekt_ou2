import java.io.IOException;
import java.util.Arrays;

/**
 * The class is reprezenting a maze saved as an int vector.
 * A start position is required, else an IOException is thrown. It is
 * also thrown if the stream cannot be read. 
 * @author Bram Coenen
 *
 */
public class Maze {
	public int mazeData[];
	private Position startPosition;
	
	/**
	 * The constructor for the maze object.
	 * @param fileReader A stream of how the maze should look.
	 * @throws IOException If the stream cannot be read or no start
	 * position is found.
	 */
	Maze(java.io.Reader fileReader) throws IOException{
		
		int arrayOfStream[] = new int[10];
		int mazePart = '*';
		boolean StreamEnd = false;
		boolean foundAGoal = false;
		
		int x = 0;
		int y = 0;
		
		startPosition = null;
		try {
			while(!StreamEnd) {
				
				mazePart = fileReader.read();
				if(mazePart == -1) {
					StreamEnd = true;
				}
				else if(mazePart == '\n') {
					y++;
					x=0;
					//System.out.println("Changed line!");
					continue;
				}
				else {
					//If hash is out of bounds, increase size of vector
					if(getHash(x,y) >= arrayOfStream.length) {
						arrayOfStream = Arrays.copyOf(arrayOfStream,
								getHash(x,y) +1);
					}
					//Register the start position
					if(mazePart == 'S') {
						startPosition = new Position(x,y);
					}
					//Set a found goal flag
					if(mazePart == 'G') {
						foundAGoal = true;
					}
					
					arrayOfStream[getHash(x, y)] = mazePart;
					x++;
				}
			}
			if(startPosition == null) {
				throw new IOException("No Start position found in stream!");
			}
			else if (!foundAGoal) {
				throw new IOException("No goal position found in stream!");
			}
		}
		finally {
			//System.out.println("End of stream!");
			mazeData = arrayOfStream.clone();
		}
	}
	
	/**
	 * Checks if the given position can be moved to in the maze.
	 * @param pos The position to check
	 * @return boolean True if it can be moved to, else false.
	 */
	public boolean isMovable(Position pos) {
		if(pos == null) {
			return false;
		}
		else {
			try {
				return (mazeData[pos.hashCode()] == ' ' 
						|| mazeData[pos.hashCode()] == 'G' 
						|| mazeData[pos.hashCode()] == 'S');
			}
			catch (IndexOutOfBoundsException ex){
				return false;
			}
		}
	}
	
	/**
	 * Checks if the given position is a goal in the maze.
	 * @param pos The position to check.
	 * @return boolean True if position is goal, else false.
	 */
	public boolean isGoal(Position pos) {
		if(pos == null) {
			return false;
		}
		else {
			try {
				return (mazeData[pos.hashCode()] == 'G');
			}
			catch (IndexOutOfBoundsException ex){
				return false;
			}
		}
	}
	
	/**
	 * Get the start position in the maze.2
	 * @return Position The start position.
	 */
	public Position getStartPosition() {
		return startPosition;
	}
	
	/**
	 * Calculates the hashCode for a given position depending on x and y.
	 * Due to the fact that the coordinates are always positive, 
	 * Cantor pairing function can be used.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return int A unique positive integer depending on the x and y.
	 */
	private int getHash(int x, int y) {
		return ((x+y)*(x+y+1)/2)+y;
	}
}
