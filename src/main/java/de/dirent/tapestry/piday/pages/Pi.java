package de.dirent.tapestry.piday.pages;

import javax.inject.Inject;

import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.util.TextStreamResponse;

public class Pi {

    @Inject
    private Request request;
    
    public Object onActivate() {
        if( request.getPath().endsWith( "pi" ) ) {
            return new TextStreamResponse( "text/plain", getPi() );
        }
        return null;
    }

    public String getPi() {
        return "3.14...";
    }

    public int indexOf( String search, int start ) {
        if( search == null ) {
            return -1;
        }
        String pi = getPi();
        if( pi == null  ||  pi.length() < start ) {
            return -1;
        }
        if( search.length() == 0 ) {
            return 0;
        }
        for( int i=start; i<pi.length(); i++ ) {
            for( int j=0; j<search.length(); j++ ) {
                if( search.charAt(j) != pi.charAt(i+j) ) {
                    break;
                }
                if( j == search.length()-1 ) {
                    return i-1;
                }
            }
        }
        return -1;
    }

    public Object onSearch() {
        return onSearch(null);
    }

    public Object onSearch( String digits ) {
        JSONObject result = new JSONObject();
        result.put( "index", indexOf(digits,2) );
        result.put( "search", digits );
        return new TextStreamResponse( "application/json", result.toCompactString() );
    }
}