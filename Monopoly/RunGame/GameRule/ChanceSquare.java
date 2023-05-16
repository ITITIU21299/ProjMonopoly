package Monopoly.RunGame.GameRule;

public class ChanceSquare extends MonopolySquare{
  private CardDeck chanceCardDeck;

  public ChanceSquare(CardDeck chanceCardDeck) {
    this.chanceCardDeck = chanceCardDeck;
  }
  @Override
  public String doAction(Player player) {
    Card drawnCard = chanceCardDeck.drawChanceCard();
    player.useChanceCard(drawnCard);
  }
}
