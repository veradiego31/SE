/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.se.sesion;

import com.se.entidades.FormulaProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Willian
 */
@Stateless
public class FormulaProductoFacade extends AbstractFacade<FormulaProducto> implements FormulaProductoFacadeLocal {
    @PersistenceContext(unitName = "com.se_SE_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormulaProductoFacade() {
        super(FormulaProducto.class);
    }
    
}
