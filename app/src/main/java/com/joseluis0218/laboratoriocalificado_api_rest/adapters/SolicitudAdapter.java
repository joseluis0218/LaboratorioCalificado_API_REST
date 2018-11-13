package com.joseluis0218.laboratoriocalificado_api_rest.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.joseluis0218.laboratoriocalificado_api_rest.R;
import com.joseluis0218.laboratoriocalificado_api_rest.models.Solicitud;
import com.joseluis0218.laboratoriocalificado_api_rest.services.ApiService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class SolicitudAdapter extends RecyclerView.Adapter<SolicitudAdapter.ViewHolder>{
    private List<Solicitud> solicitudes;
    public SolicitudAdapter(){
        this.solicitudes = new ArrayList<>();
    }

    public void setSolicitudes(List<Solicitud> solicitudes){
        this.solicitudes = solicitudes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView voucherImage;
        public TextView motivoText;
        public TextView correoText;
        public ViewHolder(View itemView){
            super(itemView);
            voucherImage = itemView.findViewById(R.id.voucher_image);
            motivoText = itemView.findViewById(R.id.motivo_text);
            correoText = itemView.findViewById(R.id.correo_text);
        }
    }

    @Override
    public SolicitudAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_solicitud, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SolicitudAdapter.ViewHolder viewHolder, int position) {
        Solicitud solicitud = this.solicitudes.get(position);

        viewHolder.motivoText.setText(solicitud.getMotivo());
        viewHolder.correoText.setText("De " + solicitud.getCorreo());
//        String url = ApiService.API_BASE_URL + "/vouchers/storages/images/" + solicitud.getVoucher();
        String url = solicitud.getVoucher();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.voucherImage);
    }

    @Override
    public int getItemCount() {
        return this.solicitudes.size();
    }
}
