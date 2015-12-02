/**
 * Data Structures
 * Assignment #2: Stacking Shipping Containers
 * Ryan Blais
 * 09/28/15
 * 
 * This program is a simulation that will verify the schedule of the loading
 * and unloading of a ship. The schedule of the ship lists the number of piles
 * and the height limit of each pile for the ship. All piles on a ship will
 * have the same height limit. After the amount of piles and the height limit
 * have been inputed, each action specifies the unique container id, the
 * unique pile id, and lastly the action for either load or unload. Once
 * the input is complete the program will verify the correctness of the
 * shipping schedule through the simulation of the loading and unloading 
 * actions. The program will state the correctness of the schedule and the
 * contents of the file. If the schedule is incorrect or a load/unload is
 * not possible, the program should correct the schedule if possible and
 * print the corrected schedule.
 */

package assignment02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws IOException {
		Scanner command = new Scanner(System.in);
		
		String input;
		String record = "";
		
		int piles = command.nextInt();
		int height = command.nextInt();
		
		// Set up record for correction text file
		record += piles + " " + height +"\r\n";
		
		boolean feasible = true;
		
		StackCollection stacks = new StackCollection(piles + 1);
		
		// Construct all stacks
		for (int i = 0; i <= piles; i++) {
			Stack stack = new Stack(height);
			stacks.setStack(i, stack);
		}
		
		Stack dock = stacks.getStack(0);
		input = command.nextLine();
		
		while ((input = readLine(command)).length() != 0) {
			String[] split = input.split(" ");
			if (split.length != 3) {
				System.out.println("Enter a command in the format {containerID} {pileID} {action:L/U}.");
				continue;
			}
			int containerId = Integer.parseInt(split[0]);
			int pileId = Integer.parseInt(split[1]);
			
			if (pileId > piles || pileId <= 0) {
				System.out.println("Pile does not exist. Ignoring.");
				continue;
			}
			if (split[2].equalsIgnoreCase("L")) {
				Stack stack = stacks.getStack(pileId);
				
				if (!stack.isFull()) {
					stack.push(containerId);
					record += input +"\r\n";
					
				// The pile is full
				} else {
					feasible = false;
					
					boolean found = false;
					int i = 1;
					
					// Search for another pile
					for (; i <= piles; i++) {
						if (!stacks.getStack(i).isFull()) {
							stacks.getStack(i).push(containerId);
							record += containerId + " " + i + " L" + "\r\n";
							found = true;
							System.out.println("Pile " + pileId + " is full. Container "
									+ "" + containerId + " is placed into pile " + 
									(i) + ".");
							break;
						}
					}
					
					// All piles are full
					if (!found) {
						System.out.println("The program has been terminated "
								+ "because all the stacks are full.");
						command.close();
						return;
					}
					
				}
			}
			else if (input.split(" ")[2].equalsIgnoreCase("U")) {
				Stack stack = stacks.getStack(pileId);
				
				// The requested container is not on top
				if (stack.isEmpty() || stack.peek() != containerId) {
					feasible = false;
					
					if (!stack.find(containerId)) {
						System.out.println("The container " + containerId + 
								" does not exist in stack " + pileId);
						continue;
					}
					
					System.out.println("The container " + containerId + 
							" is buried; unloading top containers first.");
					while (stack.peek() != containerId) {
						record += stack.peek() + " " + pileId + " U" + "\r\n";
						dock.push(stack.pop());
					}
					
					record += stack.pop() + " " + pileId + " U" + "\r\n";
					
					while (!dock.isEmpty()) {
						record += dock.peek() + " " + pileId + " L" + "\r\n";
						stack.push(dock.pop());
					}
				}
				else if (!stack.isEmpty()) {
					record += stack.pop() + " " + pileId + " U" + "\r\n";
				} else {
					System.out.println("The pile is empty. Unload from a "
							+ "nonempty pile.");
				}

			// "L" or "U" were not entered
			} else {
				feasible = false;
				System.out.println("Enter a \"L\" for load or a \"U\" for "
						+ "unload.");
			}
			
		}
		command.close();
		
		if (feasible) {
			System.out.println("Schedule is feasible");
			
		} else {
			System.out.println("Schedule is not feasible. Writing revised schedule to RevisedSchedule.txt.");
			
			File file = new File("RevisedSchedule.txt");
			if (file.exists()) file.delete();
			PrintWriter output = new PrintWriter(new FileWriter(file));
			
			output.println(record);
			
			output.close();
		}
		
		System.out.println("Final contents of piles");
		System.out.println("Pile # Container Id");
		for (int i = 1; i <= piles; i++) {
			System.out.println(i + "      " + stacks.getStack(i));
		}
	}
	
	static String readLine(Scanner command) {
		if (command.hasNextLine()) {
			return command.nextLine();
		}
		else if (command.hasNext()) {
			return command.next("*");	
		} else {
			return "";
		}	
	}
}
