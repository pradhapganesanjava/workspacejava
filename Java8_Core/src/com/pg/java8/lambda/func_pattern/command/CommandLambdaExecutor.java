package com.pg.java8.lambda.func_pattern.command;

import java.util.ArrayList;
import java.util.List;

public class CommandLambdaExecutor {

	public static void main(String...str){
		List<CommandLambda> commands = new ArrayList<>();
		commands.add(CommandLambdaExecutor::logger);
		commands.add(CommandLambdaExecutor::composer);
		commands.add(CommandLambdaExecutor::emailer);
		
		CommandLambdaExecutor.executeCommand(commands);
	}
	
	public static void executeCommand(List<CommandLambda> commands){
		commands.forEach(CommandLambda::runCommand);
	}
	
	public static void logger(){
		System.out.println("Logger here");
	}
	public static void emailer(){
		System.out.println("email sent");
	}
	public static void composer(){
		System.out.println("compose...");	
	}
	
}
