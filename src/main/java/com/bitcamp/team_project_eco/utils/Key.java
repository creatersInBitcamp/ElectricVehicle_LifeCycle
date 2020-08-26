package com.bitcamp.team_project_eco.utils;

public enum Key {
    ACCESS_KEY, SECRET_KEY;

    @Override
    public String toString(){
        String resultKey = "";
        switch(this) {
            case ACCESS_KEY: resultKey = "access"; break;
            case SECRET_KEY: resultKey = "secret"; break;
        }
        return resultKey;
    }
}
