package Monopoly.RunGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private String name;
  private int balance;
  private int position;
  private List<PropertySquare> ownedProperties;

  public Player(String name, int balance, int position) {
    this.name = name;
    this.balance = balance;
    this.position = position;
    this.ownedProperties = new ArrayList<>();
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

  public void purchaseProperty(PropertySquare property) {
    int propertyPrice = property.getPrice();
    if(balance >= propertyPrice){
      balance -= propertyPrice;
      property.setOwner(this);
      ownedProperties.add(property);
    }
  }
}
