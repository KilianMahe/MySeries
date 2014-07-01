package com.naroner.classe;

public class StoreSerie {
	private int _id;
	private String _SerieName;
	private String _FanArt;
	private String _NextEpisode;
	private int _actual_season_user;
	private int _actual_episode_user;
	
	public StoreSerie() {
		super();
	}

	public StoreSerie(int _id, String _SerieName, String _FanArt, String _NextEpisode,
			int _actual_season_user, int _actual_episode_user) {
		super();
		this._id = _id;
		this._SerieName = _SerieName;
		this._FanArt = _FanArt;
		this._NextEpisode = _NextEpisode;
		this._actual_season_user = _actual_season_user;
		this._actual_episode_user = _actual_episode_user;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_SerieName() {
		return _SerieName;
	}

	public void set_SerieName(String _SerieName) {
		this._SerieName = _SerieName;
	}

	public String get_FanArt() {
		return _FanArt;
	}

	public void set_FanArt(String _FanArt) {
		this._FanArt = _FanArt;
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

	public final String get_NextEpisode() {
		return _NextEpisode;
	}

	public final void set_NextEpisode(String _NextEpisode) {
		this._NextEpisode = _NextEpisode;
	}
}
