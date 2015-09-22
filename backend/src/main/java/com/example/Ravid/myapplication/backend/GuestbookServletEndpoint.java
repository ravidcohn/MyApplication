package com.example.Ravid.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "guestbookServletApi",
        version = "v1",
        resource = "guestbookServlet",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.Ravid.example.com",
                ownerName = "backend.myapplication.Ravid.example.com",
                packagePath = ""
        )
)
public class GuestbookServletEndpoint {

    private static final Logger logger = Logger.getLogger(GuestbookServletEndpoint.class.getName());

    /**
     * This method gets the <code>GuestbookServlet</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>GuestbookServlet</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getGuestbookServlet")
    public GuestbookServlet getGuestbookServlet(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getGuestbookServlet method");
        return null;
    }

    /**
     * This inserts a new <code>GuestbookServlet</code> object.
     *
     * @param guestbookServlet The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertGuestbookServlet")
    public GuestbookServlet insertGuestbookServlet(GuestbookServlet guestbookServlet) {
        // TODO: Implement this function
        logger.info("Calling insertGuestbookServlet method");
        return guestbookServlet;
    }
}