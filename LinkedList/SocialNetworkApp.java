import java.util.*;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class FriendNetwork {
    private UserNode head;

    public void addUser(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        newNode.next = head;
        head = newNode;
    }

    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = getUserById(userId1);
        UserNode user2 = getUserById(userId2);

        if (user1 != null && user2 != null && userId1 != userId2) {
            if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
            if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = getUserById(userId1);
        UserNode user2 = getUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.friendIds.remove((Integer) userId2);
            user2.friendIds.remove((Integer) userId1);
        }
    }

    public void displayFriends(int userId) {
        UserNode user = getUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + " (" + user.userId + "):");
        for (int fid : user.friendIds) {
            UserNode friend = getUserById(fid);
            if (friend != null) {
                System.out.println("- " + friend.name + " (" + friend.userId + ")");
            }
        }
    }

    public void searchUser(String query) {
        UserNode current = head;
        boolean found = false;
        while (current != null) {
            if (String.valueOf(current.userId).equals(query) || current.name.equalsIgnoreCase(query)) {
                System.out.println("Found: " + current.name + " | ID: " + current.userId + " | Age: " + current.age);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("User not found for: " + query);
    }

    public void mutualFriends(int userId1, int userId2) {
        UserNode user1 = getUserById(userId1);
        UserNode user2 = getUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        Set<Integer> set1 = new HashSet<>(user1.friendIds);
        Set<Integer> set2 = new HashSet<>(user2.friendIds);
        set1.retainAll(set2);

        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        if (set1.isEmpty()) {
            System.out.println("None");
        } else {
            for (int fid : set1) {
                UserNode friend = getUserById(fid);
                if (friend != null) {
                    System.out.println("- " + friend.name + " (" + friend.userId + ")");
                }
            }
        }
    }

    public void countAllFriends() {
        UserNode current = head;
        while (current != null) {
            System.out.println(current.name + " (" + current.userId + ") has " + current.friendIds.size() + " friends.");
            current = current.next;
        }
    }

    private UserNode getUserById(int id) {
        UserNode current = head;
        while (current != null) {
            if (current.userId == id)
                return current;
            current = current.next;
        }
        return null;
    }
}
public class SocialNetworkApp {
    public static void main(String[] args) {
        FriendNetwork network = new FriendNetwork();

        network.addUser(101, "Alice", 20);
        network.addUser(102, "Bob", 22);
        network.addUser(103, "Charlie", 21);
        network.addUser(104, "Diana", 23);

        network.addFriendConnection(101, 102);
        network.addFriendConnection(101, 103);
        network.addFriendConnection(102, 103);
        network.addFriendConnection(104, 102);

        System.out.println("\nFriend List:");
        network.displayFriends(101);
        network.displayFriends(102);

        System.out.println("\nMutual Friends:");
        network.mutualFriends(101, 102);

        System.out.println("\nUser Search:");
        network.searchUser("Charlie");

        System.out.println("\nFriend Counts:");
        network.countAllFriends();

        System.out.println("\nRemoving friendship between Bob and Charlie...");
        network.removeFriendConnection(102, 103);
        network.displayFriends(102);
    }
}
