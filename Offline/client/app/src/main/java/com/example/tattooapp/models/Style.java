package com.example.tattooapp.models;


import com.google.gson.annotations.SerializedName;
public class Style {

    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;

    public Style(String id, String name){
        this.id = id;
        this.name = name;
}

/*public class Style<T> {

    //@SerializedName("styles")
    public T styles;

    public Style(T styles) {
        this.styles = styles;
    }

    public T getStyles(){
        return styles;
    }*/

    /*@SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;*/



/*    public void setId(int id) {
        this.id = id;} */

    /*public int getId(){
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
*/
}

//var style ' Style<User>+
