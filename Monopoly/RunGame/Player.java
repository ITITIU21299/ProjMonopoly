package Monopoly.RunGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private String name;
  private int balance;
  private int position;
  private List<PropertySquare> ownedProperties;
  private List<Card> chanceCards;
  private List<Card> communityChestCards;

  public Player(String name, int balance, int position) {
    this.name = name;
    this.balance = balance;
    this.position = position;
    ownedProperties = new ArrayList<>();
    chanceCards = new ArrayList<>();
    communityChestCards = new ArrayList<>();
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
    int newPostion = (position - numSpaces + BOARD_SIZE) % BOARD_SIZE;
    position = newPostion;
    System.out.println(name + " moved back " + numSpaces + " spaces.");
  }

  public void purchaseProperty(PropertySquare property) {
    int propertyPrice = property.getPrice();
    if(balance >= propertyPrice){
      balance -= propertyPrice;
      property.setOwner(this);
      ownedProperties.add(property);
    }
  }
}
