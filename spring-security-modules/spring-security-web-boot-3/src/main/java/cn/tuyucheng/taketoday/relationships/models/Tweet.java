package cn.tuyucheng.taketoday.relationships.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tweet")
public class Tweet {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private long id;

   private String tweet;

   private String owner;

   @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
   @CollectionTable(name = "Tweet_Likes")
   private Set<String> likes = new HashSet<>();

   public Tweet() {
   }

   public Tweet(String tweet, String owner) {
      this.tweet = tweet;
      this.owner = owner;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getTweet() {
      return tweet;
   }

   public void setTweet(String tweet) {
      this.tweet = tweet;
   }

   public String getOwner() {
      return owner;
   }

   public void setOwner(String owner) {
      this.owner = owner;
   }

   public Set<String> getLikes() {
      return likes;
   }

   public void setLikes(Set<String> likes) {
      this.likes = likes;
   }
}