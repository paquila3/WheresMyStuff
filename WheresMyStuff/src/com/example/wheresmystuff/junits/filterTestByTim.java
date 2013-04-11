package com.example.wheresmystuff.junits;

import java.util.Date;

import org.junit.Test;

import com.example.wheresmystuff.model.FoundItem;
import com.example.wheresmystuff.model.LostItem;
import com.example.wheresmystuff.presenter.WheresMyStuff;

import android.test.AndroidTestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class filterTestByTim.
 */
public class filterTestByTim  extends AndroidTestCase {

	LostItem lostItem1, lostItem2;
	FoundItem foundItem1, foundItem2;
	@Override
	public void setUp() {
		lostItem1 = new LostItem("LostItem1", "Lost Item", 0, "", 0, "", "", "", 0, 0);
		lostItem2 = new LostItem("LostItem2", "Lost Item", 0, "", 0, "", "", "", 0, 0);
		foundItem1 = new FoundItem("FoundItem1", "Found Item", 0, "", 0, 0, 0);
		foundItem2 = new FoundItem("FoundItem2", "Found Item", 0, "", 0, 0, 0);
	}
	
	/**
	 * Lost found1.
	 */
	@Test
	public void testCase1() throws Throwable{
		assertTrue(WheresMyStuff.filter(foundItem1, new boolean[] {true,true,true,true}, 3, (new Date(0,0,0)).getTime(), false));
		assertTrue(WheresMyStuff.filter(foundItem2, new boolean[] {true,true,true,true}, 3, (new Date(0,0,0)).getTime(), false));
		assertTrue(WheresMyStuff.filter(lostItem1, new boolean[] {true,true,true,true}, 3, (new Date(0,0,0)).getTime(), false));
		assertTrue(WheresMyStuff.filter(lostItem2, new boolean[] {true,true,true,true}, 3, (new Date(0,0,0)).getTime(), false));
	}
	@Test
	public void testCase2() throws Throwable{
		assertTrue(WheresMyStuff.filter(foundItem1, new boolean[] {true,true,true,true}, 2, (new Date(0,0,0)).getTime(), false));
		assertTrue(WheresMyStuff.filter(foundItem2, new boolean[] {true,true,true,true}, 2, (new Date(0,0,0)).getTime(), false));
		assertFalse(WheresMyStuff.filter(lostItem1, new boolean[] {true,true,true,true}, 2, (new Date(0,0,0)).getTime(), false));
		assertFalse(WheresMyStuff.filter(lostItem2, new boolean[] {true,true,true,true}, 2, (new Date(0,0,0)).getTime(), false));
	}
	@Test
	public void testCase3() throws Throwable{
		assertFalse(WheresMyStuff.filter(foundItem1, new boolean[] {true,true,true,true}, 1, (new Date(0,0,0)).getTime(), false));
		assertFalse(WheresMyStuff.filter(foundItem2, new boolean[] {true,true,true,true}, 1, (new Date(0,0,0)).getTime(), false));
		assertTrue(WheresMyStuff.filter(lostItem1, new boolean[] {true,true,true,true}, 1, (new Date(0,0,0)).getTime(), false));
		assertTrue(WheresMyStuff.filter(lostItem2, new boolean[] {true,true,true,true}, 1, (new Date(0,0,0)).getTime(), false));
	}
	@Test
	public void testCase4() throws Throwable{
		assertFalse(WheresMyStuff.filter(foundItem1, new boolean[] {true,true,true,true}, 0, (new Date(0,0,0)).getTime(), false));
		assertFalse(WheresMyStuff.filter(foundItem2, new boolean[] {true,true,true,true}, 0, (new Date(0,0,0)).getTime(), false));
		assertFalse(WheresMyStuff.filter(lostItem1, new boolean[] {true,true,true,true}, 0, (new Date(0,0,0)).getTime(), false));
		assertFalse(WheresMyStuff.filter(lostItem2, new boolean[] {true,true,true,true}, 0, (new Date(0,0,0)).getTime(), false));
	}
	@Test
	public void testCase5() throws Throwable{
		assertFalse(WheresMyStuff.filter(foundItem1, new boolean[] {false,true,true,true}, 3, (new Date(0,0,0)).getTime(), false));
		assertFalse(WheresMyStuff.filter(foundItem2, new boolean[] {false,true,true,true}, 3, (new Date(0,0,0)).getTime(), false));
		assertFalse(WheresMyStuff.filter(lostItem1, new boolean[] {false,true,true,true}, 3, (new Date(0,0,0)).getTime(), false));
		assertFalse(WheresMyStuff.filter(lostItem2, new boolean[] {false,true,true,true}, 3, (new Date(0,0,0)).getTime(), false));
	}
	@Test
	public void testCase6() throws Throwable{
		assertFalse(WheresMyStuff.filter(foundItem1, new boolean[] {true,true,true,true}, 3, (new Date(0,0,4000)).getTime(), false));
		assertFalse(WheresMyStuff.filter(foundItem2, new boolean[] {true,true,true,true}, 3, (new Date(0,0,4000)).getTime(), false));
		assertFalse(WheresMyStuff.filter(lostItem1, new boolean[] {true,true,true,true}, 3, (new Date(0,0,4000)).getTime(), false));
		assertFalse(WheresMyStuff.filter(lostItem2, new boolean[] {true,true,true,true}, 3, (new Date(0,0,4000)).getTime(), false));
	}
	@Test
	public void testCase7() throws Throwable{
		assertFalse(WheresMyStuff.filter(foundItem1, new boolean[] {true,true,true,true}, 3, (new Date(0,0,0)).getTime(), true));
		assertFalse(WheresMyStuff.filter(foundItem2, new boolean[] {true,true,true,true}, 3, (new Date(0,0,0)).getTime(), true));
		assertFalse(WheresMyStuff.filter(lostItem1, new boolean[] {true,true,true,true}, 3, (new Date(0,0,0)).getTime(), true));
		assertFalse(WheresMyStuff.filter(lostItem2, new boolean[] {true,true,true,true}, 3, (new Date(0,0,0)).getTime(), true));
	}}
