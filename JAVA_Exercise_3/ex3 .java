package Yarin;

import java.util.Arrays;

public class ex3 {

	//1
	public static String moveCharToLast(String str, char ch) {
		if(str.length()<2) {
			return str;
		}
		if(str.charAt(0) == ch) {
			return moveCharToLast(str.substring(1),ch) + str.charAt(0);
		}	
		else {
			return str.charAt(0) + moveCharToLast(str.substring(1),ch);

		}
	}

	//2
	public static String reduce(String str) {
		if(str.length()<2) {
			return str;
		}
		if(str.charAt(0) == str.charAt(1)) {
			return reduce(str.substring(1));
		}
		else {
			return str.charAt(0) + reduce(str.substring(1));
		}
	}


	//3
	public static boolean mySplit(int[] nums) {
		int groupA[] = new int[nums.length];  //5
		int groupB[] = new int[nums.length];  //3
		int groupC[] = new int[nums.length];  //others
		int a = 0;
		int b = 0;
		int c = 0;
		for(int i=0 ; i<nums.length ; i++) {
			if(nums[i]%5 == 0) {
				groupA[a] = nums[i];
				a++;
			}
			else {
				if(nums[i]%3 == 0) {
					groupB[b] = nums[i];
					b++;
				}
				else {
					groupC[c] = nums[i];
					c++;
				}
			}
		}
		int arrA[] = fixArr(groupA,a);
		int arrB[] = fixArr(groupB,b);
		int arrC[] = fixArr(groupC,c);
		return MySplit(arrA,arrB,arrC);
	}

	public static boolean MySplit(int arrA[], int arrB[], int arrC[]) {
		if(arrC.length<1) {
			return sum(arrA) == sum(arrB);
		}
		int num = arrC[arrC.length-1];
		int newC[] = fixArr(arrC,arrC.length-1);
		int newA[] = add(arrA,num);
		int newB[] = add(arrB,num);
		return MySplit(newA,arrB,newC) || MySplit(arrA,newB,newC);
	}

	public static int[] fixArr(int[] arr, int len) {
		int ans[] = new int[len];
		for(int i=0 ; i<len ; i++) {
			ans[i] = arr[i];
		}
		return ans;
	}

	public static int sum(int arr[]) {
		int sum = 0;
		for(int i=0 ; i<arr.length ; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static int[] add(int arr[], int x) {
		int ans[] = new int[arr.length+1];
		for(int i=0 ; i<arr.length ; i++) {
			ans[i] = arr[i];
		}
		ans[arr.length] = x;
		return ans;
	}

	//4
	public static int[][] sumOfNeighbours(int[][] mat){
		int sumOfNi[][] = new int[mat.length][mat[0].length];
		for(int i=0 ; i<mat.length ; i++) {
			for(int j=0 ; j<mat[i].length ; j++) {
				sumOfNi[i][j] = sumOfNei(mat,i,j);
			}
		}
		return sumOfNi;
	}

	public static int sumOfNei(int matrix[][], int x, int y) {
		int sum = 0;
		for(int i=Math.max(0, x-1) ; i<=Math.min(matrix.length-1, x+1) ; i++) {
			for(int j=Math.max(0, y-1) ; j<=Math.min(matrix[i].length-1, y+1) ; j++) {
				sum += matrix[i][j];
			}
		}
		return sum - matrix[x][y];
	}


	//5
	public static String caesarCipherText(String str, int key) {
		String s = "";
		for(int i=0 ; i<str.length() ; i++) {
			char c = str.charAt(i);
			if(c != ' ') {
				s += caesarCipherText(c,key);
			}
			else {
				s+=c;
			}
		}
		return s;
	}
	public static char caesarCipherText(char c, int key) {
		char a = (char)(c+key);
		if(a>'z') {
			a = (char)(a-26);
		}
		else if(a<'a') {
			a = (char)(a+26);
		}
		return a;
	}

	//6a
	public static String vigenereCipherText(String str, String key) {
		String code = "";
		int keyLen = key.length();
		int j=0;
		for(int i=0 ; i<str.length() ; i++) {
			if(j>=keyLen) {
				j=0;
			}
			int k = charToKey(key.charAt(j++));
			char c = str.charAt(i);
			if(c == ' ') {
				code += c;
			}
			else {
				code += caesarCipherText(c,k);
			}
		}
		return code;
	}


	public static int charToKey(char c) {
		return c-97;
	}

	//6b
	public static String vigenereDecipherText(String str, String key) {
		String code = "";
		int keyLen = key.length();
		int j=0;
		for(int i=0 ; i<str.length() ; i++) {
			if(j>=keyLen) {
				j=0;
			}
			int k = charToKey(key.charAt(j++));
			char c = str.charAt(i);
			if(c == ' ') {
				code += c;
			}
			else {
				code += caesarCipherText(c,-1*k);
			}
		}
		return code;
	}

	public static void main(String[] args) {
		String s = moveCharToLast("hello",'e');
		System.out.println(s);
		System.out.println(reduce("aaabbaabb"));
		System.out.println(caesarCipherText("yarin itai",4));
		int arr[] = {21,7,5,15,7};
		System.out.println(mySplit(arr));
		int mat[][] = {{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		for(int i=0 ; i<mat.length ; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		System.out.println();
		int matrix[][] = sumOfNeighbours(mat);
		for(int i=0 ; i<matrix.length ; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		String r = vigenereCipherText("impressive student from ariel university", "honor");
		System.out.println(r);
		String r2 = vigenereDecipherText("pacfvzgvjv ggiulbg wycz rywrz bbvjvygvhp", "honor");
		System.out.println(r2);


	}

}
