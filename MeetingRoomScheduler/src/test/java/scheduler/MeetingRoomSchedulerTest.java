package scheduler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static scheduler.MeetingRoomScheduler.*;

class MeetingRoomSchedulerTest {

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("correctListProvider")
    void meetingRoomSchedular_whenMeetingListDoesntHaveConflict_thenReturnTrue(List<Meeting> meetings) {
        var result = canAttendAll(meetings);
        assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("conflictListProvider")
    void meetingRoomSchedular_whenMeetingsHaveConflicts_thenReturnFalse(List<Meeting> meetings) {
        var result = canAttendAll(meetings);
        assertFalse(result);
    }

    @ParameterizedTest
    @MethodSource("illegalMeetingsListProvider")
    void meetingRoomSchedular_whenMeetingsAreNotCorrect_thenThrowIllegalArgumentException(List<Meeting> meetings) {
        assertThrows(IllegalArgumentException.class, () -> canAttendAll(meetings));
    }

    @ParameterizedTest
    @MethodSource("countRoomsProvider")
    void countRooms_whenMeetingListHaveConflict_thenThrowIllegalArgumentException(List<Meeting> meetings, int expectedRoom) {
        var result = minimumRoomsRequired(meetings);
        assertEquals(expectedRoom, result);
    }

    @ParameterizedTest
    @MethodSource("firstConflictListProvider")
    void findFirstConflict_whenMeetingListHaveConflict_thenThrowIllegalArgumentException(List<Meeting> meetings, Meeting expectedFirstConflict) {
        var result = findFirstConflict(meetings);
        assertEquals(expectedFirstConflict, result.get());
    }

    @ParameterizedTest
    @MethodSource("correctListProvider")
    void findFirstConflict_whenThereIsNotConflicts_thenReturnOptionalEmpty(List<Meeting> meetings) {
        var result = findFirstConflict(meetings);
        assertTrue(result.isEmpty());
    }

    @Test
    void meetingRoomSchedular_whenThereIsOneMeeting_thenReturnTrue() {
        var meetings = List.of(new Meeting(1, 4));
        var result = canAttendAll(meetings);
        assertTrue(result);
    }

    public static Stream<Arguments> countRoomsProvider() {
        return Stream.of(
                Arguments.of(List.of(new Meeting(1, 2)), 1),
                Arguments.of(List.of(new Meeting(1, 2), new Meeting(2, 3)),1),
                Arguments.of(List.of(new Meeting(2, 3), new Meeting(1, 2)),1),
                Arguments.of(List.of(new Meeting(2, 3), new Meeting(1, 2), new Meeting(2,4)), 2)
        );
    }

    public static Stream<Arguments> correctListProvider() {
        return Stream.of(
                Arguments.of(List.of(new Meeting(1, 2))),
                Arguments.of(List.of(new Meeting(1, 2), new Meeting(3, 4))),
                Arguments.of(List.of(new Meeting(3, 4), new Meeting(1, 2))),
                Arguments.of(List.of(new Meeting(3, 4), new Meeting(1, 3)))
        );
    }

    public static Stream<Arguments> illegalMeetingsListProvider() {
        return Stream.of(
                Arguments.of(List.of(new Meeting(2, 1))),
                Arguments.of(List.of(new Meeting(2, 2))),
                Arguments.of(List.of(new Meeting(5, 3), new Meeting(1, 4)))
        );
    }

    public static Stream<Arguments> conflictListProvider() {
        return Stream.of(
                Arguments.of(List.of(new Meeting(1, 3), new Meeting(2, 4))),
                Arguments.of(List.of(new Meeting(2, 4), new Meeting(1, 3))),
                Arguments.of(List.of(new Meeting(1, 4), new Meeting(2, 3)))
        );
    }

    public static Stream<Arguments> firstConflictListProvider() {
        return Stream.of(
                Arguments.of(List.of(new Meeting(1, 3), new Meeting(2, 4)), new Meeting(2, 4)),
                Arguments.of(List.of(new Meeting(1, 2), new Meeting(2, 4), new Meeting(1, 3), new Meeting(5, 7)), new Meeting(1, 3))
        );
    }

}