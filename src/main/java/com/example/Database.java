package com.example;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Note> noteList = new ArrayList<>();
    private static Database database = new Database();

    private Database(){

    }

    public static Database getInstance() {
        return database;
    }

    public List<Note> getList() {
        return noteList;
    }
}
