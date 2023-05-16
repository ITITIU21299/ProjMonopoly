package Monopoly.RunGame.GameRule;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private String name;
  private int balance;
  private int position;
  private String token;
  private List<PropertySquare> ownedProperties;
  private List<Card> chanceCards;
  private List<Card> communityChestCards;
  private ArrayList<Card> getOutOfJailCards;
  private boolean inJail;

  public Player(String name, int balance, int position, String token) {
    this.name = name;
    this.balance = balance;
    this.position = position;
    this.token = token;
    ownedProperties = new ArrayList<>();
    chanceCards = new ArrayList<>();
    communityChestCards = new ArrayList<>();
    inJail = false;
  }

  public String getToken(){
    return token;
  }

  public String getName() {
    return name;
  }

  public int getBalance() {
    return balance;
  }

  public int getPosition() {
    return position;
  }

  public List<PropertySquare> getOwnedProperties() {
    return ownedProperties;
  }

  public List<Card> getChanceCards(){
    return chanceCards;
  }

  public List<Card> getCommuityChestCards() {
    return communityChestCards;
  }

  public void setOwnedProperties(List<PropertySquare> ownedProperties) {
    this.ownedProperties = ownedProperties;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public void addChanceCard(Card card) {
    chanceCards.add(card);
  }

  public void addCommunityChestCard(Card card) {
    communityChestCards.add(card);
  }

  public void addBalance(int amount) {
    balance += amount;
  }

  public void subtractBalance(int amount) {
    balance -= amount;
  }

  public void payRentTo(Player owner, int amount) {
    balance -= amount;
    owner.addBalance(amount);
  }

  public void moveToGo() {
    position = 0;
    balance += 200;
    System.out.println(name + " go to GO and collectd 200$");
  }

  public void moveBack(int numSpaces) {
    int newPostion = (position - numSpaces + 40) % 40;
    position = newPostion;
    System.out.println(name + " moved back " + numSpaces + " spaces.");
  }

  public void addGetOutOfJailCard(Card card) {
    getOutOfJailCards.add(card);
  }

  public void useChanceCard(Card card) {
    if (card.getType() == Card.CardType.CHANCE) {
      String cardText = card.getText();
      if (cardText.equals("Advance to GO. Collect 200$.")) {
        moveToGo();
        addBalance(200);
      } else if (cardText.equals("Go Back 3 Spaces.")) {
        moveBack(3);
      } else if (cardText.equals("Speeding fine $15.")) {
        subtractBalance(15);
      } else if (cardText.equals("Get Out of Jail Free.")) {
        addGetOutOfJailCard(card);
      } else if (cardText.equals("Your building loan matures. Collect $150.")) {
        addBalance(150);
      }
    }
  }

  public void useCommnutityChestCard(Card card) {
    if (card.getType() == Card.CardType.COMMUNITY_CHEST) {
      String cardText = card.getText();
      if (cardText.equals("Advance to GO. Collect 200$.")) {
        moveToGo();
        addBalance(200);
      }
      else if (cardText.equals("Bank error in your favor. Collect $200.")) {
        addBalance(200);
      }
      else if (cardText.equals("Get Out of Jail Free.")) {
        addGetOutOfJailCard(card);
      }
      else if (cardText.equals("Receive $25 consultancy fee.")) {
        addBalance(25);
      }
      else if (cardText.equals("You inherit $100.")) {
        addBalance(100);
      }
    }
  }

  public void purchaseProperty(PropertySquare property) {
    int propertyPrice = property.getPrice();
    if (balance >= propertyPrice) {
      balance -= propertyPrice;
      property.setOwner(this);
      ownedProperties.add(property);
    }
  }
  
  public int getRailroadCount() {
    int railroadCount = 0;
    for (PropertySquare property : ownedProperties) {
      if (property instanceof RailroadSquare) {
        railroadCount++;
      }
    }
    return railroadCount;
  }
<<<<<<< HEAD
=======

  public boolean ownsMonopolyInColorGroup(PropertySquare.Color color) {
    List<PropertySquare> propertiesInColorGroup = getPropertiesInColorGroup(color);
    int ownedProperties = 0;
    for (PropertySquare property : propertiesInColorGroup) {
      if (property.getOwner() == this) {
        ownedProperties++;
      }
    }
    return ownedProperties == propertiesInColorGroup.size();
  }

  private List<PropertySquare> getPropertiesInColorGroup(PropertySquare.Color color) {
    List<PropertySquare> propertiesInColorGroup = new ArrayList<>();
    for (PropertySquare property : ownedProperties) {
      if (property.getColor() == color) {
        propertiesInColorGroup.add(property);
      }
    }
    return propertiesInColorGroup;
  }

  public void buyRailroad(RailroadSquare railroad) {
    if (railroad.getOwner() != null) {
      System.out.println("Railroad is already owned by another player.");
      return;
    }

    int price = railroad.getPrice();
    if (getBalance() >= price) {
      balance -= price;
      railroad.setOwner(this);
      ownedProperties.add(railroad);
      System.out.println(name + " has bought " + railroad.getName());
    } else {
      System.out.println("Insuffiecient balance to buy " + railroad.getName());
    }
  }
  
  public int getRollDice() {
    Dice dice = new Dice();

    return dice.getResult();
  }

  public boolean isInJail() {
    return inJail;
  }
  
  public void setInJail(boolean inJail) {
    this.inJail = inJail;
  }
>>>>>>> 76e6f718bdb99301d447ff2b539d0523003517f8
}
