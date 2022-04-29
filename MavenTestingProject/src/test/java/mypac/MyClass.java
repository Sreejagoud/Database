package mypac;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MyClass {

	@Test
	public void test() {
		System.out.println("test method");
	}
	@Test
      public void addition() {
    	  int i=10;
    	  int j=20;
    	  int s=i+j;
    	  assertEquals(s,30);
    	  System.out.println("addition passed");
	}
      @Test
      public void difference() {
    	  int i=10;
    	  int j=67;
    	  int diff=i+j;
    	  assertEquals(diff,57);
    	  System.out.println("diff passed");
      }
@BeforeClass
	public static void beforeClassMethod() {
		System.out.println("Before Class Method(connect DB)");
		//real time connect DB
		
		}
@AfterClass
	public static void afterClassMethod() {
		System.out.println("after Class Method (Disconnect DB)");
		
	}
@Before
public void myMethodBefore() {
	  System.out.println("Exceutes after each method");
	  }

@After

public void mymethodAfter() {
	  System.out.println("Exceutes after each method");
}
	
@Ignore(" not yet implemented")
	@Test
	public void test3() {
		int a=12, b=13;
		int s=a-b;
		assertEquals(s,20);
		
}
}
