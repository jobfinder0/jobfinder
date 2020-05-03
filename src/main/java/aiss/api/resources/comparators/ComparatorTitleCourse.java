package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.api.model.Course;

public class ComparatorTitleCourse implements Comparator<Course> {

	@Override
	public int compare(Course c1, Course c2) {
		return c1.getTitle().compareTo(c2.getTitle());
	}

}
