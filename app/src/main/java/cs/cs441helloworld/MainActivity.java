package cs.cs441helloworld;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
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
        final TextView tv = findViewById(R.id.text_view);
        //custom message text handle
        final TextView tv2 = findViewById(R.id.customtext);

        //floating action button bottom right of app
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You clicked the floating action button!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //left FAB to decrease text size
        FloatingActionButton fabL = findViewById(R.id.fabL);
        fabL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,10);
            }
        });
        //right FAB to increase text size
        FloatingActionButton fabR = findViewById(R.id.fabR);
        fabR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
            }
        });

        //empty button that changes to 'Hello World!'
        final Button button = findViewById(R.id.my_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setText("Hello World!");
            }
        });

        //toggle button to change text display
        ToggleButton toggle = findViewById(R.id.my_toggle);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tv.setText("Hello World!");
                } else {
                    tv.setText("Goodbye World!");
                }
            }
        });

        //button for edit text widget
        final Button input_button = findViewById(R.id.inputbutton);
        input_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = findViewById(R.id.textinput);
                String input = et.getText().toString();
                tv2.setText("Hello " + input + "!");
            }
        });

        configureNextButton();
    }

    private void configureNextButton() {
        Button nextButton = findViewById(R.id.nextbutton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setExitTransition(new Fade());
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });
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
