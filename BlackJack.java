import java.util.Scanner;
public class BlackJack {
    public static void main(String[] args) {
        Hand dealer = new Hand();
        Hand player1 = new Hand();
        Hand player2 = new Hand();
        int player1score = 0;
        int player2score = 0;
        int dealerscore = 0;
        int roundrevolution = 0;

        boolean gameend = false;

        Deck mainDeck = new Deck();
        int dealerindex = 0;
        int player1index = 0;
        int player2index = 0;


        mainDeck.shuffle();
        /////// actual game
        dealer.addCard(mainDeck.dealCard());
        System.out.print("Dealer here is your card " + dealer.getCard(dealerindex) + "\r\n");
        dealerindex++;
        dealer.addCard(mainDeck.dealCard());
        System.out.print("Dealer here is your secret card" + "\r\n");

//        Card player1temp = mainDeck.dealCard();
//        convertTen(player1temp);
        player1.addCard(mainDeck.dealCard());
        System.out.print("Player 1 here is your card " + player1.getCard(player1index) + "\r\n");
        player1index++;
        player1.addCard(mainDeck.dealCard());
        System.out.print("Player 1 here is your card " + player1.getCard(player1index) + "\r\n");


//        player2.addCard(mainDeck.dealCard());
//        System.out.print("Player 2 here is your card " + player2.getCard(player2index) + "\r\n");
//        player2index++;
//        player2.addCard(mainDeck.dealCard());
//        System.out.print("Player 2 here is your card " + player2.getCard(player2index) + "\r\n");


        //Main Game

        while (gameend == false) {


            ///player 1 turn

            System.out.print("Player 1 would you like to hit or stand. Press 1 for hit, press 2 for stand");

            Scanner number = new Scanner(System.in);
            int cc = number.nextInt();

            switch (cc) {
                case 1: {
//                    Card temp = mainDeck.dealCard();
//                    convertTen(temp);
                    player1.addCard(mainDeck.dealCard());
                    player1index++;
                    System.out.print("Player 1 has drawn a " + player1.getCard(player1index));
                    for (int i = 0; i < player1.getCardCount(); i++) {
                        if (player1.getCard(i).getValue() > 10) {
                            player1score += 10;
                            player1index++;
                        } else {
                            player1score += player1.getCard(i).getValue();
                            player1index++;
                        }
                    }
                    System.out.println(player1score);

                    if (player1score > 21) {
                        System.out.print("Player 1 you have busted!" + "\r\n");
                    }

                    if (player1score == 21) {
                        System.out.print("Player 1 has won the game!" + "\r\n");
                        gameend = true;
                    }

                    if (gameend == true) {
                        System.exit(0);
                    }
                    break;
                }
                case 2: {
                    if (roundrevolution > 1) {
                        if (player1score > dealerscore) {
                            System.out.print("Player 1 has won the game" + "\r\n");
                            gameend = true;
                        }
                    } else {
                        System.out.print("Player 1 has decided to stand!" + "\r\n");
                    }
                    break;
                }
            }
            roundrevolution++;

            ///dealer turn


            if (roundrevolution == 1) {
                System.out.print("Dealer secret card is " + dealer.getCard(dealerindex) + "\r\n");
            }

            for (int i = 0; i < dealer.getCardCount(); i++) {
                if (dealer.getCard(i).getValue() > 10) {
                    dealerscore += 10;


                } else {
                    dealerscore += dealer.getCard(i).getValue();
                }
            }


            if (roundrevolution == 1){
                if (dealerscore <= 16) {
                    System.out.print("Dealer's hand under 16 so you must draw!" + "\r\n");
                    dealer.addCard(mainDeck.dealCard());
                    dealerindex++;
                    System.out.print("Dealer your new card is " + dealer.getCard(dealerindex));
                    dealerscore += dealer.getCard(dealerindex).getValue();
                    if (dealerscore > 21) {
                        System.out.print("Dealer you have busted so you gave twice your bet to everyone!" + "\r\n");
                        gameend = true;
                    }
                    break;
                }
            if (dealerscore >= 17) {
                System.out.print("Dealer's hand is/over 17 so you must stand!" + "\r\n");
            }

            if (gameend == true) {
                System.exit(0);
            }
            break;
        }
            else{
                System.out.print("");
            }

        }


    }
}

