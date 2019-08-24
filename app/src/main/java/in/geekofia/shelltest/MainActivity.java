package in.geekofia.shelltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mResult;
    EditText mTerminal;
    Button mExecute;
    String mCommand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTerminal = findViewById(R.id.command_input);
        mExecute = findViewById(R.id.execute_button);
        mResult = findViewById(R.id.shell_output);

        mExecute.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.execute_button:
                ShellExecuter exe = new ShellExecuter();
                mCommand = mTerminal.getText().toString();

                String output = exe.executer(mCommand);
                mResult.setText(output);
                Log.d("Output", output);
        }
    }
}
