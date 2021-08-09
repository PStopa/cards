package com.kodilla.cards.repository;

import com.kodilla.cards.domain.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CardsRepository extends CrudRepository<Card, Long> {

    List<Card> findByClientId(Long clientId);
}
