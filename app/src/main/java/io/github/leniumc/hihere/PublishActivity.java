package io.github.leniumc.hihere;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class PublishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu_publish, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.send) {
            EditText titleEditText = findViewById(R.id.title_edit_text);
            EditText descriptionEditText = findViewById(R.id.description_edit_text);
            String title = titleEditText.getText().toString();
            String description = descriptionEditText.getText().toString();

            publishPost(title, description);
        }
        return super.onOptionsItemSelected(item);
    }

    public void exitActivity(View view) {
        finish();
    }

    public void publishPost(String title, String description) {
        // TODO: finish this
    }
}
