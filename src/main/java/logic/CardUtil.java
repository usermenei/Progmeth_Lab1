package logic;

import javax.smartcardio.Card;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		for(UnitCard uc:list){
			if(uc.equals(card)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		for(UnitDeck ud:list){
			if(ud.equals(deck)){
				return true;
			}
		}
		return false;

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		for(UnitDeck deck:deckList){
			for(CardCounter cc:deck.getCardsInDeck()){
				if(cc.getCard().equals(cardToTest)){
					return true;
				}
			}
		}
		return false;
	}

	public static ArrayList<UnitCard> getCardsFromFile(String filename) {

		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();
		InputStream inputStream = CardUtil.class.getClassLoader().getResourceAsStream(filename);
		if (inputStream == null) {
			System.out.println("Cannot find file!");
			return null;
		}

		Scanner myReader = new Scanner(inputStream);
		ArrayList<UnitCard> tempCards = new ArrayList<>();
		try {
			while (myReader.hasNextLine()) {

				String line = myReader.nextLine();

				ArrayList<String> list = new ArrayList<>(
						Arrays.asList(line.split("\\s*,\\s*"))
				);

				// Must have exactly 5 fields
				if (list.size() != 5) {
					throw new Exception("Invalid Format all previous valid card in this file are not added");
				}

				String name = list.get(0);
				int bloodCost = Integer.parseInt(list.get(1));
				int power = Integer.parseInt(list.get(2));
				int health = Integer.parseInt(list.get(3));
				String flavorText = list.get(4);

				UnitCard card = new UnitCard(
						name,
						bloodCost,
						power,
						health,
						flavorText
				);

				tempCards.add(card);
			}

			// Only add if everything is correct
			cardsFromFile.addAll(tempCards);

		} catch (Exception e) {
			System.out.println("Invalid Format all previous valid card in this file are not added");
			cardsFromFile.clear();
		} finally {
			myReader.close();
		}

		return cardsFromFile;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
