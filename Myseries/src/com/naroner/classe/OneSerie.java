package com.naroner.classe;

public class OneSerie {
	private String _seriesid;
	private String _language;
	private String _SeriesName;
	private String _banner;
	private String _Overview;
	private String _FirstAired;
	private String _Network;
	private String _IMDB_ID;
	private String _zap2it_id;
	private String _id;
	
	public OneSerie(String _seriesid, String _language, String _SeriesName,
			String _banner, String _Overview, String _FirstAired,
			String _Network, String _IMDB_ID, String _zap2it_id, String _id) {
		super();
		this._seriesid = _seriesid;
		this._language = _language;
		this._SeriesName = _SeriesName;
		this._banner = _banner;
		this._Overview = _Overview;
		this._FirstAired = _FirstAired;
		this._Network = _Network;
		this._IMDB_ID = _IMDB_ID;
		this._zap2it_id = _zap2it_id;
		this._id = _id;
	}

	public String get_seriesid() {
		return _seriesid;
	}

	public void set_seriesid(String _seriesid) {
		this._seriesid = _seriesid;
	}

	public String get_language() {
		return _language;
	}

	public void set_language(String _language) {
		this._language = _language;
	}

	public String get_SeriesName() {
		return _SeriesName;
	}

	public void set_SeriesName(String _SeriesName) {
		this._SeriesName = _SeriesName;
	}

	public String get_banner() {
		return _banner;
	}

	public void set_banner(String _banner) {
		this._banner = _banner;
	}

	public String get_Overview() {
		return _Overview;
	}

	public void set_Overview(String _Overview) {
		this._Overview = _Overview;
	}

	public String get_FirstAired() {
		return _FirstAired;
	}

	public void set_FirstAired(String _FirstAired) {
		this._FirstAired = _FirstAired;
	}

	public String get_Network() {
		return _Network;
	}

	public void set_Network(String _Network) {
		this._Network = _Network;
	}

	public String get_IMDB_ID() {
		return _IMDB_ID;
	}

	public void set_IMDB_ID(String _IMDB_ID) {
		this._IMDB_ID = _IMDB_ID;
	}

	public String get_zap2it_id() {
		return _zap2it_id;
	}

	public void set_zap2it_id(String _zap2it_id) {
		this._zap2it_id = _zap2it_id;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	
	
}
