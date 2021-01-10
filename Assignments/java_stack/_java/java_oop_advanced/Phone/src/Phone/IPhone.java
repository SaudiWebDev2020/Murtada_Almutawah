package Phone;

public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        // your code here
    	return String.format("iPhone %s says %s",this.getVersionNumber(),this.getRingTone());
    }
    @Override
    public String unlock() {
        // your code here
    	return "Unlocking via facial recognition";
    }
    @Override
    public void displayInfo() {
        // your code here
    	System.out.println(String.format("iPhone %s from %s",this.getVersionNumber(),this.getCarrier()));
    }
}