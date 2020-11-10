/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session10;

/**
 *
 * @author ADMIN
 */
public class Category {
    private int cateId;
    private String cateName;
    private int parentId;
    private String imgUrl;
    private boolean status;

    public Category() {
    }

    public Category(int cateId, String cateName, int parentId, String imgUrl, boolean status) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.parentId = parentId;
        this.imgUrl = imgUrl;
        this.status = status;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Category{" + "cateId=" + cateId + ", cateName=" + cateName + ", parentId=" + parentId + ", imgUrl=" + imgUrl + ", status=" + status + '}';
    }
    
    
}
