package com.unl.ute.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.unl.ute.R;
import com.unl.ute.sw.models.PersonaJSMD;

import java.util.List;

public class ListaAdaptadorPersona extends ArrayAdapter<PersonaJSMD> {

    private Context context;
    private List<PersonaJSMD> list;
    public ListaAdaptadorPersona(Context context, List<PersonaJSMD> lista) {
        super(context, R.layout.people_item, lista);
        this.context = context;
        this.list=lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.people_item, null);
        final PersonaJSMD pPersonaJSMD = list.get(position);

        TextView txtName = item.findViewById(R.id.name);
        TextView txtLastName = item.findViewById(R.id.lastname);
        TextView txtPhone = item.findViewById(R.id.phone);
        TextView txtIdentifyDNI = item.findViewById(R.id.identifyID);
        TextView txtAddress = item.findViewById(R.id.address);

        txtName.setText(pPersonaJSMD.getNombres());
        txtLastName.setText(pPersonaJSMD.getApellidos());
        txtPhone.setText(pPersonaJSMD.getCelular());
        txtIdentifyDNI.setText(pPersonaJSMD.getIdentificacion());
        txtAddress.setText(pPersonaJSMD.getDireccion());

        return item;
    }
}
