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

package com.ushahidi.android.data.repository.datasource.useraccount;

import com.ushahidi.android.data.api.UserApi;
import com.ushahidi.android.data.api.service.UserService;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * @author Ushahidi Team <team@ushahidi.com>
 */
public class UserAccountDataSourceFactory {

    private final Context mContext;

    private UserService mUserService;

    public UserAccountDataSourceFactory(Context context) {
        mContext = context;
    }

    public void setUserService(@NonNull UserService userService) {
        mUserService = userService;
    }

    public UserAccountDataSource createApiDataSource() {
        if (mUserService == null) {
            throw new RuntimeException("Please call setUserService(...)");
        }
        final UserApi userApi = new UserApi(mContext, mUserService);
        return new UserAccountApiDataSource(userApi);
    }
}