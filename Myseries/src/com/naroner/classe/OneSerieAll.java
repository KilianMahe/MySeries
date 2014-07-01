package com.naroner.classe;

import java.util.ArrayList;

public class OneSerieAll {
	private String _id;
	private String _Actors;
	private String _Airs_DayOfWeek;
	private String _Airs_Time;
	private String _ContentRating;
	private String _FirstAired;
	private String _Genre;
	private String _IMDB_ID;
	private String _Language;
	private String _Network;
	private String _NetworkID;
	private String _Overview;
	private String _Rating;
	private String _RatingCount;
	private String _Runtime;
	private String _SeriesID;
	private String _SeriesName;
	private String _Status;
	private String _added;
	private String _addedBy;
	private String _banner;
	private String _fanart;
	private String _lastupdated;
	private String _poster;
	private String _tms_wanted_old;
	private String _zap2it_id;
	private int _actual_season_user;
	private int _actual_episode_user;
	private ArrayList<episode> _episode;
	
	public OneSerieAll(String _id, String _Actors, String _Airs_DayOfWeek,
			String _Airs_Time, String _ContentRating, String _FirstAired,
			String _Genre, String _IMDB_ID, String _Language, String _Network,
			String _NetworkID, String _Overview, String _Rating,
			String _RatingCount, String _Runtime, String _SeriesID,
			String _SeriesName, String _Status, String _added, String _addedBy,
			String _banner, String _fanart, String _lastupdated,
			String _poster, String _tms_wanted_old, String _zap2it_id,
			ArrayList<episode> _episode) {
		super();
		this._id = _id;
		this._Actors = _Actors;
		this._Airs_DayOfWeek = _Airs_DayOfWeek;
		this._Airs_Time = _Airs_Time;
		this._ContentRating = _ContentRating;
		this._FirstAired = _FirstAired;
		this._Genre = _Genre;
		this._IMDB_ID = _IMDB_ID;
		this._Language = _Language;
		this._Network = _Network;
		this._NetworkID = _NetworkID;
		this._Overview = _Overview;
		this._Rating = _Rating;
		this._RatingCount = _RatingCount;
		this._Runtime = _Runtime;
		this._SeriesID = _SeriesID;
		this._SeriesName = _SeriesName;
		this._Status = _Status;
		this._added = _added;
		this._addedBy = _addedBy;
		this._banner = _banner;
		this._fanart = _fanart;
		this._lastupdated = _lastupdated;
		this._poster = _poster;
		this._tms_wanted_old = _tms_wanted_old;
		this._zap2it_id = _zap2it_id;
		this._episode = _episode;
	}
	public OneSerieAll() {
		super();
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_Actors() {
		return _Actors;
	}
	public void set_Actors(String _Actors) {
		this._Actors = _Actors;
	}
	public String get_Airs_DayOfWeek() {
		return _Airs_DayOfWeek;
	}
	public void set_Airs_DayOfWeek(String _Airs_DayOfWeek) {
		this._Airs_DayOfWeek = _Airs_DayOfWeek;
	}
	public String get_Airs_Time() {
		return _Airs_Time;
	}
	public void set_Airs_Time(String _Airs_Time) {
		this._Airs_Time = _Airs_Time;
	}
	public String get_ContentRating() {
		return _ContentRating;
	}
	public void set_ContentRating(String _ContentRating) {
		this._ContentRating = _ContentRating;
	}
	public String get_FirstAired() {
		return _FirstAired;
	}
	public void set_FirstAired(String _FirstAired) {
		this._FirstAired = _FirstAired;
	}
	public String get_Genre() {
		return _Genre;
	}
	public void set_Genre(String _Genre) {
		this._Genre = _Genre;
	}
	public String get_IMDB_ID() {
		return _IMDB_ID;
	}
	public void set_IMDB_ID(String _IMDB_ID) {
		this._IMDB_ID = _IMDB_ID;
	}
	public String get_Language() {
		return _Language;
	}
	public void set_Language(String _Language) {
		this._Language = _Language;
	}
	public String get_Network() {
		return _Network;
	}
	public void set_Network(String _Network) {
		this._Network = _Network;
	}
	public String get_NetworkID() {
		return _NetworkID;
	}
	public void set_NetworkID(String _NetworkID) {
		this._NetworkID = _NetworkID;
	}
	public String get_Overview() {
		return _Overview;
	}
	public void set_Overview(String _Overview) {
		this._Overview = _Overview;
	}
	public String get_Rating() {
		return _Rating;
	}
	public void set_Rating(String _Rating) {
		this._Rating = _Rating;
	}
	public String get_RatingCount() {
		return _RatingCount;
	}
	public void set_RatingCount(String _RatingCount) {
		this._RatingCount = _RatingCount;
	}
	public String get_Runtime() {
		return _Runtime;
	}
	public void set_Runtime(String _Runtime) {
		this._Runtime = _Runtime;
	}
	public String get_SeriesID() {
		return _SeriesID;
	}
	public void set_SeriesID(String _SeriesID) {
		this._SeriesID = _SeriesID;
	}
	public String get_SeriesName() {
		return _SeriesName;
	}
	public void set_SeriesName(String _SeriesName) {
		this._SeriesName = _SeriesName;
	}
	public String get_Status() {
		return _Status;
	}
	public void set_Status(String _Status) {
		this._Status = _Status;
	}
	public String get_added() {
		return _added;
	}
	public void set_added(String _added) {
		this._added = _added;
	}
	public String get_addedBy() {
		return _addedBy;
	}
	public void set_addedBy(String _addedBy) {
		this._addedBy = _addedBy;
	}
	public String get_banner() {
		return _banner;
	}
	public void set_banner(String _banner) {
		this._banner = _banner;
	}
	public String get_fanart() {
		return _fanart;
	}
	public void set_fanart(String _fanart) {
		this._fanart = _fanart;
	}
	public String get_lastupdated() {
		return _lastupdated;
	}
	public void set_lastupdated(String _lastupdated) {
		this._lastupdated = _lastupdated;
	}
	public String get_poster() {
		return _poster;
	}
	public void set_poster(String _poster) {
		this._poster = _poster;
	}
	public String get_tms_wanted_old() {
		return _tms_wanted_old;
	}
	public void set_tms_wanted_old(String _tms_wanted_old) {
		this._tms_wanted_old = _tms_wanted_old;
	}
	public String get_zap2it_id() {
		return _zap2it_id;
	}
	public void set_zap2it_id(String _zap2it_id) {
		this._zap2it_id = _zap2it_id;
	}
	public ArrayList<episode> get_episode() {
		return _episode;
	}
	public void set_episode(ArrayList<episode> _episode) {
		this._episode = _episode;
	}
	public int get_actual_season_user() {
		return _actual_season_user;
	}
	public void set_actual_season_user(int _actual_season_user) {
		this._actual_season_user = _actual_season_user;
	}
	public int get_actual_episode_user() {
		return _actual_episode_user;
	}
	public void set_actual_episode_user(int _actual_episode_user) {
		this._actual_episode_user = _actual_episode_user;
	}
	public String get_nombre_saison(){
		return this._episode.get(this._episode.size() - 1).get_SeasonNumber();
	}
	
	public int get_nombre_episodes_on_saison(int saison){
		int nombre_episode = 0;
		for(int i = 0; i < _episode.size(); i++){
			if(_episode.get(i).get_Combined_season().equals(Integer.toString(saison))){
				nombre_episode++;
			}
		}
		return nombre_episode;
	}
	
	public String get_date_of_next_episode(String saison, String episode){
		String date = "";
		int episode_int = Integer.parseInt(episode);
		episode_int++;
		for(int i = 0; i < _episode.size(); i++){
			if(_episode.get(i).get_Combined_season().equals(saison) 
					&& _episode.get(i).get_Combined_episodenumber().equals(Integer.toString(episode_int))){
				date = _episode.get(i).get_FirstAired();
			}
		}
		int saison_int = Integer.parseInt(saison);
		saison_int++;
		if(date == ""){
			for(int i = 0; i < _episode.size(); i++){
				if(_episode.get(i).get_Combined_season().equals(Integer.toString(saison_int)) 
						&& _episode.get(i).get_Combined_episodenumber().equals("1")){
					date = _episode.get(i).get_FirstAired();
				}
			}
		}
		if(date.equals("")){
			date = "Unknow";
		}
		return date;
	}

}
