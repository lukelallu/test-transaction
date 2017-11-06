package org.tran.poc.poc.util;

import org.tran.poc.poc.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Utility {
    private static final Logger slf4jLogger = LoggerFactory.getLogger(MQListener.class);

    public static String callAccounts(User user) {
        String output =null;
        try {
            slf4jLogger.info("Request - " +user.toString());
            String urlString = "http://localhost:8080/test-rest/account/from/" + user.getFrom() + "/to/" + user.getTo() + "/amount/" + user.getAmount() + "/when/now";
            slf4jLogger.info("urlString - " +urlString);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            slf4jLogger.info("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                slf4jLogger.info(output);
                return output;
            }
            conn.disconnect();
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return output;
    }
}
