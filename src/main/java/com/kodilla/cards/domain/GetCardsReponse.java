package com.kodilla.cards.domain;

import lombok.Data;

import java.util.List;

@Data
public class GetCardsReponse {

    private List<CardDto> cards;

    public GetCardsReponse(List<CardDto> cards) {
        this.cards = cards;
    }
}
