package com.example.wheresmystuff.junits;

import android.test.AndroidTestCase;
import junit.framework.Assert;
import com.example.wheresmystuff.presenter.WheresMyStuff;
import com.example.wheresmystuff.model.*;

public class JUnitTestByChintan extends AndroidTestCase {
	private User regular_user, admin_user;
	
	public void setUp()
	{
		regular_user = new User("regular_user", "password", false, 1);
		admin_user = new User("admin_user", "password", true, 2);
		WheresMyStuff.promoteUser(regular_user);
	}
	

	public void testCase1() throws Throwable {
		Assert.assertTrue(regular_user.isAdmin());
	}
}
