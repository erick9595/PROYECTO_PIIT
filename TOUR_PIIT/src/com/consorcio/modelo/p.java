package com.consorcio.modelo;

import java.util.List;

import com.consorcio.entidad.Enlace;

public class p {

	public static void main(String[] args) {
		List<Enlace> data=new modeloLogin().listaEnlace(1);
		for(Enlace x:data){
			System.out.println(x.getDescripcion());
		}

	}

}
