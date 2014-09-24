/**
 * 
 */
package main.java.controller;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CHANDRA
 * 
 */
public class NavigationController extends BaseController {

    public static void logOut() {
	// get a handle on the request / response
	FacesContext context = FacesContext.getCurrentInstance();
	ExternalContext ec = context.getExternalContext();
	HttpServletRequest request = (HttpServletRequest) ec.getRequest();
	HttpServletResponse response = (HttpServletResponse) ec.getResponse();

	// destroy the HTTP session - this will destroy all Apache Orchestra
	// conversation contexts across all application tabs
	System.out.println("invalidating session");
	request.getSession(false).invalidate();

	// re-direct to the application root e.g. /ProdisMoffatPlus
	// Spring security will automatically forward to the login page as
	// the session has now been invalidated
	try {
	    String contextRoot = ec.getRequestContextPath();
	    System.out.println("redirecting to context root - " + contextRoot);
	    response.sendRedirect(contextRoot);
	} catch (IOException e) {
	    System.out.println("exception redirecting to logon page - "
		    + e.toString());
	}

	// tell JSF the response is complete
	context.responseComplete();
    }

}
