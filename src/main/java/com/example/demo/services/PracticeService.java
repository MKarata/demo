package com.example.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.deans.Employee;
import com.example.demo.deans.Employees;

@Service
public class PracticeService {
	
	 public TreeSet<Employees> getEmployessDetails() {
		 //Comparable
	      //TreeSet<Employees> employeeSet = new TreeSet<>();
		 
		 //custom comparator using Comparator
	        TreeSet<Employees> employeeSet = new TreeSet<>(Comparator.comparing(emp -> emp.getId()));

	        employeeSet.add(new Employees(1, "John", 50000));
	        employeeSet.add(new Employees(3, "Alice", 60000));
	        employeeSet.add(new Employees(2, "Bob", 55000));

	        for (Employees e : employeeSet) {
	            System.out.println("get Employees Details: " +e);
	        }
	        
	        return employeeSet;
	    } 
	 
	 
	 public List<Employee> getHighestSalarys() {
			List<Employee> employees = Arrays.asList(
					  new Employee(1, "Tom", 40000),
					  new Employee(2, "Jerry", 60000),
					  new Employee(3, "Mike", 55000),
					  new Employee(4, "Anna", 48000));
					  
			double maxSalary = employees.stream().mapToDouble(Employee::getSalary).max().orElse(0);
					  return employees.stream()
						        .filter(e -> e.getSalary() == maxSalary)
						        .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
						        .collect(Collectors.toList());
		}
	 
	 
		public void getLongestSubString() {
			String s = "javaprogramming";
			int start = 0, end = 0, maxLen = 0;
			List<Character> list = new ArrayList<>();
			while (end < s.length()) {
				if (!list.contains(s.charAt(end))) {
					list.add(s.charAt(end));
					end++;
					maxLen = Math.max(maxLen, list.size());
				} else {
					list.remove(Character.valueOf(s.charAt(start)));
					start++;
				}
				System.out.println("list of char: " + list);
				System.out.println("max length: " + maxLen);
			}
		}
		
		
		public void mainGetLongestSubString() {
			String s = "javaprogramming";
			int start = 0, end = 0, maxLen = 0;
			List<Character> list = new ArrayList<>();
			String result = "";

			while (end < s.length()) {
				char current = s.charAt(end);
				if (!list.contains(current)) {
					list.add(current);
					end++;

					String currentSubstring = buildString(list);
					if (list.size() > maxLen || 
							(list.size() == maxLen && currentSubstring.compareTo(result) > 0)) {
						maxLen = list.size();
						result = currentSubstring;
					}
				} else {
					list.remove(Character.valueOf(s.charAt(start)));
					start++;
				}

				// Debugging output
				System.out.println("Current list: " + list);
				System.out.println("Current best: " + result + " (length " + maxLen + ")");
			}

			System.out.println("\n✅ Final Result: " + result);
		}

		// Helper method to build string from list of characters
		public static String buildString(List<Character> list) {
			StringBuilder sb = new StringBuilder();
			for (char c : list) {
				sb.append(c);
			}
			return sb.toString();
		}
		

		public static void main(String[] args) {
			try {
				System.out.println("1");
				throw new Exception();
			} catch (Exception e) {
				System.out.println("3");
			} 
//			catch (ArrayIndexOutOfBoundsException e) {
//				System.out.println("2");
//			}
			finally {
				System.out.println("4");
			}
		}

}
