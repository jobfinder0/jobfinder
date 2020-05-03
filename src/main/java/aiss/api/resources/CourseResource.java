package aiss.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.model.Comment;
import aiss.api.model.Course;
import aiss.api.model.repository.CourseRepository;
import aiss.api.model.repository.MapCourseRepository;
import aiss.api.resources.comparators.ComparatorPriceCourse;
import aiss.api.resources.comparators.ComparatorPriceCourseReversed;
import aiss.api.resources.comparators.ComparatorTitleCourse;
import aiss.api.resources.comparators.ComparatorTitleCourseReversed;

@Path("/courses")
public class CourseResource {
	
	/* Singleton */
	private static CourseResource _instance=null;
	CourseRepository repository;
	
	private CourseResource() {
		repository = MapCourseRepository.getInstance();

	}
	
	public static CourseResource getInstance()
	{
		if(_instance==null)
				_instance=new CourseResource();
		return _instance;
	}
	
	
    @GET
    @Produces("application/json")
    public Collection<Course> getAll(@QueryParam("order") String order,
            @QueryParam("isEmpty") Boolean isEmpty, @QueryParam("title") String title, @QueryParam("limit") Integer limit, @QueryParam("offset") Integer offset)
    {
        List<Course> result = new ArrayList<Course>();
            
        for (Course course: repository.getAllCourses()) {
            if (title == null || course.getTitle().toLowerCase().contains(title.toLowerCase())) { // Title filter
                if (isEmpty == null // Empty course filter
                        || (isEmpty && (course.getComments() == null || course.getComments().size() == 0))
                        || (!isEmpty && (course.getComments() != null && course.getComments().size() > 0))) {
                    result.add(course);
                }
            }
        }
            
        if (order != null) { // Order results
            if (order.equals("title")) {
                Collections.sort(result, new ComparatorTitleCourse());
            } else if (order.equals("-title")) {
                Collections.sort(result, new ComparatorTitleCourseReversed());
            } else if (order.equals("price")) {
            	Collections.sort(result, new ComparatorPriceCourse());
            } else if (order.equals("-price")) {
            	Collections.sort(result, new ComparatorPriceCourseReversed());
            }else {
                throw new BadRequestException("The order parameter must be 'title','-title','price' or '-price'.");
            }
        }
        
        if(offset!=null) {
        	if(offset<result.size())
        	result = result.subList(offset, result.size());
        	else 
        	result.clear();
        }
        if(limit!=null && limit<result.size()) {
        	result = result.subList(0, limit);
        }

        return result;
    }
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Course get(@PathParam("id") String id)
	{
		Course course = repository.getCourse(id);
		
		if (course == null) {
			throw new NotFoundException("The course with id="+ id +" was not found");			
		}
		
		return course;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addCourse(@Context UriInfo uriInfo, Course course) {
		if (course.getTitle() == null || "".equals(course.getTitle()))
			throw new BadRequestException("The title of the course must not be null");

		if (course.getDescription() == null || "".equals(course.getDescription()))
			throw new BadRequestException("The description of the course must not be null");
		

		if (course.getPrice() == null)
			throw new BadRequestException("The price of the course must not be null");
		

		if (course.getCurrency() == null || "".equals(course.getCurrency()))
			throw new BadRequestException("The currency of the course must not be null");
		
		if (course.getComments()!=null)
			throw new BadRequestException("The comments property is not editable.");

		repository.addCourse(course);

		// Builds the response. Returns the course the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(course.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(course);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updateCourse(Course course) {
		Course oldcourse = repository.getCourse(course.getId());
		if (oldcourse == null) {
			throw new NotFoundException("The course with id="+ course.getId() +" was not found");			
		}
		
		if (course.getComments()!=null)
			throw new BadRequestException("The comments property is not editable.");
		
		// Update title
		if (course.getTitle()!=null)
			oldcourse.setTitle(course.getTitle());
		
		// Update description
		if (course.getDescription()!=null)
			oldcourse.setDescription(course.getDescription());
		
		// Update price
		if (course.getPrice()!=null)
			oldcourse.setPrice(course.getPrice());
		
		// Update currency
		if (course.getCurrency()!=null)
			oldcourse.setCurrency(course.getCurrency());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeCourse(@PathParam("id") String id) {
		Course toberemoved=repository.getCourse(id);
		if (toberemoved == null)
			throw new NotFoundException("The course with id="+ id +" was not found");
		else
			repository.deleteCourse(id);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{courseId}/{commentId}")
	@Produces("application/json")
	public Response addComment(@Context UriInfo uriInfo,@PathParam("courseId") String courseId, @PathParam("commentId") String commentId)
	{				
		
		Course course = repository.getCourse(courseId);
		Comment comment = repository.getComment(commentId);
		
		if (course==null)
			throw new NotFoundException("The course with id=" + courseId + " was not found");
		
		if (comment == null)
			throw new NotFoundException("The comment with id=" + commentId + " was not found");
		
		if (course.getComment(commentId)!=null)
			throw new BadRequestException("The comment is already included in the course.");
			
		repository.addComment(courseId, commentId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(courseId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(course);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{courseId}/{commentId}")
	public Response removeComment(@PathParam("courseId") String courseId, @PathParam("commentId") String commentId) {
		Course course = repository.getCourse(courseId);
		Comment comment = repository.getComment(commentId);
		
		if (course==null)
			throw new NotFoundException("The course with id=" + courseId + " was not found");
		
		if (comment == null)
			throw new NotFoundException("The comment with id=" + commentId + " was not found");
		
		
		repository.removeComment(courseId, commentId);		
		
		return Response.noContent().build();
	}
}
