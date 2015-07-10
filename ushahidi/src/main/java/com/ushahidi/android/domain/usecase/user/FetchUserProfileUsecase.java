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

package com.ushahidi.android.domain.usecase.user;

import com.addhen.android.raiburari.domain.executor.PostExecutionThread;
import com.addhen.android.raiburari.domain.executor.ThreadExecutor;
import com.addhen.android.raiburari.domain.usecase.Usecase;
import com.ushahidi.android.domain.entity.UserAuthToken;
import com.ushahidi.android.domain.repository.UserProfileRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Usecase for fetching user profiles from the internet
 *
 * @author Ushahidi Team <team@ushahidi.com>
 */
public class FetchUserProfileUsecase extends Usecase {

    private final UserProfileRepository mUserProfileRepository;

    private UserAuthToken mUserAuthToken;

    @Inject
    public FetchUserProfileUsecase(UserProfileRepository userProfileRepository,
            ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        mUserProfileRepository = userProfileRepository;
    }

    /**
     * Sets the deployment ID to be used to fetch the {@link com.ushahidi.android.domain.entity.Tag}
     * and where to fetch it from.
     *
     * @param userAuthToken The user auth token
     */
    public void setUserAuthToken(UserAuthToken userAuthToken) {
        mUserAuthToken = userAuthToken;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        if (mUserAuthToken == null) {
            throw new RuntimeException(
                    "User auth token id and from cannot be null. You must call setUserAuthtoken(...)");
        }
        return mUserProfileRepository.fetchUserProfile(mUserAuthToken);
    }
}
