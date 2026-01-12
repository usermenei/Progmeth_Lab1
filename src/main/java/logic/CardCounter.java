package logic;

public class CardCounter {
	
	private UnitCard card;
	private int count;

	public CardCounter(UnitCard unitCard,int number){
		this.setCard(unitCard);
		this.setCount(number);
	}

	public UnitCard getCard() {
		return this.card;
	}
	public void setCard(UnitCard unitCard){
		this.card = unitCard;
	}
	public int getCount() {
		return this.count;
	}
	public void setCount(int number){
		if(number<0){
			this.count=0;
		}
		else{
			this.count = number;
		}
	}
	public String toString() {
		return  this.getCard() + " x " + this.getCount();
	}

}
