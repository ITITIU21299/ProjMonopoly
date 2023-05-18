package Monopoly.RunGame.GameRule;

public class ChanceSquare extends MonopolySquare{
  private CardDeck chanceCardDeck;
  private String text;
  
  public ChanceSquare(CardDeck chanceCardDeck) {
    this.chanceCardDeck = chanceCardDeck;
  }

  @Override
  public void doAction(Player player) {
    Card drawnCard = chanceCardDeck.drawCommunityChestCard();
    player.useCommnutityChestCard(drawnCard);
    if (drawnCard != null) {
      text = player.getName() + " has drawn the card: " + drawnCard.getText();
    }
  }
  
  public String getNotification(){
    return text;
  }
}
