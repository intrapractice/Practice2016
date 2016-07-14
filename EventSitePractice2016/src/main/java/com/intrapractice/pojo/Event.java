package com.intrapractice.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Event {

    private int id;

    private String title;

    private String description;

    private Timestamp date;
    
    private Timestamp endDate;

    private String location;

    private User owner;

    private List<User> participants;

    private int likeCount;

    private int participantsCount;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }
    
	public String getEventStatus() {
		Date eventDate = new Date(date.getTime());
		Date currentDate = new Date(System.currentTimeMillis());
		System.out.println(eventDate.toString());
		System.out.println(currentDate.toString());
		if (endDate == null) {
			if (currentDate.before(eventDate))
				return "Coming soon";
			else if (currentDate.after(eventDate))
				return "Ended";
			else
				return "In progress";
		} else {
			Date eventEndDate = new Date(endDate.getTime());
			System.out.println(eventEndDate.toString());
			if (currentDate.before(eventDate))
				return "Coming soon";
			else if (currentDate.after(eventEndDate))
				return "Ended";
			else
				return "In progress";
		}
	}
	
}