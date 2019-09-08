package com.Junifer.mazes;

/**
* - Service to provide the functionality to solve simple mazes. The mazes are given in 
*   a file and the program is going to read in the file, solve the maze and output the solution. 
*   If no solution is possible the output it will be  indicated.
*   
* - It use the interface mazeJunifer to execute three process to solved a maze.
*    + Load the data of a file.txt that content the maze and the (x,y) location of the start and end.
*    + Solve the maze and return the solution.
*    + Formatted the result to show in the console.
*    + Show the maze in console.
* 
*/
public class MazeApp {
	
   private static MazeJunifer mazeJunifer = new MazeJuniferImpl();
   public String[][] maze;
	
   public  void appSolvingMaze(String file){
	
	// Load the data of a file.txt that content the maze and the (x,y) location of the start and end ...
        maze = mazeJunifer.loadDataFile(file); 
		
	// Solve the maze and return the solution ... 
	maze = mazeJunifer.solvemazes(maze); 
		
	// Formatted the result to show in the console...
	maze = mazeJunifer.formatOUT(maze);
		
	// Show the maze in console...
	mazeJunifer.showMaze(maze);	
   }
}
