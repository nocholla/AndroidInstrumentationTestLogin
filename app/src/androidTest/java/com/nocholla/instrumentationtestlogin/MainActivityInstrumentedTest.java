package com.nocholla.instrumentationtestlogin;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import android.widget.EditText;

public class MainActivityInstrumentedTest {

    MainActivity mActivity;
    private EditText username;
    private EditText password;

    protected void setUp() throws Exception {
        username = mActivity.findViewById(R.id.username);
        password = mActivity.findViewById(R.id.password);
    }

    public void testPreconditions() {
        assertNotNull(username);
        assertNotNull(password);
    }

    public void testText() {
        assertEquals("edureka", username.getText());
        assertEquals("edureka123\"", password.getText());
    }

}
