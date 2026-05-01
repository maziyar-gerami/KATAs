public class ParkingLotTestDrive {

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(2);

        lot.enter("AA123");
        lot.enter("BB456");

        System.out.println(lot.getAvailableSpots());

        int cost = lot.exit("AA123");
        System.out.println(cost);

    }

}
