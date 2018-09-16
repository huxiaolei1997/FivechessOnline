package com.example.mystery.fivechessonline.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mystery on 2018/9/16.
 */

public class ChessTable {
    private int id;
    @SerializedName("user_black")
    private String userBlack;
    @SerializedName("user_white")
    private String userWhite;
    @SerializedName("last_check")
    private String lastCheck;
    @SerializedName("game_id")
    private int gameId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserBlack() {
        return userBlack;
    }

    public void setUserBlack(String userBlack) {
        this.userBlack = userBlack;
    }

    public String getUserWhite() {
        return userWhite;
    }

    public void setUserWhite(String userWhite) {
        this.userWhite = userWhite;
    }

    public String getLastCheck() {
        return lastCheck;
    }

    public void setLastCheck(String lastCheck) {
        this.lastCheck = lastCheck;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", userBlack: '" + userBlack + '\'' +
                ", userWhite: '" + userWhite + '\'' +
                ", lastCheck: '" + lastCheck + '\'' +
                ", gameId: " + gameId +
                '}';
    }
}
