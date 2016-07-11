package com.intrapractice.dao;

import java.util.Date;
import java.util.List;

import com.intrapractice.pojo.Event;

public interface EventsDao {

    public List<Event> getAllEvents();

    public Event getEventById(int id);

    public boolean createEvent(String title, String description, Date eventDate, String location, int ownerId);

    public List<Event> getEventsByOwnerId(int ownerId);

    public List<Event> getJoinedEventsByUserId(int userId);
}