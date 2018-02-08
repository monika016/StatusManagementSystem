package com.mindtree.StatusManagementSystem.junit;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;



public class main {

	public static void main(String ar[]) {
	      Result result = JUnitCore.runClasses(ControllerTest.class);

	      for (Failure failure : result.getFailures()) {
	          System.out.println(failure.toString());
	       }
	 		
	       System.out.println(result.wasSuccessful());
	}

}
