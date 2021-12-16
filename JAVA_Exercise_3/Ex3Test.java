import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Ex3Test {

	@Test
	void testMoveCharToLast() {
		String in = "hello world, let's go!";
		String out = "heo word, et's go!llll";
		assertTrue(out.equals(Ex3.moveCharToLast(in,'l')));
		in = "&hi&hi&";
		out = "hihi&&&";
		assertTrue(out.equals(Ex3.moveCharToLast(in,'&')));
	}
	
	@Test
	void testReduce() {
		String in = "aaabbccccxxxyzz";
		String out = "abcxyz";
		assertTrue(out.equals(Ex3.reduce(in)));
		in = "abcda";
		out = in;
		assertTrue(out.equals(Ex3.reduce(in)));
	}
	
	@Test
	void testMySplit() {
		assertEquals(Ex3.mySplit(new int[] {1,1}),true);
		assertEquals(Ex3.mySplit(new int[] {1,1,1}),false);
		assertEquals(Ex3.mySplit(new int[] {2,4,2}),true);
		assertEquals(Ex3.mySplit(new int[] {5,21,8,15,7}),true);
		assertEquals(Ex3.mySplit(new int[] {15,10,5}),false);
		assertEquals(Ex3.mySplit(new int[] {15,8,7}),true);
	}
	
	@Test
	void testSumOfNeighbours() {
		int[][] mat1 = {{3,5,7,5},{-4,2,10,11},{9,-50,3,60}};
		int[][] matOut1 = {{3,18,33,28},{-31,-17,43,85},{-52,20,33,24}};
		mat1 = Ex3.sumOfNeighbours(mat1);
		for(int i=0; i < mat1.length ;++i)
			assertTrue(Arrays.equals(mat1[i], matOut1[i]));
		
		int[][] mat2 = {{1,-2},{4,1}};
		int[][] matOut2 = {{3,6},{0,3}};
		mat2 = Ex3.sumOfNeighbours(mat2);
		for(int i=0; i < mat2.length ;++i)
			assertTrue(Arrays.equals(mat2[i], matOut2[i]));	
	}
	
	@Test
	void testCaesarCipherText() {
		String in = "abcdefghijklmnopqrstuvwxyz ";
		String out = "efghijklmnopqrstuvwxyzabcd ";
		assertTrue(out.equals(Ex3.caesarCipherText(in, 4)));
		assertTrue(in.equals(Ex3.caesarCipherText(Ex3.caesarCipherText(in, 4),-4)));
	}
	
	@Test
	void testVigenereCipherText() {
		String in = "a simple example";
		String out = "a zqqkpq rqaowti";
		assertTrue(out.equals(Ex3.vigenereCipherText(in, "achievement")));
		in = "impressive student from ariel university";
		out = "pacfvzgvjv ggiulbg wycz rywrz bbvjvygvhp";
		assertTrue(out.equals(Ex3.vigenereCipherText(in, "honor")));
		in = "test";
		out = "test";
		assertTrue(out.equals(Ex3.vigenereCipherText(in, "a")));
	}
	
	@Test
	void testVigenereDecipherText() {
		String in = "a simple example";
		String key = "achievement";
		assertTrue(in.equals(Ex3.vigenereDecipherText(Ex3.vigenereCipherText(in,key),key)));		
	}

}
