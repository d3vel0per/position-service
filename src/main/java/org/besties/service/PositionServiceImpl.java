package org.besties.service;

import org.besties.entity.Position;
import org.besties.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> getAllPositions() {
        return (List<Position>) positionRepository.findAll();
    }
}
