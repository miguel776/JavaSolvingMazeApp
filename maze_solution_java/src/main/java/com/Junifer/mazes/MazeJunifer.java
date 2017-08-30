package com.Junifer.mazes;


/** 
 *  - This interface is implemented  by the "OfferImpl" class and provide the functionalities of  Load the file.txt, Solve a maze 
 *    and Formatted the result to show in the console.
 * 
 * 
 */


public interface MazeJunifer {
	
	
	/**
     *  Load the file.txt
     *
     * @param String file - Location of the file containing the input data.
     * @return A matrix "maze" that content the maze without solving.
     */
	public  String[][] loadDataFile(String file);
	
	/**
     * Solve the maze
     *
     * @param  A matrix "maze" that content the maze without solving.
     * @return A matrix "maze" that content the maze solves.
     */
	public  String[][] solvemazes(String[][] maze);
		
	/**
     * Formatted the result to show in the console.
     *
     * @param  A matrix "maze" that content the maze solves.
     * @return A matrix "maze" that content the maze format.
     */
	public  String[][] formatOUT(String[][] maze);
	
	/**
     * It show the result in the console.
     *
     * @param A matrix "mazeFormats" that content the maze solves and Formatted. 
     */
	public  void showMaze(String[][] maze);

}
