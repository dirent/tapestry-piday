package de.dirent.tapestry.piday.services;

import org.apache.tapestry5.ioc.ServiceBinder;

import de.dirent.tapestry.piday.internal.services.PiImpl;

public class AppModule {

    public static void bind( ServiceBinder binder ) {
		binder.bind( Pi.class, PiImpl.class );
    }
}