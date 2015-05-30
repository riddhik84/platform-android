/*
 * Copyright (c) 2015 Ushahidi Inc
 *
 * This program is free software: you can redistribute it and/or modify it under
 *  the terms of the GNU Affero General Public License as published by the Free
 *  Software Foundation, either version 3 of the License, or (at your option)
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 *  FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program in the file LICENSE-AGPL. If not, see
 *  https://www.gnu.org/licenses/agpl-3.0.html
 */

package com.ushahidi.android.data.entity.mapper;

import com.ushahidi.android.BuildConfig;
import com.ushahidi.android.data.entity.PostEntity;
import com.ushahidi.android.data.entity.PostTagEntity;
import com.ushahidi.android.data.entity.PostValueEntity;
import com.ushahidi.android.data.entity.TagEntity;
import com.ushahidi.android.domain.entity.Post;
import com.ushahidi.android.domain.entity.PostValue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * @author Ushahidi Team <team@ushahidi.com>
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21, constants = BuildConfig.class)
public class PostEntityDataMapperTest {

    private static Long PARENT = 1l;

    private static String TITLE = "title";

    private static PostEntity.Type TYPE = PostEntity.Type.REPORT;

    private static String SLUG = "slug";

    private static String CONTENT = "content";

    private static String AUTHOR_EMAIL = "author email";

    private static String AUTHOR_REAL_NAME = "author real name";

    private static PostEntity.Status POST_STATUS = PostEntity.Status.DRAFT;

    private static Long DEPLOYMENT_ID = 1l;

    private static Long DUMMY_ID = 1l;

    private static Date CREATED = new Date();

    private static Date UPDATED = new Date();

    private static List<TagEntity> TAG_LIST = new ArrayList<>();

    private static List<PostTagEntity> POST_TAG_ENTITY = new ArrayList<>();

    private static PostValueEntity POST_VALUE = new PostValueEntity();

    private PostEntityDataMapper mPostEntityMapper;

    private PostEntity mPostEntity;

    private Post mPost;

    @Before
    public void setUp() throws Exception {
        mPostEntityMapper = new PostEntityDataMapper();
        POST_VALUE.setDeploymentId(1l);
        POST_VALUE.setValues("values");
    }

    @Test
    public void shouldMapPostEntityToPost() {
        mPostEntity = new PostEntity();
        mPostEntity._id = DUMMY_ID;
        mPostEntity.setTitle(TITLE);
        mPostEntity.setDeploymentId(DEPLOYMENT_ID);
        mPostEntity.setAuthorEmail(AUTHOR_EMAIL);
        mPostEntity.setAuthorRealname(AUTHOR_REAL_NAME);
        mPostEntity.setContent(CONTENT);
        mPostEntity.setSlug(SLUG);
        mPostEntity.setCreated(CREATED);
        mPostEntity.setUpdated(UPDATED);
        mPostEntity.setParent(PARENT);
        mPostEntity.setStatus(POST_STATUS);
        mPostEntity.setValues(POST_VALUE);
        mPostEntity.setTags(TAG_LIST);
        mPostEntity.setType(TYPE);
        mPostEntity.setPostTagEntityList(POST_TAG_ENTITY);

        Post post = mPostEntityMapper.map(mPostEntity);

        assertThat(post).isNotNull();
        assertThat(post).isInstanceOf(Post.class);
        assertThat(post.getDeploymentId()).isNotNull();
        assertThat(post.getDeploymentId()).isEqualTo(DEPLOYMENT_ID);
        assertThat(post.getAuthorEmail()).isNotNull();
        assertThat(post.getAuthorEmail()).isEqualTo(AUTHOR_EMAIL);
        assertThat(post.getAuthorRealname()).isNotNull();
        assertThat(post.getAuthorRealname()).isEqualTo(AUTHOR_REAL_NAME);
        assertThat(post.getContent()).isNotNull();
        assertThat(post.getContent()).isEqualTo(CONTENT);
        assertThat(post.getCreated()).isNotNull();
        assertThat(post.getCreated()).isEqualTo(CREATED);
        assertThat(post.getUpdated()).isNotNull();
        assertThat(post.getUpdated()).isEqualTo(UPDATED);
        assertThat(post.getSlug()).isNotNull();
        assertThat(post.getSlug()).isEqualTo(SLUG);
        assertThat(post.getTags()).isNotNull();
        assertThat(post.getTags()).isEqualTo(TAG_LIST);
        assertThat(post.getStatus()).isNotNull();
        //Fixme: Not mapping the post status
        //assertThat(post.getStatus()).isEqualTo(POST_STATUS);
        assertThat(post.getType()).isNotNull();
        //Fixme: Not mapping post type
        //assertThat(post.getType()).isEqualTo(TYPE);
        assertThat(post._id).isNotNull();
        assertThat(post._id).isEqualTo(DUMMY_ID);
        assertThat(post.getParent()).isNotNull();
        assertThat(post.getParent()).isEqualTo(PARENT);
        assertThat(post.getValues()).isNotNull();
        //FixMe Not mapping post value
        //assertThat(post.getValues()).isEqualTo(POST_VALUE);
        assertThat(post.getTitle()).isNotNull();
        assertThat(post.getTitle()).isEqualTo(TITLE);
    }

