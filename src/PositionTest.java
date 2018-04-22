import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * Tests the methods of the position object.
 * @author Bram Coenen
 *
 */
public class PositionTest {

	/**
	 * Tests if a valid position is not null.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testConstructor() throws IndexOutOfBoundsException {
		Position pos = new Position(0,0);
		assertNotNull("Constructor returned null",pos);
	}
	
	/**
	 * Tests if an exception is thrown when a neagtiv x value is given,
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void testConstructorNegativeX() throws IndexOutOfBoundsException {
		Position pos = new Position(-1,0);
		assertNotNull("Constructor returned null",pos);
	}
	
	/**
	 * Tests if an exception is thrown when a neagtiv y value is given,
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void testConstructorNegativeY() throws IndexOutOfBoundsException {
		Position pos = new Position(0,-1);
		assertNotNull("Constructor returned null",pos);
	}
	
	/**
	 * Tests if the corect x value is returned.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testGetX() throws IndexOutOfBoundsException {
		Position pos = new Position(4,4);
		assertEquals("Did not set correct x!",pos.getX(),4);
	}
	
	/**
	 * Tests if the corect y value is returned.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testGetY() throws IndexOutOfBoundsException {
		Position pos = new Position(4,4);
		assertEquals("Did not set correct y!",pos.getY(),4);
	}
	
	/**
	 * Tests if the corect posistion to the south is returned.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testGetPositionToSouth() throws IndexOutOfBoundsException {
		Position pos = new Position(10,4);
		Position south = new Position(10,5);
		Position shouldBeSouthPosition = pos.getPosToSouth();
		
		assertTrue("Did not set correct position!", 
				south.equals(shouldBeSouthPosition));
	}
	
	/**
	 * Tests if the corect posistion to the north is returned.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testGetPositionToNorth() throws IndexOutOfBoundsException {
		Position pos = new Position(10,4);
		Position north = new Position(10,3);
		Position shouldBeNorthPosition = pos.getPosToNorth();
		
		assertTrue("Did not set correct position!", 
				north.equals(shouldBeNorthPosition));
	}
	
	/**
	 * Tests if null is given when get north results in a negative y value.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testGetPositionToNorthNull() throws IndexOutOfBoundsException {
		Position pos = new Position(10,0);
		Position shouldBeNull = pos.getPosToNorth();
		
		assertNull("Did not set correct position!", shouldBeNull);
	}
	
	/**
	 * Tests if the corect posistion to the west is returned.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testGetPositionToWest() throws IndexOutOfBoundsException {
		Position pos = new Position(10,4);
		Position west = new Position(9,4);
		Position shouldBeWestPosition = pos.getPosToWest();
		
		assertTrue("Did not set correct position!", 
				west.equals(shouldBeWestPosition));
	}
	
	/**
	 * Tests if null is given when get west results in a negative x value.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testGetPositionToWestNull() throws IndexOutOfBoundsException {
		Position pos = new Position(0,5);
		Position shouldBeNull = pos.getPosToWest();
		
		assertNull("Did not set correct position!", shouldBeNull);
	}
	
	/**
	 * Tests if the corect posistion to the east is returned.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testGetPositionToEast() throws IndexOutOfBoundsException {
		Position pos = new Position(10,4);
		Position east = new Position(11,4);
		Position shouldBeEastPosition = pos.getPosToEast();
		
		assertTrue("Did not set correct position!", 
				east.equals(shouldBeEastPosition));
	}
	
	/**
	 * Tests if two position with same x and y are equal.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testEquals() throws IndexOutOfBoundsException {
		Position pos = new Position(10,4);
		Position samePos = new Position(10,4);		
		assertTrue("Did not say positions are the same!", 
				pos.equals(samePos));
	}
	
	/**
	 * Tests if two position with different x and y are not equal.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testEqualsFalse() throws IndexOutOfBoundsException {
		Position pos = new Position(10,4);
		Position samePos = new Position(11,9);		
		assertFalse("Says positions are the same!", 
				pos.equals(samePos));
	}
	
	/**
	 * Tests if a position is not equal to a null position.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testEqualsWithNull() throws IndexOutOfBoundsException {
		Position pos = new Position(10,4);
		Position samePos = null;		
		assertFalse("Says positions are the same!", 
				pos.equals(samePos));
	}
	
	/**
	 * Tests if the correct hashcode is returned.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testHashCode() throws IndexOutOfBoundsException {
		int x = 20;
		int y = 40;
		Position pos = new Position(x,y);
		int hashValue = ((x+y)*(x+y+1)/2) + y;	
		assertEquals("Did not return correct hash!", 
				pos.hashCode(), hashValue);
	}
	
	/**
	 * Tests if two different positions don't have the same hashvalue.
	 * @throws IndexOutOfBoundsException if a position with a negative value
	 * is created.
	 */
	@Test
	public void testHashCodeNotSame() throws IndexOutOfBoundsException {
		int x = 20;
		int y = 40;
		Position pos = new Position(x,y);
		Position invertedPos = new Position(y,x);
		assertNotEquals("Did not return correct hash!", pos.hashCode(), 
				invertedPos.hashCode());
	}
}
