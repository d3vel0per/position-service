package org.besties.service;

import org.besties.entity.Position;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface PositionService {
    public List<Position> getAllPositions();
}
