package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.api.model.Course;

public class ComparatorTitleCourseReversed implements Comparator<Course> {

	@Override
	public int compare(Course c1, Course c2) {
		return c2.getTitle().compareTo(c1.getTitle());
	}

}
