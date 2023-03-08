package com.example.service;

import com.example.exception.InputValidationException;
import com.example.model.ShowDetailsRequest;
import com.example.persistence.entity.ShowDetails;

import java.text.ParseException;
import java.util.List;

public interface SeatInventoryService {
	
	public ShowDetails createShowInventory(ShowDetailsRequest req) throws InputValidationException, ParseException;

    public int updateShowInventory(ShowDetailsRequest input) throws InputValidationException;

    public List<ShowDetails> getAllShows(String  theaterName, String movieName);

}
