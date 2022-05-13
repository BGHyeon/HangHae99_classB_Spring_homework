package classes;

import interfaces.BusInterface;

public class Bus extends Car implements BusInterface {
	private int maxPassenger = 20;
	private int currentPassenger = 0;

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		if (this.isDrive())
			return "운행";
		else
			return "차고지행";
	}

	@Override
	public void changeState() {
		// TODO Auto-generated method stub
		if(!isDrive() && getFuelValue() < 10 ) {
			System.out.println("주유량 부족으로 운행을 할 수 없습니다.");
			return;
		}
		super.changeState();
		
	}

	@Override
	public void setFuelValue(int fuelValue) {
		// TODO Auto-generated method stub
		super.setFuelValue(fuelValue);
		if (getFuelValue() < 10) {
			System.out.println("주유가 필요합니다.");
			changeState();
		}
	}

	@Override
	public void setCurrentSpeed(int currentSpeed) {
		// TODO Auto-generated method stub
		if (getFuelValue() < 10) {
			System.out.println("주유량을 확인해 주세요.");
			return;
		}
		super.setCurrentSpeed(currentSpeed);
	}

	@Override
	public void ridePassenger(int num) {
		if (this.getCurrentPassenger() + num < 0) {
			System.out.println("최대 승객을 초과해서 탈수 없습니다.");
			System.out.println("최대 승객 : " + this.maxPassenger);
			System.out.println("현제 승객 : " + this.currentPassenger);
		} else if (!isDrive())
			System.out.println("운행을 하지 않는 상태입니다.");
		else
			this.currentPassenger += num;
	}

	@Override
	public void getOutPassenger(int num) {
		if (this.getCurrentPassenger() - num < 0) {
			System.out.println("내리는 승객 현제 승객보다 많습니다.");
			System.out.println("현제 승객 : " + this.currentPassenger);
		} else
			this.currentPassenger -= num;

	}

	public int getMaxPassenger() {
		return maxPassenger;
	}

	public void setMaxPassenger(int maxPassenger) {
		this.maxPassenger = maxPassenger;
	}

	public int getCurrentPassenger() {
		return currentPassenger;
	}

	public void setCurrentPassenger(int currentPassenger) {
		if (currentPassenger > maxPassenger) {
			System.out.println("버스가 가득 찼습니다.");
			return;
		}
		this.currentPassenger = currentPassenger;
	}

}
