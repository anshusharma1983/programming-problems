package test.array;

public class BitWise {
	enum RRV_CALL {
		SSA, IRS, MED, EQUI, VLP, DOR
	};

	public static void main(String[] args) {
		// RRV_CALL rrvCall;
		System.out.print("VALUE,");
		for (RRV_CALL rrvCall : RRV_CALL.values()) {
			System.out.print(rrvCall.name() + ",");
		}
		System.out.println();

		for (int i = 0; i < 64; i++) {
			System.out.print(i + ",");
			for (RRV_CALL rrvCall : RRV_CALL.values()) {
				int rrv =(int) Math.pow(2, rrvCall.ordinal());
				System.out.print(((rrv & i) > 0 ? "1," : "0,"));
			}
			System.out.println();
		}
	}
}
