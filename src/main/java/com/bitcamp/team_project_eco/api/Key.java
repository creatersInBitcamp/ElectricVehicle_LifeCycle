package com.bitcamp.team_project_eco.api;

public enum Key {
    ACCESS_KEY, SECRET_KEY;

    @Override
    public String toString(){
        String resultKey = "";
        switch(this) {
            case ACCESS_KEY: resultKey = "AKIAJY74NGLYQPH454SQ"; break;
            case SECRET_KEY: resultKey = "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"; break;
            default: resultKey = "";
        }
        return resultKey;
    }
}
