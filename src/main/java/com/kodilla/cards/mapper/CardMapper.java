package com.kodilla.cards.mapper;

import com.kodilla.cards.domain.Card;
import com.kodilla.cards.domain.CardDto;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public Card mapToCard(final CardDto dto) {
        return new Card(dto.getId(), dto.getNumber(), dto.getType(), dto.getClientId());
    }

    public CardDto mapToCardDto(final Card card) {
        return new CardDto(card.getId(), card.getNumber(), card.getType(), card.getClientId());
    }
}
