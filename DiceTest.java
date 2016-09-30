package terning;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {

	Dice cup;
	@Before
	public void setUp() throws Exception {
		cup = new Dice();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRollEquality() {
		int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0, r6 = 0;
		for (int i = 0; i < 60000; i++) {
			switch(cup.roll()){
			case 1:
				r1++;
				break;
			case 2:
				r2++;
				break;
			case 3:
				r3++;
				break;
			case 4:
				r4++;
				break;
			case 5:
				r5++;
				break;
			case 6:
				r6++;
				break;
			}
		}
		int expected = 1;
		int actual = 0;
		if (r1<10400 && r1>9600){
			if (r2<10400 && r2>9600){
				if (r3<10400 && r3>9600){
					if (r4<10400 && r4>9600){
						if (r5<10400 && r5>9600){
							if (r6<10400 && r6>9600){
								actual = 1;
							}
						}
					}
				}
			}
		}
		assertEquals(expected, actual);
		
		/*
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		System.out.println(r5);
		System.out.println(r6);
		*/
		
	}

	@Test
	public void testRollOutOfScope() {
		int expected = 1;
		int actual = 1;
		for (int i = 0; i<60000; i++){
			int a = cup.roll();
			if (a<1||a>6){
				actual = 0;
			}
		}
		assertEquals(expected, actual);
	}
	

}
