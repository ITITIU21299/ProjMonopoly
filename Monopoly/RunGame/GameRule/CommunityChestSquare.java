package Monopoly.RunGame.GameRule;

public class CommunityChestSquare extends MonopolySquare{
  private CardDeck communityChestCardDeck;
  private String text;
  public CommunityChestSquare(CardDeck communityChestCardDeck) {
    this.communityChestCardDeck = communityChestCardDeck;
  }
  @Override
  public void doAction(Player player) {
    Card drawnCard = communityChestCardDeck.drawCommunityChestCard();
    player.useCommnutityChestCard(drawnCard);
  }
  public String getNotification(){
    return text;
  }
}
