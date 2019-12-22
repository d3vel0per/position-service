package org.besties.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.besties.entity.PositionId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public PositionNotFoundException(String message, PositionId positionId) {
        super(message);
        extensions.put("invalid position key", positionId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
}
