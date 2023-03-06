package com.example.model;

import com.example.persistence.entity.ShowDetails;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ShowDetailsGetResponse extends ShowDetailsResponse {
    private List<ShowDetails> showList;

    @Builder
    public ShowDetailsGetResponse(List<Error> errList, List<ShowDetails> shows) {
        super(errList);
        this.showList = shows;
    }
}
