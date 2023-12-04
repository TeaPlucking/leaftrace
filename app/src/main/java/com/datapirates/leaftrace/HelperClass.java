package com.datapirates.leaftrace;

public class HelperClass {

    String editTextEmail, editTextManagerid, editTextUsername, editTextPwd, editTextRePwd, editTextname;

    public HelperClass(String editTextEmail, String editTextManagerid, String editTextUsername, String editTextPwd, String editTextRePwd, String name) {
        this.editTextEmail = editTextEmail;
        this.editTextManagerid = editTextManagerid;
        this.editTextUsername = editTextUsername;
        this.editTextPwd = editTextPwd;
        this.editTextRePwd = editTextRePwd;
        this.editTextname = editTextname;

    }

    public String getEditTextEmail() {
        return editTextEmail;
    }

    public void setEditTextEmail(String editTextEmail) {
        this.editTextEmail = editTextEmail;
    }

    public String getEditTextManagerid() {
        return editTextManagerid;
    }

    public void setEditTextManagerid(String editTextManagerid) {
        this.editTextManagerid = editTextManagerid;
    }

    public String getEditTextUsername() {
        return editTextUsername;
    }

    public void setEditTextUsername(String editTextUsername) {
        this.editTextUsername = editTextUsername;
    }

    public String getEditTextPwd() {
        return editTextPwd;
    }

    public void setEditTextPwd(String editTextPwd) {
        this.editTextPwd = editTextPwd;
    }

    public String getEditTextRePwd() {
        return editTextRePwd;
    }

    public void setEditTextRePwd(String editTextRePwd) {
        this.editTextRePwd = editTextRePwd;
    }

    public String getEditTextname() {
        return editTextname;
    }

    public void setEditTextname(String editTextname) {
        this.editTextname = editTextname;

    }

    public HelperClass() {
    }
}