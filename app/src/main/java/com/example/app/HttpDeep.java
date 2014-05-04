package com.example.app;


import com.loopj.android.http.*;

import java.util.ArrayList;

/**
 * Created by curtis on 5/3/14.
 */

public class HttpDeep {

    AsyncHttpClient client = null;
    String BASE_URL = "http://deep.kenaddison.com/";
    String COOKIE = "";

    public HttpDeep() {
        client = new AsyncHttpClient();
    }

    public void setCOOKIE(String cookie) {
        COOKIE = cookie;
    }

    public void register(String dId, String uName, String pass, AsyncHttpResponseHandler asyncHandler) {
        RequestParams params = new RequestParams();
        params.put("deviceId", dId);
        params.put("username", uName);
        params.put("password", pass);

        doRequest(params, "register/", asyncHandler);
    }

    public void login(String dId, String uName, String pass, AsyncHttpResponseHandler asyncHandler) {
        RequestParams params = new RequestParams();
        params.put("deviceId", dId);
        params.put("username", uName);
        params.put("password", pass);

        doRequest(params, "login/", asyncHandler);

    }

    public void createGame(ArrayList<String> users, AsyncHttpResponseHandler asyncHandler) {
        RequestParams params = new RequestParams();
        params.put("players", arrayListToString(users));
        params.put ("cookie", COOKIE);

        doRequest(params, "game/", asyncHandler);
    }

    public void joinGame(String gameId, AsyncHttpResponseHandler asyncHandler) {
        RequestParams params = new RequestParams();
        params.put("cookie", COOKIE);

        doRequest(params, "game/" + gameId + "/join/", asyncHandler);
    }

    public void inviteToGame(String gameId, ArrayList<String> users, AsyncHttpResponseHandler asyncHandler) {
        RequestParams params = new RequestParams();
        params.put("players", arrayListToString(users));
        params.put("cookie", COOKIE);

        doRequest(params, "game/" + gameId + "/invite/", asyncHandler);
    }

    public void befriend(String friendId, AsyncHttpResponseHandler asyncHandler) {
        RequestParams params = new RequestParams();
        params.put("cookie", COOKIE);

        doRequest(params, "friend/" + friendId, asyncHandler);
    }

    public void doRequest(RequestParams params, String url, AsyncHttpResponseHandler handler) {
        params.put("cookie", COOKIE);
        client.post(BASE_URL + url, params, handler);

    }

    private String arrayListToString(ArrayList <String> list) {
        String string = "";
        if (list != null) {
            for (String s : list) {
                string += s;
            }
        }

        return string;
    }
}
