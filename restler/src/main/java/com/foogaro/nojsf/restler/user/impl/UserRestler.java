package com.foogaro.nojsf.restler.user.impl;

import com.foogaro.nojsf.business.exception.BusinessException;
import com.foogaro.nojsf.business.user.IUserBusiness;
import com.foogaro.nojsf.model.DataWrapper;
import com.foogaro.nojsf.model.ResponseWrapper;
import com.foogaro.nojsf.model.UserDTO;
import com.foogaro.nojsf.restler.ACRUDRestler;
import com.foogaro.nojsf.restler.exception.RestlerException;
import com.foogaro.nojsf.restler.user.IUserRestler;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UserRestler extends ACRUDRestler<UserDTO> implements IUserRestler {

    @Inject
    private IUserBusiness userBusiness;

    public Response findAll(@Context HttpServletRequest request, @Context HttpServletResponse response) throws RestlerException {
        Response res;

        List<UserDTO> userDTOList;
        try {
            userDTOList = userBusiness.findAll();
            ResponseWrapper responseWrapper = new ResponseWrapper();
            responseWrapper.setDataWrapper(userDTOList);
            res = Response.ok(responseWrapper).build();
        } catch (BusinessException e) {
            e.printStackTrace();
            res = Response.serverError().build();
        }

//        ResponseWrapper responseWrapper = new ResponseWrapper();
//        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
//        UserDTO userDTO;
//
//        userDTO = new UserDTO();userDTO.setFirstName("Luigi");userDTO.setFirstName("Fugaro");userDTO.setIdentifier("LUFOO");userDTOList.add(userDTO);
//        userDTO = new UserDTO();userDTO.setFirstName("Gigi");userDTO.setFirstName("Foogaro");userDTO.setIdentifier("GIFOO");userDTOList.add(userDTO);
//        userDTO = new UserDTO();userDTO.setFirstName("Gigio");userDTO.setFirstName("Figaro");userDTO.setIdentifier("GIFI");userDTOList.add(userDTO);
//        userDTO = new UserDTO();userDTO.setFirstName("G");userDTO.setFirstName("F");userDTO.setIdentifier("GF");userDTOList.add(userDTO);
//
//        responseWrapper.setDataWrapper(userDTOList);
//
////            res = Response.ok(userDTOList.toArray(new UserDTO[0])).build();
//        res = Response.ok(responseWrapper).build();

        return res;
    }

}