    @Test
    public void shouldUnMapFromPostToPostEntity() {
        mPost = new Post();
        PostValue postValue = new PostValue();
        postValue.setDeploymentId(1l);
        postValue.setValues("values");
        mPost._id = DUMMY_ID;
        mPost.setTitle(TITLE);
        mPost.setDeploymentId(DEPLOYMENT_ID);
        mPost.setAuthorEmail(AUTHOR_EMAIL);
        mPost.setAuthorRealname(AUTHOR_REAL_NAME);
        mPost.setContent(CONTENT);
        mPost.setSlug(SLUG);
        mPost.setCreated(CREATED);
        mPost.setUpdated(UPDATED);
        mPost.setParent(PARENT);
        mPost.setStatus(Post.Status.DRAFT);
        mPost.setValues(postValue);
        mPost.setTags(new ArrayList<>());
        mPost.setType(Post.Type.REPORT);

        PostEntity postEntity = mPostEntityMapper.map(mPost);

        assertThat(postEntity).isNotNull();
        assertThat(postEntity).isInstanceOf(PostEntity.class);
        assertThat(postEntity.getDeploymentId()).isNotNull();
        assertThat(postEntity.getDeploymentId()).isEqualTo(DEPLOYMENT_ID);
        assertThat(postEntity.getAuthorEmail()).isNotNull();
        assertThat(postEntity.getAuthorEmail()).isEqualTo(AUTHOR_EMAIL);
        assertThat(postEntity.getAuthorRealname()).isNotNull();
        assertThat(postEntity.getAuthorRealname()).isEqualTo(AUTHOR_REAL_NAME);
        assertThat(postEntity.getContent()).isNotNull();
        assertThat(postEntity.getContent()).isEqualTo(CONTENT);
        assertThat(postEntity.getCreated()).isNotNull();
        assertThat(postEntity.getCreated()).isEqualTo(CREATED);
        assertThat(postEntity.getUpdated()).isNotNull();
        assertThat(postEntity.getUpdated()).isEqualTo(UPDATED);
        assertThat(postEntity.getSlug()).isNotNull();
        assertThat(postEntity.getSlug()).isEqualTo(SLUG);
        assertThat(postEntity.getTags()).isNotNull();
        assertThat(postEntity.getTags()).isEqualTo(TAG_LIST);
        assertThat(postEntity.getStatus()).isNotNull();
        assertThat(postEntity.getStatus()).isEqualTo(POST_STATUS);
        assertThat(postEntity.getType()).isNotNull();
        assertThat(postEntity.getType()).isEqualTo(TYPE);
        assertThat(postEntity._id).isNotNull();
        assertThat(postEntity._id).isEqualTo(DUMMY_ID);
        assertThat(postEntity.getParent()).isNotNull();
        assertThat(postEntity.getParent()).isEqualTo(PARENT);
        assertThat(postEntity.getValues()).isNotNull();
        //FIXME: Not mapping the postvalue
        //assertThat(postEntity.getValues()).isEqualTo(POST_VALUE);
        assertThat(postEntity.getTitle()).isNotNull();
        assertThat(postEntity.getTitle()).isEqualTo(TITLE);
    }
}
