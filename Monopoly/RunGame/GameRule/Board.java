package Monopoly.RunGame.GameRule;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Monopoly.RunGame.GameRule.PropertySquare.Color;

public class Board {
  public static final int JAIL_POSITION = 10;
  private List<MonopolySquare> squares;
  private int currentPlayerPosition;
  private CardDeck communityChestCardDeck;
  private CardDeck chanceCardDeck;
  private int newPostion;
  

  public Board() {
    squares = new ArrayList<>();
    currentPlayerPosition = 0;
    chanceCardDeck = new CardDeck();
    communityChestCardDeck = new CardDeck();

    squares.add(new GoSquare());
    squares.add(new PropertySquare("MEDITERRANEAN AVENUE", 60, Color.BROWN));
    squares.add(new CommunityChestSquare(communityChestCardDeck));
    squares.add(new PropertySquare("BALTIC AVENUE", 60, Color.BROWN));
    squares.add(new IncomeTaxSquare());
    squares.add(new RailroadSquare("READING RAILROAD"));
    squares.add(new PropertySquare("ORIENTAL AVENUE", 100, Color.LIGHT_BLUE));
    squares.add(new ChanceSquare(chanceCardDeck));
    squares.add(new PropertySquare("VERMONT AVENUE", 100, Color.LIGHT_BLUE));
    squares.add(new PropertySquare("CONNECTICUT AVENUE", 120, Color.LIGHT_BLUE));
    squares.add(new JailSquare());
    squares.add(new PropertySquare("ST. CHARLES PLACE", 140, Color.PINK));
    squares.add(new ElectricCompanySquare("ELECTRIC COMPANY", 150));
    squares.add(new PropertySquare("STATES AVENUE", 140, Color.PINK));
    squares.add(new PropertySquare("VIRGINIA AVENUE", 160, Color.PINK));
    squares.add(new RailroadSquare("PENNSYLVANIA RAILROAD"));
    squares.add(new PropertySquare("ST. JAMES PLACE", 180, Color.ORANGE));
    squares.add(new CommunityChestSquare(communityChestCardDeck));
    squares.add(new PropertySquare("TENNESSEE AVENUE", 180, Color.ORANGE));
    squares.add(new PropertySquare("NEWYORK AVENUE", 200, Color.ORANGE));
    squares.add(new FreeParkingSquare());
    squares.add(new PropertySquare("MARVIN GARDENS", 280, Color.YELLOW));
    squares.add(new WaterWorksSquare("Water Works", 150));
    squares.add(new PropertySquare("VENTNOR AVENUE", 260, Color.YELLOW));
    squares.add(new PropertySquare("ATLANTIC AVENUE", 260, Color.YELLOW));
    squares.add(new RailroadSquare("B & O RAILROAD"));
    squares.add(new PropertySquare("ILLUNOIS AVENUE", 240, Color.RED));
    squares.add(new PropertySquare("ATLANTIC AVENUE", 220, Color.RED));
    squares.add(new ChanceSquare(chanceCardDeck));
    squares.add(new PropertySquare("KENTUCKY AVENUE", 220, Color.RED));
    squares.add(new GoToJailSquare());
    squares.add(new PropertySquare("PACIFIC AVENUE", 300, Color.GREEN));
    squares.add(new PropertySquare("NORTH CAROLINA AVENUE", 300, Color.GREEN));
    squares.add(new CommunityChestSquare(communityChestCardDeck));
    squares.add(new PropertySquare("PENNSYLVANIA AVENUE", 320, Color.GREEN));
    squares.add(new RailroadSquare("SHORT LINE RAILROAD"));
    squares.add(new ChanceSquare(chanceCardDeck));
    squares.add(new PropertySquare("PARK PLACE", 350, Color.DARK_BLUE));
    squares.add(new LuxuryTaxSquare());
    squares.add(new PropertySquare("BOARDWALK", 400, Color.DARK_BLUE));
  }

  public void movePlayer(Player player, int steps) {
    int currentPosition = player.getPosition();
    int boardSize = squares.size();

    newPostion = (currentPosition + steps) % boardSize;

    if (newPostion < currentPosition) {
      player.addBalance(200);
    }

    player.setPosition(newPostion);
    MonopolySquare currentSquare = squares.get(newPostion);
    currentSquare.doAction(player);
  }
  public String Notify(){
    MonopolySquare currentSquare = squares.get(newPostion);
    return currentSquare.getNotification();
  }
}
