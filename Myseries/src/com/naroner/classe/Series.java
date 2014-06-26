package com.naroner.classe;

import java.util.ArrayList;

public class Series {
	private ArrayList<OneSerie> _series;

	public Series(ArrayList<OneSerie> _series) {
		super();
		this._series = _series;
	}

	public ArrayList<OneSerie> get_series() {
		return _series;
	}

	public void set_series(ArrayList<OneSerie> _series) {
		this._series = _series;
	}
	
	public void add_serie(OneSerie serie){
		this._series.add(serie);
	}

}
