package com.example.android_lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputTaskTitle;
    private EditText inputTaskDescription;
    private Button addButton;
    private LinearLayout taskContainer;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTaskTitle = findViewById(R.id.inputTaskTitle);
        inputTaskDescription = findViewById(R.id.inputTaskDescription);
        addButton = findViewById(R.id.addButton);
        taskContainer = findViewById(R.id.taskContainer);
        scrollView = findViewById(R.id.scrollView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskTitle = inputTaskTitle.getText().toString();
                String taskDescription = inputTaskDescription.getText().toString();
                if (!taskTitle.isEmpty() && !taskDescription.isEmpty()) {
                    addTask(taskTitle, taskDescription);
                    inputTaskTitle.setText("");
                    inputTaskDescription.setText("");
                }
            }
        });
    }

    private void addTask(String title, String description) {
        View taskView = getLayoutInflater().inflate(R.layout.task_item, taskContainer, false);
        TextView taskTitleView = taskView.findViewById(R.id.taskTitle);
        TextView taskDescriptionView = taskView.findViewById(R.id.taskDescription);
        taskTitleView.setText(title);
        taskDescriptionView.setText(description);
        taskContainer.addView(taskView);

        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}