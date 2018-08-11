package com.blackc0.cardtext;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BlackC on 2018/06/09 1026.
 */
public class FilterRecordsActivity extends Activity {
    @BindView(R.id.filterRecordsActivity_cardView_dayType_all)
    CardText filterRecordsActivity_cardView_dayType_all;
    @BindView(R.id.filterRecordsActivity_cardView_dayType_today)
    CardText filterRecordsActivity_cardView_dayType_today;
    @BindView(R.id.filterRecordsActivity_cardView_dayType_recent_seven_day)
    CardText filterRecordsActivity_cardView_dayType_recent_seven_day;
    @BindView(R.id.filterRecordsActivity_cardView_dayType_recent_fifteen_day)
    CardText filterRecordsActivity_cardView_dayType_recent_fifteen_day;
    @BindView(R.id.filterRecordsActivity_cardView_dayType_start_time)
    CardText filterRecordsActivity_cardView_dayType_start_time;
    @BindView(R.id.filterRecordsActivity_cardView_dayType_end_time)
    CardText filterRecordsActivity_cardView_dayType_end_time;
    @BindView(R.id.filterRecordsActivity_cardView_mealType_all)
    CardText filterRecordsActivity_cardView_mealType_all;
    @BindView(R.id.filterRecordsActivity_cardView_mealType_breakfast)
    CardText filterRecordsActivity_cardView_mealType_breakfast;
    @BindView(R.id.filterRecordsActivity_cardView_mealType_lunch)
    CardText filterRecordsActivity_cardView_mealType_lunch;
    @BindView(R.id.filterRecordsActivity_cardView_mealType_dinner)
    CardText filterRecordsActivity_cardView_mealType_dinner;
    @BindView(R.id.filterRecordsActivity_cardView_mealType_supper)
    CardText filterRecordsActivity_cardView_mealType_supper;
    @BindView(R.id.filterRecordsActivity_cardView_orderType_orderMeal)
    CardText filterRecordsActivity_cardView_orderType_orderMeal;
    @BindView(R.id.filterRecordsActivity_cardView_orderType_buyMeal)
    CardText filterRecordsActivity_cardView_orderType_buyMeal;
    @BindView(R.id.filterRecordsActivity_cardView_orderType_eventMeal)
    CardText filterRecordsActivity_cardView_orderType_eventMeal;
    @BindView(R.id.filterRecordsActivity_linearLayout_verification_filter)
    LinearLayout filterRecordsActivity_linearLayout_verification_filter;
    @BindView(R.id.filterRecordsActivity_cardView_payType_all)
    CardText filterRecordsActivity_cardView_payType_all;
    @BindView(R.id.filterRecordsActivity_cardView_payType_WeChat)
    CardText filterRecordsActivity_cardView_payType_WeChat;
    @BindView(R.id.filterRecordsActivity_cardView_payType_aliPay)
    CardText filterRecordsActivity_cardView_payType_aliPay;
    @BindView(R.id.filterRecordsActivity_cardView_payType_cash)
    CardText filterRecordsActivity_cardView_payType_cash;
    @BindView(R.id.filterRecordsActivity_cardView_payType_cardBalance)
    CardText filterRecordsActivity_cardView_payType_cardBalance;
    @BindView(R.id.filterRecordsActivity_linearLayout_cashRegister_filter)
    LinearLayout filterRecordsActivity_linearLayout_cashRegister_filter;
    @BindView(R.id.filterRecordsActivity_textView_reset)
    TextView filterRecordsActivity_textView_reset;
    private ArrayList<CardText> dayTypeList;
    private ArrayList<CardText> mealTypeList;
    private ArrayList<CardText> payTypeList;
    private ArrayList<CardText> orderTypeList;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_records);
        ButterKnife.bind(this);
        setResult(RESULT_CANCELED);
        initView();
    }

    private void initView() {
        dayTypeList = new ArrayList<>();
        dayTypeList.add(filterRecordsActivity_cardView_dayType_all);
        dayTypeList.add(filterRecordsActivity_cardView_dayType_today);
        dayTypeList.add(filterRecordsActivity_cardView_dayType_recent_seven_day);
        dayTypeList.add(filterRecordsActivity_cardView_dayType_recent_fifteen_day);
        dayTypeList.add(filterRecordsActivity_cardView_dayType_start_time);
        dayTypeList.add(filterRecordsActivity_cardView_dayType_end_time);

        mealTypeList = new ArrayList<>();
        mealTypeList.add(filterRecordsActivity_cardView_mealType_all);
        mealTypeList.add(filterRecordsActivity_cardView_mealType_breakfast);
        mealTypeList.add(filterRecordsActivity_cardView_mealType_lunch);
        mealTypeList.add(filterRecordsActivity_cardView_mealType_dinner);
        mealTypeList.add(filterRecordsActivity_cardView_mealType_supper);

        orderTypeList = new ArrayList<>();
        orderTypeList.add(filterRecordsActivity_cardView_orderType_orderMeal);
        orderTypeList.add(filterRecordsActivity_cardView_orderType_buyMeal);
        orderTypeList.add(filterRecordsActivity_cardView_orderType_eventMeal);

        payTypeList = new ArrayList<>();
        payTypeList.add(filterRecordsActivity_cardView_payType_all);
        payTypeList.add(filterRecordsActivity_cardView_payType_WeChat);
        payTypeList.add(filterRecordsActivity_cardView_payType_aliPay);
        payTypeList.add(filterRecordsActivity_cardView_payType_cash);
        payTypeList.add(filterRecordsActivity_cardView_payType_cardBalance);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setListItemChecked(ArrayList<CardText> arrayList, int checkedIndex) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == checkedIndex) {
                arrayList.get(checkedIndex).setChecked(true);
                continue;
            }
            arrayList.get(i).setChecked(false);
        }
    }

}
