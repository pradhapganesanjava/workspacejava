package com.pg.java8.func;

import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		Predicate<String> prNameValid = PredicateTest::isNameExists;
		Predicate<String> prAuthValid = PredicateTest::isAuthUser;
		Predicate<String> prRoleValid = PredicateTest::isValidRole;

		printPredicate(prNameValid,"Pradhap");
		printPredicate(prAuthValid,"MGR_001");
		printPredicate(prRoleValid,"programmer analyst");
		
		///System.out.println("name: "+ prNameValid.test("pradhap") + " auth: "+  prAuthValid.test("EMP_001") +" role: " + prRoleValid.test("developer"));

//		PredicateTest.PredicateVararg<String> vaName = PredicateTest::isNameExists;
		PredicateTest.PredicateVararg<String> vaName2 = PredicateTest::isAuthPerson;

		
	}

	static boolean isAuthPerson(String...args){
		switch (args[0]+args[1]+args[2]) {
		case "PradhapGanesanMale":
			return true;
		case "GanesanPradhapMale":
			return true;
		case "SangeethaRaghuFemale":
			return true;
		case "RaghuSangeethaFemale":
			return true;
		default:
			return false;
	}
}
	
	static boolean isNameExists(final String name) {
		switch (name) {
			case "pradhap":
				return true;
			case "PRADHAP":
				return true;
			case "Pradhap Ganesan":
				return true;
			case "Pradhap":
				return true;
			default:
				return false;
		}
	}

	static boolean isValidRole(final String role) {
		switch (role) {
			case "developer":
				return true;
			case "programmer analyst":
				return true;
			case "full stack developer":
				return true;
			case "sr software developer":
				return true;
			default:
				return false;
		}
	}

	static boolean isAuthUser(final String userId) {
		switch (userId) {
			case "EMP_001":
				return true;
			case "MGR_001":
				return true;
			case "CNT_001":
				return true;
			case "CNT_002":
				return true;
			default:
				return false;
		}
	}
	
	static <T> void printPredicate(Predicate<T> pred,T param){
			System.out.println(param+ " : "+pred.test(param));
	}
	
	private static interface PredicateVararg<T>{
		public boolean test(T... str);
	}
}
