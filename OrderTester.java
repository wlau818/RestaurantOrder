import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OrderTester {

	public static void main (String[] args) {
		Scanner scnr = new Scanner(System.in);
		Queue<Order> line = new LinkedList<Order>();
		System.out.print("Food: ");
		String eat = scnr.next();
		System.out.print("Prep time: ");
		int t = scnr.nextInt();
		Order f = new Order(eat, t);
		line.add(f);
		System.out.println("");
		int time = 0;
		while(line.size() > 0) {
			System.out.println("Number of orders in queue: " + line.size());
			System.out.println("Current order being prepared: " + line.element().getFood());
			System.out.println("");
			System.out.print("Any new orders? yes or no ");
			String choice = scnr.next();
			String food = null;
			int min = 0;
			if (choice.equals("yes")) {
				System.out.print("Food: ");
				food = scnr.next();
				System.out.print("Prep time: ");
				min = scnr.nextInt();
				Order next = new Order(food, min);
				line.add(next);
			}			
			if (line.element().getTime() == time) {
				System.out.println("");
				System.out.println("Order done: " + line.element().getFood());
				System.out.println("");
				line.remove();
				time = 0;
			} else {
				System.out.println("");
				System.out.println("Wait time left for first order: " + (line.element().getTime() - time) + " min");
			}
			System.out.println("");
			time ++;
		}
		System.out.println("No more orders.");
	}
}
