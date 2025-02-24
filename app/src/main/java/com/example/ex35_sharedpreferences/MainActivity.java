package com.example.ex35_sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity is the main activity of the SharedPreferences example app.
 * It allows the user to enter a name, increase a count, reset the count,
 * and save the name and count state using SharedPreferences.
 *
 * @author Gali Lavi <gl7857@bs.amalnet.k12.il>
 * @version 1.0
 * @since 24/02/2025
 *
 * Short description:
 * This activity enables edge-to-edge display and shows a simple interface
 * that allows the user to enter a name, increase a count, reset the count,
 * and save the information before closing the app.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * EditText for entering the user's name.
     */
    private EditText etName;

    /**
     * TextView to display the current count.
     */
    private TextView tvCount;

    /**
     * SharedPreferences to store and retrieve the user's name and count.
     */
    private SharedPreferences settings;

    /**
     * Editor for modifying the SharedPreferences.
     */
    private SharedPreferences.Editor editor;

    /**
     * Integer variable to track the count.
     */
    private int count = 0;

    /**
     * String variable to store the user's name.
     */
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCount = findViewById(R.id.tvCount);
        etName = findViewById(R.id.etName);
        settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        editor = settings.edit();

        name = settings.getString("Name", "");
        count = settings.getInt("Count", 0);
        etName.setText(name);
        tvCount.setText(String.valueOf(count));
    }

    /**
     * Increments the count and updates the display when a button is clicked.
     *
     * @param view the button that was clicked
     */
    public void onCountClick(View view) {
        count++;
        tvCount.setText(String.valueOf(count));
    }

    /**
     * Resets the count to zero and updates the display when a button is clicked.
     *
     * @param view the button that was clicked
     */
    public void onResetClick(View view) {
        count = 0;
        tvCount.setText(String.valueOf(count));
    }

    /**
     * Saves the current name and count to SharedPreferences and finishes the activity.
     *
     * @param view the button that was clicked
     */
    public void onExitClick(View view) {
        editor.putString("Name", etName.getText().toString());
        editor.putInt("Count", count);
        editor.commit();
        finish();
    }

    /**
     * Creates the options menu for this activity.
     * Inflates the menu resource to display the menu items.
     *
     * @param menu the menu in which items should be added
     * @return true if the menu was successfully created, false otherwise
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.creditsmenu, menu);
        return true;
    }

    /**
     * Handles item selection from the options menu.
     * If the "menuMain" item is selected, the activity finishes and returns to the main activity.
     *
     * @param item the menu item that was selected
     * @return true if the item selection was handled, false otherwise
     */
    @Override
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuMain) {
            finish();
        }
        return true;

    }
}
