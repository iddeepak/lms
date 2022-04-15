package com.java.lms.controller;

import com.java.lms.LibraryManagementSystemApplication;
import com.java.lms.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class ServerStatusApi {

    @GetMapping("/heartbeat")
    public Object returnStatus(HttpServletResponse response){
        try{
            if(LibraryManagementSystemApplication.status){
                response.setStatus(HttpStatus.OK.value());
                return new ApiResponse(true, "Server is up and Running");
            }else{
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ApiResponse(false, "Please wait for a few seconds");
            }
        }catch(Exception e){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ApiResponse(false, "Unexpected Error");
        }


    }
}
