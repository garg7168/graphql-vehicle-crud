package com.alti.graphql.exceptions;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class VehicleNotFoundException extends RuntimeException implements GraphQLError{
	
	private int vehicleId;

    public VehicleNotFoundException(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public String getMessage() {
        return "vehicle with ID " + vehicleId + " could not be found";
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("vehicleId", vehicleId);
    }

}
