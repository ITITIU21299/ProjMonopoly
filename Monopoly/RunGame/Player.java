package Monopoly.RunGame;

public class Player {
  private String name;
  private int balance;
  private int position;


  public Player(String name, int balance, int position) {
    this.name = name;
    this.balance = balance;
    this.position = position;
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
}
