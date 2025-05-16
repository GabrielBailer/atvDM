package com.ifsc.banana;

import java.util.ArrayList;

public class DAOPlanetas {
    ArrayList<Planetas> listplanetas;

    public DAOPlanetas(){
        listplanetas = new ArrayList<>();
        String[] planetas = new String[]{"Mercurio", "Venus", "Terra", "Marte", "Jupter", "Saturno", "Netuno", "Urano"};
        Integer [] fotos = new Integer[] {R.drawable.mercury, R.drawable.venus, R.drawable.earth, R.drawable.mars, R.drawable.jupter, R.drawable.saturn,
        R.drawable.neptune, R.drawable.uranus};
        for (int i=0; i<planetas.length;i++) {
            listplanetas.add(new Planetas(planetas[i],fotos[i]));
        }
    }
}
