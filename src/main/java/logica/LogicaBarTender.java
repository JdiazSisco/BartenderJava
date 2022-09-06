/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.VasoDAO;
import domain.Vaso;
import java.util.*;

/**
 *
 * @author user
 */
public class LogicaBarTender {

    private ArrayList<Integer> respuestaFinal = new ArrayList<>();
    private int arregloPrimos[] = {2, 3, 5, 6, 11, 13, 17};

    /**
     *
     * @param ciclo Cantidad de veces iteraciones que se van a realizar
     * @param idArray posicion del registro a utilizar de la base de datos
     */
    public void ordenarDatos(int ciclo, int idArray) {

        int contador = 0;
        ArrayList<Integer> arregloVasos = new ArrayList<>();
        arregloVasos = creaListaVasos(idArray);

        do {
            arregloVasos = recorrerArreglo(arregloVasos, contador);
            contador++;
        } while (contador < ciclo);

        if (!arregloVasos.isEmpty()) {
            agregarResiduales(arregloVasos);
        }
        imprimirRespuestafinal();

    }

    /**
     * Metodo que se comunica con la capa de datos para consultar la tabla de
     * arrays
     *
     * @param idArray fila a consultar
     * @return
     */
    private String consultaDatos(int idArray) {
        VasoDAO vasoDAO = new VasoDAO();
        String inputArray = vasoDAO.consultaVasos(idArray);
        return inputArray;
    }

    /**
     * Metodo que crea una lista apartir de los datos devueltos desde la
     * consulta a la base de datos
     *
     * @param idArray fila a consultar
     * @return
     */
    private ArrayList<Integer> creaListaVasos(int idArray) {

        String inputArray = consultaDatos(idArray);
        String[] partesInputArray = inputArray.split(",");
        ArrayList<Integer> listadoArray = new ArrayList<>();

        for (String parte : partesInputArray) {
            listadoArray.add(Integer.parseInt(parte));
        }

        return listadoArray;
    }

    /**
     * Metodo que recorre el arreglo y lo compara contra la posicion X en el
     * arreglo de numeros primos para determinar su residuo
     *
     * @param arreglo Arreglo a recorrer
     * @param iteracion Iteraccion actual
     * @return Devuelve una lista con los numeros que no pudieron ser dividos en
     * en el numero primo actual
     */
    public ArrayList<Integer> recorrerArreglo(ArrayList<Integer> arreglo, int iteracion) {

        ArrayList<Integer> arrayA = new ArrayList<>();
        ArrayList<Integer> arrayB = new ArrayList<>();
        String respuestaA = "";
        String respuestaB = "";
        String respuestaR = "";
        System.out.println("Q" + (iteracion + 1));

        for (int i = 0; i < arreglo.size(); i++) {
            if (arreglo.get(i) % arregloPrimos[iteracion] == 0) {
                arrayB.add(arreglo.get(i));
                respuestaFinal.add(arreglo.get(i));
                respuestaB = respuestaB + "," + arreglo.get(i);
            } else {
                arrayA.add(arreglo.get(i));
                respuestaA = respuestaA + "," + arreglo.get(i);
            }
        }

        System.out.println("B" + (iteracion + 1) + ": " + respuestaB);
        System.out.println("A" + (iteracion + 1) + ": " + respuestaA);

        for (Integer valorR : respuestaFinal) {
            respuestaR = respuestaR + "," + valorR;
        }

        System.out.println("Respuesta" + (iteracion + 1) + ": " + respuestaR);
        return arrayA;
    }

    /**
     * Metodo que imprime el resultado final
     */
    private void imprimirRespuestafinal() {
        String respuesta = "";
        for (Integer valorR : respuestaFinal) {
            //System.out.println(valorR);
            respuesta = respuesta + "," +valorR;
        }

        System.out.println("Respuesta final: " + respuesta);
    }

    /**
     * Metodo que agrega los valores que pudieron sobrar al arreglo final
     *
     * @param arreglo
     */
    public void agregarResiduales(List<Integer> arreglo) {
        for (int i = 0; i < arreglo.size(); i++) {
            respuestaFinal.add(arreglo.get(i));
        }
    }
}
