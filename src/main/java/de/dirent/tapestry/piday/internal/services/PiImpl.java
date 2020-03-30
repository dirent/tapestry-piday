package de.dirent.tapestry.piday.internal.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tapestry5.ioc.annotations.Symbol;

import de.dirent.tapestry.piday.services.Pi;

public class PiImpl implements Pi {

    protected static final Log logger = LogFactory.getLog( Pi.class );

    private String pi = "3.14";

    @Override
    public String get() {
        return this.pi;
    }

    @Inject
    @Symbol( value = "piday.pathtodigits" )
    private String pathToDigits;

    @Override
    public void init() {
        if( pathToDigits == null ) {
            logger.warn( "No path to pi given." );
        } else {
            logger.debug( "Loading pi into memory. Path is " + pathToDigits );
            byte[] buf = new byte[32000];
            File piDigits = new File( pathToDigits );
            try ( InputStream in = new FileInputStream( piDigits ) ) {
                StringBuffer response = new StringBuffer(1000000000);
                while( in.read(buf) > 0 ) {
                    response.append( new String(buf, "utf-8" ) );
                }
                pi = response.toString();
                logger.info( "Loaded pi into memory." );
            } catch( Exception e) {
                logger.error("Could not read from digits file: " + e.getMessage() );
            }
        }
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