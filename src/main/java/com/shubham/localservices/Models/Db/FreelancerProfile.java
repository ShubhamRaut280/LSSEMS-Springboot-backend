package com.shubham.localservices.Models.Db;

import jakarta.persistence.*;

@Entity
@Table(name = "freelancer_profiles")
public class FreelancerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private int userid;

    private String bio;
    private String skills; // Can be stored as a JSON string
    private Double hourlyRate;


    private Double rating;
    private Integer reviewsCount;


    public FreelancerProfile(Long profileId, User user, int userid, String bio, String skills, Double hourlyRate, Double rating, Integer reviewsCount) {
        this.profileId = profileId;
        this.user = user;
        this.userid = userid;
        this.bio = bio;
        this.skills = skills;
        this.hourlyRate = hourlyRate;
        this.rating = rating;
        this.reviewsCount = reviewsCount;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
    }
}
