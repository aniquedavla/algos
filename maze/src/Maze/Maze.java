package Maze;
import stack.Stack;
import java.util.Random;

public class Maze {

	// Constructors
	/**
	 * Default Constructor: generates a maze as a two-dimension array of
	 * MazeCell types
	 * @param rows
	 * @param cols
	 */
	public Maze(int rows, int cols)
	{
		if(rows < 2) rows = 2;
		if(cols < 2) cols = 2;
		rowCount = rows;
		colCount = cols;
		cellCount = rowCount*colCount;
		
		cells = new MazeCell[rowCount][colCount];
		
		for (int row = 0; row < rowCount; row++)
		{
			for(int col = 0; col < colCount; col++)
			{
				cells[row][col] = new MazeCell(row, col, this);
				
				short pathExistence = 0;
				if (row - 1 >= 0) 	pathExistence |= Path.NORTH.value;
				if (row + 1 < rows) pathExistence |= Path.SOUTH.value;
				if (col - 1 >= 0)	pathExistence |= Path.WEST.value;
				if (col + 1 < cols) pathExistence |= Path.EAST.value;
				cells[row][col].pathState |= (pathExistence << 4);
			}
		}

		mazeStart = cells[0][0];
		mazeEnd = cells[rowCount - 1][colCount - 1];

		
		mazify();
		printMaze();
		
		// the next two lines cause the printMaze method to leave an opening
		// at the start and end rooms
		mazeStart.pathConnect(Path.NORTH);
		mazeEnd.pathConnect(Path.SOUTH);
	}
	
	// Instance Methods
	private void mazify()
	{
		Stack<MazeCell> stack = new Stack<MazeCell>();

		MazeCell currentCell = mazeStart;
		int visitedCells = 1;
		MazeCell neighbor = null;
		Path spinner = null;
		
		while(visitedCells < cellCount)
		{
			neighbor = null;
			// randomize the order in which neighboring cells will be checked
			short[] perm = {0, 1, 2, 3};
			perm = shuffle(perm);

			for(int i = 0; i < perm.length  && neighbor == null; i++)
			{
				spinner = Path.values()[perm[i]];
				MazeCell temp = currentCell.getNeighbor(spinner);
				if(temp != null && temp.hasAllWalls())
					neighbor = temp;
			}
			
			if(neighbor != null)
			{
				currentCell.pathConnect(neighbor, spinner);
				stack.push(currentCell);
				currentCell = neighbor;
				visitedCells++;
			}
			else
			{
				currentCell = stack.pop();
			}
			
		}
		mazeStart.pathConnect(Path.NORTH);
		mazeEnd.pathConnect(Path.SOUTH);
	}
	
	private short[] shuffle(short[] arr)
	{
		Random random = new Random();
		for(int i = arr.length - 1; i > 0; i--)
		{
			short index = (short) random.nextInt(i + 1);
			
			short a = arr[index];
			arr[index] = arr[i];
			arr[i] = a;
		}
		return arr;
	}
	
	private void printMaze()
	{
		String northWalls = "+";
		String eastWestWalls = "|";
		String southWalls = "+";
		// first row:
		for(int col = 0; col < colCount; col++)
		{
			MazeCell currentCell = cells[0][col];
			northWalls += currentCell.hasWall(Path.NORTH) ? "———+" : "   +";
			southWalls += currentCell.hasWall(Path.SOUTH) ? "———+" : "   +";
			eastWestWalls += currentCell.hasWall(Path.EAST) ? "   |" : "    ";
		}
		System.out.println(northWalls);
		System.out.println(eastWestWalls);
		System.out.println(southWalls);
		for(int row = 1; row < rowCount; row++)
		{
			eastWestWalls = "|";
			southWalls = "+";
			for( int col = 0; col < colCount; col++)
			{
				MazeCell currentCell = cells[row][col];
				southWalls += currentCell.hasWall(Path.SOUTH) ? "———+" : "   +";
				eastWestWalls += currentCell.hasWall(Path.EAST) ? "   |" :  "    ";
			}
			System.out.println(eastWestWalls);
			System.out.println(southWalls);
		}
		
	}
	

	
	// Static Methods
	
	// Instance Fields
	private MazeCell[][] cells;
	final public MazeCell mazeStart;
	final public MazeCell mazeEnd;
	public final int rowCount;
	public final int colCount;
	public final int cellCount;
	
	// Static Fields
	
	// Inner classes
	/**
	 * enum type lists the cardinal directions, each associated with a unique
	 * power of 2, allowing the path status to be determined by a 4-bit value
	 * as follows:
	 * 		Bit 0 => status of NORTH path from MazeCell
	 * 		Bit 1 => status of EAST path from MazeCell
	 * 		Bit 2 => status of SOUTH path from MazeCell
	 * 		Bit 3 => status of WEST path from MazeCell
	 * 
	 * 		total value 0 => all paths closed (all walls in place)
	 * 		total value 15 => all paths open (no walls remain)
	 * 		any value < 15 => at least one wall remains
	 * 		total value	5 =>  SOUTH and NORTH paths open
	 * 		etc...
	 * @author Iain
	 */
	private enum Path
	{
		NORTH(1), EAST(2), SOUTH(4), WEST(8);
		private short value;
		private Path(int newValue)
		{
			this.value = (short) newValue;
		}
		
		private Path getOpposite()
		{
			switch(this)
			{
			case NORTH:
				return Path.SOUTH;
			case EAST:
				return Path.WEST;
			case SOUTH:
				return Path.NORTH;
			case WEST:
				return Path.EAST;
			default:
				return null;	
			}
		}
	}
	
	protected class MazeCell
	{
		// Constructor
		protected MazeCell(int newRow, int newCol, Maze parentMaze)
		{
			row = newRow;
			col = newCol;
			maze = parentMaze;

			pathState = 0;

		}
		
		// Instance Methods
		private boolean hasAllWalls()
		{
			return (pathState & 15) == 0;
		}
		
		private boolean hasWall(Path target)
		{
			return (pathState & target.value) == 0;
		}
		
		private boolean hasNeighbor(Path target)
		{
			return (pathState & (target.value << 4)) != 0;
		}
		
		private MazeCell getNeighbor(Path target)
		{
			if(hasNeighbor(target)) 
			{
				switch(target)
				{
				case NORTH:
					return maze.cells[row - 1][col];
				case EAST:
					return maze.cells[row][col + 1];
				case SOUTH:
					return maze.cells[row + 1][col];
				case WEST:
					return maze.cells[row][col - 1];
				}
			}
			return null;
		}
		
		private short pathConnect(MazeCell that, Path direction)
		{
			this.pathState |= direction.value;
			that.pathState |= direction.getOpposite().value;
			
			return this.pathState;
		}
		
		private short pathConnect(Path direction)
		{
			this.pathState |= direction.value;
			
			return this.pathState;
		}
		
		// Static Methods
		
		// Instance Fields
		final int row;
		final int col;
		final Maze maze;
		
		short pathState; 	// the lower 4 bits of pathState indicate which
							// paths to adjacent cells are open
							// the upper 4 bits of pathState indicate whether
							// adjacent cells exist
		
		// Static Fields
		
		// Inner classes
	}
	
}
