package com.naroner.classe;

public class StoreSerie {
	private int _id;
	private String _SerieName;
	private byte[] _FanArt;
	private String _NextEpisode;
	private String _Airs_Time;
	private int _Number_available_episode;
	private int _Number_available_episode_user_seen;
	private int _actual_season_user;
	private int _actual_episode_user;
	
	public StoreSerie() {
		super();
	}
	
	

	public StoreSerie(int _id, String _SerieName, byte[] _FanArt,
			String _NextEpisode, String _Airs_Time,
			int _actual_season_user,
			int _actual_episode_user,
			int _Number_available_episode,
			int _Number_available_episode_user_seen) {
		super();
		this._id = _id;
		this._SerieName = _SerieName;
		this._FanArt = _FanArt;
		this._NextEpisode = _NextEpisode;
		this._Airs_Time = _Airs_Time;
		this._Number_available_episode = _Number_available_episode;
		this._Number_available_episode_user_seen = _Number_available_episode_user_seen;
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

	public byte[]  get_FanArt() {
		return _FanArt;
	}

	public void set_FanArt(byte[]  _FanArt) {
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

	public final String get_Airs_Time() {
		return _Airs_Time;
	}

	public final void set_Airs_Time(String _Airs_Time) {
		this._Airs_Time = _Airs_Time;
	}

	public final int get_Number_available_episode() {
		return _Number_available_episode;
	}

	public final void set_Number_available_episode(int _Number_available_episode) {
		this._Number_available_episode = _Number_available_episode;
	}

	public final int get_Number_available_episode_user_seen() {
		return _Number_available_episode_user_seen;
	}

	public final void set_Number_available_episode_user_seen(
			int _Number_available_episode_user_seen) {
		this._Number_available_episode_user_seen = _Number_available_episode_user_seen;
	}
	
	
}
