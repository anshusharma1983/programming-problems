package test.misc;
public class JavaType {
	public static void main(String[] args) {
		String arguments = "1,1.0,xyz,true,false,1010101010101";
		String[] arr = arguments.split(",");
		for (String str : arr) {
			try {
				Integer.valueOf(str);
				System.out.println(str + " is of type Integer");
				continue;
			} catch (Exception e) {
			}

			try {
				Float.valueOf(str);
				System.out.println(str + " is of type Float");
				continue;
			} catch (Exception e) {
			}

			try {
				if ("true".equals(str) || "false".equals(str)) {
					System.out.println(str + " is of type Boolean");
					continue;
				}
			} catch (Exception e) {
			}

			System.out.println(str + " is of type String");

		}

		Float l = new Float("1010101010101");
		System.out.println(l);
	}
}
