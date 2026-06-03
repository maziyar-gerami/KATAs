package scheduler;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MeetingRoomScheduler {

    public static boolean canAttendAll(List<Meeting> meetings) {
        if (meetings == null) return true;
        var orderedMeeting = getOrderedAndValidMeetings(meetings);

        if (meetings.isEmpty() || meetings.size() == 1)
            return true;

        for (int i = 1; i < orderedMeeting.size(); i++)
            if (orderedMeeting.get(i).start() < orderedMeeting.get(i - 1).end())
                return false;

        return true;
    }

    public static Optional<Meeting> findFirstConflict(List<Meeting> meetings) {
        if (meetings.isEmpty() || meetings.size() == 1)
            return Optional.empty();

        var orderedMeeting = getOrderedAndValidMeetings(meetings);

        for (int i = 1; i < orderedMeeting.size(); i++)
            if (orderedMeeting.get(i).start() < orderedMeeting.get(i - 1).end())
                return Optional.of(orderedMeeting.get(i));
        return Optional.empty();
    }

    static int minimumRoomsRequired(List<Meeting> meetings) {
        int rooms = 1;
        if (meetings.isEmpty() || meetings.size() == 1)
            return rooms;

        var orderedMeeting = getOrderedAndValidMeetings(meetings);

        for (int i = 1; i < orderedMeeting.size(); i++)
            if (orderedMeeting.get(i).start() < orderedMeeting.get(i - 1).end())
                rooms++;

        return rooms;
    }

    private static Meeting validateMeeting(Meeting m) {
        if (m.start() >= m.end())
            throw new IllegalArgumentException();
        return m;
    }

    public static class MeetingComparator implements Comparator<Meeting> {

        @Override
        public int compare(Meeting m1, Meeting m2) {
            return Comparator.comparingInt(Meeting::start)
                    .compare(m1, m2);
        }
    }

    private static List<Meeting> getOrderedAndValidMeetings(List<Meeting> meetings) {
        return meetings.stream()
                .map(MeetingRoomScheduler::validateMeeting)
                .sorted(new MeetingComparator())
                .toList();
    }
}
