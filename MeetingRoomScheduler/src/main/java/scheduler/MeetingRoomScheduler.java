package scheduler;

import java.util.List;
import java.util.Optional;

public class MeetingRoomScheduler {

    public static boolean canAttendAll(List<Meeting> meetings) {
        if (meetings == null || meetings.isEmpty())
            return true;

        if (meetings.size() == 1)
            return true;

        return false;
    }

    Optional<Meeting> findFirstConflict(List<Meeting> meetings) {
        return null;
    }

    int minimumRoomsRequired(List<Meeting> meetings) {
        return 0;
    }
}
