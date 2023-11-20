package lab9;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	String name;
	String address;
	List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course maxPracticalCourse = null;
		for (Course course : courses) {
			if (course.sameType("Practical")
					&& (maxPracticalCourse == null || course.hasMoreStudent(maxPracticalCourse))) {
				maxPracticalCourse = course;
			}
		}
		return maxPracticalCourse;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		
		Map<Integer, List<Student>> studentsByYear = new HashMap<Integer, List<Student>>();
		for (Course course : courses) {
			for (Student student : course.getStudents()) {
				if (!studentsByYear.containsKey(student.getYear())) {
					ArrayList<Student> students = new ArrayList<Student>();
					students.add(student);
					studentsByYear.put(student.getYear(), students);
				} else {
					studentsByYear.get(student.getYear()).add(student);
				}
			}
		}
		return studentsByYear;
	}

	public Set<Course> filterCourses(String type) {
		Set<Course> filteredCourses = new TreeSet<Course>(new Comparator<Course>() {
			@Override
			public int compare(Course o1, Course o2) {
				return o1.getNumberOfStudents() - o2.getNumberOfStudents();
			}
		});
		for (Course course : courses) {
			if (course.sameType(type)) {
				filteredCourses.add(course);
			}
		}
		return filteredCourses;
	}

	

}
