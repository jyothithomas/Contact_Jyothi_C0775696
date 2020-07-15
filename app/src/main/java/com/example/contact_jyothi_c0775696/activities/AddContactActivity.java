package com.example.contact_jyothi_c0775696.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.contact_jyothi_c0775696.R;
import com.example.contact_jyothi_c0775696.database.ContactDataBase;
import com.example.contact_jyothi_c0775696.model.Contact;

public class AddContactActivity extends AppCompatActivity {

    EditText fname, lname, address, phone;
    Button addPerson;

    Contact editPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_contact);

        fname = findViewById( R.id.text_fname );
        lname = findViewById( R.id.text_lname );
        address = findViewById( R.id.text_address );
        phone = findViewById( R.id.text_phone );
        addPerson = findViewById( R.id.button_submit );
        editPerson = getIntent().getParcelableExtra( "contact" );

        addPerson.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fnameString = fname.getText().toString();
                String lnameString = lname.getText().toString();
                String addressString = address.getText().toString();
                String phoneString = phone.getText().toString();
                ContactDataBase personDB = ContactDataBase.getInstance( v.getContext() );
                if (editPerson != null)
                {
                    editPerson.setFirstname( fnameString );
                    editPerson.setLastname( lnameString );
                    editPerson.setAddress( addressString );
                    editPerson.setPhone( phoneString );
                    personDB.daoObject().update( editPerson );

                }
                else {
                    Contact contact = new Contact( fnameString, lnameString, addressString, phoneString );
                    personDB.daoObject().insert( contact );
                }

                finish();
            }
        } );

        if (editPerson != null)
        {
            fname.setText( editPerson.getFirstname() );
            lname.setText( editPerson.getLastname() );
            address.setText( editPerson.getAddress() );
            phone.setText( editPerson.getPhone() );

        }
    }
}