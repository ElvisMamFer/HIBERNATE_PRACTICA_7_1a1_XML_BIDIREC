/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educomser.entity.dao;

import com.educomser.entity.Direccion;
import java.util.List;

public interface DireccionDao {
    
    public void create(Direccion direccion);
    public void update(Direccion direccion);
    public void delete(Direccion direccion);
    public Direccion findById(int id);
    public List<Direccion> getAll();
}
