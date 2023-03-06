package com.example.model;

import com.example.persistence.entity.ShowDetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowDetailsCreateResponse extends ShowDetailsResponse {
    private ShowDetails show;

    @Builder
    public ShowDetailsCreateResponse(List<Error> errList, ShowDetails show) {
        super(errList);
        this.show = show;
    }
}
