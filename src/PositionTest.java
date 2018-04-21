import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Bram Coenen
 *
 */
public class PositionTest {

	@Test
	public void testConstructor() {
		Position pos = new Position(0,0);
		assertNotNull("Constructor returned null",pos);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testConstructorNegativeX() {
		Position pos = new Position(-1,0);
		assertNotNull("Constructor returned null",pos);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testConstructorNegativeY() {
		Position pos = new Position(0,-1);
		assertNotNull("Constructor returned null",pos);
	}
	
	@Test
	public void testGetX() {
		Position pos = new Position(4,4);
		assertEquals("Did not set correct x!",pos.getX(),4);
	}
	
	@Test
	public void testGetY() {
		Position pos = new Position(4,4);
		assertEquals("Did not set correct y!",pos.getY(),4);
	}
	
	@Test
	public void testGetPositionToSouth() {
		Position pos = new Position(10,4);
		Position south = new Position(10,5);
		Position shouldBeSouthPosition = pos.getPosToSouth();
		
		assertTrue("Did not set correct position!", 
				south.equals(shouldBeSouthPosition));
	}
	
	@Test
	public void testGetPositionToNorth() {
		Position pos = new Position(10,4);
		Position north = new Position(10,3);
		Position shouldBeNorthPosition = pos.getPosToNorth();
		
		assertTrue("Did not set correct position!", 
				north.equals(shouldBeNorthPosition));
	}
	
	@Test
	public void testGetPositionToNorthNull() {
		Position pos = new Position(10,0);
		Position shouldBeNull = pos.getPosToNorth();
		
		assertNull("Did not set correct position!", shouldBeNull);
	}
	
	@Test
	public void testGetPositionToWest() {
		Position pos = new Position(10,4);
		Position west = new Position(9,4);
		Position shouldBeWestPosition = pos.getPosToWest();
		
		assertTrue("Did not set correct position!", 
				west.equals(shouldBeWestPosition));
	}
	
	@Test
	public void testGetPositionToWestNull() {
		Position pos = new Position(0,5);
		Position shouldBeNull = pos.getPosToWest();
		
		assertNull("Did not set correct position!", shouldBeNull);
	}
	
	@Test
	public void testGetPositionToEast() {
		Position pos = new Position(10,4);
		Position east = new Position(11,4);
		Position shouldBeEastPosition = pos.getPosToEast();
		
		assertTrue("Did not set correct position!", 
				east.equals(shouldBeEastPosition));
	}
	
	@Test
	public void testEquals() {
		Position pos = new Position(10,4);
		Position samePos = new Position(10,4);		
		assertTrue("Did not say positions are the same!", 
				pos.equals(samePos));
	}
	
	@Test
	public void testEqualsFalse() {
		Position pos = new Position(10,4);
		Position samePos = new Position(11,9);		
		assertFalse("Did not say positions are the same!", 
				pos.equals(samePos));
	}
	
	@Test
	public void testHashCode() {
		int x = 20;
		int y = 40;
		Position pos = new Position(x,y);
		int hashValue = ((x+y)*(x+y+1)/2) + y;	
		assertEquals("Did not return correct hash!", 
				pos.hashCode(), hashValue);
	}
	
	@Test
	public void testHashCodeNotSame() {
		int x = 20;
		int y = 40;
		Position pos = new Position(x,y);
		Position invertedPos = new Position(y,x);
		assertNotEquals("Did not return correct hash!", pos.hashCode(), 
				invertedPos.hashCode());
	}
}
