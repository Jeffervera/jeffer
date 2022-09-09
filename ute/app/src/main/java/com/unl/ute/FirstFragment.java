package com.unl.ute;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.unl.ute.adapters.ListaAdaptadorPersona;
import com.unl.ute.databinding.FragmentFirstBinding;
import com.unl.ute.sw.PeticionesSW;
import com.unl.ute.sw.VolleyRequest;
import com.unl.ute.sw.models.ListaPersonaJSMD;
import com.unl.ute.sw.models.PersonaJSMD;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    private ListaAdaptadorPersona listaAdaptadorPersona;
    private ListView peopleList;
    private RequestQueue requestQueue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestQueue = Volley.newRequestQueue(getContext());
        listaAdaptadorPersona = new ListaAdaptadorPersona(getContext(), new ArrayList<PersonaJSMD>());
        peopleList = view.findViewById(R.id.people_list);
        peopleList.setEmptyView(view.findViewById(R.id.people_empty_list));
        cargarPersona();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void cargarPersona(){
        VolleyRequest<ListaPersonaJSMD> peticion = PeticionesSW.getListaPersonas(getContext(), new Response.Listener<ListaPersonaJSMD>() {
            @Override
            public void onResponse(ListaPersonaJSMD response) {
                if(response.getCode() == 200){
                    listaAdaptadorPersona = new ListaAdaptadorPersona(getContext(), response.getData());
                    peopleList.setAdapter(listaAdaptadorPersona);
                }
            }
        },
        new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){ System.out.println("Error: "+ error); }
        });
        requestQueue.add(peticion);
    }
}