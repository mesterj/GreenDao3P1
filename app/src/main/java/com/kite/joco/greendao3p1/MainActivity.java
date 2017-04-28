package com.kite.joco.greendao3p1;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.kite.joco.greendao3p1.entity.DaoSession;
import com.kite.joco.greendao3p1.entity.Person;
import com.kite.joco.greendao3p1.entity.PersonDao;

import org.greenrobot.greendao.query.Query;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etPersonName ;
    DatePicker dtPersonSzulIdo;
    PersonDao personDao;
    private static String LOGTAG = "MainActi";
    Query<Person> allPersonQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPersonName = (EditText) findViewById(R.id.etPersonName);
        dtPersonSzulIdo = (DatePicker) findViewById(R.id.dtPersonBorn);
        DaoSession daoSession = ((PersonApp)getApplication()).getDaoSession();
        personDao = daoSession.getPersonDao();
    }

    public void onClick(View v) {
        String nev = etPersonName.getText().toString();
        int ev = dtPersonSzulIdo.getYear()+1;
        int ho = dtPersonSzulIdo.getMonth();
        int nap = dtPersonSzulIdo.getDayOfMonth();

        Date szulido = new Date(ev,ho,nap);

        Person p = new Person();
        p.setName(nev);
        p.setSzuldate(szulido);
        personDao.save(p);
        Log.i(LOGTAG,"Név: "+ p.getName() + " saved.");
        Log.i(LOGTAG,"List of saved names: ");
        allPersonQuery = personDao.queryBuilder().orderAsc(PersonDao.Properties.Name).build();
        List<Person> personList = allPersonQuery.list();
        for (Person person: personList){
            Log.i(LOGTAG,"Név: "+ person.getName() + " szülidő: " + person.getSzuldate());
        }
    }
}
