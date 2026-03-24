package LinkedLists;


import java.util.*;

public class Twitter {

    private static class Tweet{
        int id;
        Tweet next;
        int time;

        public Tweet(int id,int time){
            this.id = id;
            this.time = time;
        }
    }

    private final Map<Integer, Set<Integer>> followerMap;
    private final Map<Integer, Tweet> tweetMap;
    private int time = 0;

    public Twitter() {
        this.followerMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId,time++);
        tweet.next = tweetMap.get(userId);
        tweetMap.put(userId,tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> tweets = new PriorityQueue<>((a,b)-> b.time-a.time);
        followerMap.computeIfAbsent(userId, k-> new HashSet<>()).add(userId);

        for(int followee: followerMap.get(userId)){
            Tweet tweet = tweetMap.get(followee);
            if(tweet != null) tweets.offer(tweet);
        }

        List<Integer> result = new ArrayList<>();
        while (!tweets.isEmpty() && result.size() <10){
            Tweet tweet = tweets.poll();
            result.add(tweet.id);
            if(tweet.next != null) tweets.offer(tweet.next);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        followerMap.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerMap.containsKey(followerId)){
            followerMap.get(followerId).remove(followeeId);
        }
    }
}
