package com.kodilla.cards.service;

import com.kodilla.cards.domain.Card;
import com.kodilla.cards.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsService {

    @Autowired
    private CardsRepository repository;

    public List<Card> getCardsByClinetId(Long clientId) {
        return repository.findByClientId(clientId);
    }
}
