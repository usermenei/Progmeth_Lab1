package logic;

import java.util.ArrayList;
import java.util.Objects;

public class UnitDeck {
    private ArrayList<CardCounter> cardsInDeck;
    private String deckName;

    public UnitDeck(String name){
        this.cardsInDeck = new ArrayList<CardCounter>();
        this.setDeckName(name);
    }
    public void addCard(UnitCard unitcard,int number){
        if(number>=1){
            for(CardCounter cardcount: cardsInDeck){
                if(unitcard==cardcount.getCard()){
                    cardcount.setCount(cardcount.getCount()+number);
                    return;
                }
            }
            cardsInDeck.add(new CardCounter(unitcard,number));
        }
    }
    public void removeCard(UnitCard unitcard,int number){
        if(number>=1&&this.existsInDeck(unitcard)){
            for(CardCounter cardcount: cardsInDeck){
                if(unitcard==cardcount.getCard()){
                    if(cardcount.getCount()-number<=0){
                        cardsInDeck.remove(cardcount);
                        return;
                    }
                    else{
                        cardcount.setCount(cardcount.getCount()-number);
                        return;
                    }
                }
            }
        }
    }
    public ArrayList<CardCounter> getCardsInDeck(){
        return this.cardsInDeck;
    }
    public void setCardsInDeck(ArrayList<CardCounter> arc){
        this.cardsInDeck = arc;
    }
    public String getDeckName(){
        return this.deckName;
    }
    public void setDeckName(String name){
        if(name.isBlank()){
            this.deckName = "Untitled Deck";
        }
        else{
            this.deckName = name;
        }
    }
    public int cardCount(){
        int total=0;
        for(CardCounter card:cardsInDeck){
            total = total + card.getCount();
        }
        return total;
    }
    public boolean existsInDeck(UnitCard unitcard){
        for(CardCounter card:cardsInDeck){
            if(card.getCard()==unitcard){
                return true;
            }
        }
        return false;
    }
    public boolean equals(UnitDeck unitDeck){
        if(Objects.equals(this.deckName, unitDeck.deckName)){
            return true;
        }
        return false;
    }
}
