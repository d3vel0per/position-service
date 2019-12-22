package org.besties.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.besties.entity.Position;
import org.besties.entity.PositionId;
import org.besties.exception.PositionNotFoundException;
import org.besties.repository.PositionRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private PositionRepository positionRepository;

    public Query(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Iterable<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Position getPositionByKey(String accountId, String securityId) {
        PositionId positionKey = new PositionId(accountId, securityId);
        Optional<Position> optionalPosition = positionRepository.findById(positionKey);
        if (optionalPosition.isPresent()) {
            return optionalPosition.get();
        } else {
            throw new PositionNotFoundException("Position Not Found", positionKey);
        }
    }
}
