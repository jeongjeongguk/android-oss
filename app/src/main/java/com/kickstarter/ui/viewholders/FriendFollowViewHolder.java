package com.kickstarter.ui.viewholders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kickstarter.R;
import com.kickstarter.libs.transformations.CircleTransformation;
import com.kickstarter.models.User;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

public final class FriendFollowViewHolder extends ActivityListViewHolder {
  protected @Bind(R.id.avatar) ImageView avatarImageView;
  protected @Bind(R.id.title) TextView titleTextView;
  
  protected @BindString(R.string.activity_friend_follow_is_following_you) String isFollowingYouString;
  protected @BindString(R.string.Not_implemented_yet) String notImplementedYetString;

  public FriendFollowViewHolder(final @NonNull View view) {
    super(view);
    ButterKnife.bind(this, view);
  }

  @Override
  public void onBind() {
    final Context context = context();

    final User friend = activity().user();
    if (friend == null) {
      return;
    }

    Picasso.with(context)
      .load(friend.avatar().small())
      .transform(new CircleTransformation())
      .into(avatarImageView);

    // TODO: bold username
    titleTextView.setText(
      new StringBuilder(friend.name())
        .append(" ")
        .append(isFollowingYouString)
    );
  }
}
