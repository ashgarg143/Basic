package com.example.ashish.basic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{


    private Context context;
    private List<Order> orderList;

    public OrderAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Order order = orderList.get(position);

        holder.tvDate.setText(order.getDate());
        holder.tvOrderId.setText(order.getOrderid());
        holder.tvService.setText(order.getService());
        holder.tvStatus.setText(order.getStatus());

        String url = order.getUrl();

        Picasso.get().load(url).into(holder.ivUserOrder);

        holder.cvOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,BillActivity.class);
                intent.putExtra("orderid",order.getOrderid());
                Activity activity = (Activity)context;
                activity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDate,tvOrderId,tvService,tvStatus;
        private CardView cvOrder;
        private ImageView ivUserOrder;

        public ViewHolder(View itemView) {
            super(itemView);


            tvDate = itemView.findViewById(R.id.tv_date_order);
            tvOrderId = itemView.findViewById(R.id.tv_order_id_order);
            tvService = itemView.findViewById(R.id.tv_service_order);
            tvStatus = itemView.findViewById(R.id.tv_status_order);
            cvOrder = itemView.findViewById(R.id.cv_order);
            ivUserOrder = itemView.findViewById(R.id.iv_user_order);
        }
    }
}
