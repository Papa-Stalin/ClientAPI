package cat.yoink.clientapi.friend;

import java.util.ArrayList;

public class FriendManager
{
    private final ArrayList<Friend> friends = new ArrayList<>();

    public void removeFriend(String name)
    {
        friends.stream().filter(friend -> friend.getName().equalsIgnoreCase(name)).forEach(friends::remove);
    }

    public void addFriend(String name)
    {
        friends.add(new Friend(name));
    }

    public ArrayList<Friend> getFriends()
    {
        return friends;
    }
}
