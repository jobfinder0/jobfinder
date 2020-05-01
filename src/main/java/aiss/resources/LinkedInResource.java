package aiss.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.restlet.resource.ClientResource;

import aiss.model.linkedIn.AccessToken;
import aiss.model.linkedIn.Profile;
import aiss.utility.LinkedIn;

public class LinkedInResource {
	
	private static final String clientId = LinkedIn.clientId;
	private static final String clientSecret = LinkedIn.clientSecret;
	private static final String redirectUri = LinkedIn.redirectUriOauth;
	private static final Logger log = Logger.getLogger(LinkedInResource.class.getName());
	
	public String getId(String accessToken) {
		final String uriProfile = "https://api.linkedin.com/v2/me?oauth2_access_token="+accessToken;
        log.log(Level.FINE, "LinkedIn Profile: " + uriProfile);
		ClientResource cr2 = new ClientResource(uriProfile);
		Profile profile= cr2.get(Profile.class);
		return profile.getId();
	}
	public AccessToken getAccessToken(String code) {
	        final String uri = "https://www.linkedin.com/oauth/v2/accessToken?grant_type=authorization_code&client_id="+clientId+"&client_secret="+clientSecret+"&redirect_uri="+redirectUri+"/courses&code="+code;
	        log.log(Level.FINE, "LinkedIn access token: " + uri);
			
			ClientResource cr = new ClientResource(uri);
			AccessToken accessToken = cr.get(AccessToken.class);
			return accessToken;
	    }
	
	public void ugcPost(String shareCommentary,String title,String url,String web,String accessToken) {
        final String uri = "https://api.linkedin.com/v2/ugcPosts?oauth2_access_token="+accessToken;
        String id = getId(accessToken);
        log.log(Level.FINE, "LinkedIn post: " + uri);
		
        DefaultHttpClient httpClient = new DefaultHttpClient();
    		HttpPost httpPost = new HttpPost(uri);
    		httpPost.setHeader("Content-type", "application/json");
    	    try {
    	    	String body = " {" + 
    	    			"    \"author\": \"urn:li:person:"+id+"\"," + 
    	    			"    \"lifecycleState\": \"PUBLISHED\"," + 
    	    			"    \"specificContent\": {" + 
    	    			"        \"com.linkedin.ugc.ShareContent\": {" + 
    	    			"            \"shareCommentary\": {" + 
    	    			"                \"text\": \""+shareCommentary+"\"" + 
    	    			"            }," + 
    	    			"            \"shareMediaCategory\": \"ARTICLE\"," + 
    	    			"            \"media\": [" + 
    	    			"                {" + 
    	    			"                    \"status\": \"READY\"," + 
    	    			"                    \"description\": {" + 
    	    			"                        \"text\": \""+title+"\"" + 
    	    			"                    }," + 
    	    			"                    \"originalUrl\": \""+url+"\"," + 
    	    			"                    \"title\": {" + 
    	    			"                        \"text\": \""+web+"\"" + 
    	    			"                    }" + 
    	    			"                }" + 
    	    			"            ]" + 
    	    			"        }" + 
    	    			"    }," + 
    	    			"    \"visibility\": {" + 
    	    			"        \"com.linkedin.ugc.MemberNetworkVisibility\": \"CONNECTIONS\"" + 
    	    			"    }" + 
    	    			"}";
    	        StringEntity stringEntity = new StringEntity(body);
    	        httpPost.getRequestLine();
    	        httpPost.setEntity(stringEntity);

    	        httpClient.execute(httpPost);
    	    } catch (Exception e) {
    	    	log.log(Level.WARNING, "LinkedIn post exception "+e.getCause().toString());
    	        throw new RuntimeException(e);
    	    }
    	}
	
	
}
