/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import client.rmiclient.classes.crud.tableReflection.Column;

/**
 *
 * @author User
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableColumnComplex {
    Class clazz() default Object.class;
    Column.Complexity complexity() default Column.Complexity.COMPLEX;
 }
