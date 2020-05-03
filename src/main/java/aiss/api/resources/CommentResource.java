package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.model.Comment;
import aiss.api.model.repository.CourseRepository;
import aiss.api.model.repository.MapCourseRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Path("/comments")
public class CommentResource {

	public static CommentResource _instance=null;
	CourseRepository repository;
	
	private CommentResource(){
		repository=MapCourseRepository.getInstance();
	}
	
	public static CommentResource getInstance()
	{
		if(_instance==null)
			_instance=new CommentResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Comment> getAll(@QueryParam("q") String q, @QueryParam("limit") Integer limit, @QueryParam("offset") Integer offset)
	{
		List<Comment> result = new ArrayList<Comment>();
        
        for (Comment comment: repository.getAllComments()) {
            if (q == null
            		|| comment.getText().toLowerCase().contains(q.toLowerCase())
            		|| (comment.getUsername() != null && comment.getUsername().toLowerCase().contains(q.toLowerCase())))
            	result.add(comment);
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
	public Comment get(@PathParam("id") String commentId)
	{
		Comment list = repository.getComment(commentId);
		
		if (list == null) {
			throw new NotFoundException("The comment with id="+ commentId +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addComment(@Context UriInfo uriInfo, Comment comment) {
		if (comment.getText() == null || "".equals(comment.getText()))
			throw new BadRequestException("The text of the comment must not be null");
		if (comment.getUsername() == null || "".equals(comment.getUsername()))
			throw new BadRequestException("The username of the comment must not be null");

		repository.addComment(comment);

		// Builds the response. Returns the course the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(comment.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(comment);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateComment(Comment comment) {
		Comment oldcomment = repository.getComment(comment.getId());
		if (oldcomment == null) {
			throw new NotFoundException("The comment with id="+ comment.getId() +" was not found");			
		}
		
		// Update text
		if (comment.getText()!=null)
			oldcomment.setText(comment.getText());
		
		// Update username
		if (comment.getUsername()!=null)
			oldcomment.setUsername(comment.getUsername());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeComment(@PathParam("id") String commentId) {
		Comment toberemoved=repository.getComment(commentId);
		if (toberemoved == null)
			throw new NotFoundException("The comment with id="+ commentId +" was not found");
		else
			repository.deleteComment(commentId);
		
		return Response.noContent().build();
	}
	
}