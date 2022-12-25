package HW_6;

public class Store {

    public String name;
    public String address;
    public String workingDays;
    public Integer[] workingHours;

    public Store(String name, String address, String workingDays, Integer[] workingHours) {
        this.name = name;
        this.address = address;
        this.workingDays = workingDays;
        this.workingHours = workingHours;
    }

    public void showWorkingHours() {
        String openTime = String.format("c %d:%d до %d:%d.", workingHours[0],
                workingHours[1], workingHours[2], workingHours[3]);
        System.out.println("Часы работы магазина:\n" +
                workingDays + "\n"+
                openTime);
    }

    @Override
    public String toString() {
        return String.format("Магазин \"%s\" по адресу %s", name, address);
    }
}
