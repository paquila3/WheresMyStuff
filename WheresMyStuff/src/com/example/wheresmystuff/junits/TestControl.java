package com.example.wheresmystuff.junits;

import android.test.suitebuilder.TestSuiteBuilder;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TestControl extends TestSuite {
	public static Test suite() {
        return new TestSuiteBuilder(TestControl.class).includeAllPackagesUnderHere().build();
    }
}
