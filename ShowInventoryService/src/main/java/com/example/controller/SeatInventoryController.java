package com.example.controller;

import com.example.exception.InputValidationException;
import com.example.model.Error;
import com.example.model.ShowDetailsGetResponse;
import com.example.model.ShowDetailsRequest;
import com.example.model.ShowDetailsCreateResponse;
import com.example.persistence.entity.ShowDetails;
import com.example.service.SeatInventoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class SeatInventoryController {

    @Autowired
    private SeatInventoryService showService;

    @PostMapping(path = "/seatInventory", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShowDetailsCreateResponse> createSeatInv(@RequestBody ShowDetailsRequest request) {

        ShowDetailsCreateResponse saveResponse = null;
        ResponseEntity<ShowDetailsCreateResponse> ret = null;
        ShowDetails showDtls = null;

        System.out.println("In controller save " +request.getMovieName());
        validate(request);
        try {
            showDtls = showService.createShowInventory(request);
            saveResponse = ShowDetailsCreateResponse.builder().show(showDtls).build();
            ret = new ResponseEntity<>(saveResponse, HttpStatus.OK);
        }
        catch (RuntimeException e) {
            log.error("Input invalid ");
            e.printStackTrace();
            Error err = Error.builder()
                    .errorCode(HttpStatus.BAD_REQUEST.value())
                    .errorDesc(e.getCause() != null ? e.getCause().getMessage() : e.getMessage()).build();
            saveResponse = ShowDetailsCreateResponse.builder()
                    .errList(Collections.singletonList(err))
                    .build();
            ret = new ResponseEntity<>(saveResponse, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            log.error("Unexpected Exception in create show ");
            e.printStackTrace();
            Error err = Error.builder()
                    .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .errorDesc(e.getCause() != null ? e.getCause().getMessage() : e.getMessage()).build();
            saveResponse = ShowDetailsCreateResponse.builder()
                    .errList(Collections.singletonList(err))
                    .build();
            ret = new ResponseEntity<>(saveResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ret;
    }

    private void validate(ShowDetailsRequest request) throws InputValidationException {
        // TBD : Date validations
        if(StringUtils.isBlank(request.getMovieName()))
            throw new InputValidationException("Movie Name cannot be blank.");
        if(StringUtils.isBlank(request.getTheaterName()))
            throw new InputValidationException("Theater Name cannot be blank.");
    }

    @GetMapping("/seatInventory/theater/{theaterName}/movie/{movieName}")
    public ResponseEntity<ShowDetailsGetResponse> getSeatInv(@PathVariable("theaterName") String theaterName,
                                                              @PathVariable("movieName") String movieName) throws InputValidationException {
        log.info("Start getShowDetails : "+ movieName);
        ShowDetailsGetResponse getResponse = null;
        ResponseEntity<ShowDetailsGetResponse> ret = null;
        Optional<ShowDetails> showDtls = null;

        /*if(empId != null ) {
            emp = empService.getEmployee(empId);
            if (!emp.isEmpty()) {
                getResponse = EmpGetResponse.builder()
                        .emp(emp.get()).build();
                ret = new ResponseEntity<>(getResponse, HttpStatus.OK);
            }
            else {
                Error err = Error.builder()
                        .errorCode(HttpStatus.NOT_FOUND.value())
                        .errorDesc("EmployeeSimple does not exist.").build();
                getResponse = EmpGetResponse.builder()
                        .errList(Collections.singletonList(err)).build();
                ret = new ResponseEntity<>(getResponse, HttpStatus.NOT_FOUND);
            }
        }
        else {
            log.error("Emp id is mandatory");
            Error err = Error.builder()
                    .errorCode(HttpStatus.BAD_REQUEST.value())
                    .errorDesc("EmployeeSimple id needed in request.").build();
            getResponse = EmpGetResponse.builder()
                    .errList(Collections.singletonList(err)).build();
            ret = new ResponseEntity<>(getResponse, HttpStatus.BAD_REQUEST);
        }*/
        return ret;
    }

}
