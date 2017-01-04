package com.postrowski.foo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by postrowski on 2016-12-31.
 */
@Path("foos")
public class FooResource {

    @Inject
    FooService fooService;

    @GET
    @Path("/{a}/{b}")
    public int sum(@PathParam("a") int a, @PathParam("b") int b ) {
        int sum = fooService.sum(a, b);
        return sum;
    }

}
