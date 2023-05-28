package Monopoly.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Player {
  private String name;
  private int balance;
  private int prevposition;
  private int position;
  private String token;
  private List<PropertySquare> ownedProperties;
  private List<Card> chanceCards;
  private List<Card> communityChestCards;
  private ArrayList<Card> getOutOfJailCards;
  private boolean inJail;
  private int diceResult;
  private int jailRollCount;
  public boolean hasRolledDouble;
  private Color color;
  private int index;
  private boolean chanceCardGO;
  private boolean jailcheck;
  private int numberofturn = 0;
  private boolean bankrupted;
  private boolean isBankrupted;

  public Player() {
  }

  public Player(String name, int balance, int position, String token, Color color, int index) {
    this.name = name;
    this.balance = balance;
    this.position = position;
    this.token = token;
    this.color = color;
    this.index = index;
    getOutOfJailCards = new ArrayList<>();
    ownedProperties = new ArrayList<>();
    chanceCards = new ArrayList<>();
    communityChestCards = new ArrayList<>();
    inJail = false;
    jailRollCount = 0;
    hasRolledDouble = false;
  }

  public String getToken() {
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

  public int getPrevPosition() {
    return prevposition;
  }

  public Color getColor() {
    return color;
  }

  public int getIndex() {
    return index;
  }

  public void removeOwnedProperties() {
    ownedProperties = null;
  }

  public boolean getBankrupted() {
    return bankrupted;
  }

  public void setBankrupted(boolean bankrupted) {
    this.bankrupted = bankrupted;
  }

  public void setIsBankrupted(boolean isBankrupted) {
    this.isBankrupted = isBankrupted;
  }

  public boolean getIsBankrupted() {
    return isBankrupted;
  }

  public List<PropertySquare> getOwnedProperties() {
    return ownedProperties;
  }

  public void setOwnedProperties(List<PropertySquare> ownedProperties) {
    this.ownedProperties = ownedProperties;
  }

  public List<Card> getChanceCards() {
    return chanceCards;
  }

  public List<Card> getCommuityChestCards() {
    return communityChestCards;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void setPosition(int newPosition) {
    setPrevPosition(this.position);
    this.position = newPosition;
  }

  public void setPrevPosition(int position) {
    prevposition = position;
  }

  public void addChanceCard(Card card) {
    chanceCards.add(card);
    if (card.getText() == "Get Out of Jail Free.") {
      addGetOutOfJailCard(card);
    }
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
    int currentPosition = getPosition();
    int goPosition = 0;
    int distance = goPosition - currentPosition;
    balance += 200;
    move(distance);
  }

  public void move(int distance) {
    int currentPosition = getPosition();
    int boardSize = 40;
    int newPostion = (currentPosition + distance) % boardSize;
    setPosition(newPostion);
  }

  public void moveBack(int numSpaces) {
    int currentPosition = getPosition();
    int newPosition = (currentPosition - numSpaces + 40) % 40;
    setPosition(newPosition);
  }

  public void addGetOutOfJailCard(Card card) {
    getOutOfJailCards.add(card);
  }

  public boolean hasGetOutOfJailCard() {
    return !getOutOfJailCards.isEmpty();
  }

  public void setJailRollCount(int count) {
    jailRollCount = count;
  }

  public int getJailRollCount() {
    return jailRollCount;
  }

  public void increaseJailRollCount() {
    jailRollCount++;
  }

  public void useGetOutOfJailCard() {
    if (!getOutOfJailCards.isEmpty()) {
      getOutOfJailCards.remove(0);
      releaseFromJail();
    }
  }

  public boolean hasRolledDouble() {
    return hasRolledDouble;
  }

  public void setHasRollDouble(boolean rollDouble) {
    hasRolledDouble = rollDouble;
  }

  public void setchanceCardGO(boolean chanceCardGO) {
    this.chanceCardGO = chanceCardGO;
  }

  public void moveToGoChaneCard() {
    setchanceCardGO(false);
    position = 0;
    chanceCardGO = true;
  }

  public boolean getchanceCardGO() {
    return chanceCardGO;
  }

  public boolean JailCheck() {
    return jailcheck;
  }

  public void setJailCheck(boolean jailcheck) {
    this.jailcheck = jailcheck;
  }

  public void addNumberofTurn() {
    numberofturn++;
  }

  public int getNumberofTurn() {
    return numberofturn;
  }

  public void useChanceCard(Card card) {
    if (card.getType() == Card.CardType.CHANCE) {
      String cardText = card.getText();
      if (cardText.equals("Advance to GO. Collect 200$.")) {
        moveToGoChaneCard();
        addBalance(200);
      } else if (cardText.equals("Bank pays you dividend of $50.")) {
        addBalance(50);
      } else if (cardText.equals("Speeding fine $15.")) {
        subtractBalance(15);
      } else if (cardText.equals("Get Out of Jail.")) {
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
        moveToGoChaneCard();
        addBalance(200);
      } else if (cardText.equals("Bank error in your favor. Collect $200.")) {
        addBalance(200);
      } else if (cardText.equals("Get Out of Jail.")) {
        addGetOutOfJailCard(card);
      } else if (cardText.equals("Receive $25 consultancy fee.")) {
        addBalance(25);
      } else if (cardText.equals("You inherit $100.")) {
        addBalance(100);
      }
    }
  }

  public void purchaseProperty(PropertySquare property) {
    int propertyPrice = property.getPrice();
    subtractBalance(propertyPrice);
    property.setOwner(this);
    ownedProperties.add(property);

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
    return diceResult;
  }

  public void setRollDice(int result1, int result2) {
    this.diceResult = result1 + result2;
    setHasRollDouble(result1 == result2);
  }

  public boolean isInJail() {
    return inJail;
  }

  public void setInJail(boolean inJail) {
    this.inJail = inJail;
    if (inJail == true)
      toJail();
  }

  public void toJail() {
    int tmp = prevposition;
    this.setPosition(10);
    this.setPrevPosition(tmp);
  }

  public void releaseFromJail() {
    setInJail(false);
    setJailRollCount(0);
  }
}
