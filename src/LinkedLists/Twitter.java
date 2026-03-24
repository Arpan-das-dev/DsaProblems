package LinkedLists;

import java.util.*;

/**
 * Utility class implementing simplified Twitter with feed functionality (NeetCode 150 sheet).
 *
 * <p>LeetCode 355: Design Twitter supporting postTweet, getNewsFeed (top 10 recent), follow/unfollow.
 * News feed = user's + followed users' tweets, newest first.</p>
 *
 * <p><b>Approach:</b> LinkedList Tweets + MaxHeap Merge</p>
 * <ul>
 *   <li>Tweets: doubly-linked per user (newest first)</li>
 *   <li>Feed: max-heap merges followees' recent tweets</li>
 *   <li>Heap stores {time, tweet} for top-10 extraction</li>
 * </ul>
 *
 * <p>{@code @code Time: post=O(1), feed=O(fk log f), f=followees, k=10}<p>
 *
 * @author Arpan Das
 * @since 24/03/2026
 * <p><b>Part of {@code NeetCode 150}</b></p>
 */

public class Twitter {

    /** Tweet node with linked list for user timeline. */
    private static class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private final Map<Integer, Set<Integer>> followers;  // user → followed users
    private final Map<Integer, Tweet> userTweets;       // user → newest tweet
    private int globalTime;

    /** Initialize Twitter. */
    public Twitter() {
        this.followers = new HashMap<>();
        this.userTweets = new HashMap<>();
        this.globalTime = 0;
    }

    /**
     * Compose new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, globalTime++);
        tweet.next = userTweets.get(userId);
        userTweets.put(userId, tweet);
    }

    /**
     * Retrieve 10 most recent tweets from user + followees.
     *
     * <p>Max-heap merges most recent tweets from each followed user.</p>
     *
     * <p><b>Examples:</b></p>
     * <pre>
     * postTweet(1,5) → getNewsFeed(1) → [5]
     * follow(1,2), postTweet(2,6) → getNewsFeed(1) → [6,5]
     * unfollow(1,2) → getNewsFeed(1) → [5]
     * </pre>
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
                (a, b) -> b.time - a.time  // Max-heap by time
        );

        // Include self + followees
        Set<Integer> followed = followers.getOrDefault(userId, new HashSet<>());
        followed.add(userId);

        // Add most recent tweet from each
        for (int followee : followed) {
            Tweet recent = userTweets.get(followee);
            if (recent != null) {
                maxHeap.offer(recent);
            }
        }

        List<Integer> feed = new ArrayList<>();
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            Tweet tweet = maxHeap.poll();
            feed.add(tweet.id);

            // Add next tweet from same user
            if (tweet.next != null) {
                maxHeap.offer(tweet.next);
            }
        }
        return feed;
    }

    /** Follower follows followee. */
    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    /** Follower unfollows followee. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followed = followers.get(followerId);
        if (followed != null) {
            followed.remove(followeeId);
        }
    }
}
