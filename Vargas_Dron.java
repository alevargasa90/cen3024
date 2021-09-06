import java.util.Scanner;

//Author Name: Alejandro Vargas
//Date: 8/29/2021
//Program Name: Vargas_Drone
//Purpose: Simulation using button, drone movement in x, y,z location

public class Vargas_Dron {
	
	public static class Drone {
		
		
		// y_pos is the position on the north south direction
		// x_pos is the position on the east and west direction
		// z_pos is the hight
		private int x_pos;
		private int y_pos;
		private int z_pos;
		private String move = "You have moved ";
		private int orientation;
		
		public Drone() {
			orientation = 0;
			x_pos=0;
			y_pos=0;
			z_pos=0;
		}
		
		public Drone(int x_pos,int y_pos,int z_pos) {
			orientation = 0;
			this.x_pos=x_pos;
			this.y_pos=y_pos;
			this.z_pos=z_pos;
		}
		
		public int getX_pos() {
			return x_pos;
		}

		public void setX_pos(int x_pos) {
			this.x_pos = x_pos;
		}

		public int getY_pos() {
			return y_pos;
		}

		public void setY_pos(int y_pos) {
			this.y_pos = y_pos;
		}

		public int getZ_pos() {
			return z_pos;
		}

		public void setZ_pos(int z_pos) {
			this.z_pos = z_pos;
		}

		public void moveUp() {
			z_pos++;
			System.out.println(move + "upward");
		}
		
		public void moveDown() {
			z_pos--;
			System.out.println(move + "downward");
		}
		
		public void moveForward() {
			if (orientation == 0) {
				//moving north
				y_pos++;
				System.out.println(move + "forward");
			}
			if (orientation == 1) {
				x_pos++;
				System.out.println(move + "forward");
				
			}
			if (orientation == 2) {
				y_pos--;
				System.out.println(move + "forward");
				
			}
			else if (orientation == 3) {
				x_pos--;
				System.out.println(move + "forward");
				
			}
		}
		
		public void moveBackward() {
			if (orientation == 0) {
				//moving north
				y_pos--;
				System.out.println(move + "backward");
			}
			if (orientation == 1) {
				x_pos--;
				System.out.println(move + "backward");
				
			}
			if (orientation == 2) {
				y_pos++;
				System.out.println(move + "backward");
				
			}
			else if (orientation == 3) {
				x_pos++;
				System.out.println(move + "backward");
				
			}
		}
		
		// changing the orientation 90 degrees to the right
		public void turnRight() {
			orientation = (orientation +1) % 4;
			System.out.println("You have turned right");
		}
		//changing the orientation 90 degrees to the left
		public void turnLeft() {
			orientation--;
			System.out.println("You have turned left");
			
			if (orientation < 0) {
				orientation = 3;
			}
		}
		// using the value of the orientation to return its name
		public String orientationName(){
			if (orientation == 0 )
				return "north";
			if (orientation == 1 )
				return "east";
			if (orientation == 2 )
				return "south";
			if (orientation == 3 )
				return "west";
			else 
				return "lost";			
			
		}
		
		public String toString() {
			return "Vargas_Drone [x_pos="+getX_pos()+", y_pos="+getY_pos()+", z_pos="+getZ_pos() +", orientation="+ orientationName()+"]";
		} 		
	}


	public static void main(String[] args) {
		
		int option;
		
		// creating a drone
		Drone dron1 = new Drone();
		
		Scanner sc = new Scanner(System.in);
		
		Boolean a = true;
		while(a==true) {
			System.out.println("1 - Move up\n2 - Move Down\n3 - Move Forward\n4 - Move Backward\n5 - Turn Left\n6 - Turn Right"
					+ "	\n7 - Turn Display Navegation\n8 - Exit Navegation");
			//read input
			
			option = sc.nextInt();
			
			switch(option) {
			
			case 1:
				dron1.moveUp();
				break;
			case 2:
				dron1.moveDown();
				break;
			case 3:
				dron1.moveForward();
				break;
			case 4:
				dron1.moveBackward();
				break;
			case 5:
				dron1.turnLeft();
				break;
			case 6:
				dron1.turnRight();
				break;
			case 7:
				System.out.println(dron1.toString());
				break;
			case 8:
				System.out.println("Exiting Navegation. Bye!");
				a=false;
				break;
			default:
				System.out.println("Invalid input");
			}
			
		}
		sc.close();
				
	}

}
