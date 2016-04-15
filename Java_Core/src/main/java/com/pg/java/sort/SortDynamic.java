package com.pg.java.sort;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class SortDynamic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SortDynamic sortDyn = new SortDynamic();

		EmployeeComparator empComp = sortDyn.new EmployeeComparator();
		TreeSet<Employee> empSet = new TreeSet<SortDynamic.Employee>(empComp);

		Employee emp1 = sortDyn.new Employee(22, 2200.0, "A");
		Employee emp2 = sortDyn.new Employee(25, 2500.0, "D");
		Employee emp3 = sortDyn.new Employee(23, 2300.0, "B");
		Employee emp4 = sortDyn.new Employee(24, 2400.0, "C");

		empSet.add(emp1);
		empSet.add(emp2);
		empSet.add(emp3);
		empSet.add(emp4);

		Iterator it = empSet.iterator();

		while (it.hasNext()) {
			System.out.println(" " + (Employee) it.next());
		}
		emp3.setName("A");
		Iterator it2 = empSet.iterator();
		while (it2.hasNext()) {
			System.out.println(" " + (Employee) it2.next());
		}
	}

	private class EmployeeComparator implements Comparator<Employee> {
		public int compare(Employee emp1, Employee emp2) {
			return emp1.name.compareTo(emp2.name);
		}
	}

	private class Employee {
		private int age;
		private double salary;
		private String name;

		public Employee(int age, double salary, String name) {
			this.age = age;
			this.salary = salary;
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public double getSalary() {
			return salary;
		}

		public String getName() {
			return name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			int overrideHashCode = (age + (int) salary) * name.hashCode();
			return overrideHashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (null == obj) {
				return false;
			}
			if (!(obj instanceof Employee)) {
				return false;
			}
			Employee empObj = (Employee) obj;

			if ((this.age == empObj.age) && (this.name.equals(empObj.name))) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "name: " + this.name + " age: " + this.age + " salary: " + this.salary;
		}
	}
}
