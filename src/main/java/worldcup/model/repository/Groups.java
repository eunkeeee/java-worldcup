package worldcup.model.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import worldcup.model.features.Group;
import worldcup.util.ExceptionMessage;

public class Groups {
    private static final List<Group> groups = new ArrayList<>();

    public static List<Group> groups() {
        return Collections.unmodifiableList(groups);
    }

    public static void addGroup(Group group) {
        groups.add(group);
    }

    public static void deleteAll() {
        groups.clear();
    }

    public static Group findGroupByName(String name) {
        return groups.stream()
                .filter(group -> group.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_GROUP.getMessage()));
    }
}
