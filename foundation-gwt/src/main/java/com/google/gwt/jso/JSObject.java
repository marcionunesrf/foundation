/**
 * Copyright (C) 2009-2012 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gwt.jso;

import java.util.*;

import com.google.gwt.core.client.*;
import com.google.gwt.i18n.client.*;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.json.client.JSONObject;

public abstract class JSObject extends JavaScriptObject {

    private static final DateTimeFormat ISO = DateTimeFormat.getFormat(PredefinedFormat.ISO_8601); 

    protected JSObject() {
	super();
    }

    public final native boolean hasProperty(String property) /*-{
	return this[property] != undefined;
    }-*/;

    protected final native JsArrayString properties() /*-{
	var a = new Array();
	for (var e in this) { 
	    a.push(e); 
	}
	return a;
    }-*/;

    public final Set<String> propertiesSet() {
	JsArrayString array = properties();
	Set<String> set = new HashSet<String>();
	for (int i = 0; i < array.length(); i++)
	{
	    set.add(array.get(i));
	}
	return set;
    }

    public final JSONObject json() {
	return new JSONObject(this);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Getters
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public final native String get(String property) /*-{
	return "" + this[property];
    }-*/;

    public final native int getInt(String property) /*-{
	return this[property];
    }-*/;

    public final native double getFloat(String property) /*-{
	return this[property];
    }-*/;

    public final native double getDouble(String property) /*-{
	return this[property];
    }-*/;

    public final native boolean getBoolean(String property) /*-{
	return this[property];
    }-*/;

    public final native <T extends JavaScriptObject> JsArray<T> getArray(String property) /*-{
	return this[property];
    }-*/;

    public final native <T extends JavaScriptObject> MapJSO<T> getMap(String property) /*-{
	return this[property];
    }-*/;

    public final Date getDate(String property) {
	return this.get(property, new Date(), JSObject.ISO);
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Getters with default value
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public final native String get(String property, String defaultValue) /*-{
	return this[property] ? ("" + this[property]) : defaultValue;
    }-*/;

    public final native int get(String property, int defaultValue) /*-{
	    return this[property] ? this[property] : defaultValue;
    }-*/;

    public final native float get(String property, float defaultValue) /*-{
	return this[property] ? this[property] : defaultValue;
    }-*/;

    public final native double get(String property, double defaultValue) /*-{
	return this[property] ? this[property] : defaultValue;
    }-*/;

    public final native boolean get(String property, boolean defaultValue) /*-{
	return this[property] ? this[property] : defaultValue;
    }-*/;

    public final native <T extends JavaScriptObject> JsArray<T> get(String property, JsArray<T> defaulValue) /*-{
	return this[property] ? this[property] : defaultValue;
    }-*/;

    public final native <T extends JavaScriptObject> MapJSO<T> get(String property, MapJSO<T> defaulValue) /*-{
	return this[property] ? this[property] : defaultValue;
    }-*/;

    public final native <T extends JavaScriptObject> T get(String property, T defaulValue) /*-{
	return this[property] ? this[property] : defaultValue;
    }-*/;

    public final Date get(String property, Date defaultValue) {
	return this.get(property, defaultValue, JSObject.ISO);
    }

    public final Date get(String property, Date defaultValue, DateTimeFormat format) {
	return format.parse(this.get(property, format.format(defaultValue)));
    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Setters
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public final native void set(String property, String value) /*-{
	this[property] = value;
    }-*/;

    public final native void set(String property, int value) /*-{
	this[property] = value;
    }-*/;

    public final native void set(String property, float value) /*-{
	this[property] = value;
    }-*/;

    public final native void set(String property, double value) /*-{
	this[property] = value;
    }-*/;

    public final native void set(String property, boolean value) /*-{
	this[property] = value;
    }-*/;

    public final native <T extends JavaScriptObject> void set(String property, JsArray<T> value) /*-{
	this[property] = value;
    }-*/;

    public final native <T extends JavaScriptObject> void set(String property, MapJSO<T> value) /*-{
	this[property] = value;
    }-*/;

    public final native <T extends JavaScriptObject> void set(String property, T value) /*-{
	this[property] = value;
    }-*/;

    public final void set(String property, Date value) {
	this.set(property, value, JSObject.ISO);
    }

    public final void set(String property, Date value, DateTimeFormat format) {
	this.set(property, format.format(value));
    }

}