package services;

import models.Department;
import models.Tag;

import java.util.HashMap;

public class TagService {
    private static  TagService tagServiceInstance = null;
    private HashMap<String, Tag> tagHashMap = new HashMap<String, Tag>();

    private TagService() {
        this.tagHashMap = new HashMap<String, Tag>();
    }

    public Tag getOrCreateDepartment(String tag) {
        if(!this.tagHashMap.containsKey(tag)) {
            this.tagHashMap.put(tag, new Tag(tag));
        }
        return this.tagHashMap.get(tag);
    }

    public static TagService getInstance() {
        if(tagServiceInstance == null) {
            tagServiceInstance = new TagService();
        }
        return tagServiceInstance;
    }
}
