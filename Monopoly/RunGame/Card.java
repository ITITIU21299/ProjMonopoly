package Monopoly.RunGame;

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

  public void executeChanceAction(Player player) {
    if (text.equals("Advance to GO. Collect 200$.")) {
      player.moveToGo();
      player.addBalance(200);
    } else if (text.equals("Go Back 3 Spaces.")) {
      player.moveBack(3);
    } else if (text.equals("Speeding fine $15.")) {
      player.subtractBalance(15);
    } else if (text.equals("Get Out of Jail Free.")) {
      player.addGetOutOfJailCard(this);
    } else if (text.equals("Your building loan matures. Collect $150.")) {
      player.addBalance(150);
    }
  }
  
  public void executeCommnutityChestAction(Player player) {
    if (text.equals("Advance to GO. Collect 200$.")) {
      player.moveToGo();
      player.addBalance(200);
    }
    else if (text.equals("Bank error in your favor. Collect $200.")) {
      player.addBalance(200);
    }
    else if (text.equals("Get Out of Jail Free.")) {
      player.addGetOutOfJailCard(this);
    }
    else if (text.equals("Receive $25 consultancy fee.")) {
      player.addBalance(25);
    }
    else if (text.equals("You inherit $100.")) {
      player.addBalance(100);
    }
  }
  
  public void executeAction(Player player) {
    switch (type) {
      case CHANCE:
        executeChanceAction(player);
        break;
      case COMMUNITY_CHEST:
        executeCommnutityChestAction(player);
        break; 
    }
  }
}
