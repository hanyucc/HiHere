package io.github.leniumc.hihere;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import agency.tango.android.avatarview.loader.PicassoLoader;
import agency.tango.android.avatarview.views.AvatarView;

public class PostActivity extends AppCompatActivity {

    public AvatarView avatarView;
    public TextView nameTextView, gradeTextView, descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Intent intent = getIntent();
        PostData postData = intent.getExtras().getParcelable("everything");

        avatarView = findViewById(R.id.avatar_view_post);
        nameTextView = findViewById(R.id.name_text_view);
        gradeTextView = findViewById(R.id.grade_text_view);
        descriptionTextView = findViewById(R.id.description_text_view);
        PicassoLoader imageLoader = new PicassoLoader();

        if (postData != null) {
            imageLoader.loadImage(avatarView, postData.getAvatarImageUrl(),
                    postData.getUserName());
            nameTextView.setText(postData.getUserName());
            gradeTextView.setText(postData.getUserGrade());
            descriptionTextView.setText(postData.getPostDescription());
        }
    }

    public void exitActivity(View view) {
        finish();
    }

}
