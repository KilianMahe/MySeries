package com.naroner.parsing;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.naroner.classe.OneSerieAll;

public class ParserXMLHandlerSerieAll extends DefaultHandler {
	
	// nom des tags XML
		private final String SERIES = "series";
		private final String ID = "id";
		private final String ACTORS = "Actors";
		private final String AIRS_DAYSOFWEEK = "Airs_DayOfWeek";
		private final String AIRS_TIME = "Airs_Time";
		private final String CONTENTRATING = "ContentRating";
		private final String FIRSTAIRED = "FirstAired";
		private final String GENRE = "Genre";
		private final String IMDB_ID = "IMDB_ID";
		private final String LANGUAGE = "Language";
		private final String NETWORK = "Network";
		private final String NETWORKID = "NetworkID";
		private final String OVERVIEW = "Overview";
		private final String RATING = "Rating";
		private final String RATINGCOUNT = "RatingCount";
		private final String RUNTIME = "Runtime";
		private final String SERIESID = "SeriesID";
		private final String SERIESNAME = "SeriesName";
		private final String STATUS = "Status";
		private final String ADDED = "added";
		private final String ADDEDBY = "addedBy";
		private final String BANNER = "banner";
		private final String FANART = "fanart";
		private final String LASTUPDATED = "lastupdated";
		private final String POSTER = "poster";
		private final String TMS_WANTED_OLD = "tms_wanted_old";
		private final String ZAP2IT_ID = "zap2it_id";
		

		// Array list de feeds
		private ArrayList entries;

		// Boolean permettant de savoir si nous sommes � l'int�rieur d'un item
		private boolean inItem;

		// Feed courant
		private OneSerieAll currentFeed;

		// Buffer permettant de contenir les donn�es d'un tag XML
		private StringBuffer buffer;

		@Override
		public void processingInstruction(String target, String data) throws SAXException {
			super.processingInstruction(target, data);
		}

		public ParserXMLHandlerSerieAll() {
			super();
		}

		// * Cette m�thode est appel�e par le parser une et une seule
		// * fois au d�marrage de l'analyse de votre flux xml.
		// * Elle est appel�e avant toutes les autres m�thodes de l'interface,
		// * � l'exception unique, �videmment, de la m�thode setDocumentLocator.
		// * Cet �v�nement devrait vous permettre d'initialiser tout ce qui doit
		// * l'�tre avant led�but du parcours du document.

		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			entries = new ArrayList();

		}

		/*
		 * Fonction �tant d�clench�e lorsque le parser trouve un tag XML
		 * C'est cette m�thode que nous allons utiliser pour instancier un nouveau feed
	 	*/
		@Override
		public void startElement(String uri, String localName, String name,	Attributes attributes) throws SAXException {
			// Nous r�initialisons le buffer a chaque fois qu'il rencontre un item
			buffer = new StringBuffer();		

			// Ci dessous, localName contient le nom du tag rencontr�

			// Nous avons rencontr� un tag ITEM, il faut donc instancier un nouveau feed
			if (localName.equalsIgnoreCase(SERIES)){
				this.currentFeed = new OneSerieAll();
				inItem = true;
			}
		}

		// * Fonction �tant d�clench�e lorsque le parser � pars�
		// * l'int�rieur de la balise XML La m�thode characters
		// * a donc fait son ouvrage et tous les caract�re inclus
		// * dans la balise en cours sont copi�s dans le buffer
		// * On peut donc tranquillement les r�cup�rer pour compl�ter
		// * notre objet currentFeed

		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {		

			if (localName.equalsIgnoreCase(ID)){
				if(inItem){
					// Les caract�res sont dans l'objet buffer
					this.currentFeed.set_id(buffer.toString());
					buffer = null;
				}
			}
			if (localName.equalsIgnoreCase(ACTORS)){
				if(inItem){
					this.currentFeed.set_Actors(buffer.toString());
					buffer = null;
				}
			}
			if (localName.equalsIgnoreCase(AIRS_DAYSOFWEEK)){
				if(inItem){
					this.currentFeed.set_Airs_DayOfWeek(buffer.toString());
					buffer = null;
				}
			}
			if (localName.equalsIgnoreCase(AIRS_TIME)){
				if(inItem){
					this.currentFeed.set_Airs_Time(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(CONTENTRATING)){
				if(inItem){
					this.currentFeed.set_ContentRating(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(FIRSTAIRED)){
				if(inItem){
					this.currentFeed.set_FirstAired(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(GENRE)){
				if(inItem){
					this.currentFeed.set_Genre(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(IMDB_ID)){
				if(inItem){
					this.currentFeed.set_IMDB_ID(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(LANGUAGE)){
				if(inItem){
					this.currentFeed.set_Language(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(NETWORK)){
				if(inItem){
					this.currentFeed.set_Network(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(NETWORKID)){
				if(inItem){
					this.currentFeed.set_NetworkID(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(OVERVIEW)){
				if(inItem){
					this.currentFeed.set_Overview(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(RATING)){
				if(inItem){
					this.currentFeed.set_Rating(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(RATINGCOUNT)){
				if(inItem){
					this.currentFeed.set_RatingCount(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(RUNTIME)){
				if(inItem){
					this.currentFeed.set_Runtime(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(SERIESID)){
				if(inItem){
					this.currentFeed.set_SeriesID(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(SERIESNAME)){
				if(inItem){
					this.currentFeed.set_SeriesName(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(STATUS)){
				if(inItem){
					this.currentFeed.set_Status(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(ADDED)){
				if(inItem){
					this.currentFeed.set_added(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(ADDEDBY)){
				if(inItem){
					this.currentFeed.set_addedBy(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(BANNER)){
				if(inItem){
					this.currentFeed.set_banner(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(FANART)){
				if(inItem){
					this.currentFeed.set_fanart(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(LASTUPDATED)){
				if(inItem){
					this.currentFeed.set_lastupdated(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(POSTER)){
				if(inItem){
					this.currentFeed.set_poster(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(TMS_WANTED_OLD)){
				if(inItem){
					this.currentFeed.set_tms_wanted_old(buffer.toString());
					buffer = null;
				}
			}
			if(localName.equalsIgnoreCase(ZAP2IT_ID)){
				if(inItem){
					this.currentFeed.set_zap2it_id(buffer.toString());
					buffer = null;
				}
			}
			if (localName.equalsIgnoreCase(SERIES)){
				entries.add(currentFeed);
				inItem = false;
			}
		}

		// * Tout ce qui est dans l'arborescence mais n'est pas partie
		// * int�grante d'un tag, d�clenche la lev�e de cet �v�nement.
		// * En g�n�ral, cet �v�nement est donc lev� tout simplement
		// * par la pr�sence de texte entre la balise d'ouverture et
		// * la balise de fermeture

		public void characters(char[] ch,int start, int length)	throws SAXException{
			String lecture = new String(ch,start,length);
			if(buffer != null) buffer.append(lecture);
		}

		// cette m�thode nous permettra de r�cup�rer les donn�es
		public ArrayList getData(){
			return entries;
		}
}
