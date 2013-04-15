package com.example.wheresmystuff.junits;
import junit.framework.Assert;
import com.example.wheresmystuff.model.*;
import com.example.wheresmystuff.presenter.WheresMyStuff;
import android.test.AndroidTestCase;
public class testOlivia extends AndroidTestCase {
private LostItem addItem1;

public void setUp() {
	addItem1 = new LostItem("additem1","Added Item", 0,"", 0, "", "", "", 0, 0);
	Assert.assertTrue(WheresMyStuff.addItem(addItem1));
}

public void testItem1() throws Throwable {
	Assert.assertTrue((WheresMyStuff.getItemList()).contains(addItem1));
}

public void testItem2() throws Throwable {
	Assert.assertTrue((WheresMyStuff.getItemList()).contains(addItem1));
}
}
