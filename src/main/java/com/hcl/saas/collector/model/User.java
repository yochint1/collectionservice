package com.hcl.saas.collector.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

import java.util.ArrayList;
@DynamoDBDocument
public class User {
    private String id;
    private String team_id;
    private String name;
    private boolean deleted;
    private String color;
    private String real_name;
    private String tz;
    private String tz_label;
    private float tz_offset;
    Profile ProfileObject;
    private boolean is_admin;
    private boolean is_owner;
    private boolean is_primary_owner;
    private boolean is_restricted;
    private boolean is_ultra_restricted;
    private boolean is_bot;
    private boolean is_app_user;
    private float updated;
    private boolean is_email_confirmed;
    private String who_can_share_contact_card;


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public String getName() {
        return name;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public String getColor() {
        return color;
    }

    public String getReal_name() {
        return real_name;
    }

    public String getTz() {
        return tz;
    }

    public String getTz_label() {
        return tz_label;
    }

    public float getTz_offset() {
        return tz_offset;
    }

    public Profile getProfile() {
        return ProfileObject;
    }

    public boolean getIs_admin() {
        return is_admin;
    }

    public boolean getIs_owner() {
        return is_owner;
    }

    public boolean getIs_primary_owner() {
        return is_primary_owner;
    }

    public boolean getIs_restricted() {
        return is_restricted;
    }

    public boolean getIs_ultra_restricted() {
        return is_ultra_restricted;
    }

    public boolean getIs_bot() {
        return is_bot;
    }

    public boolean getIs_app_user() {
        return is_app_user;
    }

    public float getUpdated() {
        return updated;
    }

    public boolean getIs_email_confirmed() {
        return is_email_confirmed;
    }

    public String getWho_can_share_contact_card() {
        return who_can_share_contact_card;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public void setTz_label(String tz_label) {
        this.tz_label = tz_label;
    }

    public void setTz_offset(float tz_offset) {
        this.tz_offset = tz_offset;
    }

    public void setProfile(Profile profileObject) {
        this.ProfileObject = profileObject;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public void setIs_owner(boolean is_owner) {
        this.is_owner = is_owner;
    }

    public void setIs_primary_owner(boolean is_primary_owner) {
        this.is_primary_owner = is_primary_owner;
    }

    public void setIs_restricted(boolean is_restricted) {
        this.is_restricted = is_restricted;
    }

    public void setIs_ultra_restricted(boolean is_ultra_restricted) {
        this.is_ultra_restricted = is_ultra_restricted;
    }

    public void setIs_bot(boolean is_bot) {
        this.is_bot = is_bot;
    }

    public void setIs_app_user(boolean is_app_user) {
        this.is_app_user = is_app_user;
    }

    public void setUpdated(float updated) {
        this.updated = updated;
    }

    public void setIs_email_confirmed(boolean is_email_confirmed) {
        this.is_email_confirmed = is_email_confirmed;
    }

    public void setWho_can_share_contact_card(String who_can_share_contact_card) {
        this.who_can_share_contact_card = who_can_share_contact_card;
    }
}

