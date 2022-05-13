package classes;
import java.util.UUID;

abstract class Car {
	private int currentSpeed= 0;
	private String CarNumber = "";
	private int fuelValue = 100 ;
	private boolean isDrive = true;
	private int fee = 1000;
	public Car(){
		this.CarNumber = UUID.randomUUID().toString();
	}
	
	public void changeState() {
		this.isDrive = !isDrive;
	}
	abstract String getState();

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
		if(!isDrive && this.currentSpeed > 0) {
			changeState();
		}
	}

	public String getCarNumber() {
		return CarNumber;
	}

	public void setCarNumber(String carNumber) {
		CarNumber = carNumber;
	}

	public int getFuelValue() {
		return fuelValue;
	}

	public void setFuelValue(int fuelValue) {
		this.fuelValue = fuelValue;
	}

	public boolean isDrive() {
		return isDrive;
	}

	public void setDrive(boolean isDrive) {
		this.isDrive = isDrive;
	}

	public int getFee() {
		return this.fee;
	}

	public void setFee(int currentFee) {
		this.fee = currentFee;
	}

}
