package Monopoly.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDeck {
  private List<Card> chanceCards;
  private List<Card> communityChestCards;
  private Random random;

  public CardDeck() {
    chanceCards = new ArrayList<>();
    communityChestCards = new ArrayList<>();
    random = new Random();

    chanceCards.add(new Card("Advance to GO. Collect 200$.", Card.CardType.CHANCE));
    chanceCards.add(new Card("Go Back 3 Spaces.", Card.CardType.CHANCE));
    chanceCards.add(new Card("Speeding fine $15.", Card.CardType.CHANCE));
    chanceCards.add(new Card("Get Out of Jail Free.", Card.CardType.CHANCE));
    chanceCards.add(new Card("Your building loan matures. Collect $150.", Card.CardType.CHANCE));

    communityChestCards.add(new Card("Advance to GO. Collect 200$.", Card.CardType.COMMUNITY_CHEST));
    communityChestCards.add(new Card("Bank error in your favor. Collect $200.", Card.CardType.COMMUNITY_CHEST));
    communityChestCards.add(new Card("Get Out of Jail Free.", Card.CardType.COMMUNITY_CHEST));
    communityChestCards.add(new Card("Receive $25 consultancy fee.", Card.CardType.COMMUNITY_CHEST));
    communityChestCards.add(new Card("You inherit $100.", Card.CardType.COMMUNITY_CHEST));
  }

  public Card drawChanceCard() {
    if (!chanceCards.isEmpty()) {
      int randomIndex = random.nextInt(chanceCards.size());
      Card drawnCard = chanceCards.remove(randomIndex);
      return drawnCard;
    } else {
      return null;
    }
  }
  
  public Card drawCommunityChestCard() {
    if (!communityChestCards.isEmpty()) {
      int randomIndex = random.nextInt(communityChestCards.size());
      Card drawnCard = communityChestCards.remove(randomIndex);
      return drawnCard;
    }
    else {
      return null;
    }
  }
}
