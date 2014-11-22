/*
 * Copyright (c) 2014 Ushahidi.
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program in the file LICENSE-AGPL. If not, see
 * https://www.gnu.org/licenses/agpl-3.0.html
 */

package com.ushahidi.android.core.respository;

import com.ushahidi.android.core.entity.Post;
import com.ushahidi.android.core.exception.ErrorWrap;

import java.util.List;

/**
 * The post repository
 *
 * @author Ushahidi Team <team@ushahidi.com>
 */
public interface IPostRepository {

    /**
     * Add a {@link com.ushahidi.android.core.entity.Post}.
     *
     * @param post         The Post to be saved.
     * @param postCallback A {@link PostAddCallback} used for notifying clients about
     *                           the status of the operation.
     * @author Ushahidi Team <team@ushahidi.com>
     */
    void addPost(Post post, PostAddCallback postCallback);

    /**
     * Get a list of {@link com.ushahidi.android.core.entity.Post}.
     *
     * @param postListCallback A {@link PostListCallback} used for notifying clients
     *                               about the status of the operation.
     */
    void getPostList(PostListCallback postListCallback);

    /**
     * Get an {@link com.ushahidi.android.core.entity.Post} by id.
     *
     * @param postId              The post id used for retrieving post data.
     * @param postDetailsCallback A {@link PostDetailsCallback} used for notifying
     *                                  clients about the status of the operation.
     */
    void getPostById(final long postId,
            PostDetailsCallback postDetailsCallback);

    /**
     * Update a {@link com.ushahidi.android.core.entity.Post}
     *
     * @param post     The Post to be deleted
     * @param callback A {@link PostUpdateCallback} for notifying clients about post updates
     *                 status.
     */
    void updatePost(Post post, PostUpdateCallback callback);

    /**
     * Delete a {@link com.ushahidi.android.core.entity.Post}
     *
     * @param post     The post to be deleted.
     * @param callback A {@link PostDeletedCallback} used for notifying clients about the delete
     *                 status.
     */
    void deletePost(final Post post, PostDeletedCallback callback);

    /**
     * Callback used for notifying the client when either a post has been successfully added to the
     * database or an error occurred during the process.
     */
    interface PostAddCallback {

        void onPostAdded();

        void onError(ErrorWrap error);
    }

    /**
     * Callback used for notifying the client when either a post list has been loaded successfully
     * or an error occurred during the process.
     */
    interface PostListCallback {

        void onPostListLoaded(List<Post> postList);

        void onError(ErrorWrap errorWrap);
    }

    /**
     * Callback used for notifying the client when either a post has been loaded or an error
     * occurred during the process.
     */
    interface PostDetailsCallback {

        void onPostLoaded(Post post);

        void onError(ErrorWrap errorWrap);
    }

    /**
     * Callback used for notifying the client when either a post has been updated or failed to be
     * updated.
     */
    interface PostUpdateCallback {

        void onPostUpdated();

        void onError(ErrorWrap error);
    }

    /**
     * Callback used for notifying the client when either a post has been deleted or failed to be
     * deleted.
     */
    interface PostDeletedCallback {

        void onPostDeleted();

        void onError(ErrorWrap error);
    }

}