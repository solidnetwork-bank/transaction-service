package xyz.solidnetwork.service.card;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CardService {

    public CardWrapper listAllCards() {
        CardWrapper message = new CardWrapper();

        List<Card> cards = new ArrayList<>();
        cards.add(new Card("11", 1122));
        cards.add(new Card("22", 2233));
        cards.add(new Card("33", 3344));
        cards.add(new Card("44", 4455));

        message.setCards(cards);

        return message;
    }

}
