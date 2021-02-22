package ru.netology.manager;

import java.util.*;

public class FileOpenManager {
    private Map<String, String> hashMap = new HashMap<>();

    public void add(String ext, String app) {
        hashMap.put(ext.toLowerCase(), app);
    }

    public Map<String, String > getAll() {
        return hashMap;
    }

    public List<String> getAllSortedExt(){
        List<String> list = new ArrayList<>(hashMap.keySet());
        Collections.sort(list);
        return list;
    }

    public List<String> getAllSortedApp(){
        List<String> list = new ArrayList<>(hashMap.values());
        Collections.sort(list);
        return list;
    }

    public String findAppByExt(String ext) {
        return hashMap.get(ext.toLowerCase());
    }

    public String deleteExt(String ext) {
        return hashMap.remove(ext.toLowerCase());
    }
}
