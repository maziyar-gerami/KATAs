import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    int capacity;
    int availableSpots;
    Map<String, LocalDateTime> lotHashMap = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableSpots = capacity;
    }

    public boolean enter(String plateNumber) {
        if (availableSpots < 1)
            throw new IllegalStateException("Available spots not found");
        lotHashMap.put(plateNumber, LocalDateTime.now());
        availableSpots -= 1;
        return true;
    }

    public int exit(String plateNumber) {
        if (!lotHashMap.containsKey(plateNumber))
            throw new IllegalStateException("Car not found");
        availableSpots += 1;
        var enterTime = lotHashMap.get(plateNumber);
        lotHashMap.remove(plateNumber);

        Duration duration = Duration.between(enterTime, LocalDateTime.now());
        int hours = (int) Math.max(1, duration.toHours());
        return hours * 5;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

}
