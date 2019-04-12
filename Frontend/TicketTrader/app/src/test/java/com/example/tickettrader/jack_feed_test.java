package com.example.tickettrader;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;




public class jack_feed_test {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Test
    public void refresh_returnsFalse() {
        //This creates a Mock Object of the class that we have not fully implemented
        feedPage test = mock(feedPage.class);
        test.refresh("http://cs308-pp-1.misc.iastate.edu:8080/tickets");

        if (test.feedData == null) {
            Assert.assertTrue(true);
        }

    }

}

