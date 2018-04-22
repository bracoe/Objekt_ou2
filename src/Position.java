/**
 * 
 */

/**
 * This class is made for representing x and y coordinates for a maze.
 * X and y value should be positive for the hashcode, but they can be 
 * negative. However the hashcode will not be unique.
 * @author Bram Coenen
 *
 */
public class Position {
	private int x;
	private int y;
	
	/**
	 * Creates a new position with the given x and y-value.
	 * @param x A value to set x to.
	 * @param y A value to set y to.
	 * @throws IndexOutOfBoundsException if the x or y value is negative.
	 */
	Position(int x, int y) throws IndexOutOfBoundsException{
		if(x < 0 || y < 0) {
			throw new IndexOutOfBoundsException("Got negative value!");
		}
		
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Get the x value of the position.
	 * @return int x value of position.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Get the y value of the position.
	 * @return int y value of position.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Get to position south of the current position by adding 1 to the y value.
	 * @return A new position to the south of this current position.
	 */
	public Position getPosToSouth() {
		return new Position(x,y+1);
	}
	
	/**
	 * Get to position north of the current position by subtraction 1 to the
	 * current y value.
	 * @return A new position to the north of this current position.
	 */
	public Position getPosToNorth() {
		try{
			return new Position(x,y-1);
		}
		catch (IndexOutOfBoundsException ex) {
			return null;
		}
	}

	/**
	 * Get to position north of the current position by subtraction 1 to the
	 * current x value.
	 * @return A new position to the west of this current position.
	 */
	public Position getPosToWest() {
		
		try{
			return new Position(x-1,y);
		}
		catch (IndexOutOfBoundsException ex) {
			return null;
		}
	}
	
	/**
	 * Get to position north of the current position by adding 1 to the
	 * current x value.
	 * @return A new position to the east of this current position.
	 */
	public Position getPosToEast() {
		return new Position(x+1,y);
		
	}
	
	/**
	 * Tests whether or no the two position objects are the same position.
	 * As in they have the same x and y value. If the object is null, it will
	 * always be false.
	 * @param o 
	 * @return
	 */
	@Override
	public boolean equals(Object o){
		if(o == null) {
			return false;
		}
		else {
			Position givenPosition = (Position) o;
			return(this.hashCode() == givenPosition.hashCode());
		}
	}
	
	/**
	 * Calculates the hashCode for a given position depending on x and y.
	 * Due to the fact that the coordinates are always positive, 
	 * Cantor pairing function can be used.
	 * @return int A unique positive integer depending on the x and y.
	 */
	@Override
	public int hashCode() {
		//Cantor pairing function
		return ((x+y)*(x+y+1)/2) + y;
		
	}
}
