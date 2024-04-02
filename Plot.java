/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: 2D plot data storage
 * Due: 4/1/24
 * Platform/compiler: Java/Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ben Safford
*/


public class Plot {
	
	private int xCoord, yCoord;
	private int xSize, ySize;
	
	public int getX() {
		return xCoord;
	}
	
	public int xMax() {return xCoord + xSize;}
	
	public void setX(int xCoord) {
		this.xCoord = xCoord;
	}
	public int getY() {
		return yCoord;
	}
	public int yMax() {return yCoord + ySize;}
	
	public void setY(int yCoord) {
		this.yCoord = yCoord;
	}
	public int getWidth() {
		return xSize;
	}
	public void setWidth(int xSize) {
		this.xSize = xSize;
	}
	public int getDepth() {
		return ySize;
	}
	public void setDepth(int ySize) {
		this.ySize = ySize;
	}
	
	public boolean overlaps(Plot compareTo) {
		if(compareTo.xMax() <= xCoord || compareTo.xCoord >= xMax())
			return false;
		if(compareTo.yMax() <= yCoord || compareTo.yCoord >= yMax())
			return false;
		return true;
	}
	
	
	public boolean contains(Plot compareTo) {
		return contains(compareTo.getX(), compareTo.getY()) && contains(compareTo.xMax(), compareTo.yMax());
	}
	
	public boolean contains(int x, int y) {
		return (this.xCoord <= x && this.xMax() >= x && this.yCoord <= y && this.yMax() >= y);
	}
	
	
	public Plot(int x, int y, int dx, int dy) {
		xCoord = x;
		yCoord = y;
		xSize = dx;
		ySize = dy;
	}
}
