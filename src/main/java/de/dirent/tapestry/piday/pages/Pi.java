package de.dirent.tapestry.piday.pages;

import javax.inject.Inject;

import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.util.TextStreamResponse;

public class Pi {

    @Inject
    private de.dirent.tapestry.piday.services.Pi pi;

    @Inject
    private Request request;
    
    public Object onActivate() {
        if( request.getPath().endsWith( "pi" ) ) {
            return new TextStreamResponse( "text/plain", pi.get() );
        }
        return null;
    }


    public Object onSearch() {
        return onSearch(null);
    }

    public Object onSearch( String digits ) {
        JSONObject result = new JSONObject();
        result.put( "index", pi.search(digits) );
        result.put( "search", digits );
        return new TextStreamResponse( "application/json", result.toCompactString() );
    }
}