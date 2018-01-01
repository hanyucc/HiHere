package io.github.leniumc.hihere;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import agency.tango.android.avatarview.loader.PicassoLoader;
import agency.tango.android.avatarview.views.AvatarView;

/**
 * Created by 陈涵宇 on 2017/10/8.
 */

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private List<PostData> dataList;

    public CustomAdapter(Context context, List<PostData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_post, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        PicassoLoader imageLoader = new PicassoLoader();
        imageLoader.loadImage(holder.avatarView, dataList.get(position).getAvatarImageUrl(),
                dataList.get(position).getUserName());

        holder.nameTextView.setText(dataList.get(position).getUserName());
        holder.gradeTextView.setText(dataList.get(position).getUserGrade());
        holder.descriptionTextView.setText(dataList.get(position).getPostDescription());

        holder.postCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PostActivity.class);
                PostData postData = dataList.get(holder.getAdapterPosition());
                intent.putExtra("everything", postData);
                context.startActivity(intent);
            }
        });

        holder.acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("接受")
                        .setMessage("是否确定接受该用户的请求？")
                        .setIcon(R.drawable.ic_check_black_24dp)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // TODO: send information, remove post, and add to database
                                int postId = dataList.get(holder.getAdapterPosition()).getPostId();
                                dataList.remove(holder.getAdapterPosition());
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public AvatarView avatarView;
        public TextView nameTextView, gradeTextView, descriptionTextView;
        public CardView postCard;
        public Button acceptButton;

        public ViewHolder(final View itemView) {
            super(itemView);
            avatarView = itemView.findViewById(R.id.avatar_view_post);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            gradeTextView =  itemView.findViewById(R.id.grade_text_view);
            descriptionTextView = itemView.findViewById(R.id.description_text_view);
            postCard = itemView.findViewById(R.id.card_post);
            acceptButton = itemView.findViewById(R.id.accept_button);
        }
    }
}
