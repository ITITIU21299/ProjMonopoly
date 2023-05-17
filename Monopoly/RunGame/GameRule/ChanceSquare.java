package Monopoly.RunGame.GameRule;

public class ChanceSquare extends MonopolySquare{
  private CardDeck chanceCardDeck;
  private String text;
  public ChanceSquare(CardDeck chanceCardDeck) {
    this.chanceCardDeck = chanceCardDeck;
  }
  @Override
  public void doAction(Player player) {
    Card drawnCard = chanceCardDeck.drawChanceCard();
    player.useChanceCard(drawnCard);
  }
  public String getNotification(){
    return text;
  }
}
