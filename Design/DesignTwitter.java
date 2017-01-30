/*
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
 * */

package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {

	public static void main(String[] args) {
		DesignTwitter obj = new DesignTwitter();
		List<Integer> ans;
		
		/*obj.postTweet(1, 5);
		obj.follow(1, 2);
		obj.follow(2, 1);
		ans = obj.getNewsFeed(2);
		printList(ans);
		obj.postTweet(2, 6);
		ans = obj.getNewsFeed(1);
		printList(ans);
		ans = obj.getNewsFeed(2);
		printList(ans);
		obj.unfollow(2, 1);
		ans = obj.getNewsFeed(1);
		printList(ans);
		ans = obj.getNewsFeed(2);
		printList(ans);
		obj.unfollow(1, 2);
		ans = obj.getNewsFeed(1);
		printList(ans);
		ans = obj.getNewsFeed(2);
		printList(ans);*/
		
		/*obj.postTweet(1, 1);
		ans = obj.getNewsFeed(1);
		printList(ans);
		obj.follow(2, 1);
		ans = obj.getNewsFeed(2);
		printList(ans);
		obj.unfollow(2, 1);
		ans = obj.getNewsFeed(2);
		printList(ans);*/
		
		/*obj.follow(1, 5);
		ans = obj.getNewsFeed(1);
		printList(ans);*/
		
		obj.postTweet(1, 5);
		obj.follow(1, 1);
		ans = obj.getNewsFeed(1);
		printList(ans);
	}
	
	public static void printList(List<Integer> list) {
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
    Map<Integer, User> map;
    double timeStamp;
    /** Initialize your data structure here. */
    public DesignTwitter() {
        map = new HashMap<>();
        timeStamp = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, timeStamp++);
        User temp;
        if (map.containsKey(userId)) {
            temp = map.get(userId);
        } else {
            temp = new User(userId);
        }
        
        newTweet.next = temp.head;
        temp.head = newTweet;
        map.put(userId, temp);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> answer = new ArrayList<>();
        
        if (!map.containsKey(userId)) {
            return answer;
        }
        
        Tweet tweet = null;
        User user = map.get(userId);
        int k = user.follow.size();
        int count = 10;
        PriorityQueue<Tweet> pQ = new PriorityQueue<>(k+1);
        if (user.head != null) {
        	pQ.add(user.head);
        }
        for (Integer followee : user.follow) {
        	if (map.get(followee).head != null) {
        		pQ.add(map.get(followee).head);
        	}
        }
        
        while (!pQ.isEmpty() && count > 0) {
            tweet = pQ.remove();
            answer.add(tweet.tweetId);
            if (tweet.next != null) {
                pQ.add(tweet.next);
            }
            count--;
        }
        
        return answer;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if (followerId == followeeId) {
            return;
        }
    	User temp;
    	if (map.containsKey(followerId)) {
    		temp = map.get(followerId);
    	} else {
    		temp = new User(followerId);
    		map.put(followerId, temp);
    	}
    	
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new User(followeeId));
        }
        temp.follow.add(followeeId);
        map.put(followerId, temp);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if (followerId == followeeId) {
            return;
        }
        if (map.containsKey(followerId)) {
            User temp = map.get(followerId);
            if (temp.follow.contains(followeeId)) {
                temp.follow.remove(followeeId);
                map.put(followerId, temp);
            }
        }
    }
}

class Tweet implements Comparable<Tweet> {
    int tweetId;
    Tweet next;
    double time;
    
    public Tweet(int id, double tweetTime) {
        tweetId = id;
        time = tweetTime;
    }
    
    public int compareTo(Tweet tweet) {
        if (this.time - tweet.time == 0) {
            return 0;
        } else if (this.time - tweet.time > 0) {
            return -1;
        } else {
            return 1;
        }
    }
}

class User {
    int userId;
    Set<Integer> follow;
    Tweet head;
    
    public User(int id) {
        follow = new HashSet<>();
        userId = id;
        head = null;
    }
}
