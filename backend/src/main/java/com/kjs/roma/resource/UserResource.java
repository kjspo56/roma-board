package com.kjs.roma.resource;

import com.kjs.roma.dto.user.UserDTO;
import com.kjs.roma.service.UserService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Component;

@Component
@Path("/user")
@RequiredArgsConstructor
@Slf4j
public class UserResource {

    private final UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(UserDTO userDTO) throws ServiceException {
        return Response.status(Response.Status.OK)
                .entity(userService.login(userDTO))
                .build();
    }
}
