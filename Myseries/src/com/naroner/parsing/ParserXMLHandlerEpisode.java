package com.naroner.parsing;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.naroner.classe.episode;

public class ParserXMLHandlerEpisode extends DefaultHandler {

	// nom des tags XML
			private final String EPISODE = "Episode";
			private final String ID = "id";
			private final String COMBINED_EPISODENUMBER = "Combined_episodenumber";
			private final String COMBINED_SEASON = "Combined_season";
			private final String DVD_CHAPTER  = "DVD_chapter";
			private final String DVD_DISCID  = "DVD_discid";
			private final String DVD_EPISODENUMBER = "DVD_episodenumber";
			private final String DVD_SEASON = "DVD_season";
			private final String DIRECTOR = "Director";
			private final String EPIMGFLAG = "EpImgFlag";
			private final String EPISODENAME = "EpisodeName";
			private final String EPISODENUMBER = "EpisodeNumber";
			private final String FIRSTAIRED = "FirstAired";
			private final String GUESTSTARS = "GuestStars";
			private final String IMDB_ID = "IMDB_ID";
			private final String LANGUAGE = "Language";
			private final String OVERVIEW = "Overview";
			private final String PRODUCTIONCODE = "ProductionCode";
			private final String RATING = "Rating";
			private final String RATINGCOUNT = "RatingCount";
			private final String SEASONNUMBER = "SeasonNumber";
			private final String WRITER = "Writer";
			private final String ABSOLUTE_NUMBER = "absolute_number";
			private final String AIRSAFTER_SEASON = "airsafter_season";
			private final String AIRSBEFORE_EPISODE = "airsbefore_episode";
			private final String AIRSBEFORE_SEASON = "airsbefore_season";
			private final String FILENAME = "filename";
			private final String LASTUPDATED = "lastupdated";
			private final String SEASONID = "seasonid";
			private final String SERIESID = "seriesid";
			private final String THUMB_ADDED = "thumb_added";
			private final String THUMB_HEIGHT = "thumb_height";
			private final String THUMB_WIDTH = "thumb_width";
			

			// Array list de feeds
			private ArrayList entries;

			// Boolean permettant de savoir si nous sommes � l'int�rieur d'un item
			private boolean inItem;

			// Feed courant
			private episode currentFeed;

			// Buffer permettant de contenir les donn�es d'un tag XML
			private StringBuffer buffer;

			@Override
			public void processingInstruction(String target, String data) throws SAXException {
				super.processingInstruction(target, data);
			}

			public ParserXMLHandlerEpisode() {
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
				if (localName.equalsIgnoreCase(EPISODE)){
					this.currentFeed = new episode();
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
				if (localName.equalsIgnoreCase(COMBINED_EPISODENUMBER)){
					if(inItem){
						this.currentFeed.set_Combined_episodenumber(buffer.toString());
						buffer = null;
					}
				}
				if (localName.equalsIgnoreCase(COMBINED_SEASON)){
					if(inItem){
						this.currentFeed.set_Combined_season(buffer.toString());
						buffer = null;
					}
				}
				if (localName.equalsIgnoreCase(DVD_CHAPTER)){
					if(inItem){
						this.currentFeed.set_DVD_chapter(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(DVD_DISCID)){
					if(inItem){
						this.currentFeed.set_DVD_discid(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(DVD_EPISODENUMBER)){
					if(inItem){
						this.currentFeed.set_DVD_episodenumber(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(DVD_SEASON)){
					if(inItem){
						this.currentFeed.set_DVD_season(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(DIRECTOR)){
					if(inItem){
						this.currentFeed.set_Director(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(EPIMGFLAG)){
					if(inItem){
						this.currentFeed.set_EpImgFlag(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(EPISODENAME)){
					if(inItem){
						this.currentFeed.set_EpisodeName(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(EPISODENUMBER)){
					if(inItem){
						this.currentFeed.set_EpisodeNumber(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(FIRSTAIRED)){
					if(inItem){
						this.currentFeed.set_FirstAired(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(GUESTSTARS)){
					if(inItem){
						this.currentFeed.set_GuestStars(buffer.toString());
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
				if(localName.equalsIgnoreCase(OVERVIEW)){
					if(inItem){
						this.currentFeed.set_Overview(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(PRODUCTIONCODE)){
					if(inItem){
						this.currentFeed.set_ProductionCode(buffer.toString());
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
				if(localName.equalsIgnoreCase(SEASONNUMBER)){
					if(inItem){
						this.currentFeed.set_SeasonNumber(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(WRITER)){
					if(inItem){
						this.currentFeed.set_Writer(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(ABSOLUTE_NUMBER)){
					if(inItem){
						this.currentFeed.set_absolute_number(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(AIRSAFTER_SEASON)){
					if(inItem){
						this.currentFeed.set_airsafter_season(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(AIRSBEFORE_EPISODE)){
					if(inItem){
						this.currentFeed.set_airsafter_season(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(AIRSBEFORE_SEASON)){
					if(inItem){
						this.currentFeed.set_airsbefore_season(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(FILENAME)){
					if(inItem){
						this.currentFeed.set_filename(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(LASTUPDATED)){
					if(inItem){
						this.currentFeed.set_lastupdated(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(SEASONID)){
					if(inItem){
						this.currentFeed.set_seasonid(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(SERIESID)){
					if(inItem){
						this.currentFeed.set_seriesid(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(THUMB_ADDED)){
					if(inItem){
						this.currentFeed.set_thumb_added(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(THUMB_HEIGHT)){
					if(inItem){
						this.currentFeed.set_thumb_height(buffer.toString());
						buffer = null;
					}
				}
				if(localName.equalsIgnoreCase(THUMB_WIDTH)){
					if(inItem){
						this.currentFeed.set_thumb_width(buffer.toString());
						buffer = null;
					}
				}
				if (localName.equalsIgnoreCase(EPISODE)){
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
