package com.intrapractice.dao;

import java.util.List;

import com.intrapractice.pojo.Event;

public interface EventLikesDao {

    public boolean likeEvent(int eventId, int userId);

    public int getEventLikesCount(int eventId);

    public List<Integer> getEventsLikedByUser(int userId);

}
