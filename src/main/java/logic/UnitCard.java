package logic;

import java.util.Objects;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public UnitCard(String name,int bloodCost,int power, int health, String flavorText){
		this.setName(name);
		this.setBloodCost(bloodCost);
		this.setPower(power);
		this.setHealth(health);
		this.setFlavorText(flavorText);
	}
	public int attack(UnitCard unitCard){
		return 0;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		if(name.isBlank()){
			this.name = "Creature";
		}
		else{
			this.name = name;
		}
	}
	public int getBloodCost(){
		return this.bloodCost;
	}
	public void setBloodCost(int bloodCost){
		if(bloodCost<0){
			this.bloodCost = 0;
		}
		else{
			this.bloodCost = bloodCost;
		}
	}
	public int getPower(){
		return this.power;
	}
	public void setPower(int power){
		if(power<0){
			this.power = 0;
		}
		else{
			this.power = power;
		}
	}
	public int getHealth(){
		return this.health;
	}
	public void setHealth(int health){
		if(health<1){
			this.health = 1;
		}
		else{
			this.health = health;
		}
	}
	public String getFlavorText(){
		return this.flavorText;
	}
	public void setFlavorText(String flavorText){
		this.flavorText = flavorText;
	}
	public boolean equals(UnitCard unitCard){
		return (Objects.equals(this.name, unitCard.getName()));
	}
	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
}
