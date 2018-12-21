package com.example.toshiba.iiitdmjparking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    /*private DatabaseReference rootdatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference childreference = rootdatabase.child("Slots");
*/
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference rootdatabase = firebaseDatabase.getReference();
    private DatabaseReference childreference = rootdatabase.child("Slots");

    public TextView lhtc1,lhtc2,hall1,nr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "onCreate: YES");

        //childreference.addValueEventListener(this);

        lhtc1 = (TextView) findViewById(R.id.editText2);
        lhtc2 = (TextView) findViewById(R.id.editText3);
        hall1 = (TextView) findViewById(R.id.editText4);
        nr = (TextView) findViewById(R.id.editText5) ;

        childreference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
             /*   for(DataSnapshot ds : dataSnapshot.getChildren()){
                    int l1slot1= ds.child("lhtc1").child("slot1").getValue(Integer.class);
                    int l1slot2= ds.child("lhtc1").child("slot2").getValue(Integer.class);
                    int l2slot1= ds.child("lhtc2").child("slot1").getValue(Integer.class);  */

                   int l1slot1 = dataSnapshot.child("lhtc1").child("slot1").getValue(Integer.class);
                   int l1slot2 = dataSnapshot.child("lhtc1").child("slot2").getValue(Integer.class);
                   int l2slot1 = dataSnapshot.child("lhtc2").child("slot1").getValue(Integer.class);
                   int lhtc1_nos = dataSnapshot.child("lhtc1").child("nos").getValue(Integer.class);
                   int lhtc2_nos = dataSnapshot.child("lhtc2").child("nos").getValue(Integer.class);
                   Log.d("TAG", "onvaluereceival: "+ l1slot1 + l1slot2 + l2slot1);
                   lhtc1.setText(Integer.toString(l1slot1+l1slot2)+"/"+Integer.toString(lhtc1_nos));
                   lhtc2.setText(Integer.toString(l2slot1)+"/"+Integer.toString(lhtc2_nos));
                   hall1.setText("NA");
                   nr.setText("NA");


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.w("TAG", "Failed to read value.");
             //   Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG).show();


            }
        });

    }
}
