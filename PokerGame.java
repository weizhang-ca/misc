public enum Rank{
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
	};
public enum Suit{
	HEART, SPADE, CLUB, DIAMOND;
}
class Card{
	Suit suit;
	Rank rank;
	public Card(Rank rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
	}
	boolean compareTo(Card card){
		if(this.rank.compareTo(card.rank)<0){
			return false;
		}
		else if(this.rank == card.rank)
		{
			if(this.suit.compareTo(card.suit)<0){
				return false;
			}
		}
		return true;
	}
}
class Deck{
	private final static int TOTAL_SIZE = 52;
	private final static int RANK_SIZE = 13;
	private final static int SUIT_SIZE = 4;
	private final static int SHUFFLE_TIMES = 100;
	private Card[] cards;
	private int currentIndex = 0;
	
	public Card[] getCards(){
		return this.cards;
	}
	public void fillDeck(){
		cards = new Card[TOTAL_SIZE];
		int k = 0;
		for(Rank rank:Rank.values()){
			for(Suit suit:Suit.values()){
				Card card = new Card(rank, suit);
				cards[k++] = card;
			}
		}
		}
	}
	
	public void shuffle(){
		Random rand = new Random();
		for(int i=0; i<SHUFFLE_TIMES; i++){
			int index1 = rand.netInt(TOTAL_SIZE);
			int index2 = rand.netInt(TOTAL_SIZE);
			Card temp = cards[index1];
			cards[index1] = cards[index2];
			cards[index2] = temp;
		}
	}
	
	public Card dealCard(){
		if(currentIndex > TOTAL_SIZE){
			fillDeck();
			shuffle();
			currentIndex = 0;
			return cards[currentIndex];
		}
		return cards[currentIndex];
	}
}
class Player{
	private Cards[] myCards;
	private int size;
	public Player(int size){
		this.size =size;
		myrCards = new Cards[size];
	}
	public boolean receiveCard(Card card){
		if(myCards.length>=size){
			return false;
		}
		myCards[myCards.length] = card;
		return true;
	}
}
public class PokerGame{
	private final static PLAYER_NUM = 4;
	private Deck deck;
	private Player[] players;
	public PokerGame(){
		deck = new Deck();
		deck.fillDeck();	
		players = new Player[4];
		for(int i=0; i<PLAYER_NUM; i++){
			players[i] = new Player();
		}
	}
	
	public void Play(){
		deck.shuffle();
		for(int i=0; i<PLAYER_NUM; i++){
			players[i].receiveCard(deck.dealCard());
		}
	}
}