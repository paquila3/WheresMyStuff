package com.example.wheresmystuff.junits;

import android.test.AndroidTestCase;
import junit.framework.Assert;

public class searchTestByPeter extends AndroidTestCase {
	private int testInt;
	
	@Override
	public void setUp() {
		testInt = 2;
	}
	
	public void testCase1() throws Throwable {
		Assert.assertTrue(testInt > 0);
	}
}
