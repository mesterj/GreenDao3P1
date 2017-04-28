package com.kite.joco.greendao3p1;

import android.app.Application;

import com.kite.joco.greendao3p1.entity.DaoMaster;
import com.kite.joco.greendao3p1.entity.DaoSession;

import org.greenrobot.greendao.database.Database;

import static com.kite.joco.greendao3p1.entity.DaoMaster.*;

/**
 * Created by Mester József on 2017. 01. 09..
 */

public class PersonApp extends Application {

    private DaoSession daoSession;

    public PersonApp() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DevOpenHelper  devOpenHelper = new DevOpenHelper(this,"persons-db");
        Database db = devOpenHelper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
