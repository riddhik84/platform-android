/*
 * Copyright (c) 2015 Ushahidi.
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

package com.ushahidi.android.core.usecase;

import com.ushahidi.android.core.Entity;
import com.ushahidi.android.core.exception.ErrorWrap;

import java.util.List;

/**
 * @author Ushahidi Team <team@ushahidi.com>
 */
public interface ISearch<E extends Entity> extends IInteractor {

    /**
     * Executes this use case.
     *
     * @param callback A {@link Callback} used to notify the client.
     */
    void execute(String query, Callback callback);

    interface Callback<E extends Entity> {

        void onError(ErrorWrap error);

        void onEntityFound(List<E> entityList);
    }
}