package de.dirent.tapestry.piday.pages;

import org.apache.tapestry5.util.TextStreamResponse;

public class Pi {

    public Object onActivate() {
        return new TextStreamResponse( "text/plain", getPi() );
    }

    public String getPi() {
        return "3.14...";
    }
}