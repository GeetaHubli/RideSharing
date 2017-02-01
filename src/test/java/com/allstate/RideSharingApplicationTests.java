package com.allstate;

import com.allstate.services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Suite.class)
@SpringBootTest
@Suite.SuiteClasses({
		CityServiceTest.class,
		CarServiceTest.class,
		PassengerServiceTest.class,
		DriverServiceTest.class,
		TripServiceTest.class,
		ReportServiceTest.class
})
public class RideSharingApplicationTests {

	@Test
	public void contextLoads() {
	}

}
