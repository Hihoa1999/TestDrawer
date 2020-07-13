package com.example.testdrawer;

public class itemsv {
    public itemsv(String name, String birt, String school, String sex, String favorite)
    {
        this.name=name;
        this.birt=birt;
        this.school=school;
        this.sex=sex;
        this.favorite=favorite;
    }
    public String name;
    public String birt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirt() {
        return birt;
    }

    public void setBirt(String birt) {
        this.birt = birt;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String school;
    public String sex;
    public String favorite;

}
