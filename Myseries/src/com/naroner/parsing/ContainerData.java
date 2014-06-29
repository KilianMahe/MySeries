package com.naroner.parsing;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.naroner.classe.OneSerieAll;

import android.content.Context;
import android.util.Log;

public class ContainerData {	

	static public Context context;

	public ContainerData() {

	}

	public static ArrayList getFeeds(String _url){
		// On passe par une classe factory pour obtenir une instance de sax
		SAXParserFactory fabrique = SAXParserFactory.newInstance();
		SAXParser parseur = null;
		ArrayList entries = null;
		try {
			// On "fabrique" une instance de SAXParser
			parseur = fabrique.newSAXParser();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		// On défini l'url du fichier XML
		URL url = null;
		try {
			url = new URL(_url);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		/*
		 * Le handler sera gestionnaire du fichier XML c'est à dire que c'est lui qui sera chargé
		 * des opérations de parsing. On vera cette classe en détails ci après.
		*/
		DefaultHandler handler = new ParserXMLHandler();
		try {
			// On parse le fichier XML
			InputStream input = url.openStream();
			if(input==null)
				Log.e("erreur android","null");
			else{
				parseur.parse(input, handler);
				// On récupère directement la liste des feeds
				entries = ((ParserXMLHandler) handler).getData();
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// On la retourne l'array list
		return entries;
	}
	
	public static ArrayList getFeedsAll(String _url){
		// On passe par une classe factory pour obtenir une instance de sax
		SAXParserFactory fabrique = SAXParserFactory.newInstance();
		SAXParser parseur = null;
		ArrayList entries = null;
		try {
			// On "fabrique" une instance de SAXParser
			parseur = fabrique.newSAXParser();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		// On défini l'url du fichier XML
		URL url = null;
		try {
			url = new URL(_url);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		/*
		 * Le handler sera gestionnaire du fichier XML c'est à dire que c'est lui qui sera chargé
		 * des opérations de parsing. On vera cette classe en détails ci après.
		*/
		DefaultHandler handler = new ParserXMLHandlerSerieAll();
		try {
			// On parse le fichier XML
			InputStream input = url.openStream();
			if(input==null)
				Log.e("erreur android","null");
			else{
				parseur.parse(input, handler);
				// On récupère directement la liste des feeds
				entries = ((ParserXMLHandlerSerieAll) handler).getData();
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// On la retourne l'array list
		return entries;
	}
	
	public static ArrayList getFeedsAllEpisode(String _url){
		// On passe par une classe factory pour obtenir une instance de sax
		SAXParserFactory fabrique = SAXParserFactory.newInstance();
		SAXParser parseur = null;
		ArrayList entries = null;
		try {
			// On "fabrique" une instance de SAXParser
			parseur = fabrique.newSAXParser();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		// On défini l'url du fichier XML
		URL url = null;
		try {
			url = new URL(_url);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		/*
		 * Le handler sera gestionnaire du fichier XML c'est à dire que c'est lui qui sera chargé
		 * des opérations de parsing. On vera cette classe en détails ci après.
		*/
		DefaultHandler handler = new ParserXMLHandlerEpisode();
		try {
			// On parse le fichier XML
			InputStream input = url.openStream();
			if(input==null)
				Log.e("erreur android","null");
			else{
				parseur.parse(input, handler);
				// On récupère directement la liste des feeds
				entries = ((ParserXMLHandlerEpisode) handler).getData();
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// On la retourne l'array list
		return entries;
	}

}