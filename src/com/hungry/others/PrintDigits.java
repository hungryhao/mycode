package com.hungry.others;

public class PrintDigits {
	
	public void print1ToMaxNDigits(int n) {
		if(n<=0) {
			return;
		}
		
		String[] number = new String[n];
		
		for(int i=0; i<10; i++) {
			number[0] =  i + "";
			print1ToMaxNDigitsRecursively(number, n, 0);
		}
	}
	
	private void print1ToMaxNDigitsRecursively(String[] number, int len, int index) {
		if(index==len-1) {
			printNumber(number);
			return;
		}
		
		for(int i=0; i<10; ++i) {
			number[index+1] = i + "";
			print1ToMaxNDigitsRecursively(number, len, index+1);
		}
	}
	
	private void printNumber(String[] number) {
		boolean isBeginning0 = true;
		int len = number.length;
		for(int i=0; i<len; ++i) {
			if(isBeginning0 && !number[i].equals("0")) {
				isBeginning0 = false;
			}
			
			if(!isBeginning0) {
				System.out.print(number[i]);
			}
		}
		System.out.print("\t");
	}
	
	public static void main(String[] args) {
		PrintDigits pd = new PrintDigits();
		int n = 1;
		pd.print1ToMaxNDigits(n);
		//System.out.println();
	}

}
