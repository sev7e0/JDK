/*
 * %W% %E%
 * 
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.jmx.mbeanserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Util {
    static <K, V> Map<K, V> newMap() {
        return new HashMap<K, V>();
    }
    
    static <K, V> Map<K, V> newSynchronizedMap() {
        return Collections.synchronizedMap(Util.<K, V>newMap());
    }
    
    static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap<K, V>();
    }
    
    static <K, V> Map<K, V> newSynchronizedIdentityHashMap() {
        Map<K, V> map = newIdentityHashMap();
        return Collections.synchronizedMap(map);
    }
    
    static <K, V> SortedMap<K, V> newSortedMap() {
        return new TreeMap<K, V>();
    }
    
    static <K, V> SortedMap<K, V> newSortedMap(Comparator<? super K> comp) {
        return new TreeMap<K, V>(comp);
    }
    
    static <K, V> Map<K, V> newInsertionOrderMap() {
        return new LinkedHashMap<K, V>();
    }
    
    static <E> Set<E> newSet() {
        return new HashSet<E>();
    }
    
    static <E> Set<E> newSet(Collection<E> c) {
        return new HashSet<E>(c);
    }
    
    static <E> List<E> newList() {
        return new ArrayList<E>();
    }
    
    static <E> List<E> newList(Collection<E> c) {
        return new ArrayList<E>(c);
    }
    
    /* This method can be used by code that is deliberately violating the
     * allowed checked casts.  Rather than marking the whole method containing
     * the code with @SuppressWarnings, you can use a call to this method for
     * the exact place where you need to escape the constraints.  Typically
     * you will "import static" this method and then write either
     *    X x = cast(y);
     * or, if that doesn't work (e.g. X is a type variable)
     *    Util.<X>cast(y);
     */
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object x) {
        return (T) x;
    }
}
