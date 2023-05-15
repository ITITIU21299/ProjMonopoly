package Monopoly.RunGame.GameRule;

public class CommunityChestSquare extends MonopolySquare{
  private CardDeck communityChestCardDeck;

  public CommunityChestSquare(CardDeck communityChestCardDeck) {
    this.communityChestCardDeck = communityChestCardDeck;
  }
  @Override
  public void doAction(Player player) {
    Card drawnCard = communityChestCardDeck.drawCommunityChestCard();
    player.useCommnutityChestCard(drawnCard);
  }
}
