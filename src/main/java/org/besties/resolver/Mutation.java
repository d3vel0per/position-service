package org.besties.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.besties.entity.Position;
import org.besties.entity.PositionId;
import org.besties.exception.PositionNotFoundException;
import org.besties.repository.PositionRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private PositionRepository positionRepository;

    public Mutation(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position newPosition(String accountId, String securityId, Long longQuantity, Long shortQuantity) {
        return positionRepository.save(new Position(accountId, securityId, longQuantity, shortQuantity));
    }

    public Boolean deletePosition(String accountId, String securityId) {
        boolean exists = positionRepository.existsById(new PositionId(accountId, securityId));
        if(exists) {
            positionRepository.deleteById(new PositionId(accountId, securityId));
        }
        return exists;
    }

    public Position updatePosition(String accountId, String securityId, Long longQuantity, Long shortQuantity) {
        PositionId positionKey = new PositionId(accountId, securityId);
        Optional<Position> optionalPosition = positionRepository.findById(positionKey);
        if (optionalPosition.isPresent()) {
            Position position = optionalPosition.get();
            // Set the new name and save the updated position
            position.setLongQuantity(longQuantity);
            position.setShortQuantity(shortQuantity);
            positionRepository.save(position);
            return position;
        } else {
            throw new PositionNotFoundException("Position Not Found", positionKey);
        }
    }
}
