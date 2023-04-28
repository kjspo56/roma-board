package com.kjs.roma.resource;

import com.kjs.roma.dto.PostDTO;
import com.kjs.roma.service.PostService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@Path("/post")
@RequiredArgsConstructor
@Slf4j
public class PostResource {

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create() {
        System.out.println("Hello World");
        return Response.status(Response.Status.OK)
                .build();
    }*/

    private final PostService postService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public ResponseEntity<PostDTO> create(@Valid @RequestBody PostDTO postDTO){
        PostDTO createPostDTO = postService.create(postDTO);
        return new ResponseEntity<>(createPostDTO, HttpStatus.CREATED);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public ResponseEntity<List<PostDTO>> list(){
        List<PostDTO> postDTOList = postService.list();
        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{seq}")
    public ResponseEntity<PostDTO> get(@PathParam("seq") Long seq) {
        PostDTO postDTO = postService.get(seq);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public ResponseEntity<PostDTO> update(PostDTO postDTO) {
        PostDTO updatePostDTO = postService.update(postDTO);
        return new ResponseEntity<>(updatePostDTO, HttpStatus.OK);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{seq}")
    public ResponseEntity<Void> delete(@PathParam("seq") Long seq) {
        postService.delete(seq);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
