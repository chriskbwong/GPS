import java.util.Scanner;
import java.util.ArrayList;

public class GPS {
	public static final double INITIAL_X = 0;
	public static final double INITIAL_Y = 0;
	public static final int INITIAL_TIME = 0;

	public class WayPoint {
		private double x;
		private double y;
		private int time;

		public WayPoint(double x, double y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		public double getX() {
			return x;
		}
		public double getY(){
			return y;
		}
		public int getTime(){
			return time;
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		ArrayList<WayPoint> list = new ArrayList<WayPoint>();
		boolean gameOn = true;
		/*
		 * all goes in loop Prompt user to read in x, y, time new WayPoint (x,
		 * y, time); put on ArrayList
		 */
		while(gameOn) {

			System.out.println("Enter your x coordinate");
			double xPoint = kb.nextDouble();
			if (xPoint < 0) {
				gameOn = false;
				break;
			}
			System.out.println("Enter your y coordinate");
			double yPoint = kb.nextDouble();
			System.out.println("Enter the time you are logging this entry");
			int timePoint = kb.nextInt();

			GPS location = new GPS();
			WayPoint way = location.new WayPoint(xPoint, yPoint, timePoint);
			list.add(way);

			System.out.println("Onto the next set");
		}

		// second loop
		double positionX = 0;
		double positionY = 0;
		int timeDifference = 0;
		double totalDistance = 0;
		int totalTime = 0;
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
			double differenceX = list.get(i).getX() - positionX;
			positionX = list.get(i).getX();
			double differenceY = list.get(i).getY() - positionY;
			positionY = list.get(i).getY();
			int differenceTime = list.get(i).getTime() - timeDifference;
			timeDifference = list.get(i).getTime();
			double distance = 0;
			distance = Math.sqrt((differenceX * differenceX) + (differenceY * differenceY));
			totalDistance = totalDistance + distance;
			totalTime = totalTime + differenceTime;
			// c = Math.sqrt((a*a) + (b*b));
		}
		double speed = totalDistance/totalTime;
		
		System.out.println("You have traveled " + totalDistance + " miles in " + totalTime + " hours. Which gives you a speed of " + speed + " mph.");
		

	}
}