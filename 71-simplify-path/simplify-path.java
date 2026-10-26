import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        List<String> directories = new ArrayList<>();

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!directories.isEmpty()) {
                    directories.remove(directories.size() - 1);
                }
            } else {
                directories.add(part);
            }
        }

        return "/" + String.join("/", directories);
    }
}