package dtos;

public class CreateParkingLotRequestDto {
    String address;
    int numberOfFloors;
    int numberOfEntry;
    int numberOfExit;
    String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfEntry() {
        return numberOfEntry;
    }

    public void setNumberOfEntry(int numberOfEntry) {
        this.numberOfEntry = numberOfEntry;
    }

    public int getNumberOfExit() {
        return numberOfExit;
    }

    public void setNumberOfExit(int numberOfExit) {
        this.numberOfExit = numberOfExit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
