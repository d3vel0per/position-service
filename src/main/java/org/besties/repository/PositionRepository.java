package org.besties.repository;

import org.besties.entity.Position;
import org.besties.entity.PositionId;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, PositionId> {
}
