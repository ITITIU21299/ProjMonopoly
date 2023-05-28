package Monopoly.src;

public class Card {
  private String text;

  public enum CardType {
    CHANCE,
    COMMUNITY_CHEST
  }

  private CardType type;

  public Card(String text, CardType type) {
    this.text = text;
    this.type = type;
  }

  public String getText() {
    return text;
  }

  public CardType getType() {
    return type;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setType(CardType type) {
    this.type = type;
  }
}
