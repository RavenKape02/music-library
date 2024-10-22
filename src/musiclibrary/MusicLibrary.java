/*John Raven F. Caduyac
 * Chapter 02: Java Basics II Array and String Methods
 * Exercise 02: Music Library
 * */

package musiclibrary;

import java.util.Scanner;

public class MusicLibrary {
	
	//function to add a song to the array
	public static String[][] addSong(String song[][], int array_length, String[] songToAdd) {
		//since the array in java is not dynamic, i need to make this function so it continuously makes a new array when the user wants to add a song
		String newSongs[][] = new String[array_length + 1][2];
		for(int i = 0; i<array_length; i++) {
			newSongs[i] = song[i];
		}
		newSongs[array_length] = songToAdd;
		return newSongs;
	}
	
	//main function
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//declaring variables
		String songs[][] = {};
		Scanner sc = new Scanner(System.in);
		int option;
		
		//Simple CLI Menu
		System.out.println("Welcome to the Music Library!");
		while(true) {
			System.out.println("=======  :: MAIN MENU ::  =======\n"+
							   "[0] Exit\n"+
							   "[1] View Library\n"+
							   "[2] View Artist's Songs\n"+
							   "[3] Add Song\n"+
							   "[4] Update Song");
			System.out.print("Select an option: ");
			try {
				//use the extra sc.nextline() to eliminate the new line character from input
				option = sc.nextInt();
				sc.nextLine();
			}
			catch(Exception e) {
				//catching the error of NOT inputting a number
				System.out.println("Invalid Input. Please enter a number");
				sc.nextLine();
				continue;
			}
			if(option == 0) {
				System.out.println("Goodbye!");
				break;
			}
			else if(option == 1){
				//code for viewing library
				System.out.println("=======  :: VIEWING LIBRARY ::  =======");
				//this try catch statement is for checking if there are songs existing in the array
				try {
					if(songs[0]!=null) {
						System.out.println("Song Title                           	|| Artist ");
						for(int i = 0; i < songs.length; i++) {
							//just used this formatting of the songs so it looks neat
							System.out.printf("%-40s-- %-35s%n", songs[i][0], songs[i][1]);
						}
					}	
				}
				catch(Exception e) {
					System.out.println("No songs saved");
				}
			}
			//views all the songs given the artist
			else if(option == 2) {
				try {
					if(songs[0]!= null) {
						System.out.println("Enter the artist:");
						String viewartist = sc.nextLine();
						boolean artistExist = false;
						for(int j = 0; j<songs.length; j++) {
							if((viewartist.equalsIgnoreCase(songs[j][1]))) {
								System.out.printf("%-40s-- %-35s%n", songs[j][0], songs[j][1]);
								artistExist = true;
							}
						}
						if(artistExist == false) {
							System.out.println("No songs from specified artist saved.");
						}
					}
				}
				catch(Exception e){
					System.out.println("No songs saved");
				}
			}
			//code for adding song, using the function for adding song
			else if(option == 3) {
				System.out.println("=======  :: ADDING SONG ::  =======");
				System.out.println("Enter the title of the song: ");
				String songtitle = sc.nextLine();
				System.out.println("Enter the artist of the song: ");
				String artistname = sc.nextLine();
				String songtoadd[] = {songtitle, artistname};
				
				songs = addSong(songs, songs.length, songtoadd);			
			}
			// code for updating a song
			else if(option == 4) {
				try {
					if(songs[0]!= null) {
						//prints every songs first
						System.out.println("=======  :: UPDATING SONG ::  =======");
						for(int i = 0; i < songs.length; i++) {
							System.out.printf("%-40s-- %-35s%n", songs[i][0], songs[i][1]);
						}
						System.out.println("Enter the title of the song you wish to update:");
						String editsong = sc.nextLine();
						boolean songExist = false;
						
						//now checks through the 2d array if the song exists
						for(int j = 0; j<songs.length; j++) {
							if((editsong.equalsIgnoreCase(songs[j][0]))) {
								System.out.println("Enter updated title (Enter '---' if you wish to keep the existing title):");
								String updatedTitle = sc.nextLine();
								System.out.println("Enter updated artist (Enter '---' if you wish to keep the existing title):");
								String updatedArtist = sc.nextLine();
								
								if(!updatedTitle.equalsIgnoreCase("---")) {
									songs[j][0] = updatedTitle;
								}
								
								if(!updatedArtist.equalsIgnoreCase("---")) {
									songs[j][1] = updatedArtist;
								}
								songExist = true;
							}
						}
						if(songExist == false) {
							System.out.println("No song found");
						}
					}
				}
				catch(Exception e){
					System.out.println("No songs saved");
				}
				
			}
			else {
				System.out.println("Invalid Input");
			}
		}
		sc.close();
	}
}

