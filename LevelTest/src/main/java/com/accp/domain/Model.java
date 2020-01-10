package com.accp.domain;

import java.util.List;

public class Model {
    private Integer id;

    private String name;

    private Integer parentid;

    private Integer catalog;

    private String path;
    
    private List<Model> list;
    

    public List<Model> getList() {
		return list;
	}

	public void setList(List<Model> list) {
		this.list = list;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getCatalog() {
        return catalog;
    }

    public void setCatalog(Integer catalog) {
        this.catalog = catalog;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}