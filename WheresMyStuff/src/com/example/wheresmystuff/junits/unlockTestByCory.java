package com.example.wheresmystuff.junits;

import android.test.AndroidTestCase;
import junit.framework.Assert;
import com.example.wheresmystuff.presenter.WheresMyStuff;
import com.example.wheresmystuff.model.*;

public class unlockTestByCory extends AndroidTestCase {
	private User user1,user0,user2,user3;
	
	@Override
	public void setUp() {
		user0 = new User("user0@gmail.com", "hello", 00);
		user1 = new User("user1@gmail.com", "hello", 01);
		user1.setLocked(true);
		user2 = new User("user2@gmail.com", "hello",true, 02);
		user2.setLocked(true);
		user3 = new User("user3@gmail.com", "hello",true, 03);
	}
	
	public void testCase1() throws Throwable {
		Assert.assertFalse(user0.isLocked());
	}
	public void testCase2() throws Throwable {
		WheresMyStuff.unlockUser(user1);
		Assert.assertTrue(user1.isLocked());
	}
	public void testCase3() throws Throwable {
		WheresMyStuff.unlockUser(user2);
		Assert.assertTrue(user2.isLocked());
	}
	public void testCase4() throws Throwable {
		Assert.assertFalse(user3.isLocked());
	}
	
}
