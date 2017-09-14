package com.example.dubo.mypicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import addapp.pickers.picker.DatePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPick();
            }
        });
    }

    private void openPick() {
        DatePicker picker = new DatePicker(this, DatePicker.YEAR_MONTH);
        picker.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        picker.setWidth((int) (picker.getScreenWidthPixels() * 0.6));
        picker.setRangeStart(2016, 10, 14);
        picker.setRangeEnd(2020, 11, 11);
        picker.setSelectedItem(2017, 9);
        picker.setWeightEnable(true);
        picker.setWheelModeEnable(true);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthPickListener() {
            @Override
            public void onDatePicked(String year, String month) {
                Toast.makeText(MainActivity.this,year + "-" + month,Toast.LENGTH_SHORT).show();
            }
        });
        picker.show();
        /*DateTimePicker picker = new DateTimePicker(this, DateTimePicker.HOUR_24);
        picker.setBackgroundColor(getColor(R.color.colorPrimary));
        picker.setSelectedTextColor(ContextCompat.getColor(MainActivity.this,R.color.colorAccent));
        picker.setDateRangeEnd(2050,1);
        View inflate = this.getLayoutInflater().inflate(R.layout.text, null);
        picker.setContentView(inflate);
        picker.setGravity(Gravity.CENTER);*/


        /*picker.setDateRangeStart(2017, 1, 1);
        picker.setDateRangeEnd(2025, 11, 11);
        picker.setTimeRangeStart(9, 0);
        picker.setTimeRangeEnd(20, 30);
        picker.setSelectedTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
        picker.setWeightEnable(true);
        picker.setWheelModeEnable(true);
        picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
            @Override
            public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date date = null;
                try {
                    date = formatter.parse(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (date != null) {
                    if (date.getTime() < new Date().getTime()) {
                        //DubToastUtils.showToastNew("选择的发货时间无效");
                        return;
                    }
                    //dateYMDHM = date.getTime();
                    //send_materials_times.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                }
            }
        });
        picker.show();*/
    }
}
