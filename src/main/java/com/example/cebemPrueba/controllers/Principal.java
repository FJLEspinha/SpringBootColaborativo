package com.example.cebemPrueba.controllers;

import java.util.ArrayList;
import java.util.Map;

import com.example.cebemPrueba.models.Dato;
import com.example.cebemPrueba.models.Translate;
import com.example.cebemPrueba.services.DatoService;
import com.example.cebemPrueba.services.TranslateService;
import com.example.cebemPrueba.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Principal {

    @Autowired
  TranslateService translateService;
  @Autowired
  DatoService datoService;

    @GetMapping("/contarvocales/{frase}")
    public String count(@PathVariable String frase) {
        String resultado = Utils.count(frase);
        return resultado;
    }

    @GetMapping("/transformarbinario/{frase}")
    public String transforToBinary(@PathVariable String frase) {
        String resultado = Utils.convertTextToBinary(frase);
        return resultado;
    }

    // http://localhost:8080/traduce/

    @GetMapping("/traduce/{segment}")
    public String getTranslateText(@PathVariable String segment) {

      Translate t = translateService.getTranslateFromAPI(segment);
        return " traducido es: " + t.responseData.translatedText;
   }

    // http://localhost:8080/guarda?DATO1=XXXX&DATO2=YYYY&DATO3=ZZZZ&DATON=NNNN
    @PostMapping("/insertardatos")
    public String addDato(@RequestParam Map<String, String> body) {
        String datoText = body.get("text");
        datoText.replaceAll("<", "");
        datoText.replaceAll(">", "");
        Dato dato = new Dato();
        dato.setText(datoText);
        datoService.saveDato(dato);
        return "Frase insertada";
    }

    @GetMapping("/listardatos")
    public String DatoList() {
        ArrayList<Dato> datos = datoService.getAllDatos();
        String listado = "";
        for (Dato dato : datos) {
            listado += dato.getText();

            listado += "<br/>";
        }
        return listado;
        
    }

}
