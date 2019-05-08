package com.gvndemo.utilities;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
@SuppressWarnings("unchecked")


public final class PropertyHelper {

/**
 * hMapProperties contains the hashmap of key/value pairs associated with each property 
 */
protected final static HashMap<String, Object> HMAPPROPERTIES = new HashMap<String,Object>();
 

/**
 * @param propertyFile
 * @return
 */
public static HashMap<String, Object> loadProperties(String propertyFile) { 
	 Properties properties = PropertyLoader.loadProperties(propertyFile); 
	 Enumeration <String> keys = (Enumeration<String>) properties.propertyNames(); 
		while (keys.hasMoreElements()) {
		      String tmpKey = (String) keys.nextElement();
		      HMAPPROPERTIES.put(tmpKey,properties.getProperty(tmpKey)); 	
		      
		    }
	   return HMAPPROPERTIES; 
 }


/**
 * @param propertyName
 * @return
 */
public static String getProperty(String propertyName){
	 String propertyValue = ""; 
	 try { 
		 propertyValue = (String) HMAPPROPERTIES.get(propertyName); 
	 }
	 catch (Exception e){
		 LoggerStackTraceUtil.printErrorMessage(e);
		 propertyValue = ""; 
	 }
	 finally { 
	 }
	 return propertyValue; 
	 }

/**
 * Function used to get the default value if the property is null
 * @param propertyName - Name of the property
 * @param strDefault - Default value that needs to be returned if the value is null
 * @return Property value/Default Value as String
 */
public static String getProperty(String propertyName,String strDefault){
	 String propertyValue = ""; 
	 try { 
		 propertyValue = (String) HMAPPROPERTIES.get(propertyName); 
		 // Check the property value is null/not
		 if(propertyValue == null){
			// Assign the default value to the propertyValue
		   propertyValue=strDefault;
		 }
	 }
	 catch (Exception e){
		 LoggerStackTraceUtil.printErrorMessage(e);
		 propertyValue = ""; 
	 }
	 finally { 
	 }
	 return propertyValue; 
	 }

/**
 * A convenience method (aliasing getProperty) 
 * @param propertyName property to be retrieved. 
 * @return
 * @see getProperty
 */
public static String get(String propertyName){
	return getProperty(propertyName); 
}
 }

