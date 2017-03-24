package com.pg.dp.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
	 //example of scope - singleton vs prototype
	      
	   ApplicationContext context = 
             new ClassPathXmlApplicationContext("Beans.xml");

      HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
      objA.getMessage();
      objA.setMessage("I'm object A");
      objA.getMessage();

      HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
      objB.getMessage();
      
      
	   //Callback methods examples
	   /*AbstractApplicationContext context = 
               new ClassPathXmlApplicationContext("Beans.xml");

	   HelloWorld objB = (HelloWorld) context.getBean("helloWorldCallback");
      objB.getMessage();
      context.registerShutdownHook();
*/

   }
}
