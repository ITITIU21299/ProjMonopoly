public interface MonopolySquare {
  public String getName();

  public String getType();

  public int getRent();

  public boolean isOwned();

  public Player getOwner();

  public void setOwner(Player player);

  public void landOn(Player player);
}
