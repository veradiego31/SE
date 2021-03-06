/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.se.web;

import com.se.entidades.MateriaPrima;
import com.se.entidades.Producto;
import com.se.sesion.ProductoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Willian
 */
@Controller
public class HolaControlador {
    @EJB(mappedName = "java:global/SE/ProductoFacade")
    private ProductoFacadeLocal productoFacade;
    
    @RequestMapping(value = "/hola", method = RequestMethod.GET)
    public String hola(){
        return "hola";
    }
    
    @RequestMapping(value = "/ingresar", method = RequestMethod.GET)
    public String ingresar(@RequestParam String nombre,Model modelo){
        modelo.addAttribute("nombre", nombre);
        return "ingreso";
    }
    
    @RequestMapping(value = "/respuesta",produces = "application/json")
    @ResponseBody
    public MateriaPrima responder(){
        MateriaPrima materiaPrima = new MateriaPrima(1, "Descripcion");
        return materiaPrima;
    }
    
    @RequestMapping(value = "/listaProductos",produces = "application/json")
    @ResponseBody
    public List<Producto> listarProducto(){
        return productoFacade.findAll();
    }
    
}
