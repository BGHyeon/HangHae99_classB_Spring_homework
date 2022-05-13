package classes;

import interfaces.TexiInterface;

public class Texi extends Car implements TexiInterface {
	private int distanceFee = 500;
	private int defaultDistance = 2;
	private String destination = null;
	private int destinationDistance = 0;
	
	
	
	@Override
	public void changeState() {
		// TODO Auto-generated method stub
		super.changeState();
		if(isDrive() && !destination.equals(null)) {
			System.out.println("승객이 아직 탑승한 상태입니다.");
		}else {
			setDrive(!isDrive());
		}
	}
	
	
	@Override
	public String getState() {
		if(isDrive()) {
			return "일반";
		}else
			return "탑승 불가";
	}


	@Override
	public int calculateFee() {
		int fee = 0;
		if(!isDrive())
			System.out.println("승객이 없습니다.");
		else if(destination.equals(null))
			System.out.println("목적지를 설정하지 않았습니다.");
		else {
			if(destinationDistance <= defaultDistance) {
				fee = getFee();
			}else {
				fee = getFee() + ((destinationDistance-defaultDistance) * this.distanceFee);
			}
		}
		
		return fee;
	}


	@Override
	public void passengerOut() {
		this.destination = null;
		this.destinationDistance = 0 ;
		changeState();
		
	}


	public int getDistanceFee() {
		return distanceFee;
	}


	public void setDistanceFee(int distanceFee) {
		this.distanceFee = distanceFee;
	}


	public int getDefaultDistance() {
		return defaultDistance;
	}


	public void setDefaultDistance(int defaultDistance) {
		this.defaultDistance = defaultDistance;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public int getDestinationDistance() {
		return destinationDistance;
	}


	public void setDestinationDistance(int destinationDistance) {
		this.destinationDistance = destinationDistance;
	}
}
