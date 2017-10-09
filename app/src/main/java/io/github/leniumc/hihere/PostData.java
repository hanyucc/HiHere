package io.github.leniumc.hihere;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 陈涵宇 on 2017/10/8.
 */

class PostData implements Parcelable {
    private String avatarImageUrl, userName, userGrade, postDescription;
    private int postId;

    public PostData(String avatarImageUrl, String userName, String userGrade, String postDescription, int postId) {
        this.avatarImageUrl = avatarImageUrl;
        this.userName = userName;
        this.userGrade = userGrade;
        this.postDescription = postDescription;
        this.postId = postId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(avatarImageUrl);
        dest.writeString(userName);
        dest.writeString(userGrade);
        dest.writeString(postDescription);
        dest.writeInt(postId);
    }

    public static final Creator<PostData> CREATOR = new Creator<PostData>() {
        public PostData createFromParcel(Parcel in) {
            return new PostData(in);
        }

        public PostData[] newArray(int size) {
            return new PostData[size];
        }
    };

    private PostData(Parcel in) {
        avatarImageUrl = in.readString();
        userName = in.readString();
        userGrade = in.readString();
        postDescription = in.readString();
        postId = in.readInt();
    }

    public String getAvatarImageUrl() {
        return avatarImageUrl;
    }

    public void setAvatarImageUrl(String avatarImageUrl) {
        this.avatarImageUrl = avatarImageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
