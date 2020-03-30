package de.dirent.tapestry.piday.services;

import javax.servlet.ServletContext;

import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ServletApplicationInitializer;
import org.apache.tapestry5.services.ServletApplicationInitializerFilter;

import de.dirent.tapestry.piday.internal.services.PiImpl;

public class AppModule {

    public static void bind(ServiceBinder binder) {
        binder.bind(Pi.class, PiImpl.class);
    }

    @Contribute(value = ServletApplicationInitializer.class)
    public static void loadPi(
            final OrderedConfiguration < ServletApplicationInitializerFilter > configuration,
            @Inject final Pi pi) {

        configuration.add("piloader", new ServletApplicationInitializerFilter() {

            @Override
            public void initializeApplication(ServletContext context, ServletApplicationInitializer initializer) {
                pi.init();
            }
        });
    }
}