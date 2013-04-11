package com.example.wheresmystuff.junits;

import android.test.AndroidTestCase;
import junit.framework.Assert;
import com.example.wheresmystuff.presenter.WheresMyStuff;
import com.example.wheresmystuff.model.*;

public class searchTestByPeter extends AndroidTestCase {
	private Item lostItem1, lostItem2, foundItem1, foundItem2;
	
	@Override
	public void setUp() {
		lostItem1 = new LostItem("LostItem1", "Lost Item", 0, "", 0, "", "", "", 0, 0);
		lostItem2 = new LostItem("LostItem2", "Lost Item", 0, "", 0, "", "", "", 0, 0);
		foundItem1 = new FoundItem("FoundItem1", "Found Item", 0, "", 0, 0, 0);
		foundItem2 = new FoundItem("FoundItem2", "Found Item", 0, "", 0, 0, 0);
	}
	
	public void testCase1() throws Throwable {
		Assert.assertTrue(WheresMyStuff.search(lostItem1, "lostitem1", ""));
	}
	
	public void testCase2() throws Throwable {
		Assert.assertTrue(WheresMyStuff.search(lostItem2, "lostitem2", "") && WheresMyStuff.search(lostItem2, "lostitem2", "lost item"));
	}
	
	public void testCase3() throws Throwable {
		Assert.assertTrue(WheresMyStuff.search(lostItem1, "", "lost item") && WheresMyStuff.search(lostItem2, "", "lost item"));
	}
	
	public void testCase4() throws Throwable {
		Assert.assertTrue(WheresMyStuff.search(foundItem1, "founditem1", ""));
	}
	
	public void testCase5() throws Throwable {
		Assert.assertTrue(WheresMyStuff.search(foundItem2, "founditem2", "") && WheresMyStuff.search(foundItem2, "founditem2", "found item"));
	}
	
	public void testCase6() throws Throwable {
		Assert.assertTrue(WheresMyStuff.search(foundItem1, "", "found item") && WheresMyStuff.search(foundItem2, "", "found item"));
	}
}
