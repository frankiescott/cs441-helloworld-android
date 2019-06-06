package cs.cs441helloworld;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.util.TypedValue;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Hello World! text handle
        final TextView helloWorld = findViewById(R.id.helloWorld);
        //custom message text handle
        final TextView sayHelloTo = findViewById(R.id.sayHelloTo);

        //floating action button bottom right of app
        FloatingActionButton fabSnackBar = findViewById(R.id.fabSnackbar);
        fabSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You clicked the floating action button!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //left FAB to decrease text size
        FloatingActionButton fabL = findViewById(R.id.fabDecreaseTextSize);
        fabL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helloWorld.setTextSize(TypedValue.COMPLEX_UNIT_DIP,10);
            }
        });
        //right FAB to increase text size
        FloatingActionButton fabR = findViewById(R.id.fabIncreaseTextSize);
        fabR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helloWorld.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
            }
        });

        //empty button that changes to 'Hello World!'
        final Button helloWorldButton = findViewById(R.id.helloWorldButton);
        helloWorldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helloWorldButton.setText("Hello World!");
            }
        });

        //toggle button to change text display
        ToggleButton toggle = findViewById(R.id.helloGoodbyeToggle);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    helloWorld.setText("Hello World!");
                } else {
                    helloWorld.setText("Goodbye World!");
                }
            }
        });

        //button for edit text widget
        final Button input_button = findViewById(R.id.sayHelloButton);
        input_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = findViewById(R.id.sayHelloToInput);
                String input = et.getText().toString();
                sayHelloTo.setText("Hello " + input + "!");
            }
        });

        //button to switch to next activity
        configureNextButton();
    }

    private void configureNextButton() {
        Button nextButton = findViewById(R.id.nextActivity);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setExitTransition(new Fade());
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        TextView touchText = findViewById(R.id.touchText);
        touchText.setText("X: " + x + " Y: " + y);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
