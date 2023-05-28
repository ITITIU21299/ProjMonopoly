package Monopoly.src;

public class ChanceSquare extends MonopolySquare{
  private CardDeck chanceCardDeck;
  private String text;
  
  public ChanceSquare(CardDeck chanceCardDeck) {
    this.chanceCardDeck = chanceCardDeck;
  }

  @Override
  public void doAction(Player player) {
    Card drawnCard = chanceCardDeck.drawCommunityChestCard();
    if (drawnCard == null){
      text = "Chance card is empty      ";
    } else
    if (drawnCard != null) {
      player.useCommnutityChestCard(drawnCard);
      text = player.getName() + " has drawn the card: " + drawnCard.getText();
    }
  }
  
  public String getNotification(){
    return text;
  }
}
