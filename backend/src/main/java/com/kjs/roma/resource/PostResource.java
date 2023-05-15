package com.kjs.roma.resource;

import com.kjs.roma.dto.page.PageDTO;
import com.kjs.roma.dto.post.PostDTO;
import com.kjs.roma.service.PostService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Path("/post")
@RequiredArgsConstructor
@Slf4j
public class PostResource {
    private final PostService postService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(@Valid @RequestBody PostDTO postDTO) throws ServiceException {
        return Response.status(Response.Status.OK)
                .entity(postService.create(postDTO))
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response list(PageDTO pageDTO) throws ServiceException{
        return Response.status(Response.Status.OK)
                .entity(postService.list(pageDTO))
                .build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{seq}")
    public Response get(@PathParam("seq") Long seq) {
        return Response.status(Response.Status.OK)
                .entity(postService.get(seq))
                .entity(postService.updateVisit(seq))
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(PostDTO postDTO) {
        return Response.status(Response.Status.OK)
                .entity(postService.update(postDTO))
                .build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/view/{seq}")
    public Response view(@PathParam("seq") Long seq) {
        return Response.status(Response.Status.OK)
                .entity(postService.updateVisit(seq))
                .build();
    }


    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{seq}")
    public Response delete(@PathParam("seq") Long seq) {
        return Response.status(Response.Status.OK)
                .entity(postService.delete(seq))
                .build();
    }

}
