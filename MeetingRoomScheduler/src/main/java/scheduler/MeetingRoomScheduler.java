package scheduler;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

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
                return Optional.of(orderedMeeting.get(i - 1));
        return Optional.empty();
    }

    static int minimumRoomsRequired(List<Meeting> meetings) {
        if (meetings == null || meetings.isEmpty())
            return 0;

        if (meetings.size() == 1)
            return 1;
        var orderedMeeting = getOrderedAndValidMeetings(meetings);

        var endings = new PriorityQueue<Integer>();
        for (int i = 0; i < orderedMeeting.size(); i++) {
            if (i > 0 && orderedMeeting.get(i).start() >= endings.peek())
                endings.poll();
            endings.add(orderedMeeting.get(i).end());
        }
        return endings.size();
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
