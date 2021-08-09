package com.kodilla.cards.controller;

import com.kodilla.cards.domain.Card;
import com.kodilla.cards.domain.CardDto;
import com.kodilla.cards.domain.GetCardsReponse;
import com.kodilla.cards.mapper.CardMapper;
import com.kodilla.cards.service.CardsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
@RequiredArgsConstructor
public class CardsController {
    private final CardMapper mapper;
    private final CardsService service;

    @GetMapping("/cards")
    public GetCardsReponse getCards(@RequestParam(required = true) Long customerId) {
        log.info("Get cards for customerId: {}", customerId);
        List<Card> cards = service.getCardsByClinetId(customerId);
        List<CardDto> cardDtos = cards.stream()
                .map(mapper::mapToCardDto)
                .collect(Collectors.toList());
        return new GetCardsReponse(cardDtos);
    }
}
