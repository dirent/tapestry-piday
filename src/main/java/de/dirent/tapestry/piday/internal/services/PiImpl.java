package de.dirent.tapestry.piday.internal.services;

import de.dirent.tapestry.piday.services.Pi;

public class PiImpl implements Pi {

    private String pi = "3.14";

    @Override
    public String get() {
        return this.pi;
    }

    @Override
    public void init() {
    }

    @Override
    public int search(String digits) {
        return indexOf(digits,2);
    }


    public int indexOf( String search, int start ) {
        if( search == null ) {
            return -1;
        }
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
}