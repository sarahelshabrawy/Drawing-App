package com.example.model.Shapes;

import com.example.model.Canvas;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class Shape implements IShape{
    String dimensions;
    String shapeType;
    HashMap<String,String> JSONDimensions;
    HashMap<String,String> JSONProperties;
    String properties;
    Canvas myCanvas = Canvas.getInstance();

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    @Override
    public void createShape() {

    }

    @Override
    public void updateShape() {
        myCanvas.getShapes().put(ID,this);
        //undo n redo
    }

    @Override
    public void deleteShape() {
    myCanvas.getShapes().remove(ID);
    }

    public void setJSONDimensions(HashMap<String, String> JSONDimensions) {
        this.JSONDimensions = JSONDimensions;
    }

    public void setJSONProperties(HashMap<String, String> JSONProperties) {
        this.JSONProperties = JSONProperties;
    }

    long ID;

    public Shape( HashMap<String,String>  JSONProperties,  HashMap<String,String>  JSONDimensions, String shapeType) {
        this.JSONProperties = JSONProperties;
        this.JSONDimensions = JSONDimensions;
        this.shapeType = shapeType;
    }

    public HashMap<String, String> getJSONProperties() {
        return JSONProperties;
    }

    public HashMap<String, String> getJSONDimensions() {
        return JSONDimensions;
    }


    public void setProperties(String properties) {
        this.properties = properties;
        this.JSONProperties = fromJsonToMap(properties);
    }


    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
        this.JSONDimensions = fromJsonToMap(dimensions);
    }

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }


    private HashMap<String, String> fromJsonToMap(String JSONString)
    {
        Map<String, String> retMap = new Gson().fromJson(
                JSONString, new TypeToken<HashMap<String, String>>() {}.getType()
        );
        return (HashMap<String, String>) retMap;
    }
}
