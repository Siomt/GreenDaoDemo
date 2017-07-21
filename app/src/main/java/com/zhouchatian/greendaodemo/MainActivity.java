package com.zhouchatian.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhouchatian.greendaodemo.db.User;
import com.zhouchatian.greendaodemo.db.UserDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    UserDao mUserDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
    }

    private void seach(int page){
        QueryBuilder qb = mUserDao.queryBuilder();
        qb.where(UserDao.Properties.Name.eq(""));
        qb.and(UserDao.Properties.Name.eq(""),UserDao.Properties.Name.eq(""));
//        qb.orderAsc(AnnounDaoBeanDao.Properties.NoticeCreatTime);//从小到大
        qb.orderDesc(UserDao.Properties.Id);//从大到小
        qb.offset(page*10);
        qb.limit(10);
        qb.build();
        List<User> list = qb.list();
    }
}
