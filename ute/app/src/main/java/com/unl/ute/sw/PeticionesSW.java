package com.unl.ute.sw;

import android.content.Context;

import androidx.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.Response;
import com.unl.ute.sw.models.ListaPersonaJSMD;

public class PeticionesSW {

    public static String API_URL = "http://192.168.1.4:3001/api/v1/";

    public static VolleyRequest<ListaPersonaJSMD> getListaPersonas(
            @NonNull final Context context,
            @NonNull Response.Listener<ListaPersonaJSMD> response,
            @NonNull Response.ErrorListener errorListener
    ){
        String url = API_URL + "persona";
        VolleyRequest request = new VolleyRequest(
                context,
                Request.Method.GET,
                url,
                response, errorListener
        );
        request.setResponseClass(ListaPersonaJSMD.class);
        return request;
    }
}
