package scheduler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomSchedulerTest {

    @ParameterizedTest
    @NullAndEmptySource
    void meetingRoomSchedular_whenListIsNullOrEmpty_thenReturnTrue(List<Meeting> meetings){
        var result = MeetingRoomScheduler.canAttendAll(meetings);
        assertTrue(result);
    }

    @Test
    void meetingRoomSchedular_whenThereIsOneMeeting_thenReturnTrue(){
        var meetings = List.of(new Meeting(1, 4));
        var result = MeetingRoomScheduler.canAttendAll(meetings);
        assertTrue(result);
    }

}