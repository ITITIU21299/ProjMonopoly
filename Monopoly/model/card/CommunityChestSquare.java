package Monopoly.model.card;

import Monopoly.model.board.MonopolySquare;
import Monopoly.model.player.Player;

public class CommunityChestSquare extends MonopolySquare {
  private CardDeck communityChestCardDeck;
  private String text;

  public CommunityChestSquare(CardDeck communityChestCardDeck) {
    this.communityChestCardDeck = communityChestCardDeck;
  }

  @Override
  public void doAction(Player player) {
    Card drawnCard = communityChestCardDeck.drawCommunityChestCard();
    if (drawnCard == null) {
      text = "                                   Community chest is empty                                     ";
    } else if (drawnCard != null) {
      player.useCommnutityChestCard(drawnCard);
      text = player.getName() + " has drawn the card: " + drawnCard.getText();
    }
  }

  public String getNotification() {
    return text;
  }
}
