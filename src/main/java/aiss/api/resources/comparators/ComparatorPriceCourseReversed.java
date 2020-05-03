package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.api.model.Course;

public class ComparatorPriceCourseReversed implements Comparator<Course> {

	@Override
	public int compare(Course c1, Course c2) {
		return c2.getPrice().compareTo(c1.getPrice());
	}

}
