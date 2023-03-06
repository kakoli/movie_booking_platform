package com.example.service;

import com.example.exception.InputValidationException;
import com.example.model.ShowDetailsRequest;
import com.example.persistence.entity.ShowDetails;

import java.text.ParseException;

public interface SeatInventoryService {
	
	public ShowDetails createShowInventory(ShowDetailsRequest req) throws InputValidationException, ParseException;

	/*public Optional<EmployeeSimple> getEmployee(Integer id);

    public List<EmpData> getAllEmployees();*/

}
