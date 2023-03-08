package com.example.model;

import com.example.persistence.entity.ShowDetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowDetailsUpdateResponse extends ShowDetailsResponse {
    private int rowsUpdated;

    @Builder
    public ShowDetailsUpdateResponse(List<Error> errList, int rows) {
        super(errList);
        this.rowsUpdated = rows;
    }
}
