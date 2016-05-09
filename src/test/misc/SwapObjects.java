package test.misc;

public class SwapObjects {
	static class Car {
		int model, no;

		// Constructor
		// public Car(int model, int no) {
		// this.model = model;
		// this.no = no;
		// }

		public static Car getCar(int model, int no) {
			Car car = new Car();
			car.model = model;
			car.no = no;
			return car;
		}

		// Utility method to print object details
		void print() {
			System.out.println("no = " + no + ", model = " + model);
		}
	}

	// A Wrapper over class that is used for swapping
	static class CarWrapper {
		Car c;

		// Constructor
		// CarWrapper(Car c) {
		// this.c = c;
		// }
	}

	// Driver method
	public static void main(String[] args) {
		Car c1 = Car.getCar(101, 1);
		Car c2 = Car.getCar(202, 2);
		CarWrapper cw1 = new CarWrapper();
		cw1.c = c1;
		CarWrapper cw2 = new CarWrapper();
		cw2.c = c2;
		swap(cw1, cw2);
		cw1.c.print();
		cw2.c.print();
		System.out.println(c1.model);
	}

	public static void swap(CarWrapper cw1, CarWrapper cw2) {
		Car temp = cw1.c;
		cw1.c = cw2.c;
		cw2.c = temp;
	}

}
