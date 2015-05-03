package com.hungry.others;

public class Random {
	private static final int A = 48271;
	private static final int M = 2147483647;
	private static final int Q = M / A;
	private static final int R = M % A;

	private int state;

	public Random() {
		state = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}

	public int randomInt() {
		int tmpState = A * (state % Q) - R * (state / Q);
		if (tmpState >= 0) {
			state = tmpState;
		} else {
			state = tmpState + M;
		}

		return state;
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		System.out.println(r.randomInt());
	}

}
