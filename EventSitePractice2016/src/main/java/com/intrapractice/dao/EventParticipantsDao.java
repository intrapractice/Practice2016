package com.intrapractice.dao;

import java.util.List;

import com.intrapractice.pojo.User;

public interface EventParticipantsDao {

    public boolean addParticipantForEvent(int eventId, int userId);

    public List<User> getParticipantsForEvent(int eventId);

    public int getEventParticipantsCount(int eventId);

}
