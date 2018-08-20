package com.example.ashish.basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class BillActivity extends AppCompatActivity {

    private ProgressBar pbBill;
    private String orderId;
    private TextView tvService,tvDate,tvStatus,tvAddress,tvCgst,tvSgst,tvServicePlace,tvServiceFor
            ,tvDiscount,tvPaymentStatus,tvTotal,tvTotalTime,tvRate,tvJobAssigned;
    private ImageView ivUserBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        orderId = getIntent().getStringExtra("orderid");

        setTitle(orderId);

        pbBill = findViewById(R.id.pb_bill);

        tvDate = findViewById(R.id.tv_date_bill);
        tvService = findViewById(R.id.tv_service_bill);
        tvStatus = findViewById(R.id.tv_status_bill);
        tvAddress = findViewById(R.id.tv_address_bill);
        tvCgst = findViewById(R.id.tv_tax_cgst__bill);
        tvSgst = findViewById(R.id.tv_tax_sgst_bill);
        tvService = findViewById(R.id.tv_service_bill);
        tvServicePlace = findViewById(R.id.tv_service_place_bill);
        tvServiceFor = findViewById(R.id.tv_service_for_bill);
        tvDiscount = findViewById(R.id.tv_discount_bill);
        tvPaymentStatus = findViewById(R.id.tv_payment_status_bill);
        tvTotal = findViewById(R.id.tv_grand_total_bill);
        tvRate = findViewById(R.id.tv_rate_bill);
        tvTotalTime = findViewById(R.id.tv_total_time_bill);

        ivUserBill = findViewById(R.id.iv_user_bill);
        tvJobAssigned = findViewById(R.id.tv_job_assigned_bill);

        loadBill();

    }

    private void loadBill() {

        DatabaseReference reference = FirebaseDatabase.getInstance()
                .getReference("orders");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Order order = snapshot.getValue(Order.class);
                    if(order.getOrderid().equals(orderId)){

                        tvDate.setText(order.getDate());
                        tvStatus.setText(order.getStatus());
                        tvAddress.setText(order.getAddress());
                        tvService.setText(order.getService());
                        tvCgst.setText(order.getCgst());
                        tvSgst.setText(order.getSgst());
                        tvService.setText(order.getService());
                        tvServicePlace.setText(order.getServicePlace());
                        tvServiceFor.setText(order.getServicefor());
                        tvDiscount.setText(order.getDiscount());
                        tvPaymentStatus.setText(order.getPaymentStatus());
                        tvTotal.setText(order.getTotal());
                        tvRate.setText(order.getRate());
                        tvJobAssigned.setText(order.getJobAssigned());
                        tvTotalTime.setText(order.getTotalTime());

                        Picasso.get().load(order.getUrl()).into(ivUserBill);



                    }
                }
                pbBill.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
