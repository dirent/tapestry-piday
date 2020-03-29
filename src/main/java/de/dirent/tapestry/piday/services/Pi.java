package de.dirent.tapestry.piday.services;

public interface Pi {

    /**
     * Initializes pi.
     * This is expected to be called at start up of the application.
     */
    void init();

    /**
     * Gets some digits of pi
     * 
     * @return the digits
     */
    String get();

    /**
     * Searches for digits in pi
     * 
     * @param digits the digits to search for
     * @return the index of the digits or -1 if digits has not been found
     */
    int search( String digits );
}