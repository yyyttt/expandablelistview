package com.example.model;

import java.util.ArrayList;

public class ParentModel {

	public String parentName;
	public ArrayList<ChildModel> ChildModel;

	public ParentModel(String parentName) {
		super();
		this.parentName = parentName;
		this.ChildModel = new ArrayList<ChildModel>();
	}
}
